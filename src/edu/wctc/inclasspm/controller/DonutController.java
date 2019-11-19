package edu.wctc.inclasspm.controller;

import edu.wctc.inclasspm.entity.Donut;
import edu.wctc.inclasspm.service.DonutService;
import edu.wctc.inclasspm.service.DonutShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donut")
public class DonutController {
    @Autowired
    private DonutService donutService;

    @Autowired
    private DonutShopService donutShopService;

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm,
                         Model theModel) {
        List<Donut> list = donutService.getDonutsByName(theSearchTerm);

        theModel.addAttribute("donuts", list);

        return "pm/list-donuts";
    }

    @GetMapping("/delete")
    public String deleteDonut(@RequestParam("donutId") int theId) {
        donutService.deleteDonut(theId);

        return "redirect:/donut/list";
    }

    @RequestMapping("/showUpdateDonutForm")
    public String showUpdateDonutForm(@RequestParam("donutId") int theId,
                                      Model theModel) {
        Donut theDonut = donutService.getDonut(theId);

        theModel.addAttribute("aDonut", theDonut);

        theModel.addAttribute("shops", donutShopService.getDonutShops());

        return "pm/add-donut-form";
    }

    @RequestMapping("/list")
    public String listDonuts(Model theModel) {
        List<Donut> donutList = donutService.getDonuts();

        theModel.addAttribute("donuts", donutList);

        return "pm/list-donuts";
    }

    @GetMapping("/showAddDonutForm")
    public String showAddDonutForm(Model theModel) {
        Donut newDonut = new Donut();

        theModel.addAttribute("aDonut", newDonut);

        theModel.addAttribute("shops", donutShopService.getDonutShops());

        return "pm/add-donut-form";
    }

    @PostMapping("/save")
    public String saveDonut(@RequestParam(name = "donutImage") MultipartFile file,
                            @Valid @ModelAttribute(name = "aDonut") Donut theDonut,
                            BindingResult bindingResult,
                            Model theModel,
                            HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            theModel.addAttribute("shops", donutShopService.getDonutShops());
            return "pm/add-donut-form";
        }

        String applicationPath = request.getServletContext().getRealPath("/");

        donutService.saveDonut(theDonut, file, applicationPath);

        return "redirect:/donut/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, ste);
    }

}
