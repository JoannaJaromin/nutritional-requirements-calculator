package joanna.jaromin.requirements.calculator.repository;

import joanna.jaromin.requirements.calculator.entity.User;

public interface UserRepository extends MyJpaRepository<User,Integer> {
    User findByUsername(String username);
}
