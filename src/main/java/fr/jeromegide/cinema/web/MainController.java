package fr.jeromegide.cinema.web;

import fr.jeromegide.cinema.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    FilmDao filmsDao ;
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("films", filmsDao.films());
        model.addAttribute("nom", "jeromegide");
        return "index";
    }
    @GetMapping("/film/{id}")
    //public String detail(Model model, HttpServletRequest httpServletRequest)
    public String detail(Model model, @PathVariable("id") String id){
        Integer idFilm = Integer.parseInt(id);
        model.addAttribute("film", filmsDao.getById(idFilm));
        return "detail";
    }
}
