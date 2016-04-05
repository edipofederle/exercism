(ns beer-song)

(defn pluralize-it-on [total]
  (cond
    (== total 1) "it "
    (> total 1)  "one "))

(defn pluralize [number total]
   (cond
     (== total 1) (str total " bottle of beer on the wall.\n")
     (> total 1) (str total " bottles of beer on the wall.\n")
     (== total 0) "no more bottles of beer on the wall.\n"))

(defn pluralize-first [total]
  (cond
    (== total 1) (str total " bottle")
    (> total 1) (str total " bottles")
    (== total 0) "no more bottles of beer on the wall.\n"))

(defn verse [number]
  (if (= number 0)
    "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    (str (pluralize-first number) " of beer on the wall, " (pluralize-first number) " of beer.\nTake " (pluralize-it-on number)  "down and pass it around, " (pluralize number (- number 1)))))

(defn generate-verse [stop-point range]
  (reduce
   (fn [accu verse-number] 
     (if (= verse-number stop-point)
       (str accu (verse verse-number))
       (str accu (verse verse-number) "\n")))
   "" (into [] (reverse range))))

(defn sing 
  ([x]
   (generate-verse 0 (range (inc x))))
  ([x y]
   (generate-verse y (range y (inc x)))))


