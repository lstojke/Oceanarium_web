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
    private PracownicyDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Pracownik> pracownikList = dao.list();
        model.addAttribute("pracownikList", pracownikList);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownicy", pracownik);
        return "new_form";
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownicy") Pracownik pracownik) {
        dao.save(pracownik);
        return "redirect:/";
    }

     @RequestMapping(value= "/edit/{id_pracownika}")
    public ModelAndView showEditForm(@PathVariable(name = "id_pracownika") int id_pracownika) {
        ModelAndView mav = new ModelAndView("edit_form");
        Pracownik pracownik = dao.get(id_pracownika);
        mav.addObject("pracownicy", pracownik);
        return mav;
    }

    @RequestMapping(value= "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownicy") Pracownik pracownik) {
        dao.update(pracownik);
        return "redirect:/";
    }

    @RequestMapping(value= "/delete/{id_pracownika}")
    public String delete(@PathVariable(name = "id_pracownika") int id_pracownika) {
        dao.delete(id_pracownika);
        return "redirect:/";
    }

    public AppController(PracownicyDAO dao) {
        this.dao = dao;
    }
}
