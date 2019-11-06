package edu.wctc.inclassam;

import edu.wctc.inclassam.dao.DonutDAO;
import edu.wctc.inclassam.entity.Donut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/donut")
public class DonutController {
    // Inject the Donut DAO bean
    @Autowired
    private DonutDAO donutDAO;

    @RequestMapping("/list")
    public String listDonuts(Model theModel) {
        // Get Donuts from DAO
        List<Donut> donutList = donutDAO.getDonuts();

        // Add the list of donuts to the model
        theModel.addAttribute("donuts", donutList);

        // Return the name of the view
        return "list-donuts";
    }
}
