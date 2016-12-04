(ns clojure-advent-of-code-2016.day3part2
 (:require [ clojure.core.matrix :as mtx])
 (:require [clojure.string :as str]))

;; Maths innit

(defn -main []
  (->>
    (-> (slurp "resources/day3.txt")
        (str/split #"\s+"))
    (map read-string)
    (partition 9)
    (map #(mtx/transpose (mtx/reshape % [3 3])))
    (mapcat identity)
    (map sort)
    (filter (fn [[ a b c ]] (> (+ a b) c)))
    count))

(-main)
