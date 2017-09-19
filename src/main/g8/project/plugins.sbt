addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.18")

libraryDependencies += "com.geirsson" %% "scalafmt-bootstrap" % "0.6.6"

// for autoplugins
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.2.0")

addSbtPlugin("com.iheart" % "sbt-play-swagger" % "0.6.1-PLAY2.6")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

