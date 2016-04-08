(ns rna-transcription
  (:require [clojure.string :as string :refer [join]]))

(defn dna-to-rna [n]
  (cond 
    (= n \C) "G"
    (= n \G) "C"
    (= n \A) "U"
    (= n \T) "A"
    :else (throw (AssertionError. "my exception message"))))

(defn to-rna [dna-stran]
  (join (map dna-to-rna dna-stran)))

