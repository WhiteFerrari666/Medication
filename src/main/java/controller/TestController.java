package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ich vermute, hier entsteht unsere "Seite". Der Inhalt wird angezeigt, wenn
 * man die Credentials richtig eingegeben hat :)
 */
@RestController
@EnableAutoConfiguration
public class TestController {

	@GetMapping("/")
	public String home() {
		return "MedicationApp von Laura, Kathrin und Martin" +
				"\n0.0.1";
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greetings";
	}

}
