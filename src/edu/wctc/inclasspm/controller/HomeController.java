package edu.wctc.inclasspm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping("/errors")
    public String showErrorPage(HttpServletRequest request,
                                Model theModel) {
        int requestCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        String errorMsg;

        switch(requestCode) {
            case 400:
                errorMsg = "HTTP Error 400: Bad request";
                break;
            case 404:
                errorMsg = "HTTP Error 404: Resource not found";
                break;
            case 500:
                errorMsg = "HTTP Error 500: Internal server error";
                break;
            default:
                errorMsg = "Whoa! Something went really wrong";
        }

        theModel.addAttribute("errorMessage", errorMsg);

        return "pm/errors";
    }
}
