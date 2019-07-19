package vo;

public class PartyVO {
	//게시글
	private int party_id;
	private int post_number;
	private int party_size;
	private String user_id;
	private String write_date;
	private String title;
	private String contents;
	private String location;
	//참가자
	private int participant_size;
	
	public int getParty_id() {
		return party_id;
	}
	public void setParty_id(int party_id) {
		this.party_id = party_id;
	}
	public int getPost_number() {
		return post_number;
	}
	public void setPost_number(int post_number) {
		this.post_number = post_number;
	}
	public int getParty_size() {
		return party_size;
	}
	public void setParty_size(int party_size) {
		this.party_size = party_size;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getParticipant_size() {
		return participant_size;
	}
	public void setParticipant_size(int participant_size) {
		this.participant_size = participant_size;
	}
	@Override
	public String toString() {
		return "PartyVO [party_id=" + party_id + ", post_number=" + post_number + ", party_size=" + party_size
				+ ", user_id=" + user_id + ", write_date=" + write_date + ", title=" + title + ", contents="
				+ contents + ", location=" + location + ", participant_size=" + participant_size + ", getParty_id()="
				+ getParty_id() + ", getPost_number()=" + getPost_number() + ", getParty_size()=" + getParty_size()
				+ ", getUser_id()=" + getUser_id() + ", getWrite_date()=" + getWrite_date() + ", getTitle()="
				+ getTitle() + ", getContents()=" + getContents() + ", getLocation()=" + getLocation()
				+ ", getParticipant_size()=" + getParticipant_size() + "]";
	}
}

