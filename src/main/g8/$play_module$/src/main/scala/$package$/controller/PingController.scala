package $package$.controller

import javax.inject._
import play.api.mvc._
import play.mvc.Http

@Singleton
class PingController @Inject()(cc: ControllerComponents) extends CustomBaseController(cc) {
  def ping = Action {
    Ok("pong").as(Http.MimeTypes.TEXT)
  }
}
