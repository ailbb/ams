import com.ailbb.ajj.$

/**
  * Created by Wz on 5/17/2018.
  */
object HelloScala {
  def main(args: Array[String]): Unit = {
    HelloJava.main(null);
    println("Hello Ama by Scala!");
    $.sout($.readFile(HelloScala.getClass.getResource("").getPath))
  }
}
