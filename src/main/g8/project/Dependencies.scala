import sbt._
import play.sbt.PlayImport._

object Dependencies {

  val scalatestplus = "org.scalatestplus.play" %% "scalatestplus-play" % "$scalatestplusplay_version$"

  lazy val libraries = Seq(
    filters,
    guice,
    scalatestplus % Test
  )

  val resolvers = Seq(
    Resolver.sonatypeRepo("public")
  )
}
