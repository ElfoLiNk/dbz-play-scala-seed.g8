package $package$.controller

import javax.inject._
import play.api._
import play.api.mvc._
import $package$.logging.CustomLogger

/**
 * Custom Base Controller that is a common base for all controllers.
 * This base controller is created in order to define a common
 * functions and extended trait.
 */
abstract class CustomBaseController(protected val cc: ControllerComponents) extends AbstractController(cc) with CustomLogger

