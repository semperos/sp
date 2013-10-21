(ns com.semperos.sp.page.index
  (:require [domina :as d])
  (:require-macros [dommy.macros :refer [node]]))

(defn init
  [el]
  (d/append! el (node [:div.jumbotron
                       [:h1 "Slavonic Primer"]
                       [:p.lead "Collection of resources for learning Old Church Slavonic"
                        [:br]
                        "as used in the Russian Orthodox Church"]])))
