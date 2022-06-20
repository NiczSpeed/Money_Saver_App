package pl.niczspeed.money_saver_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.niczspeed.money_saver_app.model.money;
import pl.niczspeed.money_saver_app.repository.MoneyRepository;

import java.util.List;
@Service
public class MoneyService {

    @Autowired
    private MoneyRepository moneyRepository;


    public List<money> listAll(){
        return moneyRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    public money get (int id){
        return moneyRepository.findById(id).get();
    }

    public void delete(int id){
        moneyRepository.deleteById(id);
    }

    public void save(money std){
        moneyRepository.save(std);
    }

    public float expenditure(){
       return moneyRepository.getMoneySumExpenditure();
    }

    public float profit(){
        return moneyRepository.getMoneySumProfit();
    }

}
