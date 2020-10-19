(ns lakepend.db
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.string :as str]))

(def db-conf {:classname "org.sqlite.JDBC"
              :subprotocol "sqlite"
              :subname "resources/database.db"})

(defn insert-weather-data
  [weather-data]
  (jdbc/insert-multi! db-conf :weather weather-data))

(defn find-last-datetime
  []
  (-> jdbc/query db-conf "select recorded_at from order by recorded_ar desc limit 1"
      first
      :recorded_at))