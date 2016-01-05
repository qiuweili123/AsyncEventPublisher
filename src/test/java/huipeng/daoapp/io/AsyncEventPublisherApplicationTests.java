package huipeng.daoapp.io;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AsyncEventPublisherApplication.class)
@WebAppConfiguration
@ActiveProfiles("scratch")
public class AsyncEventPublisherApplicationTests {
  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Rule
  public OutputCapture outputCapture = new OutputCapture();


  @Before
  public void setUp() {
    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }

  @Test
  public void testHome() throws Exception {
    this.mvc.perform(get("/API/say/hello")).andExpect(status().isOk())
        .andExpect(content().string(containsString("hello")));
    this.outputCapture.expect(containsString("somniloquy will wait 3s"));
    this.outputCapture.expect(containsString("wake up"));
    this.outputCapture.expect(containsString("hello"));
    this.outputCapture.expect(containsString("Send Event"));
    this.outputCapture.expect(containsString("Process Event"));
    this.outputCapture.expect(not(containsString("Done Event")));
  }
}
