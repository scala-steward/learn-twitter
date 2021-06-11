package ahlers.learn.twitter

import com.twitter.finatra.http.routing.HttpWarmup
import com.twitter.inject.utils.Handler
import com.twitter.finatra.http.request.RequestBuilder
import javax.inject.{ Inject, Singleton }

/**
 * @since June 11, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
@Singleton
class MessageWarmupHandler @Inject() (httpWarmup: HttpWarmup)
  extends Handler {

  import RequestBuilder.get

  override def handle() =
    httpWarmup
      .send(
        request = get("/messages/hello-world"),
        times = 5)()

}
