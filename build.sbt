lazy val root = (project in file(".")).
  settings(
   name := "Zenreach_Test",
   version := "1.0.0-SNAPSHOT",
   scalaVersion :="2.10.6",
   organization := "com.manas",
   crossScalaVersions := Seq("2.10.6"),
   libraryDependencies ++=Seq(
     "org.scalatest" % "scalatest_2.10" %"2.2.5"
   ),
   resolvers ++= repos
  )
lazy val repos = Seq()
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")
//publishTo := Some("Internal Publish Repository" at "http://my-repo.com/artifactory/local-release/")

