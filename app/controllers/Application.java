package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * Controller for the Application that renders webpages.
 */
public class Application extends Controller {

  /**
   * Renders the index.html page.
   * @return The content of the rendered page.
   */
  public static Result index() {

    return ok(index.render("Your new application is ready."));
  }

}
