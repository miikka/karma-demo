(ns karma-demo.runner
  (:require [jx.reporter.karma :refer-macros [run-all-tests]]
            karma-demo.core-test))

(enable-console-print!)

(defn ^:export run-all [karma]
  (run-all-tests karma))
