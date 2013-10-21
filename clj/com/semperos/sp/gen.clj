(ns ^{:doc "Generate static HTML files for 'pages' within the Slavonic Primer application.

This allows developing the application as a pseudo single-page app, wherein page transitions are real page transitions, but each page's important rendering and behavior is all handled in JavaScript.

This namespace allows defining a shared site layout and those 'skeleton' pages into which the ClojureScript side of things will inject its DOM."}
  com.semperos.sp.gen
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.stacktrace :as st]
            [hiccup.page :refer [html5 include-css include-js]]))

(defn layout
  [page-name]
  (html5
   {:lang "en"}
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport" :content "width=device-width"}]
    [:title "Slavonic Primer"]
    (include-css
     "static/bootstrap/dist/css/bootstrap.min.css"
     "static/css/app.css")
    (include-js "node_modules/sp-app.js")]
   [:body {:onload "com.semperos.sp.app.start()"
           :class (str "page-" page-name)}
    [:header.navbar.navbar-default {:role "banner"}
     [:div.container
      [:div.navbar-header
       [:button.navbar-toggle {:type "button"}
        [:span.sr-only "Toggle navigation"]
        [:span.icon-bar]
        [:span.icon-bar]
        [:span.icon-bar]]
       [:a.navbar-brand {:href "index.html"} "Slavonic Primer"]]
      [:nav.collapse.navbar-collapse {:role "navigation"}
       [:ul.nav.navbar-nav
        [:li
         [:a {:href "grammar.html"} "Grammar"]]
        [:li
         [:a {:href "vocabulary.html"} "Vocabulary"]]
        [:li
         [:a {:href "texts.html"} "Texts"]]]
       ;; [:ul.nav.navbar-nav.navbar-right
       ;;  [:li
       ;;   [:a {:href "/logout"}
       ;;    [:span.glyphicon.glyphicon-log-out] " " "Logout"]]]
       ]]]

    [:main.container
     [:div {:id (str "page-" page-name)}]]

    [:footer
     [:div.container
      [:div
       [:hr]
       [:div.row
        [:div.col-md-12
         "Slavonic Primer, version 0.0.1"]]]]]]))

(defn shell
  [name]
  (fn [] (layout name)))

(defn write-static-page
  "Spit out Hiccup as HTML to file with given name"
  [page-name page-content]
  (spit page-name page-content))

(defn all-static-pages
  []
  (let [names ["index" "grammar" "vocabulary" "texts"]
        shells (map shell names)]
    (zipmap names shells)))

(defn clean-pages
  []
  (doseq [[page-name _] (all-static-pages)
          :let [page-name (str page-name ".html")]]
    (println "Deleting" page-name)
    (io/as-file page-name)))

(defn write-pages
  []
  (doseq [[page-name page-fn] (all-static-pages)
          :let [page-name (str page-name ".html")]]
    (println "Writing" page-name)
    (write-static-page page-name (page-fn))))

(defn firstl
  [xs]
  (-> xs
      first
      (fnil str/lower-case "")))

(defn -main
  [& args]
  (cond
   (= (firstl args) "write") (write-pages)
   (= (firstl args) "clean") (clean-pages)
   :else (write-pages)))
