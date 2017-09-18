package $package$.test.controller

import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._
import play.mvc.Http
import $package$.test.ControllerBaseSpec
import $package$.controller._
import $package$.model.MathModel._
import $package$.service.MathService
import org.scalactic._
import scala.concurrent.duration._
import scala.concurrent.Await

class MathControllerSpec extends ControllerBaseSpec {
  "Product input values" should {
    "return 0 for empty input" in callProduct(ProductInput(None), 0)
    "return 0 for empty list" in callProduct(ProductInput(Some(List.empty)), 0)
    "return a specific value a list of values" in callProduct(ProductInput(Some(List(1, -4.1, 20.2, 5.8))), -480.356)
  }

  def callProduct(input: ProductInput, valueOut: Double) = {
    val request = FakeRequest(POST, routes.MathController.product.url)
      .withJsonBody(Json.toJson(input))
    val result    = route(app, request).get

    implicit val doubleEquality = TolerantNumerics.tolerantDoubleEquality(0.00001)
    status(result) mustBe OK
    contentType(result) mustBe Some(Http.MimeTypes.JSON)

    val resultVal = Json.fromJson[ProductOutput](Json.parse(contentAsString(result))).get.result
    resultVal === valueOut mustBe true
  }
}
