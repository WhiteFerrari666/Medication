package controller;

import java.util.ArrayList;
import java.util.List;

import form.ErinnerungForm;
import model.Erinnerung;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import form.MedikamentForm;
import model.Medikament;

@Controller
public class MainController {

	private static List<Medikament> medikamente = new ArrayList<Medikament>();

	static {
		medikamente.add(new Medikament("Antibiotika", 1));
		medikamente.add(new Medikament("Ibuprofen", 3));
	}
	private static List<Erinnerung> erinnerungen = new ArrayList<Erinnerung>();

	static {
		erinnerungen.add(new Erinnerung("Test", 4));
	}


	// Aus Application.properties ziehen.
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	// TODO mde Annotations durch neue, kürzere Varianten ersetzen (@GetMapping,
	// @PostMapping, etc.)
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("message", message);

		return "index";
	}

	@RequestMapping(value = {"/medikamentenListe"}, method = RequestMethod.GET)
	public String medikamentenListe(Model model) {

		model.addAttribute("medikamente", medikamente);

		return "medikamentenListe";
	}

	@RequestMapping(value = {"/addMedikament"}, method = RequestMethod.GET)
	public String showAddMedikament(Model model) {

		MedikamentForm medikamentForm = new MedikamentForm();
		model.addAttribute("medikamentForm", medikamentForm);

		return "addMedikament";
	}

	@RequestMapping(value = {"/addMedikament"}, method = RequestMethod.POST)
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

	@RequestMapping(value = {"/erinnerungenListe"}, method = RequestMethod.GET)
	public String erinnerungenListe(Model model) {


		model.addAttribute("erinnerung", erinnerungen);
		return "erinnerungenListe";
	}

	@RequestMapping(value = {"/addErinnerung"}, method = RequestMethod.GET)
	public String showAddErinnerung(Model model) {

		ErinnerungForm erinnerungForm = new ErinnerungForm();
		model.addAttribute("erinnerungForm", erinnerungForm);

		return "addErinnerung";
	}

	@RequestMapping(value = {"/addErinnerung"}, method = RequestMethod.POST)
	public String saveErinnerung(Model model, //
								 @ModelAttribute("erinnerungForm") ErinnerungForm erinnerungForm) {

		String name = erinnerungForm.getName();
		int dosis = erinnerungForm.getDosis();

		if (name != null && name.length() > 0 //
				&& dosis != 0) {
			Erinnerung newErinnerung = new Erinnerung(name, dosis);
			erinnerungen.add(newErinnerung);

			return "redirect:/erinnerungenListe";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addErinnerung";
	}

	@RequestMapping(value = {"/kalender"}, method = RequestMethod.GET)
	public String kalender(Model model) {

		return "kalender";
	}

}