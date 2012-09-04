name := "SalatTest"

version := "0.1"

organization := "com.ciriscr.salattest"

scalaVersion := "2.9.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq("com.novus" %% "salat" % "1.9.1")

maxErrors := 30

pollInterval := 1000

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalacOptions ++= Seq("-deprecation", "-optimise", "-explaintypes")

parallelExecution := true

