package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReservationForm {
	
	public ReservationForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationForm(String hostname, String telephone, String month,
			String day, String year, String hour, String totalPeople,
			String note, Map<String, String> orderError) {
		super();
		this.hostname = hostname;
		this.telephone = telephone;
		this.month = month;
		this.day = day;
		this.year = year;
		this.hour = hour;
		this.totalPeople = totalPeople;
		this.note = note;
		this.orderError = orderError;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
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

	public Map<String, String> getOrderError() {
		return orderError;
	}

	public void setOrderError(Map<String, String> orderError) {
		this.orderError = orderError;
	}

	private String hostname;
	private String telephone;
	private String month;
	private String day;
	private String year;
	private String hour;
	private String totalPeople;
	private String note;
	
	private Map<String, String> orderError = new LinkedHashMap<String, String>();
}
