package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public AppController(AdresyDAO dao) {
        this.dao = dao;
    }
}
