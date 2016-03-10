(ns codewords.views
  (:require [re-frame.core :as rf]))

(def colors
  {:dark  "#99f"
   :light "#9f9"})

(defn header [text]
  [:div#header
   [:p {:style {:background (:dark colors)}}
    text]])

(defn footer [text]
  [:div#footer {:style {:background (:dark colors)}}
   [:p text]])

(defn timer []
  (let [seconds (rf/subscribe [:seconds])]
    (fn []
      [:div#timer
       [:p "seconds elapsed: " @seconds]])))

(defn cell [width row col]
  (let [hidden? (rf/subscribe [:hidden? [row col]])]
    (fn []
      [:td {:style {:width width
                    :background (if @hidden?
                                  (:light colors)
                                  (:dark colors))}
            :on-click (fn []
                        (rf/dispatch [:cell-clicked [row col]]))}])))

(defn row-of-cells [height width row cols]
  [:tr {:style {:height height}}
   (for [col (range cols)]
     ^{:key (str "col-" col)}
     [cell width row col])])

(defn grid [height width rows cols]
  (let [row-height (/ height rows)
        col-width  (/ width  cols)]
    [:div#grid>table {:style {:margin "auto"}}
     (for [row (range rows)]
       ^{:key (str "row-" row)}
       [row-of-cells row-height col-width row cols])]))

(defn main-panel []
  [:div#main-panel {:style {:text-align "center"
                            :background (:light colors)}}
   [header "CodeWords Demo"]
   [grid 100 100 5 5]
   [timer]
   [footer "March 2016"]])
