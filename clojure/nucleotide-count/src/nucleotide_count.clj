(ns nucleotide-count
  (:require [clojure.string :as string]))

(def nucleotides {\A 0, \T 0, \C 0, \G 0})

(defn count-chars [dna char-to-count]
  (reduce (fn [accu char]
            (if (= char char-to-count)
              (inc accu)
              accu)) 0 (into [] (seq (char-array dna)))))

(defn in? 
  "true if coll contains elm"
  [coll elm]  
  (some #(= elm %) coll))


(defn count [n dna]
  (if-not (contains? (set (keys nucleotides)) n)
    (throw (Throwable. "Invalid Nucleotides"))
    (if (nil? (in? (into [] (seq (char-array dna))) n))
      0
      (count-chars dna n))))


(defn nucleotide-counts [dna]
  (if (empty? dna)
    nucleotides
    (merge nucleotides (frequencies dna))))


