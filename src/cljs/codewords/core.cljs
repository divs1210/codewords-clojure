(ns codewords.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [codewords.handlers]
              [codewords.subs]
              [codewords.views :as views]
              [codewords.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (re-frame/dispatch-sync [:initialize-db])
  (js/setInterval #(re-frame/dispatch [:second-elapsed]) 1000)
  (mount-root))
