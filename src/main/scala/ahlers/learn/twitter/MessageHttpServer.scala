package ahlers.learn.twitter

import com.google.inject
import com.twitter.finagle.Http

import scala.reflect.runtime.universe._
import com.twitter.finagle.http.{ Request, Response }
import com.twitter.finagle.stats.{ NullStatsReceiver, StatsReceiver }
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{ CommonFilters, LoggingMDCFilter, TraceIdMDCFilter }
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.inject.Logging

/**
 * @since June 04, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
class MessageHttpServer
  extends HttpServer
    with Logging {

  override protected def statsReceiverModule =
    MessageStatsReceiverModule

  override protected def start(): Unit =
    injector.instance[StatsReceiver]

  override protected def warmup() =
    handle[MessageWarmupHandler]()

  override def configureHttp(router: HttpRouter) =
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .add[MessageController]

}
