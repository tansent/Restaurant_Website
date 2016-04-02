# Restaurant_Website

###Technique Points:

* The Overall design is using a MVC structure. (JavaBean - JSP - Servlet)

* On server side, the Data transfer layer, Business Logic Layer and Database layer have been decoupled. New classes will be created using 
factory mode and reflection. So, in the future, It is easy to maintain the project. For example, After making a new class in Business Logic
Layer, we only need to change some XML configuration files rather than to change interfaces in every layers. 
