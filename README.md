## About
This is a spring boot demo, following instructions from [here](https://spring.io/guides/gs/spring-boot/)  

# Deploy
Run gradle command:
`./gradlew deployLocal`

# Manual Test
You can manually test by running the following:
`while true; do date +"[%T]"; curl 127.0.0.1:8080 ;sleep 2;done`
