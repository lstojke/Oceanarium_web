package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private PracownicyDAO pracownicyDAO;
    @Autowired
    private SektoryDAO sektoryDAO;
    @Autowired
    private AdresyDAO adresyDAO;
    @Autowired
    private ZwierzetaDAO zwierzetaDAO;

    @RequestMapping("/")
    public String mainPage(){
        return "index";
    }
    @RequestMapping("/pracownicy")
    public String pracownicy(Model model){
        List<Pracownik> pracownikList = pracownicyDAO.list();
        model.addAttribute("pracownikList", pracownikList);
        return "pracownicy";
    }

    @RequestMapping("/sektory")
    public String sektory(Model model){
        List<Sektor> sektorList = sektoryDAO.list();
        model.addAttribute("sektorList", sektorList);
        return "sektory/sektory";
    }

    @RequestMapping("/adresy")
    public String adresy(Model model){
        List<Adres> adresList = adresyDAO.list();
        model.addAttribute("adresList", adresList);
        return "adresy/adresy";
    }

    @RequestMapping("/zwierzeta")
    public String zwierzeta(Model model){
        List<Zwierze> zwierzeList = zwierzetaDAO.list();
        model.addAttribute("zwierzeList", zwierzeList);
        return "zwierzeta/zwierzeta";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Pracownik pracownik = new Pracownik();
        Adres adres = new Adres();
        model.addAttribute("pracownicy", pracownik);
        model.addAttribute("adresy", adres);
        return "new_form";
    }

    @RequestMapping("/newAdresP")
    public String workerAdres(Model model) {
        Adres adres = new Adres();
        model.addAttribute("adresy", adres);
        return "adresy/new_form";
    }

    @RequestMapping("/newSektor")
    public String SektorNewForm(Model model) {
        Sektor sektor = new Sektor();
        model.addAttribute("sektory", sektor);
        return "sektory/new_form";
    }

    @RequestMapping("/newZwierze")
    public String ZwierzeNewForm(Model model) {
        Zwierze zwierze = new Zwierze();
        model.addAttribute("zwierzeta", zwierze);
        return "zwierzeta/new_form";
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownicy") Pracownik pracownik) {
        pracownicyDAO.save(pracownik);
        return "redirect:/pracownicy";
    }

    @RequestMapping(value= "/saveAdres", method = RequestMethod.POST)
    public String saveAdres(@ModelAttribute("adresy") Adres adres) {
        adresyDAO.save(adres);
        return "redirect:/pracownicy";
    }

    @RequestMapping(value= "/saveSektor", method = RequestMethod.POST)
    public String save(@ModelAttribute("sektory") Sektor sektor) {
        sektoryDAO.save(sektor);
        return "redirect:/sektory";
    }

    @RequestMapping(value= "/saveZwierze", method = RequestMethod.POST)
    public String save(@ModelAttribute("zwierzeta") Zwierze zwierze) {
        zwierzetaDAO.save(zwierze);
        return "redirect:/zwierzeta";
    }

     @RequestMapping(value= "/edit/{id_pracownika}")
    public ModelAndView showEditForm(@PathVariable(name = "id_pracownika") int id_pracownika) {
        ModelAndView mav = new ModelAndView("edit_form");
        Pracownik pracownik = pracownicyDAO.get(id_pracownika);
        mav.addObject("pracownicy", pracownik);
        return mav;
    }

    @RequestMapping(value= "/SectorEdit/{id_sektora}")
    public ModelAndView sektorEditForm(@PathVariable(name = "id_sektora") int id_sektora) {
        ModelAndView mav = new ModelAndView("sektory/edit_form");
        Sektor sektor = sektoryDAO.get(id_sektora);
        mav.addObject("sektory", sektor);
        return mav;
    }

    @RequestMapping(value= "/AdresEdit/{id_adresu}")
    public ModelAndView AdresEditForm(@PathVariable(name = "id_adresu") int id_adresu) {
        ModelAndView mav = new ModelAndView("adresy/edit_form");
        Adres adres = adresyDAO.get(id_adresu);
        mav.addObject("adresy", adres);
        return mav;
    }

    @RequestMapping(value= "/ZwierzeEdit/{id_zwierze}")
    public ModelAndView zwierzeEditForm(@PathVariable(name = "id_zwierze") int id_zwierze) {
        ModelAndView mav = new ModelAndView("zwierzeta/edit_form");
        Zwierze zwierze = zwierzetaDAO.get(id_zwierze);
        mav.addObject("zwierzeta", zwierze);
        return mav;
    }

    @RequestMapping(value= "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownicy") Pracownik pracownik) {
        pracownicyDAO.update(pracownik);
        return "redirect:/pracownicy";
    }

    @RequestMapping(value= "/updateSektor", method = RequestMethod.POST)
    public String updateSektor(@ModelAttribute("sektory") Sektor sektor) {
        sektoryDAO.update(sektor);
        return "redirect:/sektory";
    }

    @RequestMapping(value= "/updateAdres", method = RequestMethod.POST)
    public String updateAdres(@ModelAttribute("adresy") Adres adres) {
        adresyDAO.update(adres);
        return "redirect:/adresy";
    }

    @RequestMapping(value= "/updateZwierze", method = RequestMethod.POST)
    public String updateSektor(@ModelAttribute("zwierzeta") Zwierze zwierze) {
        zwierzetaDAO.update(zwierze);
        return "redirect:/zwierzeta";
    }

    @RequestMapping(value= "/delete/{id_pracownika}")
    public String delete(@PathVariable(name = "id_pracownika") int id_pracownika) {
        pracownicyDAO.delete(id_pracownika);
        return "redirect:/pracownicy";
    }

    @RequestMapping(value= "/SectorDelete/{id_sektora}")
    public String deleteSector(@PathVariable(name = "id_sektora") int id_sektora) {
        sektoryDAO.delete(id_sektora);
        return "redirect:/sektory";
    }

    @RequestMapping(value= "/AdresDelete/{id_adresu}")
    public String deleteAdres(@PathVariable(name = "id_adresu") int id_adresu) {
        adresyDAO.delete(id_adresu);
        return "redirect:/adresy";
    }

    @RequestMapping(value= "/ZwierzeDelete/{id_zwierze}")
    public String deleteZwierze(@PathVariable(name = "id_zwierze") int id_zwierze) {
        zwierzetaDAO.delete(id_zwierze);
        return "redirect:/zwierzeta";
    }

    public AppController(PracownicyDAO pracownicyDAO, SektoryDAO sektoryDAO, AdresyDAO adresyDAO) {
        this.pracownicyDAO = pracownicyDAO;
        this.sektoryDAO = sektoryDAO;
        this.adresyDAO = adresyDAO;
        this.zwierzetaDAO = zwierzetaDAO;
    }
}
