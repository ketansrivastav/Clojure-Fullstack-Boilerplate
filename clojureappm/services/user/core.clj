(ns clojureappm.services.user.core
  (:require [clojureappm.database.history :as db]))

(defn get-new-search-session-id
  ""
  []
  (.toString (java.util.UUID/randomUUID)))

(defn save-search-page
  ""
  [user-id page]
  (let [meta-data {:timestamp (System/currentTimeMillis)}]

    (db/insert-new-search user-id (merge page meta-data))))

(defn get-user-history
  [user-id]
  (println (str "getting history for: " user-id))
  (db/get-user-history user-id))

(defn get-user-session
  [user-id session-id])
