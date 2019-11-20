package edu.wctc.inclassam.controller;

import edu.wctc.inclassam.entity.Donut;
import edu.wctc.inclassam.service.DonutService;
import edu.wctc.inclassam.service.DonutShopService;
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

    @RequestMapping("/list")
    public String listDonuts(Model theModel) {
        List<Donut> theList = donutService.getDonuts();

        theModel.addAttribute("donuts", theList);

        return "am/list-donuts";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm,
                         Model theModel) {

        List<Donut> theList = donutService.getDonutsByName(theSearchTerm);

        theModel.addAttribute("donuts", theList);

        return "am/list-donuts";
    }

    @GetMapping("/delete")
    public String deleteDonut(@RequestParam("donutId") int theId){
        donutService.deleteDonut(theId);

        return "redirect:/donut/list";
    }

    @RequestMapping("/showUpdateDonutForm")
    public String showUpdateDonutForm(@RequestParam("donutId") int theId,
                                      Model theModel) {
        Donut existingDonut = donutService.getDonut(theId);

        theModel.addAttribute("aDonut", existingDonut);

        theModel.addAttribute("shops", donutShopService.getShops());

        return "am/add-donut-form";
    }

    @GetMapping("/showAddDonutForm")
    public String showAddDonutForm(Model theModel) {
        Donut plainDonut = new Donut();

        theModel.addAttribute("aDonut", plainDonut);

        theModel.addAttribute("shops", donutShopService.getShops());

        return "am/add-donut-form";
    }

    @PostMapping("/save")
    public String saveDonut(@RequestParam(name = "donutImage") MultipartFile file,
                            @Valid @ModelAttribute(name = "aDonut") Donut theDonut,
                            BindingResult bindingResult,
                            Model theModel,
                            HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);

            theModel.addAttribute("shops", donutShopService.getShops());

            return "am/add-donut-form";
        }

        donutService.saveDonut(theDonut, file, request.getServletContext().getRealPath("/"));

        return "redirect:/donut/list";
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, ste);
    }
}
