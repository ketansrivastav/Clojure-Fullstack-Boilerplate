(ns clojureappm.database.core
  (:require [mongo-driver-3.client :as mcl]
            [mongo-driver-3.collection :as mc]))
(defonce mongo-client (promise))
(defonce database (promise))

(defn init
  [client]
  (deliver mongo-client client))


