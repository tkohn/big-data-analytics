package uulm.dbis.spark.examples

import org.apache.spark.{ SparkConf, SparkContext }

object SparkWordCount {
  def main(args: Array[String]) {
    if (args.length < 2) {
      System.err.println("Correct usage: SparkWordCount <input-path> <output-folder>")
      System.exit(1)
    }

    val sparkConf = new SparkConf().setAppName("WordCount")
    val ctx = new SparkContext(sparkConf)
    val textFile = ctx.textFile(args(0))
    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .coalesce(1, true)
      .reduceByKey(_ + _)
    counts.saveAsTextFile(args(1))
    ctx.stop()
  }
}
