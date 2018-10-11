package com.ly.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @Author: liyan
 * @Description: 使用MapReduce开发Wordcount应用程序
 * @Date: Created in 14:44 2018/8/30
 * @Modified By:
 */
public class PartitionApp {

    /**
     * Map：读取输入的文件
     */
    public static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

        LongWritable one = new LongWritable(1);

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            // 首先将文本内容转换成字符串,接收到每一行的数据
            String line = value.toString();

            // 按照指定分隔符进行拆分
            String[] words = line.split(" ");

            context.write(new Text(words[0]), new LongWritable(Long.parseLong(words[1])));
        }
    }

    /**
     * Reduce：归并操作
     */
    public static class MyReduce extends Reducer<Text, LongWritable, Text, LongWritable> {

        @Override
        protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

            long sum = 0;

            for (LongWritable value : values) {
                // 求单词key出现的次数总和
                sum += value.get();
            }

            // 最终统计结果的输出
            context.write(key, new LongWritable(sum));
        }
    }

    public static class MyParitition extends Partitioner<Text, LongWritable> {

        @Override
        public int getPartition(Text key, LongWritable value, int i) {
            if (key.toString().equals("Hadoop")) {
                return 0;
            }
            if (key.toString().equals("welcome")) {
                return 1;
            }
            if (key.toString().equals("mapreduce")) {
                return 2;
            }
            return 3;
        }
    }

    /**
     * 定义Driver：封装了所有MapReduce作业的信息
     * @param args
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        // 创建Configuration
        Configuration configuration = new Configuration();

        // 清理已经存在的输出目录
        Path outputPath = new Path(args[1]); // 文件存储路径
        FileSystem fileSystem = FileSystem.get(configuration); // 获取文件信息
        if (fileSystem.exists(outputPath)) {
            fileSystem.delete(outputPath, true);
            System.out.println("文件已经存在，删除文件！！！");
        }

        // 创建Job作业
        Job job = Job.getInstance(configuration, "wordcount");

        // 设置job的处理类
        job.setJarByClass(PartitionApp.class);

        // 设置作业处理的输入路径，路径不要写死，不利于以后扩展
        FileInputFormat.setInputPaths(job, new Path(args[0]));
//        FileInputFormat.setInputPaths(job,"E:\\Java_Interview\\test\\hello.txt");

        // 设置Map相关的参数
        job.setMapperClass(MyMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 设置Reduce相关的参数
        job.setReducerClass(MyReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 设置Job的Partion
        job.setPartitionerClass(MyParitition.class);

        // 设置4个reducer，每个分区一个
        job.setNumReduceTasks(4);

        // 设置作业处理的输出路径
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        // 提交
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
