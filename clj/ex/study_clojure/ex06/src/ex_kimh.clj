(ns ex_kimh
  (:require [clojure.string :as str]))

; autosaved
; Most codes taken or adapted from https://github.com/kimh/clojure-by-example/blob/master/source/index.html.md

(println "merhaba")

"h"

true

(+ 15 45)
; => 60

(str "each " "line " "is a" " form")
;; => "each line is a form"

(str "forms are " "expressions")
;; => "forms are expressions"

(def a-binding "is an assignment in other languages")
;; => #'ex_kimh/a-binding

(def bindings "map a name to a value")
;; => #'ex_kimh/bindings

(type 'quoted-symbols-are-not-evaluated)
;; => clojure.lang.Symbol

;; (unresolved-symbol-error)                                   ;; error

(let [binds "a value to a local name"] (str binds))
;; => "a value to a local name"

(let [a 10
      b 20] (+ 10 20))
;; => 30

; narrow indentation
(let
  [a 10
   b 20]
  (+ 10 20))
;; => 30

; clojure style convention
(let [a 10
      b 20]
  (+ 10 20))
;; => 30

; global bindings: defn vs def id=g11323

(defn f [a] a)
;; => #'ex_kimh/f
(def g (fn [a] a))
;; => #'ex_kimh/g

(def def-bindings "are global")
;; => #'ex_kimh/def-bindings

(defn a-function
  [name]
  (str name))
;; => #'ex_kimh/a-function

(defn documented
  "This is documentation"
  []
  (str ""))
;; => #'ex_kimh/documented

; var and reader macro  id=g11325

(meta (var documented))
;; => {:arglists ([]), :doc "This is documentation", :line 65, :column 1, :file "/Users/mertnuhoglu/projects/study/clj/ex/study_clojure/ex06/src/ex_kimh.clj", :name documented, :ns #namespace[ex_kimh]}
(meta #'documented)
;; => {:arglists ([]), :doc "This is documentation", :line 65, :column 1, :file "/Users/mertnuhoglu/projects/study/clj/ex/study_clojure/ex06/src/ex_kimh.clj", :name documented, :ns #namespace[ex_kimh]}

;; anonymous functions id=g11322

(fn [] (str ""))
(def anon-function (fn [] (str "")))
(anon-function)
#(str "anon function")
(#(str "evaluate " "anon function"))
#(str "function argument: " %)
(#(str "function argument: " %) "arg value")
(let [multiple-args #(+ %1 %2)]
  (multiple-args 50 20))
;; => 70

((fn [x] (+ 6 x)) 3)
;; => 9
(#(+ 6 %) 3)
;; => 9
(#(+ 6 %1) 3)
;; => 9

;; higher-order-functions id=g11326

(defn h [fun]
  (fun 10))
;; => #'ex_kimh/h
(h inc)
;; => 11

;; closure  id=g11327
(defn closure [a] #(inc a))
;; => #'ex_kimh/closure
(def outer (closure 20))
;; => #'ex_kimh/outer
outer
;; => 21

;; Namespaces id=g11328

(in-ns 'user)
;; => #namespace[user]
; outer                                                     ; unable to resolve symbol

(in-ns 'ex_kimh)
outer

(in-ns 'user)
;; => #namespace[user]
(require 'ex_kimh)
;; => nil
ex_kimh/outer
;; => 21

(require '[ex_kimh :as cbe])
;; => nil
cbe/outer
;; => 21

;; control clow id=g11329

(if (< 3 5)
  "then"
  "else")
;; => "then"

(if-let [a 1]
  a
  0)
;; => 1

(if-let [a 0]
  a
  "else")
;; => 0
;; bunun karşılığı şu:
(let [a 0]
  (if a a "else"))
;; => 0

(when true "10")
;; => "10"
(when-let [a 1] a)
;; => 1
(when-let [a false] a)
;; => nil

(let [n 2]
  (case n
    1 "a"
    2 "b"
    "other"))
;; => "b"

(let [n 3]
  (cond
    (< n 3) "a"
    (< n 5) "b"
    :else "other"))
;; => "b"

(let [n 2]
  (condp < n
    3 "a"
    5 "b"
    "else"))
;; => "else"

;; Boolean


(boolean false)
;; => false
(boolean nil)
;; => false
(boolean 0)                                                 ; truthy
;; => true
(boolean [])                                                ; truthy
;; => true
(boolean :a)
;; => true

;; Strings id=g11330

(str "join " "strings")
;; => "join strings"
(str "no " "string interpolation" " like ${message}")
;; => "no string interpolation like ${message}"
(format "%s %s" "this is" "me")
;; => "this is me"

;; Numbers id=g11331

(/ 4 3)
;; => 4/3
(* (/ 4 3) 3)
;; => 4N
(max 1 2 3)
;; => 3
(mod 3 2)
;; => 1

;; Lists id=g11332


'(1 2 3)
;; => (1 2 3)
(conj '(1 2) 3)
;; => (3 1 2)
(nth '(3 5 2) 1)
;; => 5
(count '(5 3))
;; => 2

;; Vectors id=g11333


[3 2 5]
;; => [3 2 5]
(conj [4 1] 7)
;; => [4 1 7]
(nth [3 2] 0)
;; => 3
(last [2 7 1])
;; => 1
(.indexOf [3 5 7] 5)
;; => 1

(get ["a" "b"] 1)
;; => "b"

;; Sets id=g11334


#{1 2 3}
;; => #{1 3 2}
(conj #{1 2 3} 4)
;; => #{1 4 3 2}
(disj #{1 2 3} 3)
;; => #{1 2}
(sort #{1 2 3})
;; => (1 2 3)
(contains? #{1 2 3} 2)
;; => true
(clojure.set/subset? #{1 2} #{1 2 3})
;; => true
(clojure.set/superset? #{1 2 3} #{1 2})
;; => true

;; Maps id=g11335

{:a 1 :b 2}
;; => {:a 1, :b 2}
(get {:a 1 :b 2} :a)
;; => 1
({:a 1 :b 2} :a)
;; => 1
({:a 1 :b 2} :c "default")
;; => "default"
(:a {:a 1 :b 2})
;; => 1
(assoc {:a 1} :c 3)
;; => {:a 1, :c 3}
(merge {:a 1} {:c 3})
;; => {:a 1, :c 3}
(keys {:a 1 :b 2})
;; => (:a :b)
(vals {:a 1 :b 2})
;; => (1 2)

;; Sequences id=g11336


(seq '(1 2))
;; => (1 2)
(seq [1 2])
;; => (1 2)
(seq #{1 2})
;; => (1 2)

(first [5 2])
;; => 5
(first "string")
;; => \s
(second [5 2])
;; => 2
(rest [1 2 3])
;; => (2 3)

(cons 0 [1 2])
;; => (0 1 2)
(concat '(1 2) '(3 4))
;; => (1 2 3 4)

; map id=g11338


(map inc [1 2])
;; => (2 3)
(map inc `(1 2))
;; => (2 3)
(map inc #{1 2})
;; => (2 3)
(map key {:a 1 :b 2})
;; => (:a :b)
(map #(inc (val %1)) {:a 1 :b 2})
;; => (2 3)
(map vector [:a :b] [:d :e])
;; => ([:a :d] [:b :e])

; reduce  id=g11337


(reduce + [1 2 3])
;; => 6
(reduce (fn [rst x] (+ rst x)) [1 2 3])
;; => 6
(reduce + -10 [1 2 3])
;; => -4

; into id=g11339


(into [1 2] '(3 4))
;; => [1 2 3 4]
(into [] '(1 2))
;; => [1 2]
(into (list) [1 2])
;; => (2 1)
(into #{} [1 2])
;; => #{1 2}
(into {} [[:a 1] [:b 2]])
;; => {:a 1, :b 2}
(into [] {:a 1 :b 2})
;; => [[:a 1] [:b 2]]

(reverse [1 2])
;; => (2 1)

; iterations id=g11340


(take 3 (iterate inc 3))
;; => (3 4 5)
(range 1 3)
;; => (1 2)
(repeatedly 3 #(str "hi"))
;; => ("hi" "hi" "hi")
(doseq [a [1 2 3]] (println a))
;; => nil

; take drop id=g11342


(take 5 (range 0 100))
;; => (0 1 2 3 4)
(take-while pos? [1 2 -3 4])
;; => (1 2)
(drop 3 (range 0 10))
;; => (3 4 5 6 7 8 9)
(drop-while pos? [1 2 -3 4])
;; => (-3 4)

; filter id=g11343


(filter pos? [1 2 -3 4])
;; => (1 2 4)
(remove pos? [1 2 -3 4])
;; => (-3)

; grouping id=g11344


(partition-by pos? [1 2 -3])
;; => ((1 2) (-3))
(group-by pos? [1 2 -3])
;; => {true [1 2], false [-3]}

; for: list comprehension id=g11345


(for [x [1 2 3]] (+ 5 x))
;; => (6 7 8)
(for [x [-1 2 3] :when (< 0 x)] x)                          ;; {x | x > 0}
;; => (2 3)
(for [x [1 2 3]
      :let [y (+ x 1)]
      :when (even? y)]
  y)
;; => (2 4)
(for [x (range 3) :while (< x 2)] x)
;; => (0 1)
(for
  [x ['a 'b]
   y [1 2]]
  [x y])
;; => ([a 1] [a 2] [b 1] [b 2])

; recursion id=g11346


; https://practicalli.github.io/clojure/thinking-functionally/recursion.html
(defn length [xs]
  (if (empty? xs)
    0
    (+ 1 (length (rest xs)))))
;; => #'user/length
(length [])
;; => 0
(length [:a :b])
;; => 2

(defn length2 [result xs]
  (if (empty? xs)
    result
    (recur (+ 1 result) (rest xs))))
;; => #'user/length2
(length2 0 [3 4])
;; => 2

(defn count-down [result n]
  (if (= n 0)
    result
    (recur (conj result n) (dec n))))
;; => #'user/count-down
(count-down [] 3)
;; => [3 2 1]

; loop id=g11347


(loop [i 0]
  (if (= i 3)
    (println "done!")
    (do
      (println i)
      (recur (inc i)))))
;; => nil

; macros id=g11348


(defmacro unless [cond then]
  (list
    'if
    (list 'not cond)
    then))
;; => #'user/unless
(unless false 1)
;; => 1

(macroexpand '(unless false 1))
;; => (if (not false) 1)

; quotes id=g11349


(+ 1 2)
;; => 3
(quote (+ 1 2))
;; => (+ 1 2)
'(+ 1 2)
;; => (+ 1 2)

; syntax-quoting  id=g11350


`(+ 1 2)                                                    ; syntax-quoting
;; => (clojure.core/+ 1 2)
`(+ 1 ~(inc 1))                                             ; syntax-quoting allows unquoting to evaluate its expression
;; => (clojure.core/+ 1 2)
`(+ ~(list 1 2))
;; => (clojure.core/+ (1 2))
`(+ ~@(list 1 2))                                           ; unqoute splice `~@` expands a seq
;; => (clojure.core/+ 1 2)

; threading macros id=g11351


(conj (conj [] 1) 2)
;; => [1 2]
(-> []
  (conj 1)
  (conj 2))
;; => [1 2]
(->> [1 2]
  (map inc)
  (map #(* 2 %)))
;; => (4 6)

; delay id=g11352


(def later (do [] (prn "Adding") (+ 1 2)))
;; => #'user/later
(def later (delay [] (prn "Adding") (+ 1 2)))
;; => #'user/later

(do
  (future
    (Thread/sleep 3000)
    (println "after sleep"))
  "hello")
;; => "hello"

(deref (future 1))
;; => 1
@(future 1)
;; => 1
(let [x (future 1)]
  (deref x))
;; => 1

(def p (promise))
;; => #'user/p
(defn listen []
  (future (println "callback: " @p)))
;; => #'user/listen
(defn job []
  (Thread/sleep 3000)
  (deliver p "value"))
;; => #'user/job
(listen)
;; => #future[{:status :pending, :val nil} 0x4cc152d]
(job)
;; => #promise[{:status :ready, :val "value"} 0x2f87b537]

; atom id=g11353


(def a (atom 1))
;; => #'user/a
(deref a)
;; => 1
(reset! a 2)
;; => 2

(swap! a #(inc %))
;; => 3

(defn multiple-by [an-atom n] (* an-atom n))
;; => #'user/multiple-by
(swap! a multiple-by 3)
;; => 9

; thread safety id=g11354


(def g 0)
;; => #'user/g
(repeatedly 3
  #(def g (inc g)))
;; => (#'user/g #'user/g #'user/g)

(def g 0)
;; => #'user/g
(repeatedly 2
  (fn [] (future (def g (inc g)))))
;; => (#future[{:status :ready, :val #'user/g} 0x70cb3715] #future[{:status :ready, :val #'user/g} 0x724bc9e2])

(def g (atom 0))
;; => #'user/g
(repeatedly 2
  (fn [] (future (swap! g inc))))
;; => (#future[{:status :ready, :val 2} 0x60880eb9] #future[{:status :ready, :val 1} 0x6505ef8c])

; ref id=g11355


(def r (ref 0))
;; => #'user/r
(deref r)
;; => 0

; transaction ref-set id=g11356


(dosync
  (ref-set r 1)
  (ref-set r 2))
;; => 2

(dosync
  (alter r
     (fn [a-ref]
      (inc a-ref))))
;; => 3

(def rec (ref {}))
;; => #'user/rec
(dosync
  (alter rec merge {:name "ali"})
  ;(throw (Exception. "wrong"))
  (alter rec merge {:age 40}))

; java id=g11357


(new java.util.Date)
;; => #inst "2020-06-15T14:27:36.415-00:00"
(java.util.Date. "2016/2/19")
;; => #inst "2016-02-18T22:00:00.000-00:00"

(let [d (java.util.Date.)]
  (str d))
;; => "Mon Jun 15 17:27:43 EEST 2020"

(Math/pow 2 3)
;; => 8.0
(let [d (java.util.Date.)]
  (.toString d))
;; => "Mon Jun 15 17:27:47 EEST 2020"
(let [d (java.util.Date.)]
  (. d toString))
;; => "Mon Jun 15 17:27:51 EEST 2020"
(let [d1 (java.util.Date.)
      d2 (java.util.Date.)]
  (.equals d1 d2))
;; => true

