(ns dominator.core
  (:require [stch.html :as html]
            [html-vdom.attributes :refer [attrs->props]]))

(def VNode js/VDOM.VNode)
(def VText js/VDOM.VText)
(def create js/VDOM.create)
(def patch js/VDOM.patch)
(def diff js/VDOM.diff)

(defprotocol VDOMBuilder
  (-vtree [this]))

(extend-protocol VDOMBuilder
  string
  (-vtree [this] (new VText this))

  html/Element
  (-vtree [this] (new VNode (name (.-tag this))
                     (attrs->props (.-attrs this))
                     (clj->js (map -vtree (.-children this)))))

  default
  (-vtree [this] (new VText (.toString this))))

(defn ->vtree [x]
  (if (sequential? x)
    (new VNode "div" #js {} (clj->js (map -vtree x)))
    (-vtree x)))

(defrecord VDOM [tree root-node])

(defn patch-dom
  "Given a Javascript element elem returns a function
  that takes markup and renders to the DOM at elem."
  [elem]
  (let [vdom (atom nil)]
    (fn [markup]
      (let [new-tree (->vtree markup)]
        (if-some [curr-vdom @vdom]
          (let [patches (diff (.-tree curr-vdom) new-tree)
                new-root (patch (.-root-node curr-vdom) patches)]
            (reset! vdom (->VDOM new-tree new-root)))
          (let [root-node (create new-tree)]
            (.appendChild elem root-node)
            (reset! vdom (->VDOM new-tree root-node))))))))