package $package$.test.controller

import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._
import play.mvc.Http
import $package$.test.ControllerBaseSpec
import $package$.controller._

class MathControllerSpec extends ControllerBaseSpec {

  "MathController POST" should {
    "return 0 for empty input" in callController(None, 0)
  }

  def callController(input: Option[List[Double]], valueOut: Double) = {
    val inputJson = input match {
      case None => Json.obj()
      case Some(x) => Json.obj("values" -> x)
    }

    val request = FakeRequest(POST, routes.MathController.product.url)
      .withJsonBody(inputJson)
    val result    = route(app, request).get

    status(result) mustBe OK
    contentType(result) mustBe Some(Http.MimeTypes.JSON)
    contentAsString(result) mustBe stringResult(valueOut)
  }

  def stringResult(value: Double) = s"""{"result":\${value}}"""
}
