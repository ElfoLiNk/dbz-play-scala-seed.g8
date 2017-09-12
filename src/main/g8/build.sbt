import com.typesafe.config.ConfigFactory

val conf = ConfigFactory.parseFile(new File("$play_module$/src/main/resources/application.conf")).resolve()

val commonSettings = Seq(
  scalaVersion := "2.12.3",
  version := conf.getString("app.version")
)

name := """$name$"""

organization := "$organization$"

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .enablePlugins(PlayScala)
  .settings(name := conf.getString("app.name") + "-root")
  .settings(
    run := {
      (run in play in Compile).evaluated
    }
  )
  .aggregate(play)

lazy val play = (project in file("$play_module$"))
  .settings(commonSettings: _*)
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .settings(
    libraryDependencies ++= Dependencies.libraries,
    resolvers ++= Dependencies.resolvers,
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
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

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "$organization$.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "$organization$.binders._"
