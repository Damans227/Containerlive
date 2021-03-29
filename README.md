# Containerlive

 Containerlive is a simple application for managing `Docker Containers` on Mac, Linux and Windows. It is an open source project built as a management solution for Docker. It consists of a web UI that allows you to easily manage your Docker Containers and Images, so far. Containerlive, makes use of the [Docker-Java API][DockerJava] to handle its interactions and monitoring of Docker Containers and Images.

 [DockerJava]: https://github.com/docker-java/docker-java

## How to run the application

1. In order to get this application up and running quickly, you will need to have docker run time installed on your computer. 
2. On a local computer where you have a docker runtime installed, clone this repository and go to `Deployment` folder. 
3. Now, run the following docker commands one by one:<br />
   a) `docker build -t containerlive-webapp .`<br />
   b) `docker container run --name container -dt -p 8090:8080 containerlive-webapp`<br />
4. The application should be up and running now on the following `URL: http://localhost:8090/containerlive/`


 ## How to use Containerlive

 <blockquote><b>Important Note:</b> In order to run this app, you will have to configure your Docker Host o accept incoming traffic on the TCP layer on a certain port. Typically, the port that is used for this purpose is 2375 or 2376. </blockquote>

 1. Click inside the text box on far left at the top of the page, where it says <i>'Enter ticker symbol'</i>.
 2.  Enter a valid ticker symbol, such as 'GOOG' and hit Search. 
 3.  You will see the current price of the stock under 'Stock Details' section. 
 4.  On the far right of stock details section, click on 'Quick History' in green color to view the historical data of the stock. 
 5.  Similarly, you can look up Weekly and Monthly details of a given stock as well. In order to dos so, simply click on the button called "Advanced Search" on the top right corner. 

 ## User Stories

 - A user can find the current price of any given stock. 
 - A user can view Weekly/ Monthly historical data of a stock. 

 ## Features

 - Easy to understand code which is built following MVC design pattern. 
 - Simple and straightforward User Interface. 
 - Can be hosted as a micro-service in a container. Making it easier to deploy the app over cloud. 

 ## Future features

 - Code refactoring (Minimizing the workload in controllers).
 - Implement auto refresh.
 - Implement user profiles and portfolio management. 
 - Make it small screen compatible.

 ## Dependencies 

 - Yahoo Finance Java API
 - Bootstrap 4
 - JSTL 
 - Enterprise Java
 - JSP and Servlets
 - Docker container runtime

## What the app looks like

![screenshot](https://raw.githubusercontent.com/Damans227/Stockquote/main/Screenshots/homescreen.png)
