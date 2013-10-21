(ns com.semperos.sp.dom
  (:require [domina :as d]))

(defn append-html-str
  [el s]
  (doseq [fragment (d/html-to-dom s)]
    (d/append! el fragment)))

(defn exists?
  [sel]
  (seq (d/nodes sel)))
