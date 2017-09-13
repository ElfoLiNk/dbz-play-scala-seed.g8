package $package$.test

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

/**
  Base class used to collect common functions and trait for controller tests.
  */
trait ControllerBaseSpec extends BaseSpec with GuiceOneAppPerTest with Injecting
