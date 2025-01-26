(defproject clojureappm "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [integrant/integrant "0.8.0"]
                 [integrant/repl "0.3.2"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [metosin/reitit "0.5.15"]
                 [metosin/spec-tools "0.10.5"]
                 [org.mongodb/mongodb-driver-sync "3.11.2"]
                 [mongo-driver-3 "0.5.0"]
                 [cheshire "5.10.0"]
                 [clj-http "3.12.3"]
                 [babashka/babashka.curl "0.0.3"]
                 [buddy/buddy-sign "3.4.1"]
                 [com.rpl/specter "1.1.3"]]

  :main ^:skip-aot clojureappm.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})

