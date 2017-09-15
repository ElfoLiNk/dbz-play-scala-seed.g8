package $package$.controller

import javax.inject._
import play.api.mvc._
import play.mvc.Http

/**
 * Mathematical controller used to perform some basic operation.
 */
@Singleton
class MathController @Inject()(cc: ControllerComponents) extends CustomBaseController(cc) {
  def product = Action {
    Ok("""{"result":0.0}""").as(Http.MimeTypes.JSON)
  }
}
