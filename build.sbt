name := "DataBaseModule"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.5",
  "mysql" % "mysql-connector-java" % "5.1.6",
  "org.mockito" % "mockito-all" % "1.9.5",
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)

coverageEnabled := true
    