package huipeng.daoapp.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAsync
public class AsyncEventPublisherApplication extends WebMvcConfigurerAdapter {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(AsyncEventPublisherApplication.class, args);
  }
}
