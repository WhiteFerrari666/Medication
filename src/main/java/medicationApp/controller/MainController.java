package medicationApp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import medicationApp.dao.MedikamentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import medicationApp.dao.ErinnerungenDao;
import medicationApp.dao.MedikamentDao;
import medicationApp.dao.TerminDao;
import medicationApp.form.ErinnerungForm;
import medicationApp.form.MedikamentForm;
import medicationApp.form.TerminForm;
import medicationApp.model.Erinnerung;
import medicationApp.model.Medikament;
import medicationApp.model.Termin;
import medicationApp.service.KalenderPopulationService;

@Controller
public class MainController {

    @Autowired
    private ErinnerungenDao erinnerungenDao;

    @Autowired
    private TerminDao terminDao;

    @Autowired
    private MedikamentDao medikamentDao;


	@Autowired
	private KalenderPopulationService kalenderPopulationService;

    static Date dt = new Date();

    static {

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

        final List<Medikament> medikamentenListe = (List<Medikament>)
                medikamentDao.findAll();
        model.addAttribute("medikament", medikamentenListe);
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
        String form = medikamentForm.getForm();
        int dosis = medikamentForm.getDosis();
        boolean rezeptpflichtig = medikamentForm.isRezeptpflichtig();

        if (name != null && name.length() > 0 && form != null && dosis != 0) {
            Medikament medikament = new Medikament(name, form, dosis, rezeptpflichtig);
            medikamentDao.saveAndFlush(medikament);
            return "redirect:/medikamentenListe";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addMedikament";
    }

    //Mein Tag
    @GetMapping(value = {"/meinTag"})
    public String meinTag(Model model) {
        final List<Erinnerung> erinnerungenListe = (List<Erinnerung>) erinnerungenDao.findAll();
        model.addAttribute("erinnerung", erinnerungenListe);

        LocalDate date = LocalDate.now();
        final List<Termin> terminListe = terminDao.findAllByDatumIs(date);
        model.addAttribute("termin", terminListe);

        return "meinTag";
    }

    //Erinnerung
    @GetMapping(value = {"/erinnerungenListe"})
    public String erinnerungenListe(Model model) {

        final List<Erinnerung> erinnerungenListe = (List<Erinnerung>) erinnerungenDao.findAll();
        model.addAttribute("erinnerung", erinnerungenListe);

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
        String medikament = erinnerungForm.getMedikament();
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

        if (bezeichnung != null && anfangsdatum != null) {
            Erinnerung erinnerung = new Erinnerung(bezeichnung, medikament, dosis, aktiv, montag, dienstag, mittwoch, donnerstag, freitag, samstag, sonntag, anfangsdatum, enddatum);
            erinnerungenDao.saveAndFlush(erinnerung);
            return "redirect:/erinnerungenListe";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addErinnerung";
    }

    @GetMapping(value = {"/deleteErinnerung"})
    public String showDeleteErinnerung(Model model) {

        ErinnerungForm erinnerungForm = new ErinnerungForm();
        model.addAttribute("erinnerungForm", erinnerungForm);

        final List<Erinnerung> erinnerungenListe = (List<Erinnerung>) erinnerungenDao.findAll();
        model.addAttribute("erinnerung", erinnerungenListe);

        return "deleteErinnerung";
    }

    @PostMapping(value = {"/deleteErinnerung"})
    public String deleteErinnerung(Model model, @ModelAttribute("erinnerungForm") ErinnerungForm erinnerungForm) {
        String bezeichnung = erinnerungForm.getBezeichnung();
        if (bezeichnung != null) {
            Erinnerung erinnerung = erinnerungenDao.getErinnerungByBezeichnung(bezeichnung);
            erinnerungenDao.delete(erinnerung);
            return "redirect:/erinnerungenListe";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "deleteErinnerung";
    }

    // Kalender
    @GetMapping(value = {"/kalender"})
	public String kalender(Model model) throws IOException {
		kalenderPopulationService.parseAllToJson();

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
        LocalDate datum = terminForm.getDatum();
        String weblink = terminForm.getWebLink();
        boolean dringend = terminForm.isDringend();
        String anmerkungen = terminForm.getAnmerkungen();

        if (uhrzeitBezeichnung != null && uhrzeitBezeichnung.length() > 0 && datum != null) {
            Termin termin = new Termin(uhrzeitBezeichnung, datum, weblink, dringend, anmerkungen);
            terminDao.saveAndFlush(termin);
            return "redirect:/kalender";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addTermin";
    }
}