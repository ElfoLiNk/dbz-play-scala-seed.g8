package $package$.model

import play.api.libs.json.Json

object MathModel {
  case class ProductInput(values: Option[List[Double]])
  implicit val ProductInputFormat = Json.format[ProductInput]

  case class ProductOutput(result: Double)
  implicit val ProductOutputFormat = Json.format[ProductOutput]
}
