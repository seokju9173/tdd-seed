package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Users {

    final static List<User> userList = new ArrayList<>();

    public Users(int size) {
        for(int i = 0; i < size; i++) {
            userList.add(new User());
        }
    }

    public List<User> getUserList() {
        return new ArrayList<>(userList);
    }

    public User getUser(int index) {
        return userList.get(index);
    }
}
