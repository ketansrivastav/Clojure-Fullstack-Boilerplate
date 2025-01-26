(ns clojureappm.server.middlewares.sanitize
  (:require [com.rpl.specter :as sp]))

(defn wrap-sanitize [handler]
  (fn [all]
    (handler (merge all {:parameters (sp/transform [sp/ALL (sp/walker string?)]
                                                   #(-> % str (.replace "&" "&amp;") (.replace "<" "&lt;") (.replace ">" "&gt;"))
                                                   (:parameters all))}))))

(comment
  (sp/transform [sp/ALL (sp/walker string?)]
                #(clojure.string/replace %1 #"hello" "t3st") {:str {:text [{:a "hello workd"}]}})
  (sp/select [sp/ALL] {:str {:text {:a "hello workd"}}})

  (merge {:body {:a 2}} {:body {:b 0}})
  ;;;
  )

