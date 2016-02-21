(ns codewords.views
  (:require [re-frame.core :as re-frame]))

(defn header-comp []
  [:p#header {:style {:background "#cce"}}
   "yayy! re-frame + figwheel!"])

(defn timer-comp [seconds]
  [:div#timer
   [:p "seconds elapsed: " seconds]])

(defn footer-comp []
  [:div#footer {:style {:background "#cce"}}
   [:p "Codewords"]])

(defn main-panel []
  (let [seconds (re-frame/subscribe [:seconds])]
    (fn []
      [:div#main-panel {:style {:text-align "center"
                                :background "#efe"}}
       [header-comp]
       [timer-comp @seconds]
       [footer-comp]])))
