package pl.niczspeed.money_saver_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.niczspeed.money_saver_app.model.money;
import pl.niczspeed.money_saver_app.repository.UserRepository;

import java.util.List;
@Service
public class MoneyService {

    @Autowired
    private UserRepository userRepository;

    public List<money> listAll(){
        return userRepository.findAll();
    }

    public money get (int id){
        return userRepository.findById(id).get();
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }

    public void save(money std){
        userRepository.save(std);
    }

}
