(ns dominator.attributes)

(def attr->prop
  {"class" "className"
   "colspan" "colSpan"
   "contenteditable" "contentEditable"
   "for" "htmlFor"
   "ismap" "isMap"
   "maxlength" "maxLength"
   "minlength" "minLength"
   "novalidate" "noValidate"
   "readonly" "readOnly"
   "rowspan" "rowSpan"
   "tabindex" "tabIndex"
   "usemap" "useMap"})

(defn attrs->props
  "Convert a Clojure map of attributes to Javascript properties."
  [attrs]
  (reduce (fn [acc [k v]]
            (let [key (name k)]
              (if (= key "style")
                (aset acc "attributes" #js {"style" v})
                (aset acc (attr->prop key key) v))
              acc))
          (js-obj)
          attrs))
