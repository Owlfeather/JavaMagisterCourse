import org.apache.spark.sql.SparkSession

object CounterDemo {
 def main(args: Array[String]): Unit = {
   val conf = new SparkConf().setAppName("CounterDemo").setMaster("local[*]")
   val sc = new SparkContext(conf);
   val spark = SparkSession.builder.appName("Test app").getOrCreate()
   val path_1 = "/home/polina/Документы/scripts/visits.csv"
   val df_visits = spark.read.option("header", "true").csv(path_1)
   val path_2 = "/home/polina/Документы/scripts/patients.csv"
   val df_patients = spark.read.option("header", "true").csv(path_2)
   df_visits.createOrReplaceTempView("visits")
   df_patients.createOrReplaceTempView("patients")
   spark.sql("SELECT patient_age, count(patient_age) as counter FROM patients, visits WHERE patients.patient_id = visits.patient_id AND diagnosis = 'Грипп' GROUP BY patient_age").show()
   spark.stop()
 }
}
