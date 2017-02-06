(ns karma-demo.core-test
  (:require [karma-demo.core :refer [square]]
            [clojure.test :refer [deftest is async]]))

(deftest square-test
  (is (= 4 (square 2))))

(deftest failing-test
  (is (= 0 2)))

(deftest slow-test
  (async done
    (js/setTimeout (fn [] (is true) (done)) 1000)))
