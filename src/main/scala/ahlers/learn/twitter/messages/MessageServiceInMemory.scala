package ahlers.learn.twitter.messages

import com.callicoder.SequenceGenerator
import com.twitter.util.Future

import javax.inject.Inject

/**
 * @since July 08, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
class MessageServiceInMemory @Inject() (sequenceGenerator: SequenceGenerator)
  extends MessageService {

  override def createMessage(request: MessageCreateRequest) = {
    val id = MessageId(sequenceGenerator.nextId())
    Future(MessageCreateResponse(
      id,
      request.body))
  }

}
