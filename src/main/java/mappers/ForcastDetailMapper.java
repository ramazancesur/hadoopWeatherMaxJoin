package mappers;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ForcastDetailMapper extends Mapper<Object, Text, Text, Text>{
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		String record = value.toString();
		String[] parts = record.split(";");
		context.write(new Text(parts[0]), new Text("Temp \t" + parts[1]));
	}
}