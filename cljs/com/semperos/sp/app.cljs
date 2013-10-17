(ns com.semperos.sp.app
  (:require [domina :as d]
            [domina.css :refer [sel]]
            [com.semperos.sp.nw :refer [show-dev-tools]])
  (:require-macros [dommy.macros :refer [node]]
                   [com.semperos.sp.macros :refer [log]]))

(def os (js/require "os"))

(defn ^:export start [& args]
  (show-dev-tools)
  (log (str "App started on " (.platform os)))
  (let [el (sel "#sp-app")]
    (d/append! el (node [:section
                         [:h1 "Slavonic Primer"]
                         [:p "Во имя Отца и Сына и Святаго Духа. Аминь."]]))))
