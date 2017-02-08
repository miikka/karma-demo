(defproject karma-demo "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.456"]
                 [karma-reporter "2.1.1"]]
  :source-paths ["src/clj"]
  :plugins [[lein-cljsbuild "1.1.5"]]

  :cljsbuild
  {:builds {:test {:source-paths ["src/cljs" "test/cljs"]
                   ;; :notify-command makes lein-cljsbuild run the tests after
                   ;; the build is done.
                   :notify-command ["./trigger-karma.sh"]
                   :compiler {:output-to "target/out/test_suite.js"
                              :output-dir "target/out"
                              :main karma-demo.runner
                              :parallel-build :true
                              ;; Karma's web server serves the assets under
                              ;; /base/, so that's our :asset-path.
                              :asset-path "base"
                              ;; :none works too!
                              :optimizations :advanced
                              :pretty-print false}}}})
