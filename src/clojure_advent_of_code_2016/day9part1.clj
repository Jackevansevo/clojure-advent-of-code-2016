(ns clojure-advent-of-code-2016.day9part1
 (:require [clojure.string :as str]))

;; [TODO] Some proper subvec wankery

(def marker (re-pattern #"(?<!\))\(\d+x\d+\)"))

(defn split-marker [m]
  (mapv read-string (re-seq #"\d+" m)))

(defn re-pos [re s]
  (loop [m (re-matcher re s)
         res {}]
    (if (.find m)
      (recur m (assoc res (.start m) (.group m)))
      res)))

(re-pos marker "A(2x2)BCD(2x2)EFG")
(decompress "A(1x5)BC")
(decompress "(3x3)XYZ")
(decompress "A(2x2)BCD(2x2)EFG")
(decompress "(6x1)(1x3)A")
(decompress "X(8x2)(3x3)ABCY")
