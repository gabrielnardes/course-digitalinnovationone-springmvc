package gabrielnardes.springwebmvc.controller;

import gabrielnardes.springwebmvc.model.Jedi;
import gabrielnardes.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JediController {

    @Autowired
    private JediRepository repository;

    @GetMapping("/jedi")
    public ModelAndView jedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", repository.getAllJedi());

        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi() {
        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("new-jedi");
        modelAndView.addObject("jedi", new Jedi());

        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(@ModelAttribute Jedi jedi) {
        repository.add(jedi);

        return "redirect:jedi";
    }
}
