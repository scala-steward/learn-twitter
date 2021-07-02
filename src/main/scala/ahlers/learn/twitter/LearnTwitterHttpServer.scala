package ahlers.learn.twitter

import ahlers.learn.twitter.messages.MessageController
import com.google.inject
import com.twitter.finagle.Http

import scala.reflect.runtime.universe._
import com.twitter.finagle.http.{ Request, Response }
import com.twitter.finagle.stats.{ NullStatsReceiver, StatsReceiver }
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{ CommonFilters, LoggingMDCFilter, TraceIdMDCFilter }
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.inject.Logging
import com.twitter.inject.modules.StatsReceiverModule

/**
 * @since June 04, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
class LearnTwitterHttpServer
  extends HttpServer
    with Logging {

  //override protected def statsReceiverModule =
  //  StatsReceiverModule

  override protected def start(): Unit =
    injector.instance[StatsReceiver]

  override protected def warmup() =
    handle[LearnTwitterWarmupHandler]()

  override def configureHttp(router: HttpRouter) =
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .add[MessageController]

}
