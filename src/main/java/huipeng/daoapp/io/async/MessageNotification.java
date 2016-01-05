package huipeng.daoapp.io.async;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import huipeng.daoapp.io.service.MessageService;

@Component
public class MessageNotification {
  private static final Logger logger = LoggerFactory.getLogger(MessageNotification.class);

  @Autowired
  private MessageService messageService;

  @EventListener
  public void processMessageEvent(MessageEvent event) throws IOException {
    logger.debug(new StringBuilder("Process Event").toString());
    messageService.say(event.getMessage());
    logger.debug(new StringBuilder("Done Event").toString());
  }
}
