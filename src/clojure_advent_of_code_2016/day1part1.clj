(ns clojure-advent-of-code-2016.day1part1
 (:require [clojure.string :as str]))

;; Read in the input
(def input (-> (slurp "resources/day1.txt")
               str/trim
               (str/split #", ")))

;; Store compass as atom
(def compass (atom [\N \E \S \W]))


(defn rotate [direction]
  (case direction
    \R (swap! compass (fn [l] (concat (rest l) [(first l)])))
    \L (swap! compass (fn [l] (concat [(last l)] (butlast l))))))


(defn travel [pos [orientation steps] & more]
  ;; Write a magic reducer function
  (println pos orientation steps))

(defn follow [[direction steps]]
  (rotate direction)
  (list (first (deref compass)) (read-string (str steps))))

;; [R5, L5, R5, R3]

(defn -main []
  (reduce travel [0 0] (map follow input)))


(-main)
