(ns codewords.handlers
    (:require [re-frame.core :as re-frame]
              [codewords.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/register-handler
 :second-elapsed
 (fn [app-state _]
   (update-in app-state [:seconds] inc)))

(re-frame/register-handler
 :cell-clicked
 (fn [app-state [_ cell]]
   (update-in app-state [:hidden] conj cell)))
