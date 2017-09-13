package $package$.controller

import javax.inject._

import play.api.mvc._
import play.mvc.Http

@Singleton
class PingController @Inject() extends Controller {
  def ping = Action { _ =>
    Ok("pong").as(Http.MimeTypes.TEXT)
  }
}
