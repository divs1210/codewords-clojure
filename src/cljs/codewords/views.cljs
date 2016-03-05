(ns codewords.views
  (:require [re-frame.core :as re-frame]))

(defn header []
  [:div#header
   [:p {:style {:background "#cce"}}
    "Codewords Demo"]])

(defn footer []
  [:div#footer {:style {:background "#cce"}}
   [:p "footer"]])

(defn timer []
  (let [seconds (re-frame/subscribe [:seconds])]
    (fn []
      [:div#timer
       [:p "seconds elapsed: " @seconds]])))

(defn main-panel []
  [:div#main-panel {:style {:text-align "center"
                            :background "#dfd"}}
   [header]
   [timer]
   [footer]])
