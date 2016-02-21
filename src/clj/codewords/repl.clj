(ns codewords.repl 
  (:use [figwheel-sidecar.repl-api]))

;; start dev server
(start-figwheel!)

;; connect to cljs repl
(cljs-repl)
