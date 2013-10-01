package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.bson.types.ObjectId; 
import com.mongodb.BasicDBObject;


import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import play.modules.mongodb.jackson.MongoDB;


public class Media {
	
	public Media(){
		
	}
	
	public List<Title> getTitles() {
		return titles;
	}
	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	private String id;
	private String media;
	private String mediaType;
	private Date mediaDate;
	private List<Title> titles = new ArrayList<Title>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public Date getMediaDate() {
		return mediaDate;
	}
	public void setMediaDate(Date mediaDate) {
		this.mediaDate = mediaDate;
	}
	public Media(
			@Id @JsonProperty(value="id") String id, 
			@JsonProperty(value="media") String media,
			@JsonProperty(value="mediaType") String mediaType,
			@JsonProperty(value="date") Date mediaDate) {
		super();
		this.id = id;
		this.media = media;
		this.mediaType = mediaType;
		this.mediaDate = mediaDate;
	}
	
	
	private static JacksonDBCollection<Media, String> collection = MongoDB
			.getCollection("Media", Media.class, String.class);

	public static void create(Media media) {
		Media.collection.save(media);
	}
	
	public static List<Media> findAll() {		
		return Media.collection.find().toArray();
	}
		
	public static void purge() {
		Media.collection.drop();
	}
	
	
}



