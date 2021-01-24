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

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownicy", pracownik);
        return "new_form";
    }

    @RequestMapping("/newSektor")
    public String SektorNewForm(Model model) {
        Sektor sektor = new Sektor();
        model.addAttribute("sektory", sektor);
        return "sektory/new_form";
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownicy") Pracownik pracownik) {
        pracownicyDAO.save(pracownik);
        return "redirect:/pracownicy";
    }

    @RequestMapping(value= "/saveSektor", method = RequestMethod.POST)
    public String save(@ModelAttribute("sektory") Sektor sektor) {
        sektoryDAO.save(sektor);
        return "redirect:/sektory";
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

    public AppController(PracownicyDAO pracownicyDAO, SektoryDAO sektoryDAO) {
        this.pracownicyDAO = pracownicyDAO;
        this.sektoryDAO = sektoryDAO;
    }
}
