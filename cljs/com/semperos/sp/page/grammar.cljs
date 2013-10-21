(ns com.semperos.sp.page.grammar
  (:require [domina :as d])
  (:require-macros [dommy.macros :refer [node]]))

(defn init
  [el]
  (d/append! el (node [:div.section-header
                       [:h1 "Grammar"]
                       [:p "Noun declensions, verb conjugations, syntax and more"]])))
