package $package$.playcustom.filter

import javax.inject.Inject
import akka.stream.Materializer
import play.api.Logger
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import $package$.logging.CustomLogger

class LoggingFilter @Inject() (implicit val mat: Materializer, ec: ExecutionContext) extends Filter with CustomLogger {

  def apply(nextFilter: RequestHeader => Future[Result])
           (requestHeader: RequestHeader): Future[Result] = {

    val startTime = System.currentTimeMillis

    nextFilter(requestHeader).map { result =>

      val endTime = System.currentTimeMillis
      val requestTime = endTime - startTime

      logger.info(s"\${requestHeader.method} \${requestHeader.uri}" +
        s" took \${requestTime}ms" +
        s" and returned \${result.header.status}")

      result.withHeaders("Request-Time" -> requestTime.toString)
    }
  }
}
