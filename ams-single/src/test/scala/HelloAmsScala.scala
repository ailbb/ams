import com.ailbb.ajj.$

/**
  * Created by Wz on 5/17/2018.
  */
object HelloAmsScala {
  def main(args: Array[String]): Unit = {
    HelloAmsJava.main(null);
    println("Hello Ama by Scala!");
    $.sout($.readFile(HelloAmsScala.getClass.getResource("").getPath))
  }
}
