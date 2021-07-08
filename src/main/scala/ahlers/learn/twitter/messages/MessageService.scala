package ahlers.learn.twitter.messages

import com.twitter.util.Future

/**
 * @since July 07, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
trait MessageService {

  def createMessage(request: MessageCreateRequest): Future[MessageCreateResponse]

}
