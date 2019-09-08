package joanna.jaromin.requirements.calculator.service;

import joanna.jaromin.requirements.calculator.dto.UserConverter;
import joanna.jaromin.requirements.calculator.dto.UserDto;
import joanna.jaromin.requirements.calculator.entity.User;
import joanna.jaromin.requirements.calculator.exception.RecordNotFoundException;
import joanna.jaromin.requirements.calculator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return Optional.ofNullable(user)
                .map(MyUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("Brak użytkownika o nazwie: " + username));
    }

    public UserDto findById(int userId) {
        return userRepository.findById(userId)
                .map(user -> userConverter.map(user, UserDto.class) )
                .orElseThrow(() -> new RecordNotFoundException("Nie znaleziono użytkownika o id: " + userId));
    }

    @RequiredArgsConstructor
    private static class MyUserDetails implements UserDetails {

        private final User user;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            String authority = user.getAuthority();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
            return Arrays.asList(grantedAuthority);
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }


}
