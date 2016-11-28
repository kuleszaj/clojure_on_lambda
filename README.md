# clojure-on-lambda

A Clojure library designed to demonstrate how to use an AWS Lambda function written in Clojure.

## Usage

On your local machine, run with `leiningen`, passing in Clojure-style map as string:

- `lein run {key1 value1, key2 value2, key3 value3}`

To run with AWS Lambda:

- Package with `lein uberjar`.
- Upload the resulting standalone JAR to AWS Lambda.
- Set AWS Lambda Runtime as "Java 8".
- Specify the handler as "clojure_on_lambda.core::handleRequest".
- Test with sample data.

## License

See [LICENSE](LICENSE) file.
