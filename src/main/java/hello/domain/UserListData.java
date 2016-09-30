package hello.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static UserListData createUserListData(String userPhoto, String avatar, Random random) {
        UserListData data = new UserListData();

        data.setUsers(IntStream
                .rangeClosed(1, 10)
                .mapToObj(index -> User.createUser(userPhoto, avatar, random))
                .collect(Collectors.toList()));

        return data;
    }
}
