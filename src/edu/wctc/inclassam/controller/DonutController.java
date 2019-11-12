package edu.wctc.inclassam.controller;

import edu.wctc.inclassam.dao.DonutDAO;
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

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donut")
public class DonutController {
    // Inject the Donut service bean
    @Autowired
    private DonutService donutService;

    // Inject the Donut Shop service
    @Autowired
    private DonutShopService donutShopService;

    @RequestMapping("/list")
    public String listDonuts(Model theModel) {
        // Get Donuts from service
        List<Donut> donutList = donutService.getDonuts();

        // Add the list of donuts to the model
        theModel.addAttribute("donuts", donutList);

        // Return the name of the view
        return "list-donuts";
    }

    @GetMapping("/showAddDonutForm")
    public String showAddDonutForm(Model theModel) {
        Donut theDonut = new Donut();

        theModel.addAttribute("donut", theDonut);

        theModel.addAttribute("donutShops", donutShopService.getDonutShops());

        return "add-donut-form";
    }

    @PostMapping("/save")
    public String saveDonut(@Valid @ModelAttribute("donut") Donut theDonut,
                            BindingResult bindingResult,
                            Model theModel) {
        if (bindingResult.hasErrors()) {
            theModel.addAttribute("donutShops", donutShopService.getDonutShops());
            return "add-donut-form";
        }
        donutService.saveDonut(theDonut);
        return "redirect:/donut/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // Trim whitespace from all string form parameters read by this controller
        // If the entire string is whitespace, trim it to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
