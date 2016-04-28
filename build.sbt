name := "big-data-analytics"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies ++= Seq(
  "org.apache.hadoop" % "hadoop-mapreduce-client-core" % "2.7.2" % "provided",
  "org.apache.hadoop" % "hadoop-common" % "2.7.2" % "provided" intransitive()
)

import scalariform.formatter.preferences._

scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)


assemblyJarName in assembly := "tk-wordcount.jar"
