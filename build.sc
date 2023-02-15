import mill._
import mill.scalalib._

object sparkForkJoin extends ScalaModule
{
  def scalaVersion = "2.12.15"

  // def ivyDeps = Agg(
  //   ivy"org.apache.spark::spark-sql:3.3.1",
  //   ivy"org.apache.spark::spark-mllib:3.3.1",
  //   ivy"org.apache.spark::spark-hive:3.3.1",
  // )

  object test extends Tests with TestModule.Specs2 
  {
    def scalaVersion = sparkForkJoin.scalaVersion

    def ivyDeps = Agg(
      ivy"org.specs2::specs2-core::4.19.2",
      ivy"org.specs2::specs2-matcher-extra::4.19.2",
      ivy"org.specs2::specs2-junit::4.19.2",
    )
  }
}