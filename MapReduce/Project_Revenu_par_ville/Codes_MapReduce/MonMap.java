package com.degenio.hadoop;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;  
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;                                                                                                            
public class MonMap extends MapReduceBase implements 
	Mapper<LongWritable, Text, Text, DoubleWritable> {    

	public void map(LongWritable key, Text value, 
	     	OutputCollector<Text, DoubleWritable> output, Reporter reporter)   
	     	throws IOException {  

	        String line = value.toString();
		String[] tokens = line.split("\t");
//                output.collect(new Text(tokens[2]), new DoubleWritable(Double.valueOf(tokens[4])));
                output.collect(new Text(tokens[2]), new DoubleWritable(Double.parseDouble(tokens[4])));
        } 

}    
