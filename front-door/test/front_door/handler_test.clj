(ns front-door.handler-test
  (:require [clojure.test :refer :all]
           [ring.mock.request :as mock]
           [front-door.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= 200 (:status response)))))
 
  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= 404 (:status response))))))


;; (deftest enrollment-tests
;;   (testing "start admission"
;;     (let [context
;;           response (app (-> (mock/request :post "/enroll")
;;                             (mock/json-body {:foo "bar"})))]
;;       (is (= 200 (:status response))))))
