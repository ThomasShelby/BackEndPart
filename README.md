# BackEndPart
 Continuous integration and deployment (Travis CI):
https://travis-ci.org/ThomasShelby/BackEndPart/builds
* to support Lombok, you need to install the plugin of Lombok for Intellij IDEA;
* to create all tables for the first time, you should go to application.properties and set value 
```
hibernate.hbm2ddl.auto=create
```
* to fill test data into tables:
    - go to general__insert.sql and copy scripts;
    - go to Database tab inside Intellij IDEA;
    - press on "tables" folder and select "Open New Console";
    - paste scripts and run; 