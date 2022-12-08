# Narakeet Text to Speech Streaming API example in Java

This repository provides a quick example demonstrating how to access the Narakeet [streaming Text to Speech API](https://www.narakeet.com/docs/automating/text-to-speech-api/) from Java. 

The example sends a request to generate audio from text and saves it `output.mp3` in the local directory.

## Prerequisites

To use this example, you will need Java 11 or later, and Maven 3 or later, and an API key for Narakeet.

The example uses the [`org.apache.http`](https://hc.apache.org/) library to execute HTTPS requests.

## Running the example

1. run `mvn install` to download the dependencies
2. edit [src/main/java/com/narakeet/Example.java](src/main/java/com/narakeet/Example.java) and change the voice and the text that will be sent to the API.
3. run `mvn compile exec:java -Dexec.args=YOUR_API_KEY` (replace `YOUR_API_KEY` with the Narakeet API key)

## More information

Check out https://www.narakeet.com/docs/automating/text-to-speech-api/ for more information on the Narakeet Text to Speech API
