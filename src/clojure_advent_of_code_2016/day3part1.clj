(ns clojure-advent-of-code-2016.day3part1
 (:require [clojure.string :as str]))

(defn -main []
  (->>
    (-> (slurp "resources/day3.txt")
        (str/split #"\s+"))
    (map read-string)
    (partition 3)
    (map sort)
    (filter (fn [[ a b c ]] (> (+ a b) c)))
    count))

(-main)
