package ahlers.learn.twitter.messages

import com.twitter.util.WrappedValue

//import com.twitter.inject.domain.WrappedValue

/**
 * @since June 11, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
case class MessageId(toLong: Long) extends WrappedValue[Long]
