package $package$.controller

import javax.inject._
import play.api._
import play.api.mvc._

abstract class CustomBaseController(protected val cc: ControllerComponents) extends AbstractController(cc)

