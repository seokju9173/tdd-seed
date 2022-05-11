package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {

    private final List<User> users;

    public Users(int size) {
        List<User> temp = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            temp.add(new User());
        }
        users = Collections.unmodifiableList(temp);
    }

    public List<User> getUserList() {
        return users;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public void usersGo() {
        for(int i = 0; i < users.size(); i++) {
            getUser(i).go();
        }
    }
}
