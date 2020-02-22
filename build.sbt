resolvers += Resolver.sbtPluginRepo("releases") 

//addSbtPlugin("com.eed3si0n" % "sbt-assembly" % "0.13.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.0")
//addSbtPlugin("com.typesafe.startscript" % "xsbt-start-script-plugin" % "0.5.0")
//import com.typesafe.startscript.StartScriptPlugin
//enablePlugins(JavaServerAppPackaging)
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
