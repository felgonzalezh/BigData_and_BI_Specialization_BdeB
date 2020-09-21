package com.degenio.hadoop;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.io.DoubleWritable; 
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter; 

public class MonReduce extends MapReduceBase implements   
		Reducer<Text, DoubleWritable, Text, DoubleWritable> { 
		
		public void reduce(Text key, Iterator<DoubleWritable> values, 
		OutputCollector<Text, DoubleWritable> output, Reporter reporter)                                                                
                throws IOException {
		double sum = 0; 

		while (values.hasNext()) {
		      	sum += values.next().get();
		}  
		
		output.collect(key, new DoubleWritable(sum));                                                                                           
        }                                                                                                                                            
} 
