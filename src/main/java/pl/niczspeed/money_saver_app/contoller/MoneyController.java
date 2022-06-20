package pl.niczspeed.money_saver_app.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.niczspeed.money_saver_app.model.money;
import pl.niczspeed.money_saver_app.service.MoneyService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    @RequestMapping("/")
    public String indexPage(Model model) {
        Float expenditureValue = moneyService.expenditure();
        Float profitValue = moneyService.profit();
        model.addAttribute("expenditureValue", expenditureValue);
        model.addAttribute("profitValue", profitValue);
        return "moneyAdd";
    }


    @PostMapping("/saveFile")
    public String saveData(money userData, Model model) {
        moneyService.save(userData);
        Float expenditureValue = moneyService.expenditure();
        Float profitValue = moneyService.profit();
        model.addAttribute("expenditureValue", expenditureValue);
        model.addAttribute("profitValue", profitValue);
        return "moneyAdd";
    }

    @GetMapping("/list")
    public String listPage(Model model){
        List<money> moneyList = moneyService.listAll();
        model.addAttribute("moneyList", moneyList);
        return "listPage";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMoney(@PathVariable(name = "id") int id){
        moneyService.delete(id);
        return "redirect:/";
    }



}
