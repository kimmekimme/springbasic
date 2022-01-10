package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "kimme!!");
        return "hello"; // templates/hello.html (thymeleaf 템플릿 엔진 처리)
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template"; // templates/hello.html (thymeleaf 템플릿 엔진 처리)

    }

}
