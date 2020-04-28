# SpringBootApp

- run:  

	./mvnw spring-boot:run  
	
	browse localhost:8080


- Rest API commands:  

	GET all books:  
	curl -s -X GET "http://localhost:8080/books" -H "accept: */*" | json_pp
	
	GET a book by id (ex: id=1001):  
	curl -s -X GET "http://localhost:8080/books/1001" -H "accept: */*" | json_pp

	DELETE a book by id (ex: id=1001):  
	curl -s -X DELETE "http://localhost:8080/books/1001" -H "accept: */*"
	
	POST add a new book:  
	curl -s -X POST "http://localhost:8080/books" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"title\": \"Java 2\", \"author\": \"Chris Brown\", \"isbn\": \"555-1234\"}" | json_pp

