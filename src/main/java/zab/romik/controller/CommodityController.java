package zab.romik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import zab.romik.entity.Commodity;
import zab.romik.service.CommodityService;

/**
 * Created by ROMIK on 24.05.2017.
 */
@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/commodity")
    public String Commodity(Model model){
        model.addAttribute("commodities",commodityService.findAll());
        model.addAttribute("commodity", new Commodity());
        return "commodity";
    }

    @PostMapping("/commodity")
    public String Commodity(@ModelAttribute Commodity commodity){
        commodityService.save(commodity);
        return "redirect:/commodity";
    }

    @GetMapping("/deleteCommodity/{id}")
    public String delete(@PathVariable long id){
        commodityService.delete(id);
        return "redirect:/commodity";
    }

    @GetMapping("/updateCommodity/{id}")
    public String update(@ModelAttribute Commodity commodity){
        commodityService.update(commodity);
        return "redirect:/commodity";
    }
}