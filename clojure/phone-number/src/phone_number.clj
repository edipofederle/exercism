(ns phone-number
  (:require [clojure.string :refer [split]]))

(defn remove-first-if-11-start-with-one [phone-number]
  (if (and (= (first phone-number) \1) (= (count phone-number) 11))
    (apply str (drop 1 phone-number))
    phone-number
    ))

(defn remove-special-chars [phone-number]
  (apply str (filter #(Character/isDigit %) phone-number)))

(defn clean [phone-number]
  (->  phone-number
      (remove-first-if-11-start-with-one)
      (remove-special-chars)))

(defn number [phone-number]
  (cond
    (and (not= (first phone-number) \1) (= (count phone-number) 11)) "0000000000"
    (= (count phone-number) 9) "0000000000"
    :else (clean phone-number)))

(defn area-code [number]
  (subs (clean number) 0 3))

(defn pretty-print [number]
  (let [clean-number (clean number)
        area-code (area-code clean-number)
        first-part (subs clean-number 3 6 )
        second-part (subs clean-number 6 10 )]
    (str "(" area-code ") " first-part "-" second-part)))
