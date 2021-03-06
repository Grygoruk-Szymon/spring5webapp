package gruru.springframework.spring5webapp.controllers;

import gruru.springframework.spring5webapp.respositories.AuthorRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRespository authorRespository;

    public AuthorController(AuthorRespository authorRespository) {
        this.authorRespository = authorRespository;
    }
    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRespository.findAll());

        return "authors/list";
    }

}
