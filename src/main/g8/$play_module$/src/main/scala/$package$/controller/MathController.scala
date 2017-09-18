package $package$.controller

import javax.inject._
import play.api.mvc._
import play.mvc.Http
import $package$.model.MathModel._
import $package$.service.MathService
import scala.concurrent.ExecutionContext
import play.api.libs.json.Json

/**
 * Mathematical controller used to perform some basic operation.
 */
@Singleton
class MathController @Inject()(mathService: MathService,
  cc: ControllerComponents) (implicit ec: ExecutionContext) extends CustomBaseController(cc) {

  /** Product function that receive input and execute mathematical calculation.
   */
  def product = Action.async(parse.json[ProductInput]) { request =>
    mathService.product(request.body).map(x => Ok(Json.toJson(ProductOutput(x))).as(Http.MimeTypes.JSON))
  }
}
