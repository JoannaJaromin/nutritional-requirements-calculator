package joanna.jaromin.requirements.calculator.repository;

import joanna.jaromin.requirements.calculator.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Integer> {
}
