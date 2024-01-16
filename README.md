1.Download the Docker container in your local

2.Download the images required for running selenium grid on docker by navigating to url : **https://hub.docker.com/r/selenium/hub**

3.Understand the docker compose file provided in the framework

Let’s break down this YAML file:

**version** : “3” : This line specifies the version of the Docker Compose file syntax. The version “3” is used in this case

**services** : This section defines the services(containers) that make up the Selenium Grid infrastructure

**Selenium-hub** : This section defines the Selenium Grid hub services

**image**: selenium/hub:4.16.1-20231219 : Specifies the Docker image to use for the hub service. In this case, the selenium/hub image is used, and the 4.16.1-20231219 tag represents the version which we are using now

**ports** : “4444:4444” : Maps the hosts machine’s port 4444 to the container’s port 4444. This allows external connections to the Selenium Grid hub

**Chrome** : this section defines the Selenium Grid  node service for chrome

**Image** : selenium/node-chrome: 4.16.1-20231219 : Specifies the Docker image to use for Chrome node service. Here, the selenium/node-chrome image with the  4.16.1-20231219  tag is used

**depends_on** : - selenium-hub : Indicates that the Chrome node depends on the selenium-hub service. Docker compose ensures that the hub service starts before the Chrome node

**environment** : -SE_EVENT_BUS_HOST=selenium-hub : Sets the SE_EVENT_BUS_HOST environment variable for Chrome node to point to the selenium-hub service. This allows the node to register with the hub

4.Go to the path of docker compose file locally and open command prompt from that location

5.Check for if any conatainers are running already by hitting this : **docker ps**

6.Provide the command 'docker-compose up' in the command prompt and check if you see logs

7.Go the the localhost port 4444 to check if Selenium Grid is up and running : **http://localhost:4444/ui#**

8.Again check for running containers using same command docker ps

9.Execute your tests using testng.xml file which will execute the tests on grid and same can be seen in sessions tab of the grid

10.open the session with password 'secret' to view your execution

11.You can also scale your number of nodes for a given browser using this command : docker-compose scale chrome=3

12.Check in grid if the added nodes are visible or not

13.Once your work is done can bring the grid down by executing the command 'docker-compose down'




**Useful links :**

**https://github.com/SeleniumHQ/docker-selenium**

**https://hub.docker.com/**

**https://github.com/SeleniumHQ/docker-selenium/blob/trunk/docker-compose-v3.yml**

**https://docs.docker.com/get-started/overview/**

**https://www.selenium.dev/documentation/grid/**

**https://docs.docker.com/get-started/08_using_compose/**

**Useful commands :**

docker –version – To know the version of docker your system is having

docker images : To show all the images

docker ps : To show all the containers

docker ps –a : To show all the containers including stopped containers

docker start container_id : To start a particular container

docker stop container_id : To stop a particular container

docker rm container_id : To remove the container with the given id

docker system prune –f : To remove all stopped containers

docker system prune –a : To remove all stopped containers +unused images

docker logs containerName : To check container logs

docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-chrome:4.16.1-20231212

docker-compose up – To start the grid

docker-compose down : To tear down the grid

docker-compose restart : To restart the grid

docker-compose scale chrome=3 : To increase the no. of nodes we can use this command for the browser you want to increase

