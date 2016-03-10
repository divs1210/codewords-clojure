(ns codewords.views
  (:require [re-frame.core :as rf]))

(def colors
  {:dark  "#99f"
   :light "#9f9"})

(defn header []
  [:div#header
   [:p {:style {:background (:dark colors)}}
    "Codewords Demo"]])

(defn footer []
  [:div#footer {:style {:background (:dark colors)}}
   [:p "March 2016"]])

(defn timer []
  (let [seconds (rf/subscribe [:seconds])]
    (fn []
      [:div#timer
       [:p "seconds elapsed: " @seconds]])))

(defn cell [row col width%]
  (let [hidden? (rf/subscribe [:hidden? [row col]])]
    (fn []
      [:td {:style {:width width%
                    :background (if @hidden?
                                  (:light colors)
                                  (:dark colors))}
            :on-click (fn []
                        (rf/dispatch [:cell-clicked [row col]]))}])))

(defn row-of-cells [row cols height% width%]
  [:tr {:style {:height height%}}
   (for [col (range cols)]
     ^{:key (str "col-" col)}
     [cell row col width%])])

(defn grid [rows cols]
  (let [height% (/ 100 rows)
        width%  (/ 100 cols)]
    [:div#grid>table {:style {:margin "auto"}}
     (for [row (range rows)]
       ^{:key (str "row-" row)}
       [row-of-cells row cols height% width%])]))

(defn main-panel []
  [:div#main-panel {:style {:text-align "center"
                            :background (:light colors)}}
   [header]
   [grid 5 5]
   [timer]
   [footer]])
