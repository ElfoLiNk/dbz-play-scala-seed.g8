package $package$.service

import javax.inject.Inject

import $package$.model.MathModel.ProductInput

import scala.concurrent.{ExecutionContext, Future}

/**
  * Mathematical service used to execute basic
  * mathematical operations.
  */
class MathService @Inject()()(implicit ec: ExecutionContext) {
  /**
    Evaluate product given an object that contains input values.
    */
  def product(input: ProductInput): Future[Double] = Future{
    input.values match {
      case None => 0.0d
      case Some(Nil) => 0.0d
      case Some(x) => x.product
      }
  }
}
