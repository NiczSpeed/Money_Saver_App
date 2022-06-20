package pl.niczspeed.money_saver_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.niczspeed.money_saver_app.model.money;




@Repository
public interface MoneyRepository extends JpaRepository<money, Integer> {

    @Query(value = "SELECT sum(price) FROM money where role=\"expenditure\" and date > (NOW() - INTERVAL 1 MONTH)", nativeQuery = true)
    public float getMoneySumExpenditure();

    @Query(value = "SELECT sum(price) FROM money where role=\"profit\" and date > (NOW() - INTERVAL 1 MONTH)", nativeQuery = true)
    public float getMoneySumProfit();
}
