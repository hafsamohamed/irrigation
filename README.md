# irrigation

This is a Irrigation system using Spring boot and rest API java

# 🛠 How to run
**Maven**
* Run the `mvn install` phase from the project directory to create the shaded executable jars in the `target/` directory
* Run the jars using the `java -jar` command

**MySQL**
* Create a docker image for using database user using MySQL Commandline 8.0 using the following commands:
```cmd
docker run --detach --env MYSQL_ROOT_PASSWORD=root --env MYSQL_USER=admin --env MYSQL_PASSWORD=admin --env MYSQL_DATABASE=irrigation --name mysql --publish 3309:3306 mysql:8-oracle;
```
then
```cmd
docker exec -it mysql bash
```
then 
```cmd
mysql -u admin -p
```
then enter password :"admin"


# Documentation
* in the package tes/java/com/example/irrigation/api/resources
  class: ApiTest it contains method to test the api through mocking the sensior simulator see this class it will be help you to understand the whole api simply

# 👷‍♀️ Contributors
* [Hafsa Mohamed](https://github.com/hafsamohamed)
