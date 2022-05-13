package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Users {

    private final List<User> users;

    public Users(int size) {
        List<User> temp = new ArrayList<>();
        IntStream.range(0, size).
                mapToObj(i -> new User()).
                forEach(temp::add);
        users = Collections.unmodifiableList(temp);
    }

    public List<User> getUserList() {
        return users;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public void usersGo() {
        IntStream.range(0, users.size()).
                mapToObj(i -> getUser(i)).
                forEach(User::go);
    }
}
