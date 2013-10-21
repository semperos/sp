(ns com.semperos.sp.event
  (:require goog.positioning
            [domina :as d])
  (:import goog.ui.Popup)
  (:require-macros [com.semperos.sp.macros :refer [log]]))

(defn href-from-event
  "Return href from <a> target of click event using Google event listeners."
  [e]
  (log (.-clientX (.-evt e)) (.-clientY (.-evt e)))
  (-> e .-evt .-currentTarget .-href))

(defn client-x
  [e]
  (.-clientX (.-evt e)))

(defn client-y
  [e]
  (.-clientY (.-evt e)))

(defn prevent-default
  [e]
  (.preventDefault (.-evt e)))
