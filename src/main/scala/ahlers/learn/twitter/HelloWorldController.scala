package ahlers.learn.twitter

import com.twitter.finatra.http.Controller
import com.twitter.finatra.http.AbstractController

import javax.inject.Inject

/**
 * @since June 04, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
class HelloWorldController()
  extends AbstractController :

  override def configureRoutes() = ()
