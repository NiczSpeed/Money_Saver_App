package pl.niczspeed.money_saver_app.money;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import pl.niczspeed.money_saver_app.model.money;
import pl.niczspeed.money_saver_app.repository.MoneyRepository;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class MoneyRepositoryTests {

    @Autowired
    private MoneyRepository moneyRepository;

    @Test
    public void testListAll(){
        List<money> moneyList = moneyRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
        moneyList.forEach(System.out::println);
    }

    @Test
    public void getMoneySumExpenditureTest(){
        float expenditureMoney = moneyRepository.getMoneySumExpenditure();
        System.out.println(expenditureMoney);
    }

    @Test
    public void getMoneySumProfitTest(){
        Float profitMoney = moneyRepository.getMoneySumProfit();
        System.out.println(profitMoney);
    }




}
