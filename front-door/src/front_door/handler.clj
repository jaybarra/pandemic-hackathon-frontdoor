(ns front-door.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [front-door.views :as views]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" 
       [] 
       (views/home-page))
  
  (GET "/enroll"
       []
       (views/enroll-page))

  (POST "/enroll" 
        {params :params}
        (let [_ (println "hi")]
          (views/enroll-page params)))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
