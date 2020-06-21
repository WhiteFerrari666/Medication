package medicationApp.model;

import java.util.Date;

public class KalenderTermin {

	private String titel;
	private Date datum;
	private String webLink;

	public KalenderTermin() {
	}

	public KalenderTermin(String titel, Date datum, String webLink) {
		this.titel = titel;
		this.datum = datum;
		this.webLink = webLink;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getWebLink() {
		return webLink;
	}

	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}
}
