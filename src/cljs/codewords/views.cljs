(ns codewords.views
  (:require [re-frame.core :as re-frame]))

(defn header-comp []
  [:div#timer
   [:p#header {:style {:background "#cce"}}
    "Codewords"]])

(defn timer-comp [seconds]
  [:div#timer
   [:p "seconds elapsed: " seconds]])

(defn footer-comp []
  [:div#footer {:style {:background "#cce"}}
   [:p "yayy! re-frame + figwheel!"]])

(defn main-panel []
  (let [seconds (re-frame/subscribe [:seconds])]
    (fn []
      [:div#main-panel {:style {:text-align "center"
                                :background "#dfd"}}
       [header-comp]
       [timer-comp @seconds]
       [footer-comp]])))
