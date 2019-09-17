package example.fw.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import example.application.queryservices.users.UserQueryService;
import example.domain.values.user.TheaterUsername;

@Service
public class MyUserDetailsService implements UserDetailsService {

    UserQueryService userQueryService;

    public MyUserDetailsService(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userQueryService
                .queryByName(new TheaterUsername(username))
                .map(SecurityAuthentication::new)
                .orElseThrow(()->new UsernameNotFoundException("ユーザーが見つかりません"));
    }
}
