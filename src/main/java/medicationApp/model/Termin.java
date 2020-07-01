package medicationApp.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "termin")
public class Termin {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "uhrzeit_bezeichnung", nullable = false)
	private String uhrzeitBezeichnung;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "datum", nullable = false)
	private Date datum;

	@Column(name = "weblink")
	private String webLink;

	@Column(name = "dringend")
	private boolean dringend;

	@Column(name = "anmerkungen")
	private String anmerkungen;

	public Termin() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Termin(String uhrzeitBezeichnung, Date datum, String webLink, boolean dringend, String anmerkungen) {
		this.uhrzeitBezeichnung = uhrzeitBezeichnung;
		this.datum = datum;
		this.webLink = webLink;
		this.dringend = dringend;
		this.anmerkungen = anmerkungen;

	}


	public String getUhrzeitBezeichnung() {
		return uhrzeitBezeichnung;
	}

	public void setUhrzeitBezeichnung(String uhrzeitBezeichnung) {
		this.uhrzeitBezeichnung = uhrzeitBezeichnung;
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

	public boolean isDringend() {
		return dringend;
	}

	public void setDringend(boolean dringend) {
		this.dringend = dringend;
	}

	public String getAnmerkungen() {
		return anmerkungen;
	}

	public void setAnmerkungen(String anmerkungen) {
		this.anmerkungen = anmerkungen;
	}
}
