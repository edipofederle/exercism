(ns rna-transcription
  (:require [clojure.string :as string :refer [join]]))

(def map {"C" "G"
    "G" "C"
    "A" "U"
    "T" "A"})

(defn is-valid-chain? [chain]
  (empty?
   (remove
    (fn [n] (some #(= n %) (keys map)))
    (string/split chain #""))))

(defn to-rna [rna]
  (if-not (is-valid-chain? rna)
    (throw (AssertionError. "my exception message")))
  (join
   (reduce 
    (fn [coll, rna] 
      (conj coll (map rna)))
    []
    (string/split rna #""))))







