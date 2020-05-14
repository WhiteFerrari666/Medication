package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ich vermute, hier entsteht unsere "Seite". Der Inhalt wird angezeigt, wenn
 * man die Credentials richtig eingegeben hat :)
 */
@RestController
@EnableAutoConfiguration
public class TestController {

	@RequestMapping("/")
	public String home() {
		return "Spring boot is working!";
	}
}
