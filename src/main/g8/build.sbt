import com.typesafe.config.ConfigFactory

val conf = ConfigFactory.parseFile(new File("conf/application.conf")).resolve()

val commonSettings = Seq(
  scalaVersion := "2.12.6",
  version := conf.getString("app.version")
)

name := """$name$"""

organization := "$organization$"

lazy val root = (project in file(".")).settings(commonSettings: _*).enablePlugins(PlayScala)

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "$organization$.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "$organization$.binders._"
