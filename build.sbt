
//enablePlugins(JavaAppPackaging)

name := "ping"
version := "1.0"
scalaVersion := "2.12.10"
libraryDependencies ++= {

  Seq(
    // akka
    "com.typesafe.akka" %% "akka-http" % "10.0.10",
    "com.typesafe.akka" %% "akka-stream"   % "2.5.9",
    "com.typesafe.akka" %% "akka-actor"   % "2.5.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
  )
}
