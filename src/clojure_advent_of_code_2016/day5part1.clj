(ns clojure-advent-of-code-2016.day5part1
 (:require [digest])
 (:require [clojure.string :as str]))


(defn five-zeros? [h]
  (= (subs h 0 5) "00000"))

(defn hashes
  ([w] (hashes w 0))
  ([w n]
   (lazy-seq
     (cons (digest/md5 (str w n)) (hashes w (inc n))))))

(defn -main []
  (->> (hashes "uqwqemis")
       (filter five-zeros?)
       (take 8)
       (map #(nth % 5))
       (apply str)))

(-main)
