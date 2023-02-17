(ns fn.syntax.java)

; [Learn clojure in Y Minutes](https://learnxinyminutes.com/docs/clojure/)

; Use import to load a java module
(import java.util.Date)

; You can import from an ns too.
(ns test
  (:import java.util.Date
           java.util.Calendar))

; Use the class name with a "." at the end to make a new instance
(Date.)
;=> #inst"2023-02-17T20:53:49.982-00:00"

; Use . to call methods. Or, use the ".method" shortcut
(. (Date.) getTime)
;=> 1676667362472
(.getTime (Date.))
;=> 1676667362472

; Use / to call static methods
(System/currentTimeMillis)
;=> 1676667378473

; Use doto to make dealing with (mutable) classes more tolerable
(import java.util.Calendar)
(doto (Calendar/getInstance)
  (.set 2000 1 1 0 0 0)
  .getTime)
;=> #inst"2000-02-01T00:00:00.722+02:00"


