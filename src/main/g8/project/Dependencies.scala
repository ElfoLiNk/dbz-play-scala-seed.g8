import sbt._
import play.sbt.PlayImport._

object Dependencies {

  val scalatestplus = "org.scalatestplus.play" %% "scalatestplus-play" % "$scalatestplusplay_version$"

  val swaggerUi = "org.webjars" % "swagger-ui" % "2.2.0"

  lazy val libraries = Seq(
    swaggerUi,
    filters,
    guice,
    scalatestplus % Test
  )

  val resolvers = Seq(
    Resolver.sonatypeRepo("public")
  )
}
