name := "big-data-analytics"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies ++= Seq(
  "org.apache.hadoop" % "hadoop-mapreduce-client-core" % "2.7.2",
  "org.apache.hadoop" % "hadoop-common" % "2.7.2" intransitive()
)

import scalariform.formatter.preferences._
scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)


assemblyJarName in assembly := "tk-wordcount.jar"

assemblyShadeRules in assembly := Seq(
  ShadeRule.rename("org.apache.commons.beanutils.**" -> "shade.commons-beanutils.@1")
    .inLibrary("commons-beanutils" % "commons-beanutils" % "1.7.0")
    .inAll,
  ShadeRule.rename("org.apache.commons.beanutils.**" -> "shade.commons-beanutils-core.@1")
    .inLibrary("commons-beanutils" % "commons-beanutils-core" % "1.8.0")
    .inAll,
  ShadeRule.rename("org.apache.commons.collections.**" -> "shade.commons-collections.collections.@1")
    .inLibrary("commons-collections" % "commons-collections" % "3.2.2")
    .inAll,
  ShadeRule.rename("org.apache.commons.beanutils.**" -> "shade.commons-beanutils.collections.@1")
    .inLibrary("commons-collections" % "commons-collections" % "3.2.2")
    .inAll
)

    