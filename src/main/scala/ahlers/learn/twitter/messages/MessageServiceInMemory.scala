package ahlers.learn.twitter.messages

import com.callicoder.SequenceGenerator
import com.twitter.util.Future

import javax.inject.Inject
import scala.collection.concurrent

/**
 * @since July 08, 2021
 * @author <a href="mailto:michael@ahlers.consulting">Michael Ahlers</a>
 */
class MessageServiceInMemory @Inject() (sequenceGenerator: SequenceGenerator)
  extends MessageService {

  val messageBodyByMessageId: concurrent.Map[MessageId, MessageBody] = concurrent.TrieMap()

  override def getMessage(request: MessageGetRequest) = {
    val id = request.id
    val bodyF = messageBodyByMessageId.get(id)
    Future(bodyF
      .map(MessageGetResponse(id, _))
      .getOrElse(throw MessageNotFoundException(request.id)))
  }

  override def createMessage(request: MessageCreateRequest) = {
    val id = MessageId(sequenceGenerator.nextId())
    val body = request.body
    messageBodyByMessageId.update(id, body)
    Future(MessageCreateResponse(
      id,
      request.body))
  }

}
