package ahlers.learn.twitter

import com.twitter.finatra.http.annotations.RouteParam

/**
 * @since June 11, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
case class MessageGetRequest(@RouteParam id: MessageId)
