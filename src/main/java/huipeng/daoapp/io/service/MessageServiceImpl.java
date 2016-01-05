package huipeng.daoapp.io.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import huipeng.daoapp.io.async.MessageEventPublisher;

@Component("messageService")
public class MessageServiceImpl implements MessageService {
  private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

  @Autowired
  private MessageEventPublisher messageEventPublisher;

  private void somniloquy(String message) {
    logger.debug(new StringBuilder("somniloquy will wait 3s").toString());
    try {
      Thread.sleep(1000 * 3); // 1000 milliseconds is one second.
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
    logger.debug(new StringBuilder("wake up").toString());
    logger.debug(message);
  }

  @Override
  public void asyncSay(String message) {
    messageEventPublisher.sendMessage(message);
  }

  @Override
  public void say(String message) {
    this.somniloquy(message);
  }

}
