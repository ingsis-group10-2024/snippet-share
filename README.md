# Snippet Share
### Snippet Share is a service that allows users to share their snippets with others, as well as explore and manage the snippets shared with them.

## Functionalities:

## Endpoints:


## Config:
Docker container:
```sh
docker-compose up
```
#### (these tools are configured to run with Github Action and GitHooks)
To verify the code style using `ktlint`, run the following command:
```sh
./gradlew ktlintCheck
```
To automatically format the code using ktlint, run the following command:
```sh
./gradlew ktlintFormat
```
To run the tests and generate the code coverage reports using JaCoCo, run the following command:
```sh
./gradlew test jacocoTestReport
```