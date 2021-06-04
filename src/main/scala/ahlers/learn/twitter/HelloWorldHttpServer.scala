package ahlers.learn.twitter

import com.twitter.inject.Logging
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

/**
 * @since June 04, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
object HelloWorldHttpServer
  extends HttpServer
    with Logging :

  override def configureHttp(router: HttpRouter) =
    /** @todo Determine why a [[Manifest]] can't be summoned with [[HttpRouter.add]]. */
    router.add(classOf[HelloWorldController])
