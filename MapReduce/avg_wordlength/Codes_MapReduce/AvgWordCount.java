package com.degenio.hadoop;         
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.DoubleWritable; 
import org.apache.hadoop.mapred.FileOutputFormat; 
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class AvgWordCount {
      	public static void main(String[] args) throws Exception {  
	JobConf conf = new JobConf(AvgWordCount.class); 
	conf.setJobName("AvgWordCount");

	conf.setMapOutputKeyClass(Text.class);
 	conf.setMapOutputValueClass(IntWritable.class); 

	conf.setOutputKeyClass(Text.class); 
	conf.setOutputValueClass(DoubleWritable.class); 
	
	conf.setMapperClass(MonMap.class);
//	conf.setCombinerClass(MonReduce.class); there are two problems here: First, outputs of mapper and reducer must match! Otherwise there is an error. Second, Hadoop does not garantee that Combiner is applied (for all the cases, and even it might not be applied at all). Best case scenario is go directly from mapper to reducer 
	conf.setReducerClass(MonReduce.class);
	
	conf.setInputFormat(TextInputFormat.class);
	conf.setOutputFormat(TextOutputFormat.class);

	FileInputFormat.setInputPaths(conf, new Path(args[0])); 
  	FileOutputFormat.setOutputPath(conf, new Path(args[1])); 
    	
	JobClient.runJob(conf);                                                                                                                        
  }                                                                                                                                                  
                                                                                                                                                     
}
