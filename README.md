# Geo API
Simple Rest API written in Java using Spring Boot and PostgreSQL.

### Endpoints

1) The Country API
   - POST /api/v1/countries Add a new country.
   - GET /api/v1/countries Retrieve all countries.
   - GET /api/v1/countries/{id} Get a country by its id.
   - PUT /api/v1/countries/{id} Update a country by its id.
   - DELETE /api/v1/countries/{id} Delete a country by its id
   
1) The POI API
   - POST /api/v1/poi Add a new POI.
   - GET /api/v1/poi Retrieve all POIs.
   - GET /api/v1/poi/{id} Get a POI by its id.
   - PUT /api/v1/poi/{id} Update a POI by its id.
   - DELETE /api/v1/poi/{id} Delete a POI by its id.

### Documentation 
   - /swagger-ui
   - /api-docs 

### Development

##### Prerequisites
Download and Install the [JDK](https://www.oracle.com/java/technologies/downloads/).  
Download and Install the [PostgreSQL](https://www.postgresql.org/https://www.postgresql.org/), an open source relational database.  
Install [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git), the free and open source distributed version control system.
Install [Docker](https://docs.docker.com/get-docker/), an open source containerization platform.

##### Clone the project
Run `git clone git@github.com:orbanszlrd/geo-api.git` to clone the repository from [GitHub](https://github.com/orbanszlrd/geo-api).

##### Create a Database
After installing PostgreSQL, create a database for your project.

##### Create the necessary Environment Variables
```
SPRING_DATASOURCE_URL=jdbc:postgresql://<hostname>:5432/<dbname>
SPRING_DATASOURCE_USERNAME=<username>
SPRING_DATASOURCE_PASSWORD=<password>
```