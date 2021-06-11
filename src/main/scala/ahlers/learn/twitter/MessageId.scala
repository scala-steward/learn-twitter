package ahlers.learn.twitter

import com.twitter.inject.domain.WrappedValue

/**
 * @since June 11, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
case class MessageId(toText: String) extends WrappedValue[String]
