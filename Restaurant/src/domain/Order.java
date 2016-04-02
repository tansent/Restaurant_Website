package domain;

public class Order {
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String hostname, String telephone, String time,
			String totalPeople, String note, String Id) {
		super();
		this.hostname = hostname;
		this.telephone = telephone;
		this.time = time;
		this.totalPeople = totalPeople;
		this.note = note;
		this.id = Id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTotalPeople() {
		return totalPeople;
	}
	public void setTotalPeople(String totalPeople) {
		this.totalPeople = totalPeople;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private String id;
	private String hostname;
	private String telephone;
	private String time;
	private String totalPeople;
	private String note;
}
