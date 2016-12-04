(ns clojure-advent-of-code-2016.day4part1
  (:require [clojure.string :as str]))

(defn order-map [target]
  (into (sorted-map-by (fn [key1 key2]
                         (compare [(target key2) key1]
                                  [(target key1) key2]))) target))

(defn match-data [d]
  (rest (re-matches #"((?:[a-z]+\-?)+)\-(\d+)\[([a-z]+)\]" d)))

(defn top-five [d]
  (take 5 (->> (str/replace d #"-" "") frequencies order-map keys)))

(defn group-data [d]
  (let [matches (match-data d)]
    {:top-five (top-five (first matches))
     :sector (read-string (second matches))
     :checksum (apply list (last matches))}))

(->>
  (-> (slurp "resources/day4.txt")
      (str/split-lines))
  (map group-data)
  (filter (fn [n] (= (:top-five n) (:checksum n))))
  (map :sector)
  (reduce +))
