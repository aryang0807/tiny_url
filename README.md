# tiny_url
A tiny URL like REST API. It gives you tiny URL for some URL and the original URL from the tiny URL through GET request.

# Requirements
1. Gradle
2. JDK
3. Mongo
4. Postman

# Setting Up
1. Clone this github repository to your local machine using git clone "repository URL"  
2. Connecting to Mongodb
- go to src-> main -> resources -> application.properties and specify the values of the following:   
  spring.data.mongodb.host (your mongodb host URL)  
  spring.data.mongodb.port (your mongodb port number)  
  spring.data.mongodb.database  (name of the database you want to put your entries into)  

# Running On Mac 
To build the apllication use the command - `./gradlew build`  

To run the application use the command - `./gradlew bootRun`  

# API
1.`/urls`  
**GET** request : Returns all entries present in MongoDB.  

Sending Request via Postman:  
`http://localhost:8080/urls`  

Sending Request via terminal:  
`curl -X GET 'http://localhost:8080/urls'`  
    
2.`/urls/?testUrl="URL"`  
**GET** request: Checks if the URL is present in the database, if so then it returns it's tinyURL and if it is not present it shortens the URL and save the entry to database and returns it's tinyURL.  

Example:    
Sending GET Request via Postman:  
`http://localhost:8080/urls/?testUrl=https://www.youtube.com/`   

Sending Request via terminal:  
`curl -X GET 'http://localhost:8080/urls/?testUrl=https://www.youtube.com/'`  

Response:  
hmtcse/uwuwy   

3.`/tinyURL/?testUrl="tiny URL"`  
**GET** request: Checks if the tiny URL is present in the database, if so then it returns it's original URL and if it is not present then it returns "No such url found". 

Example:   
Sending GET Request via Postman:   
`http://localhost:8080/tinyUrl/?testUrl=hmtcse/uwuwy`   

Sending Request via terminal:  
`curl -X GET 'http://localhost:8080/tinyUrl/?testUrl=hmtcse/uwuwy'`  

Response:  
https://www.youtube.com/   

