package vo;

public class ParticipantVO {
	private int party_id;
	private String user_id;
	
	public int getParty_id() {
		return party_id;
	}
	public void setParty_id(int party_id) {
		this.party_id = party_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "ParticipantVO [party_id=" + party_id + ", user_id=" + user_id + "]";
	}
	
}
