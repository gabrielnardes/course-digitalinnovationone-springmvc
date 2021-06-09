package gabrielnardes.springwebmvc.controller;

import gabrielnardes.springwebmvc.model.Jedi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JediController {

    @GetMapping("/jedi")
    public ModelAndView jedi() {
        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("jedi");
        modelAndView.addObject("allJedi", new Jedi("Luke", "Skywalker"));

        return modelAndView;
    }
}
