package app2;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import mappers.ForcastDetailMapper;
import mappers.ForcastMapper;
import reducers.MaxHavaReducer;

/**
 * Created by ramazancesur on 10/09/2017.
 */
public class MaxHava extends Configured implements Tool{

	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new MaxHava(), args);
		System.exit(exitCode);
	}



	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		if (args.length != 3) {
			System.err.printf("Usage: \t needs three arguments, input and output    files \n");
		} else {

			Job job = new Job(getConf());
			job.setJarByClass(getClass());
			job.setJobName(getClass().getSimpleName());

	
			job.setReducerClass(MaxHavaReducer.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);

			MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, ForcastMapper.class);
			MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, ForcastDetailMapper.class);

			FileOutputFormat.setOutputPath(job, new Path(args[2]));

			int returnValue = job.waitForCompletion(true) ? 0 : 1;

			if (job.isSuccessful()) {
				System.out.println("Job was successful");
			} else if (!job.isSuccessful()) {
				System.out.println("Job was not successful");
			}

			System.out.println(returnValue);
		}
		return 0;
	}

}