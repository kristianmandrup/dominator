(defproject com.2tothe8th/dominator "0.4.0"
  :description "Virtual-Dom in ClojureScript."
  :url "https://github.com/dubiousdavid/dominator"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.async "0.2.374"]
                 [cljsjs/virtual-dom "2.1.1-0"]
                 [stch-library/html "0.1.2" :exclusions [org.clojure/clojurescript]]
                 [jamesmacaulay/zelkova "0.4.0" :exclusions [org.clojure/clojure
                                                             org.clojure/clojurescript
                                                             org.clojure/core.async]]]
  :node-dependencies [[source-map-support "0.2.8"]]
  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-npm "0.4.0"]]
  :source-paths ["src" "target/classes"]
  :resource-paths ["externs"]
  :profiles {:doc {:dependencies [[org.clojure/clojurescript "0.0-2985"]]
                   :codox {:src-dir-uri "https://github.com/dubiousdavid/dominator/blob/master/"
                           :src-linenum-anchor-prefix "L"
                           :language :clojurescript}}})
