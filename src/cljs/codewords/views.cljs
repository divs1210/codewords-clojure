(ns codewords.views
  (:require [re-frame.core :as re-frame]))

(defn time-comp [seconds]
  [:p "Seconds elapsed: " seconds])

(defn main-panel []
  (let [seconds (re-frame/subscribe [:seconds])]
    (fn []
      [:div#timer
       [time-comp @seconds]])))
