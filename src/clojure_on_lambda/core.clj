(ns clojure-on-lambda.core
  "Sample AWS Lambda function, written in Clojure, which summarizes
  the JSON event data provided to the Lambda function, and returns the
  summarization as JSON data."
  (:require [clojure.data.json :as json])
  (:gen-class
    :methods [^:static [handleEvent [String] String]]))

(defn summarize-data
  "Summarizes the provided data."
  [data]
  {:keys (keys data)
   :key_count (count
               (keys data))})

(defn data-helper
  "Prints debugging messages to STDOUT, and calls
  `summarize-data` on provided data."
  [data]
  (println "Got:" data)
  (let [result (summarize-data (json/read-str data))]
    (println "Summarized:" result)
    (json/write-str result)))

(defn -main
  "Calls `data-helper` with input from STDIN."
  [& args]
  (let [event (read-string (first args))]
    (data-helper event)))

(defn -handleEvent
  "Hook for AWS Lamda; calls `data-helper`
  on the provided event data."
  [this event]
  (data-helper event))
