(ns clojureappm.services.auth.core
  (:require [buddy.sign.jwt :as jwt]
            [clojureappm.database.history :as history]))
(def secret-key (or (System/getenv "secret-key") "local-secret"))

(defn login
  "generate and return a new JWT"
  []
  ;; create new database collection 
  (let [uuid (history/create-new-user)]
    ;; return a JWT with the userid
    (jwt/sign {:uid uuid} secret-key)))

(defn validate
  "validate an existing JWT. If valid, return payload, if not return false"
  [token]
  (try
    (jwt/unsign token secret-key)
    (catch Exception e false)))

(comment
  (login)
  )
