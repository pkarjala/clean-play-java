package test;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs an Integration unit test against the framework.
 */
public class IntegrationTest {

  /**
   * In this example we just check if the welcome page is being shown.
   */
  @Test
  public void test() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      /**
       * Utilizes the TestBrowser to test an actual HTTP call.
       * @param browser The created browser already running.
       */
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        assertThat(browser.pageSource()).contains("Your new application is ready.");
      }
    });
  }

}
