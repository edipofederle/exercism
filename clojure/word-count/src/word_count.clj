(ns word-count
  (:require [clojure.string :as string :refer [lower-case replace]]))

(defn normalize-str [phrase]
  (-> phrase
      (clojure.string/replace  #"," " ")
      (lower-case)
      (replace #"[^a-zA-Z0-9 ]" "")))

(defn split-phrase [phrase]
  (-> phrase
      (normalize-str phrase)
      (string/split #" ")
      (remove string/blank?)))

(defn word-count [phrase]
  (reduce 
   (fn [freq word]
     (update-in freq [word] (fnil inc 0)))
   {}
   (split-phrase phrase)))
