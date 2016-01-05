package huipeng.daoapp.io;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AsyncEventPublisherApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class CallableAsyncEventPublisherApplicationTests {

  @Value("${local.server.port}")
  private int port;

  @Test
  public void testSay() throws Exception {
    assertOkResponse("/API/say/hello", "hello");
  }

  @Test
  public void testCall() throws Exception {
    assertOkResponse("/API/call/hello", "hello");
  }

  private void assertOkResponse(String path, String body) {
    ResponseEntity<String> entity =
        new TestRestTemplate().getForEntity("http://localhost:" + this.port + path, String.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(body, entity.getBody());
  }

}
