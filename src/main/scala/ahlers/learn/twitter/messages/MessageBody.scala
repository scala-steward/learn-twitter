package ahlers.learn.twitter.messages

import com.twitter.util.WrappedValue
import jakarta.validation.constraints.{ Max, NotEmpty, Size }

/**
 * @since July 2, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
case class MessageBody(
  @NotEmpty @Size(max = 10) toText: String)
  extends WrappedValue[String]
