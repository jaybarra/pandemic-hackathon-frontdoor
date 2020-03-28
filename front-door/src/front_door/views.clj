(ns front-door.views
  (:require [clojure.string :as str]            
            [hiccup.page :as page]
            [ring.util.anti-forgery :as util]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Locations: " title)]
   (page/include-css "/css/styles.css")])

(def header-links
  [:div#header-links
   "[ "
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/enroll"} "Enroll"]
   " ]"])

(defn home-page
  []
  (page/html5
   (gen-page-head "Welcome")
   header-links
   [:h1 "FrontDoor"]
   [:p "COVID-19 Front Door Response"]))

(defn enroll-page
  []
  (page/html5
   (gen-page-head "Enroll")
   header-links
   [:h1 "Enroll"]
   [:form {:action "/enroll" :method "POST"}
    [:a {:href "/enroll"} "Enroll"]
    " ]"]))
