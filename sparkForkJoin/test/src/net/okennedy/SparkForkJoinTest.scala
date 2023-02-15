package net.okennedy

import org.specs2.mutable.Specification
import java.util.concurrent.ForkJoinWorkerThread
import java.util.concurrent.ForkJoinTask
import java.util.concurrent.ForkJoinPool

class SparkForkJoinTest extends Specification
{

  lazy val workers = new ForkJoinPool(5)

  "Have the right context classloader" >> {

    var thread = new ForkJoinTask[String] {
      var result: String = null

      def setRawResult(x: String) = { result = x }
      def getRawResult: String = result

      def exec: Boolean = {
        result = Thread.currentThread().getContextClassLoader().toString
        return true
      }
    }

    workers.execute(thread)
    
    thread.join().split("@")(0) must beEqualTo(
      Thread.currentThread().getContextClassLoader().toString.split("@")(0)
    )
  }

}