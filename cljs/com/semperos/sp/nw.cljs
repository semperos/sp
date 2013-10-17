(ns ^{:doc "Utilities for node-webkit"}
  com.semperos.sp.nw)

(defn require-gui
  []
  (js/require "nw.gui"))

(defn get-window
  ([] (get-window (require-gui)))
  ([gui]
     (.get (.-Window gui))))

(defn show-dev-tools
  ([] (show-dev-tools (require-gui)))
  ([gui]
     (.showDevTools (get-window gui))))
