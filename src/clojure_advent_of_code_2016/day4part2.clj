(ns clojure-advent-of-code-2016.day4part2
  (:require [clojure.string :as str]))

(defn match-data [data]
 (rest (re-matches #"((?:[a-z]+\-?)+)\-(\d+)\[([a-z]+)\]" data)))

(defn group-data [data]
  (let [matches (match-data data)]
    {:name (first matches)
     :sector (read-string (second matches))
     :checksum (apply list (last matches))}))

(defn rotate [n c]
 (if (= \- c) \space
   (-> (int c) (- 97) (+ n 26) (mod 26) (+ 97) char)))

(defn decrypt [data]
 (assoc data :cracked
        (apply str (map #(rotate (data :sector) %) (data :name)))))

(->>
  (-> (slurp "resources/day4.txt")
      (str/split-lines))
  (map group-data)
  (map decrypt)
  (filter #(str/includes? (% :cracked) "pole"))
  (map :sector))
