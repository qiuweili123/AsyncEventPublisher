package huipeng.daoapp.io.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("messageService")
public class MessageServiceImpl implements MessageService {
  private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

  @Override
  public void say(String message) {
    logger.debug(new StringBuilder("Service will wait 10s").toString());
    try {
      Thread.sleep(1000 * 10); // 1000 milliseconds is one second.
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
    logger.debug(new StringBuilder("Done Event").toString());
    logger.debug(message);
  }

}
