
## Mongo Repositories
 
**Supported keywords for query methods**

Keyword | Sample | Logical result
--- | --- | ---
GreaterThan	| findByAgeGreaterThan(int age)	 | {"age" : {"$gt" : age}}
LessThan | findByAgeLessThan(int age) | {"age" : {"$lt" : age}}
Between | findByAgeBetween(int from, int to) | {"age" : {"$gt" : from, "$lt" : to}}
IsNotNull, NotNull | findByFirstnameNotNull() | {"firstname" : {"$ne" : null}}
IsNull, Null | findByFirstnameNull() | {"firstname" : null}
Like | findByFirstnameLike(String name) | {"firstname" : name} (name as regex)
Regex |findByFirstnameRegex(String name) | {"firstname" : {"$regex" : name }}
(No keyword) | findByFirstname(String name) | {"firstname" : name}
Not | findByFirstnameNot(String name) | {"firstname" : {"$ne" : name}}
Near | findByLocationNear(Point point) | {"location" : {"$near" : [x,y]}}
Within | findByLocationWithin(Circle circle) | {"location" : {"$within" : {"$center" : [ [x, y], distance]}}}
Within | findByLocationWithin(Box box) | {"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}True
IsTrue, True | findByActiveIsTrue() | {"active" : true}
IsFalse, False | findByActiveIsFalse() | {"active" : false}
Exists | findByLocationExists(boolean exists) |{"location" : {"$exists" : exists }}

Further information at:
* https://www.baeldung.com/queries-in-spring-data-mongodb
* https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html



## REST Repositories

Annotation _@RepositoryRestResource_ will define the exposed path
```
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
```

In case we need to call a method from repository, we'll use /search and the method name/params:
```
// http://localhost:8083/employeeRepo/search/findByLastNameLike?lastName=ra
public List<Employee> findByLastNameLike(@Param("lastName") String lastName);
...
```
 
Further information at:
* https://spring.io/guides/gs/accessing-data-rest/

**Swagger**

http://localhost:8083/swagger-ui/

![endpoints](https://github.com/eugerossi/spring-boot-rest-mongo/blob/master/endpoints/swagger.png?raw=true)