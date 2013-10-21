(defproject com.semperos/slavonic-primer "0.0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 ;; Build-time
                 [hiccup "1.0.4"]
                 ;; Run-time
                 [org.clojure/clojurescript "0.0-1934"]
                 [domina "1.0.2"]
                 [prismatic/dommy "0.1.2"]]
  :source-paths ["clj"]
  :main com.semperos.sp.gen
  :plugins [[lein-cljsbuild "0.3.4"]]
  :aliases {"cljs-watch" ["cljsbuild" "auto" "dev"]
            "cljs-prod" ["cljsbuild" "once" "prod"]}
  :cljsbuild {:builds
              {:dev {:source-paths ["cljs"]
                            :compiler {:output-to "node_modules/sp-app.js"
                                       :optimizations :simple
                                       :pretty-print true}
                            ;; :target :nodejs
                     }
               :prod {:source-paths ["cljs"]
                             :compiler {:output-to "node_modules/sp-app.js"
                                        :optimizations :advanced
                                        :pretty-print false}
                             ;; :target :nodejs
                      }}})
