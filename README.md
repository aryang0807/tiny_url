# tiny_url
A tiny URL like REST API. It gives you tiny URL for some URL and the original URL from the tiny URL through GET request.

# Requirements
1. Gradle
2. JDK
3. Mongo
4. Postman

# Setting Up
1. Clone this github repository to your local machine using git clone <repository URL>  
2. Connecting to Mongodb
- go to src-> main -> resources -> application.properties and speficy the value of the 
  spring.data.mongodb.host //your mongodb host URL
  spring.data.mongodb.port // your mongodb port number
  spring.data.mongodb.database // name of the database you want to put your entries into
  
# API
# Sending Request through Postman
