(ns clojureappm.server.routes.v1.core
  (:require [clojureappm.server.handlers.v1.auth :as auth-handler]
            [clojureappm.server.middlewares.auth :as auth-middleware]
            [clojureappm.server.middlewares.core :as middlewares]
            [clojureappm.server.middlewares.sanitize :as sanitize-middleware]))

(def SEARCH
  ["/api/v1"
   {:swagger {:tags ["web search"]}}])

(def AUTH
  ["/api/v1/auth"
   {:swagger {:tags ["auth"]}}
   ["/login" auth-handler/POST]])

(def USER
  ["/api/v1/user"
   {:swagger {:tags ["user"]
              :security [{:auth []}]}}])

(def APIs [SEARCH AUTH (middlewares/apply-middlewares USER [auth-middleware/wrap-auth sanitize-middleware/wrap-sanitize])])

