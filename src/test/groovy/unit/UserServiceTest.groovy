package unit

import joanna.jaromin.requirements.calculator.entity.User
import joanna.jaromin.requirements.calculator.entity.UserData
import joanna.jaromin.requirements.calculator.repository.UserRepository
import joanna.jaromin.requirements.calculator.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import spock.lang.Specification

class UserServiceTest extends Specification {

    private User user
    private String USERNAME = "Best User"
    private String INCORRECT_USERNAME = "Bad User"
    private String PASSWORD = "SecretPassword"
    private String USER_ROLE = "ROLE_USER"
    private UserService userService
    private UserRepository userRepository
    private UserData userData

    def setup(){
        userRepository = Mock()
        userData = Mock()
        userService = new UserService(userRepository)
    }

    def "UserService should return UserDetails based on username"() {
        given:
        user = new User(
                username: USERNAME,
                password: PASSWORD,
                authority: USER_ROLE
        )
        userRepository.findByUsername(USERNAME) >> user

        when:
        UserDetails userFromService = userService.loadUserByUsername(USERNAME)

        then:
        userFromService.username == user.username
        userFromService.password == user.password
        userFromService.authorities.collect {it.authority} == [user.authority]
        userFromService.accountNonExpired
        userFromService.accountNonLocked
        userFromService.credentialsNonExpired
        userFromService.enabled
    }

    def "UserService should throw exception when user doesn't exist"() {
        when:
        userService.loadUserByUsername(INCORRECT_USERNAME)

        then:
        UsernameNotFoundException exception = thrown()
        exception.message == 'Brak użytkownika o nazwie: ' + INCORRECT_USERNAME
    }
}
