(ns clojureappm.server.middlewares.core)

(defn apply-middlewares
  "injects wrap-auth middleware to the handle map"
  [[root swagger & routes] vec]
  (let [injected-routes
          ;; (hash-map (keys (second ele)) (merge (vals (second ele)) {:here :this}));;
          (map #(if (map? (second %1)) (list (first %1) (hash-map (key (first (second %1))) (merge (val (first (second %1))) {:middleware vec}))) %1) routes)]
    (concat (list root swagger) injected-routes)))
