(defproject clojure-on-lambda "0.1.0-SNAPSHOT"
  :description "Sample AWS Lambda function, written in Clojure."
  :url "https://github.com/kuleszaj/clojure_on_lambda"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [com.amazonaws/aws-lambda-java-core "1.1.0"]]
  :main ^:skip-aot clojure-on-lambda.core
  :plugins [[lein-cljfmt "0.5.6"]
            [lein-kibit "0.1.2"]
            [lein-bikeshed "0.3.0"]]
  :profiles {:uberjar {:aot :all}})
