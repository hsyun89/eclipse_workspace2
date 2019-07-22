package vo;

public class TrainVO {
	private int code;
	private int originNo;
	private int groupOrd;
	private int groupLayer;
	private String title;
	private String contents;
	private String user_id;
	private int groupOrdTail;
	private int flag;
	private int collapse;
	
	public int getCollapse() {
		return collapse;
	}
	public void setCollapse(int collapse) {
		this.collapse = collapse;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getGroupOrdTail() {
		return groupOrdTail;
	}
	public void setGroupOrdTail(int groupOrdTail) {
		this.groupOrdTail = groupOrdTail;
	}
	@Override
	public String toString() {
		return "TrainVO [code=" + code + ", originNo=" + originNo + ", groupOrd=" + groupOrd + ", groupLayer="
				+ groupLayer + ", title=" + title + ", contents=" + contents + ", user_id=" + user_id
				+ ", groupOrdTail=" + groupOrdTail + ", flag=" + flag + "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getOriginNo() {
		return originNo;
	}
	public void setOriginNo(int originNo) {
		this.originNo = originNo;
	}
	public int getGroupOrd() {
		return groupOrd;
	}
	public void setGroupOrd(int groupOrd) {
		this.groupOrd = groupOrd;
	}
	public int getGroupLayer() {
		return groupLayer;
	}
	public void setGroupLayer(int groupLayer) {
		this.groupLayer = groupLayer;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
