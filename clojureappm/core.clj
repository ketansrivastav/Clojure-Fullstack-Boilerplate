(ns clojureappm.core
  (:gen-class)
  (:require [integrant.core :as ig]
            [integrant.repl :refer [clear go halt prep init reset reset-all]]
            [mongo-driver-3.client :as mcl]
            [clojureappm.database.core :as db]
            [clojureappm.server.core :as server]
            [ring.adapter.jetty :as jetty]))

(def config
  {::server {:port 5000 :join? false}})

(defmethod ig/init-key ::server [_ options]
  (jetty/run-jetty server/app options))

(defmethod ig/halt-key! ::server
  [_ server]
  (.stop server))

(defmethod ig/init-key ::mongo [_ options]
  (let [conn (mcl/create (if (= (System/getenv "env1") "production")
                           (System/getenv "MONGO_URL")
                           "mongodb://root:pwd@localhost/?authSource=admin"))]
    (db/init conn)
    conn))

(defmethod ig/halt-key! ::mongo
  [_ mongo]
  (.close mongo))
;;
(defn -main
  [& args]
  (ig/init config)

  (println (str "server started on http://localhost:" (::port (::server config)))))

(comment
  (integrant.repl/set-prep! (constantly config))
  (go)
  (reset)

  nil)

