package controllers;

import java.util.List;

import play.*;
import play.data.Form;
import play.mvc.*;
import models.Media;
import models.Media;


import views.html.*;
 
public class Application extends Controller {
   
    public static Result index() {
    	List<Media> mediaList = Media.findAll();
    	return ok(index.render(mediaList));  
        //return ok(index.render("Your new application is ready."));
    }
  
}
