For your database you 
must access it using the entry “jdbc/HW3DB”
-All DB interactions/entities/controllers are mapped to HW3DB


All data access through JPA (this will allow JPA to create all the tables you need on my DB instance)
- Done throughout the application; 

2 JPA entity beans 
- See "addPerson.xhtml" and "addAnimal.xhtml"

Use of built in JSF validation, develop 
custom validation
- Under "addAnimal.xhtml", a built in JSF validator will check the length of the entry under "Pet Name"
- On the same form, the "Pet Species" form will prevent the user from trying to submit "Human" or "human" using custom validation

Managed Bean controller that saves on submission prior to directing it to the resulting view
- See "addPerson.xhtml"

AJAX 
- See "index.xhtml"