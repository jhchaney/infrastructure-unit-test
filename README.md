
Usage:
1. Start the docker NTP server
docker-compose up -d
2. Run the maven test
mvn test

Servers can be added to the test by modifying the "data" method within NTPTest. This is just a demonstration of unit testing of a non-ui based component.
