package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private AdresyDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Adres> adresList = dao.list();
        model.addAttribute("adresList", adresList);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Adres adres = new Adres();
        model.addAttribute("adresy", adres);
        return "new_form";
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("adresy") Adres adres) {
        dao.save(adres);
        return "redirect:/";
    }

    public AppController(AdresyDAO dao) {
        this.dao = dao;
    }
}
