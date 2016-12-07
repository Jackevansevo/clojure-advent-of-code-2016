(ns clojure-advent-of-code-2016.day7part1
 (:require [clojure.string :as str]))

(def thing #"(?<!\[)([a-z])((?!\1)[a-z])\2+\1(?!\])")

(def input (-> (slurp "resources/day7.txt")
               str/split-lines))

(count (filter identity (map #(if (re-find thing %) true false) input)))
