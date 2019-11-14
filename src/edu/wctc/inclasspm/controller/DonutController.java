package edu.wctc.inclasspm.controller;

import edu.wctc.inclasspm.entity.Donut;
import edu.wctc.inclasspm.service.DonutService;
import edu.wctc.inclasspm.service.DonutShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String saveDonut(@ModelAttribute(name="donut") Donut theDonut) {
        donutService.saveDonut(theDonut);

        return "redirect:/donut/list";
    }

}
