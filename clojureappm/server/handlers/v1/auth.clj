(ns clojureappm.server.handlers.v1.auth
  (:require [clojure.spec.alpha :as s]
            [clojureappm.services.auth.core :as auth]))
(defn- _handler ([req]

                 {:status 200
                  :body {:jwt (auth/login)}}))
(s/def ::text string?)

(def POST
  {
   :post {:summary "returns a JWT"
          :responses {200 {:body {:jwt ::text}}}
          :handler _handler}})
