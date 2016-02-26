(defproject counter "0.2.0"
  :description "Virtual-Dom in ClojureScript."
  :url "https://github.com/dubiousdavid/dominator"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.async "0.2.374"]
                 [figwheel-sidecar "0.5.0"]
                 [cljsjs/virtual-dom "2.1.1-0"]
                 [com.2tothe8th/dominator "0.4.0"]
                 [org.clojure/core.match "0.2.2"]]
  :node-dependencies [[source-map-support "0.2.8"]]
  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-npm "0.4.0"]]
  :source-paths ["src" "target/classes"]
  :clean-targets ["target" "js"]
  :cljsbuild
  {:builds [{:id "counter"
             :source-paths ["src"]
             :compiler {:output-to "js/main.js"
                        :externs ["externs/dominator.js"]
                        :optimizations :advanced}}]})
