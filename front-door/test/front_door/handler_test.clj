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

(deftest enrollment-test
  (testing "/enroll accepts POST"
    (let [response (app (mock/request :post "/enroll"))]
      (is (= 200 (:status response))))))
