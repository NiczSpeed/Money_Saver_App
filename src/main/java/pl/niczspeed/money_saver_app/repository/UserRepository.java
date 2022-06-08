package pl.niczspeed.money_saver_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niczspeed.money_saver_app.model.money;


@Repository
public interface UserRepository extends JpaRepository<money, Integer> {


}
