(ns clojureappm.server.handlers.v1.user
  (:require [clojure.spec.alpha :as s]
            [clojureappm.services.user.core :as user]))
(defn- new-session-handler [all]
  {:status 200
   :body {:sessionId (user/get-new-search-session-id)}})

(def new-session
  {
   :post {:summary "create new  session for the logged in user"
          :responses {200 {:body {:sessionId string?}}}
          :handler new-session-handler}})

