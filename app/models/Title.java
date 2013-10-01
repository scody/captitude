package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.vz.mongodb.jackson.Id;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Title {
	
	public Title(){
		
	}
	
	private String id;
	private String userId;
	private String titleText;
	private Date createDate;
	private List<String>userIdVotes = new ArrayList<String>();
	private int voteCount = 0;
	
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitleText() {
		return titleText;
	}
	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<String> getUserIdVotes() {
		return userIdVotes;
	}
	public void setUserIdVotes(List<String> userIdVotes) {
		this.userIdVotes = userIdVotes;
	}
	
	@JsonCreator
	public Title(
			@Id @JsonProperty(value="id")String id, 
			@JsonProperty(value="userid")String userId, 
			@JsonProperty(value="titleText")String titleText,
			@JsonProperty(value="createdDate")Date createDate,
			@JsonProperty(value="userIdVotes")List<String> userIdVotes,
			@JsonProperty(value="voteCount")int voteCount) {
		super();
		this.id = id;
		this.userId = userId;
		this.titleText = titleText;
		this.createDate = createDate;
		this.userIdVotes = userIdVotes;
		this.voteCount = voteCount;
	}	
}
