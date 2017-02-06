(defproject karma-demo "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.456"]
                 [karma-reporter "2.1.1"]]
  :source-paths ["src/clj"]
  :plugins [[lein-cljsbuild "1.1.5"]]
  :cljsbuild
  {:builds {:test {:source-paths ["src/cljs" "test/cljs"]
                   :compiler {:output-to "target/test_suite.js"
                              :main karma-demo.runner
                              :optimizations :advanced
                              :parallel-build :true
                              :pretty-print false}
                   :notify-command ["./trigger-karma.sh"]}}})
