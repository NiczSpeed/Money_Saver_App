package pl.niczspeed.money_saver_app.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.niczspeed.money_saver_app.model.money;
import pl.niczspeed.money_saver_app.repository.UserRepository;
import pl.niczspeed.money_saver_app.service.MoneyService;

import java.util.List;

@Controller
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    @RequestMapping("/")
    public String indexPage() {
        return "moneyAdd";
    }


    @PostMapping("/saveFile")
    public String saveData(money userData) {
        moneyService.save(userData);
        return "moneyAdd";
    }

    @GetMapping("/list")
    public String listPage(Model model){
        List<money> moneyList = moneyService.listAll();
        model.addAttribute("moneyList", moneyList);
        System.out.println("Get / ");
        return "listPage";
    }
}
