(ns codewords.views
    (:require [re-frame.core :as re-frame]))

(defn time-comp [seconds]
  [:div {:style {:text-align "center"}} 
   "Seconds elapsed: " seconds])

(defn main-panel []
  (let [seconds (re-frame/subscribe [:seconds])]
    (fn []
      [time-comp @seconds])))

(defonce ticker
  (js/setInterval #(re-frame/dispatch [:second-elapsed]) 1000))
