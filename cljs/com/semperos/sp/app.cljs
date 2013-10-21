(ns com.semperos.sp.app
  (:require goog.events
            goog.dom
            [domina :as d]
            [domina.css :refer [sel]]
            [domina.events :refer [listen!]]
            [com.semperos.sp.nw :refer [show-dev-tools]]
            [com.semperos.sp.dom :as dom]
            [com.semperos.sp.event :as event]
            [com.semperos.sp.io :as io]
            ;; Pages
            [com.semperos.sp.page.index :as index-page]
            [com.semperos.sp.page.grammar :as grammar-page]
            [com.semperos.sp.page.vocabulary :as vocabulary-page]
            [com.semperos.sp.page.texts :as texts-page])
  (:require-macros [dommy.macros :refer [node]]
                   [com.semperos.sp.macros :refer [log]]))

(def os (js/require "os"))
(def el (atom nil))

(defn ^:export start [& args]
  (log "Start it up!")
  (show-dev-tools)
  (log (str "App started on " (.platform os)))

  (cond
   (dom/exists? (sel "#page-index"))
   (index-page/init (sel "#page-index"))

   (dom/exists? (sel "#page-grammar"))
   (grammar-page/init (sel "#page-grammar"))

   (dom/exists? (sel "#page-vocabulary"))
   (vocabulary-page/init (sel "#page-vocabulary"))

   (dom/exists? (sel "#page-texts"))
   (texts-page/init (sel "#page-texts"))))
