(ns sof.sof22)

; rfr: video/20230221-mert-clj-egzersiz-47.mp4

; [Matrix transposition in clojure - Stack Overflow](https://stackoverflow.com/questions/10347315/matrix-transposition-in-clojure)

; a01:

(defn transpose [mat]
  (apply mapv vector mat))

; matriksler iki boyutlu (seviyeli) vektörlerle modellenebilir
(def mat [[1 2] [3 4]])
; bu aslında şu matrikse denk gelir:
; 1 2
; 3 4
(transpose mat)
;=> [[1 3] [2 4]]

; This works because (apply mapv vector m) is the same as (mapv vector (m 0) (m 1) ...).
(apply mapv vector mat)
; ≣
(mapv vector [1 2] [3 4])
; ≣
[(vector 1 3) (vector 2 4)]
;=> [[1 3] [2 4]]

(mat 0)
;=> [1 2]
(mat 1)
;=> [3 4]

; a02: clojure.core.matrix/transpose

#_(require '[clojure.core.matrix :as matrix])

#_(matrix/transpose [[1 2] [3 4]])
;=> [[1 3] [2 4]]

