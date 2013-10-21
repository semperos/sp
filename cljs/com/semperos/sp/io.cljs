(ns com.semperos.sp.io
  (:require cljs.reader)
  (:require-macros [com.semperos.sp.macros :refer [log]]))

(def fs (js/require "fs"))

(defn slurp
  [f]
  (.readFileSync fs f "utf-8"))

(defn slurp-clojure
  [f]
  (cljs.reader/read-string (slurp f)))
