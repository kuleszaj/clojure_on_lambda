(ns clojure-on-lambda.core
  "Sample AWS Lambda function, written in Clojure, which summarizes
  the event data provided to the Lambda function, and returns the
  summarization as JSON data."
  (:require [clojure.data.json :as json])
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestHandler]
   :methods [^:static [handleRequest [String String] String]]))

(defn summarize-map
  "Summarizes the provided map."
  [map-data]
  {:keys (keys map-data)
   :key_count (count
               (keys map-data))})

(defn data-helper
  "Prints debugging messages to STDOUT, and calls
  `summarize-map` on provided data."
  [map-data]
  (println "Got:" (str map-data))
  (let [result (summarize-map map-data)]
    (println "Summarized:" result)
    (json/write-str result)))

(defn -main
  "Calls `data-helper` with input from STDIN."
  [& args]
  (let [event (read-string (first args))]
    (data-helper event)))

(defn -handleRequest
  "Hook for AWS Lamda; calls `data-helper`
  on the provided event data."
  [this event context]
  (data-helper event))
