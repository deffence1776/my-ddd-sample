package example.fw.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import example.domain.concerns.authentification.bean.UserBean;

import java.util.List;

/**
 * Spring Secury用の認証情報
 */
public class SecurityAuthentication extends org.springframework.security.core.userdetails.User implements UserDetails {

    UserBean userBean;

    public SecurityAuthentication(UserBean userBean) {
        super(userBean.getTheaterUsername().toString(),
                userBean.getPassword(),
                List.of(new SimpleGrantedAuthority("USER")));
        this.userBean = userBean;
    }

    /**
     * Viewでプロパティアクセスする為にgetterとして定義
     *
     * @return
     */
    public UserBean getUserBean() {
        return userBean;
    }

}
