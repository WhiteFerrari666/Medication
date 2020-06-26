package medicationApp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import medicationApp.dao.ErinnerungenDao;
import medicationApp.form.ErinnerungForm;
import medicationApp.form.MedikamentForm;
import medicationApp.form.TerminForm;
import medicationApp.model.Erinnerung;
import medicationApp.model.Medikament;
import medicationApp.model.Termin;

@Controller
public class MainController {

	@Autowired
	private ErinnerungenDao erinnerungenDao;

	private static List<Medikament> medikamente = new ArrayList<Medikament>();
	private static List<Termin> termine = new ArrayList<Termin>();
	private static List<Erinnerung> erinnerungen = new ArrayList<Erinnerung>();

	static Date dt = new Date();
	static {
		medikamente.add(new Medikament("Antibiotika", 1));
		medikamente.add(new Medikament("Ibuprofen", 3));

		erinnerungen.add(new Erinnerung("Antibiotika", 4, true, true, false, true, false, true, false, true, dt, dt));
	}

	// Aus Application.properties ziehen.
	@Value("${welcome.message}")
	private String welcomeMessage;

	@Value("${error.message}")
	private String errorMessage;
	@Value("${medikament.error.message}")
	private String errorMessageMedikament;
	@Value("${termin.error.message}")
	private String errorMessageTermin;
	@Value("${erinnerung.error.message}")
	private String errorMessageErinnerung;

	// Mappings
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {

		model.addAttribute("message", welcomeMessage);

		return "index";
	}

	// Medikamente
	@GetMapping(value = {"/medikamentenListe"})
	public String medikamentenListe(Model model) {

		model.addAttribute("medikamente", medikamente);

		return "medikamentenListe";
	}

	@GetMapping(value = {"/addMedikament"})
	public String showAddMedikament(Model model) {

		MedikamentForm medikamentForm = new MedikamentForm();
		model.addAttribute("medikamentForm", medikamentForm);

		return "addMedikament";
	}

	@PostMapping(value = {"/addMedikament"})
	public String saveMedikament(Model model, //
			@ModelAttribute("medikamentForm") MedikamentForm medikamentForm) {

		String name = medikamentForm.getName();
		int dosis = medikamentForm.getDosis();

		if (name != null && name.length() > 0 //
				&& dosis != 0) {
			Medikament newMedikament = new Medikament(name, dosis);
			medikamente.add(newMedikament);

			return "redirect:/medikamentenListe";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addMedikament";
	}

	@GetMapping(value = {"/meinTag"})
	public void meinTag(Model model) {
	}

	@GetMapping(value = {"/erinnerungenListe"})
	public String erinnerungenListe(Model model) {

		// final List<Erinnerung> erinnerungenListe = (List<Erinnerung>)
		erinnerungenDao.findAll();
		model.addAttribute("erinnerung", erinnerungen);
		return "erinnerungenListe";
	}

	@GetMapping(value = {"/addErinnerung"})
	public String showAddErinnerung(Model model) {

		ErinnerungForm erinnerungForm = new ErinnerungForm();
		model.addAttribute("erinnerungForm", erinnerungForm);

		return "addErinnerung";
	}

	@PostMapping(value = {"/addErinnerung"})
	public String saveErinnerung(Model model, //
			@ModelAttribute("erinnerungForm") ErinnerungForm erinnerungForm) {

		String bezeichnung = erinnerungForm.getBezeichnung();
		int dosis = erinnerungForm.getDosis();
		boolean aktiv = erinnerungForm.isAktiv();
		boolean montag = erinnerungForm.isMontag();
		boolean dienstag = erinnerungForm.isDienstag();
		boolean mittwoch = erinnerungForm.isMittwoch();
		boolean donnerstag = erinnerungForm.isDonnerstag();
		boolean freitag = erinnerungForm.isFreitag();
		boolean samstag = erinnerungForm.isSamstag();
		boolean sonntag = erinnerungForm.isSonntag();
		Date anfangsdatum = erinnerungForm.getAnfangsdatum();
		Date enddatum = erinnerungForm.getEnddatum();

		if (bezeichnung != null && bezeichnung.length() > 0 //
				&& dosis != 0) {
			Erinnerung newErinnerung = new Erinnerung(bezeichnung, dosis, aktiv, montag, dienstag, mittwoch, donnerstag,
					freitag, samstag, sonntag, anfangsdatum, enddatum);
			erinnerungen.add(newErinnerung);

			return "redirect:/erinnerungenListe";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addErinnerung";
	}

	// Kalender
	@GetMapping(value = {"/kalender"})
	public String kalender(Model model) {
		// model.addAttribute("termine", termine);

		return "kalender";
	}

	@GetMapping(value = {"/addTermin"})
	public String showAddTermin(Model model) {

		TerminForm terminForm = new TerminForm();
		model.addAttribute("terminForm", terminForm);

		return "addTermin";
	}

	@PostMapping(value = {"/addTermin"})
	public String saveTermin(Model model, @ModelAttribute("terminForm") TerminForm terminForm) {

		String uhrzeitBezeichnung = terminForm.getUhrzeitBezeichnung();
		Date datum = terminForm.getDatum();
		String weblink = terminForm.getWebLink();
		boolean dringend = terminForm.isDringend();
		String anmerkungen = terminForm.getAnmerkungen();

		if (uhrzeitBezeichnung != null && uhrzeitBezeichnung.length() > 0 && datum != null) {
			Termin termin = new Termin(uhrzeitBezeichnung, datum, weblink, dringend, anmerkungen);
			termine.add(termin);
			return "redirect:/kalender";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addTermin";
	}
}