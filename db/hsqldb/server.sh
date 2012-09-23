cd `dirname $0`
mvn -e -Ddb.file=./pilot exec:java
