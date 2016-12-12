(ns clojure-advent-of-code-2016.day7part1
 (:require [clojure.string :as str]))

(defn find-abba
  "Returns true if string contains Autonomous Bridge Bypass Annotation"
  [s]
  (boolean (re-find #"([a-z])((?!\1)[a-z])\2\1" s)))

(defn annotation-in-hypernet?
  "Returns true if address has annotatino in hypernet"
  [addr]
  (if-let [hypernet (re-seq #"\[.+?\]" addr)]
    (some true? (map find-abba hypernet))))

(defn supports-tls?
  "Returns true if address supports TLS"
  [addr]
  (if (annotation-in-hypernet? addr)
    false
    (find-abba (str/replace addr #"\[.+?\]" ""))))

(->>
  (-> (slurp "resources/day7.txt")
      (str/split-lines))
  (map supports-tls?)
  (filter identity)
  count)

;; Werks for the examples ...
(supports-tls? "abba[mnop]qrst") ;; => true
(supports-tls? "abcd[bddb]xyyx") ;; => false
(supports-tls? "aaaa[qwer]tyui") ;; => false
(supports-tls? "ioxxoj[asdfgh]zxcvbn") ;; => true
