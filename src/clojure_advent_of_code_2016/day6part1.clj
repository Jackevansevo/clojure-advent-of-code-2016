(ns clojure-advent-of-code-2016.day6part1
  (:require [clojure.string :as str]))

(def input (-> (slurp "resources/day6.txt")
               str/split-lines))

(defn most-frequent [items]
  (->> items
       frequencies
       (sort-by val)
       reverse
       keys
       first))

(defn col-letter-freq [col]
  (most-frequent (map #(nth % col) input)))

(defn -main []
  (let [columns (range (count (first input)))]
    (apply str (map col-letter-freq columns))))

(-main)
