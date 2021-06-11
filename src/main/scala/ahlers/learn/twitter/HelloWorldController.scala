package ahlers.learn.twitter

import scala.reflect.runtime.universe._

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

import javax.inject.Inject

/**
 * @since June 04, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
class HelloWorldController()
  extends Controller
