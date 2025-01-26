(ns clojureappm.server.middlewares.auth
  (:require [clojureappm.services.auth.core :as auth]))

(defn wrap-auth [handler]
  (fn [{h :headers :as all}]
    ; (handler (request))
    (let [session-info (auth/validate (get h "authorization"))]
      (if (false? session-info)
        {:status 403 :body "unauthorized"}
        (handler (merge all session-info))))))

