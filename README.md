FINDER

This project will find the closest stores from a single point.

To build and run from gradle:
```
$ ./gradlew deleteReactStaticFile npmInstall npmBuild  copyReactStaticFile clean build bootRun
```

To access Swagger:
`http://localhost:8081/swagger-ui.html#/`

Test Data:

```
Amsterdam
Latitude: 52.3727598
Longitude: 4.8936041

Brussels
Latitude: 50.83857005
Longitude: 4.375756406648373

Luxembourg
Latitude: 49.8158683
Longitude: 6.1296751

```