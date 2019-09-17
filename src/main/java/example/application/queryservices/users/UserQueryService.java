package example.application.queryservices.users;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import example.domain.concerns.authentification.bean.UserBean;
import example.domain.values.user.TheaterUsername;

import java.util.Optional;

@Service
public class UserQueryService {

    PasswordEncoder passwordEncoder;

    public UserQueryService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public Optional<UserBean> queryByName(TheaterUsername username) {
        if (username.isEquals(new TheaterUsername("user"))) {
            return Optional.of(new UserBean(new TheaterUsername("user"),
                    passwordEncoder.encode("password")));
        }

        return Optional.empty();
    }
}
