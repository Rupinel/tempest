package kr.howmuch.tempest.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
@EnableAutoConfiguration
public class HomeController {

    @GetMapping("/")
    public ModelAndView Welcome() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}