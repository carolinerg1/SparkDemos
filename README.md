# SparkDemos
DataStax Cassandra Java Spark Examples

WORK IN PROGRESS

<b>Basic Spark Demo</b>

1st demo is a simple SparkSQL script

This creates a Cassandra table, inserts a few lines of data, and uses SparkSQL to return the average length of songs per song category

It uses dse spark-submit to run the script

Based on <a href="https://academy.datastax.com/downloads?destination=downloads&dxt=DX" target="_new">DSE 4.7.3</a> and the <a href="https://github.com/datastax/spark-cassandra-connector" target="_new">DataStax Cassandra Spark Connector</a>

You will need to create a "lib" folder and copy dse-4.7.3.jar into it.  If you use a different version of DSE, update pom.xml



1. compile project**
> mvn package

2. run program
> dse spark-submit --class simpleSpark.BasicSparkSQL ./target/BasicSparkDemo-0.1.jar






** if you don't have Maven

1. download Maven: https://maven.apache.org/download.cgi

2. add to path
> export PATH=[dir]/apache-maven-3.3.3/bin:$PATH
