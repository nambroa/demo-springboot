# spring-notes

Notes App made with SpringBoot. It allows creation, manipulation and usage of Notes using MVC architecture.


## Note Creation

Flow is Controller --> Service --> Factory --> Repository. And then the internal Note structure is hidden with a DTO,
which is returned in the response with a 201 CREATED.

## DB

The project uses an H2 DB which means it's in memory. All notes are lost upon application reset.

## TODO

- Initial app skeleton (DONE)
- Support note creation via API (DONE)
- Tests for note creation
- Support note editing via API
- Support note deletion via API
- Does Spring have a way to automate basic frontend to easily show notes? Thymeleaf? Search libraries.
- Make the app interact with another microservice via a queue. For example: Microservice that manages users!
  (this point is a good time to move to a relational DB)