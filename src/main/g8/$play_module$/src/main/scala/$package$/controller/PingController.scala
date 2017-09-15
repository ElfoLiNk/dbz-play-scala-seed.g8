package $package$.controller

import javax.inject._
import play.api.mvc._
import play.mvc.Http


/**
 * Ping API that implement a simple pong response that
 * could be used to verify if an application is UP&Running.
 */
@Singleton
class PingController @Inject()(cc: ControllerComponents) extends CustomBaseController(cc) {
  def ping = Action {
    logger.info("Inside ping function")
    Ok("pong").as(Http.MimeTypes.TEXT)
  }
}
