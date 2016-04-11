(ns hamming
  (:require [clojure.string :refer [split]]))

(defn distance [strand1 strand2]
  (cond
    (= strand1 strand2) 0
    (not= (count strand1) (count strand2)) nil
    :else
    (count (filter true? (map (partial reduce not=) (map vector strand1 strand2))))))


;;(map vector "foo" "bar")
;;(partial reduce not=)



