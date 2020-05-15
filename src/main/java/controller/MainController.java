package controller;

import java.util.ArrayList;
import java.util.List;

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
		medikamente.add(new Medikament("Antibiotika", 5));
		medikamente.add(new Medikament("Ibuprofen", 3));
	}

	// Aus Application.properties abspritzen (inject).
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

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

}