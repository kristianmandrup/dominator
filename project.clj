(defproject com.2tothe8th/dominator "0.3.0"
  :description "Virtual-Dom in ClojureScript."
  :url "https://github.com/dubiousdavid/dominator"
  :dependencies [[org.clojure/clojure "1.7.0-beta2"]
                 [org.clojure/clojurescript "0.0-3178"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [stch-library/html "0.1.2" :exclusions [org.clojure/clojurescript]]
                 [jamesmacaulay/zelkova "0.4.0" :exclusions [org.clojure/clojure
                                                             org.clojure/clojurescript
                                                             org.clojure/core.async]]]
  :node-dependencies [[source-map-support "0.2.8"]]
  :plugins [[lein-cljsbuild "1.0.5"]
            [lein-npm "0.4.0"]]
  :source-paths ["src" "target/classes"]
  :resource-paths ["externs"]
  :clean-targets ["wiki" "counter" "mario"]
  :profiles {:dev {:dependencies [[org.clojure/core.match "0.2.2"]]}
             :doc {:dependencies [[org.clojure/clojurescript "0.0-2985"]]
                   :codox {:src-dir-uri "https://github.com/dubiousdavid/dominator/blob/master/"
                           :src-linenum-anchor-prefix "L"
                           :language :clojurescript}}}
  :cljsbuild
  {:builds [{:id "mario"
             :source-paths ["src" "dev"]
             :compiler {:main dominator.mario
                        :output-to "mario/mario.js"
                        :output-dir "mario"
                        :optimizations :none
                        :source-map true}}
            {:id "wiki"
             :source-paths ["src" "dev"]
             :compiler {:main dominator.wiki
                        :output-to "wiki/wiki.js"
                        :output-dir "wiki"
                        :optimizations :none
                        :source-map true}}
            {:id "counter"
             :source-paths ["src" "dev"]
             :compiler {:main dominator.counter
                        :output-to "counter/counter.js"
                        :output-dir "counter"
                        :optimizations :none
                        :source-map true}}]})
