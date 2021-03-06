
lazy val root = crossProject.in(file("."))
  .dependsOn(lib)
  .enablePlugins(ShoconPlugin)
  .settings(
    scalaVersion := "2.12.2",
    name := "basic",
    version := "0.1.0-SNAPSHOT",
    description := "Basic test for the shocon sbt plugin",
    libraryDependencies += "eu.unicredit" %%% "shocon" % sys.props.getOrElse("plugin.version", sys.error("'plugin.version' environment variable is not set")),
    compile in Compile := (compile in Compile).dependsOn(shoconConcat).value
  )
  .jsSettings(
    scalaJSUseMainModuleInitializer := true
  )


lazy val rootJVM = root.jvm
lazy val rootJS = root.js

lazy val lib = crossProject.in(file("lib"))
  .enablePlugins(ShoconPlugin)
  .settings(
    scalaVersion := "2.12.2",
    name := "lib"
  )

lazy val libJVM = lib.jvm
lazy val libJS = lib.js
