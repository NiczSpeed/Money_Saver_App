package pl.niczspeed.money_saver_app.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.niczspeed.money_saver_app.model.money;
import pl.niczspeed.money_saver_app.repository.UserRepository;

@Controller
public class MoneyController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String indexPage() {
        return "moneyAdd";
    }



    @RequestMapping("/saveFile")
    @ResponseBody
    public String saveData(money userData) {
        userRepository.save(userData);
        return indexPage();
    }
}
