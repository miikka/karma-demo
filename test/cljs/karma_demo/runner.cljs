(ns karma-demo.runner
  (:require [jx.reporter.karma :refer-macros [run-all-tests]]
            ;; Remember to require all the test namespaces - otherwise
            ;; jx.reporter.karma won't find them!
            karma-demo.core-test))

(enable-console-print!)

(defn ^:export run-all [karma]
  (run-all-tests karma))
