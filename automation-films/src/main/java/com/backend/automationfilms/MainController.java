package com.backend.automationfilms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called FilmRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private FilmRepository filmRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewAward (@RequestParam String name,
    @RequestParam Integer year) {
      // @ResponseBody means the returned String is the response, not a view name
      // @RequestParam means it is a parameter from the GET or POST request

        // Example to see if spring runs and complies
        Award n = new Award();
        n.setName(name);
        n.setYear(year);
        filmRepository.save(n);
        return "Saved";
    } 

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Award> getAllAwards() {
      // This returns a JSON or XML with the users
        return filmRepository.findAll();
    }
}
