package hello.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import groovy.lang.IntRange;

/**
 * @author Sergey Vorobyev.
 */

@SuppressWarnings("unused")
public class UserListData {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static UserListData createUserListData(String userPhoto, String avatar) {
        UserListData data = new UserListData();

        data.setUsers(IntStream
                .rangeClosed(1, 10)
                .mapToObj(index -> User.createUser(userPhoto, avatar))
                .collect(Collectors.toList()));

        return data;
    }
}
