package $package$.logging

import play.api.Logger
/**
  A placeholder for logger that is usefull in order
  to implement a more complex logger.
  Usually a big corporate has a specific logging format or internal
  library.
*/
trait CustomLogger {
  val logger = Logger(this.getClass)
}
