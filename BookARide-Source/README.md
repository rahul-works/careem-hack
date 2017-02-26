Workspace Settings :
1. Import as Gradle Project
2. Refresh the Dependencies
3. Project should be a Dynamic Web Project ( In eclipse --> Properties -->ProjectFacets-->DynamicWebProject )
4. Change Deployment Assembly(In eclipse -->Properties-->Add ('src/main/webapps' should be mapped to '/'))

Project/DB Configuration RDBMS:
1. Change the DB properties accordingly in 'database.properties'

Project/DB Configuration NO-SQL :
1. Change the DB properties accordingly in 'database.properties'

API Documentation :
1. EndPoint : localhost
2. PortNumber : 8080
3. BaseURL : /MultiDB/swagger-ui.html
4. e.g. http://localhost:8080/MultiDB/swagger-ui.html

Demo:

NoSQL -- Use hello-mongo-controller
addUser, getUsers, updateUser APIs refer to DB1
addUser2, getUsers2, updateUser2 APIs refer to DB2

SQL -- subscription-controller
addPlan, getPlan/{planId}, updatePlan APIs refer to DB1
addPlan2, getPlan2/{planId}, updatePlan2 APIs refer to DB2

Images:
For References, please look into below paths
/MultiDB/src/main/resources/Screen Shot 2016-10-13 at 6.25.07 PM.png
/MultiDB/src/main/resources/Screen Shot 2016-10-13 at 6.31.25 PM.png