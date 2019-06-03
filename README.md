# Prerequisite :

	Java 7 
	Liferay 6.2
	Mysql 5.6
	Ant

==================================================================
# Functionality Covered :

- Basic CRUD Operation
- Liferay Validation
- Search Container used to paginate data
- Sorting based on columns (Title, Vocabulary, Post Date)

==================================================================

# STEPS :

1. Update portal-ext.properties 

D:\Liferay6.2\bundles\tomcat-7.0.42\webapps\ROOT\WEB-INF\classes\portal-ext.properties

jdbc.default.driverClassName=com.mysql.jdbc.Driver
jdbc.default.url=jdbc:mysql://localhost/entityManager?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
jdbc.default.username=root
jdbc.default.password=root

2. Create corresponding database in MYSQL and grant all permission to your user 

   create database entityManager;
   grant all on entityManager.* to 'root'@'localhost' identified by 'root' with grant option;
   flush privileges;

3. Create one site in Liferay and add one public page

4. Put portlet on that public page

5. Go to Admin -> Site Configuration -> Categories -> add your entity Vocabulary and category combination (1 vocabulary to many category)

6. Add Entity from portlet

7. Edit/Delete entity from corresponding action