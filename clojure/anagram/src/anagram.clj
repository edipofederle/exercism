(ns anagram
  (:require [clojure.string :as string :refer [lower-case]]))

(defn check 
  "Verify if target-word is a anagram of source-word "
  [source-word target-word]
  (= (sort (lower-case source-word)) 
     (sort (lower-case target-word))))

(defn remove-equals
  "Given a source-word and a vector of words (coll-words) remove from coll-words words equals source-word"
  [source-word coll-words]
  (into [] 
        (remove 
         (fn [word] (= word (lower-case source-word)))
         coll-words)))

(defn anagrams-for [word-source, words-coll]
  (filter
   (fn [word] (check word-source word))
   (remove-equals word-source words-coll)))
