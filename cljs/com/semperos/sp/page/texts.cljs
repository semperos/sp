(ns com.semperos.sp.page.texts
  (:require [domina :as d])
  (:require-macros [dommy.macros :refer [node]]))

(defn init
  [el]
  (d/append! el (node [:div
                       [:h1 "Texts"]])))
