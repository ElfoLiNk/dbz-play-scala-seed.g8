import com.typesafe.config.ConfigFactory

val conf = ConfigFactory.parseFile(new File("$play_module$/src/main/resources/application.conf")).resolve()

val commonSettings = Seq(
  scalaVersion := "2.12.3",
  version := conf.getString("app.version"),
  javaOptions in Test += "-Dlogger.resource=logback-test.xml"
)

name := """$name$"""

organization := "$organization$"

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(name := conf.getString("app.name") + "-root")
  .settings(
    run := {
      (run in playModule in Compile).evaluated
    },
    publishArtifact := false,
    publish := {},
    publishLocal := {}
  )
  .aggregate(playModule)

lazy val playModule = (project in file("$play_module$"))
  .settings(commonSettings: _*)
  .enablePlugins(PlayScala, JavaServerAppPackaging)
  .disablePlugins(PlayLayoutPlugin)
  .settings(
    libraryDependencies ++= Dependencies.libraries,
    resolvers ++= Dependencies.resolvers,
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
    packageName in Docker := """$name$"""
  )

def latestScalafmt = "1.2.0"
commands += Command.args("scalafmt", "Run scalafmt cli.") {
  case (state, args) =>
    val Right(scalafmt) =
      org.scalafmt.bootstrap.ScalafmtBootstrap.fromVersion(latestScalafmt)
    scalafmt.main("--non-interactive" +: args.toArray)
    state
}

onLoad in Global := (Command.process("scalafmt", _: State)) compose (onLoad in Global).value

addCommandAlias("run-local", "playModule/run -Dconfig.resource=application.conf -Dhttp.port=9000")

addCommandAlias("docker-snapshot", ";set isSnapshot in ThisBuild := true;docker:publishLocal")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "$organization$.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "$organization$.binders._"
