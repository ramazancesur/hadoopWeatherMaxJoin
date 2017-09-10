package reducers;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxHavaReducer extends Reducer<Text, Text, Text, Text> {
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		String name = "";
		double max = 0.0;
		int count = 0;
		for (Text t : values) {
			String parts[] = t.toString().split("\t");
			if (parts[0].contains("Temp ")) {
				count++;
				float deger = Float.parseFloat(parts[1]);
				if (max < deger) {
					max = deger;
				}
			} else if (parts[0].contains("CityName")) {
				name = parts[1];
			}
		}
		String str = String.format("%d\t%f", count, max);
		context.write(new Text(name), new Text(str));
	}
}
