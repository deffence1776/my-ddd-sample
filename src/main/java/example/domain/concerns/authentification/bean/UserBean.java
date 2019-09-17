package example.domain.concerns.authentification.bean;

import example.domain.values.user.TheaterUsername;

public class UserBean {
    TheaterUsername theaterUsername;
    String password;

    public UserBean(TheaterUsername theaterUsername, String password) {
        this.theaterUsername = theaterUsername;
        this.password = password;
    }

    public TheaterUsername getTheaterUsername() {
        return theaterUsername;
    }

    public String getPassword() {
        return password;
    }
}
