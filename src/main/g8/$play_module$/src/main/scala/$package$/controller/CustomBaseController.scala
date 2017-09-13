package $package$.controller

import javax.inject._
import play.api._
import play.api.mvc._
import $package$.logging.CustomLogger

abstract class CustomBaseController(protected val cc: ControllerComponents) extends AbstractController(cc) with CustomLogger

