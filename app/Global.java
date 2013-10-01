import java.util.List;

import models.Media;


import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Json;
import play.libs.Yaml;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;


/**
 * 
 */

/**
 * @author ggilbert
 * 
 */
public class Global extends GlobalSettings {
 
	@Override
	public void onStart(Application app) {
	
		Media.purge();
		
		// TODO - figure out how to make this and tests coexist
		// WARN - to run play test you must comment this out
		List<Media> medias = (List<Media>)Yaml.load("test-data.yaml");
		if (medias != null && !medias.isEmpty()) {
			for (Media media : medias) {
				Media.create(media);
			}
		}
	}
}
