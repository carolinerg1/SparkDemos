package simpleSpark;

import com.datastax.driver.core.Session;
import com.datastax.spark.connector.cql.CassandraConnector;
import com.datastax.spark.connector.japi.CassandraRow;
import com.datastax.spark.connector.japi.RDDJavaFunctions;
import com.datastax.spark.connector.japi.SparkContextJavaFunctions;

import com.datastax.spark.connector.japi.CassandraJavaUtil;
import com.datastax.spark.connector.japi.rdd.CassandraJavaRDD;



import org.apache.spark.sql.cassandra.CassandraSQLContext;

import com.google.common.base.Objects;
import org.apache.hadoop.util.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import org.apache.spark.sql.SchemaRDD;
import org.apache.spark.sql.api.java.JavaSQLContext;
import org.apache.spark.sql.api.java.JavaSchemaRDD;
import org.apache.spark.sql.api.java.Row;
import org.apache.spark.sql.hive.api.java.JavaHiveContext;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;


import static com.datastax.spark.connector.japi.CassandraJavaUtil.*;

public class BasicSparkSQL {

    public static void main(String[] args) {

        JavaSparkContext javaSparkContext = SparkConfSetup.getJavaSparkContext();

        JavaHiveContext javaHiveContext = SparkConfSetup.getJavaHiveContext(javaSparkContext);
        CassandraConnector connector = SparkConfSetup.getCassandraConnector();

        basicCassandraSession(connector);
        
        runSQL1(javaHiveContext);


        javaSparkContext.stop();

    }

    private static void basicCassandraSession(CassandraConnector connector) {

        try(Session session = connector.openSession())  {
            
            session.execute("CREATE TABLE IF NOT EXISTS demo.song (song_name text, artist text, category text, record_date timestamp, song_length float, PRIMARY KEY (song_name, artist));");
            session.execute("INSERT INTO demo.song (song_name, artist, category, record_date, song_length) values ('How sweet it is to be loved by you', 'Marvin Gaye', 'Soul', '1964-11-04', 2.95);");
            session.execute("INSERT INTO demo.song (song_name, artist, category, record_date, song_length) values ('Brown Sugar', 'The Rolling Stones', 'Rock', '1971-04-23', 3.8);");
            session.execute("INSERT INTO demo.song (song_name, artist, category, record_date, song_length) values ('Wild Horses', 'The Rolling Stones', 'Rock', '1971-04-23', 5.7);");
            session.execute("INSERT INTO demo.song (song_name, artist, category, record_date, song_length) values ('Mother''s Little Helper', 'The Rolling Stones', 'Rock', '1965-12-08', 2.75);");
            session.execute("INSERT INTO demo.song (song_name, artist, category, record_date, song_length) values ('Let Love Rule', 'Lenny Kravitz', 'Rock', '1989-07-23', 5.7);");
            session.execute("INSERT INTO demo.song (song_name, artist, category, record_date, song_length) values ('Fly Away', 'Lenny Kravitz', 'Rock', '1998-06-29', 3.68);");
        }
    }
    
    private static void runSQL1(JavaHiveContext sqlContext) {
    	
        JavaSchemaRDD sRDD = sqlContext.sql("select category, avg(song_length) from demo.song group by category");
        List<String> results = sRDD.map(new Function<Row, String>() {
            public String call(Row row) {
            	DecimalFormat df = new DecimalFormat("#.00"); 
            	String result = row.getString(0) + ": " + df.format((row.getDouble(1))) + " mins";
                return result;
            }
        }).collect();

        System.out.println("Avg Mins Per Song Category");
        for( String name : results){
            System.out.println(name);
        }
        
    	
    }
    
    


}
