package $package$.controller.test

import $package$.controller.PingController
import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

class PingControllerSpec extends PlaySpec {

  "PingController GET" should {

    "return pong string" in {
      val controller = new PingController
      val ping       = controller.ping().apply(FakeRequest())

      status(ping) mustBe OK
      contentType(ping) mustBe Some("text/plain")
      contentAsString(ping) must include("pong")
    }
  }
}
