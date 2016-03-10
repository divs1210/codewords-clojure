(ns codewords.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :seconds
 (fn [db]
   (reaction (:seconds @db))))

(re-frame/register-sub
 :hidden?
 (fn [db [_ cell]]
   (reaction (-> @db
                 :hidden
                 (contains? cell)))))
