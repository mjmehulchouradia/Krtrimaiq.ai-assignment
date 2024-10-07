List of API's

API's:
http://localhost:8080/api/authors -  GET, POST
http://localhost:8080/api/authors/{id} - GET,PUT,DELETE

http://localhost:8080/api/books -  GET, POST
http://localhost:8080/api/books/{id} - GET,PUT,DELETE


Use below Sample JSON as payload for post API's to insert data into database.

Author:

{
  "name": "George R.R. Martin",
  "bio": "American novelist and short story writer, author of A Song of Ice and Fire."
}

Books:

{
  "title": "Breaking Bard",
  "isbn": "9780553103549",
  "author": {
    "id": 2
  },
  "publishedDate": "2006-08-06"
}
