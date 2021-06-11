package ahlers.learn.twitter

import scala.reflect.runtime.universe._

import com.twitter.finagle.http.{ Request, Response }
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{ CommonFilters, LoggingMDCFilter, TraceIdMDCFilter }
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.inject.Logging

/**
 * @since June 04, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
class HelloWorldHttpServer
  extends HttpServer
    with Logging {

  override def configureHttp(router: HttpRouter) =
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .add[HelloWorldController]

}

object HelloWorldHttpServer
  extends HelloWorldHttpServer
