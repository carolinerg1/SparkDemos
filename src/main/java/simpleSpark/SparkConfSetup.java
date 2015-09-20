package simpleSpark;

import com.datastax.bdp.spark.DseSparkConfHelper;
import com.datastax.bdp.spark.DseSparkContext;
import com.datastax.spark.connector.cql.CassandraConnector;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.hive.api.java.JavaHiveContext;


/**
*  When you submit a Spark Job using dse spark-submit it automatically sets the Spark Master URL and the Spark Cassandra Connection URL.
*  The Spark Conf then just needs to set the app name.
**/
public interface SparkConfSetup {

    static public SparkConf getSparkConf() {
//        return new SparkConf()
//                .setAppName("SimpleSpark");
    	SparkConf conf = DseSparkConfHelper.enrichSparkConf(new SparkConf())
    			.set("spark.cassandra.auth.conf.factory", "com.datastax.bdp.spark.DseAuthConfFactory")
                .setAppName("My application");
    	return conf;
    }

    static public JavaSparkContext getJavaSparkContext() {
        SparkContext sparkContext = new SparkContext(getSparkConf());
        return new JavaSparkContext(sparkContext);
    }

    static public CassandraConnector getCassandraConnector() {
        return CassandraConnector.apply((getSparkConf()));
    }
    
    static public JavaHiveContext getJavaHiveContext(JavaSparkContext jsc) {
    	return new JavaHiveContext(jsc);
    }

}
