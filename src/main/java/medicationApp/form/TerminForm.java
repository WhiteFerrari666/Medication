package medicationApp.form;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TerminForm {

	private String uhrzeitBezeichnung;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datum;
	private String webLink;
	private boolean dringend;
	private String anmerkungen;

	public String getUhrzeitBezeichnung() {
		return uhrzeitBezeichnung;
	}

	public void setUhrzeitBezeichnung(String uhrzeitBezeichnung) {
		this.uhrzeitBezeichnung = uhrzeitBezeichnung;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
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
