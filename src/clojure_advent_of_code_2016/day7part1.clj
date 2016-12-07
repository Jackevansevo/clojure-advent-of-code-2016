(ns clojure-advent-of-code-2016.day7part1
  (:require [clojure.string :as str]))

(defn find-pair [m]
  (boolean (re-find #"([a-z])((?!\1)[a-z])\2\1" m)))

(defn in-brackets? [m]
  (if-let [matches (re-seq #"\[.+?\]" m)]
    (some true? (map find-pair matches))))

(defn is-tls? [addr]
  (if (in-brackets? addr)
    false
    (find-pair (str/replace addr #"\[.+?\]" ""))))

(->>
  (-> (slurp "resources/day7.txt")
      (str/split-lines))
  (map is-tls?)
  (filter identity)
  count)

;; Werks for the examples ...
(is-tls? "abba[mnop]qrst") ;; => true
(is-tls? "abcd[bddb]xyyx") ;; => false
(is-tls? "aaaa[qwer]tyui") ;; => false
(is-tls? "ioxxoj[asdfgh]zxcvbn") ;; => true
