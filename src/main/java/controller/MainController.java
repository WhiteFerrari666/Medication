package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import form.MedikamentForm;
import model.KalenderTermin;
import model.Medikament;

@Controller
public class MainController {

	private static List<Medikament> medikamente = new ArrayList<Medikament>();
	private static List<KalenderTermin> termine = new ArrayList<KalenderTermin>();

	static {
		medikamente.add(new Medikament("Antibiotika", 1));
		medikamente.add(new Medikament("Ibuprofen", 3));
	}

	// Aus Application.properties ziehen.
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	// TODO mde Annotations durch neue, kürzere Varianten ersetzen (@GetMapping,
	// @PostMapping, etc.)
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {

		model.addAttribute("message", message);

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

	// Kalender
	@GetMapping(value = {"/kalender"})
	public String kalender(Model model) {

		return "kalender";
	}

}