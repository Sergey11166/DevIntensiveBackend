package hello.domain;

import java.util.Random;

import static hello.Constants.FIRST_NAMES;
import static hello.Constants.SECOND_NAMES;
import static hello.Constants.UPDATED;
import static hello.domain.Contacts.*;
import static hello.domain.ProfileValues.*;
import static hello.domain.PublicInfo.*;
import static hello.domain.Repositories.createRepositories;

@SuppressWarnings("unused")
public class User {

    private String id;

    private String firstName;

    private String secondName;

    private int v;

    private Repositories repositories;

    private Contacts contacts;

    private ProfileValues profileValues;

    private PublicInfo publicInfo;

    private String specialization;

    private String role;

    private String updated;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getV() {
        return v;
    }
    public void setV(int v) {
        this.v = v;
    }

    public Repositories getRepositories() {
        return repositories;
    }
    public void setRepositories(Repositories repositories) {
        this.repositories = repositories;
    }

    public Contacts getContacts() {
        return contacts;
    }
    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public ProfileValues getProfileValues() {
        return profileValues;
    }
    public void setProfileValues(ProfileValues profileValues) {
        this.profileValues = profileValues;
    }

    public PublicInfo getPublicInfo() {
        return publicInfo;
    }
    public void setPublicInfo(PublicInfo publicInfo) {
        this.publicInfo = publicInfo;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getUpdated() {
        return updated;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public static User createUser(String id, String userPhoto, String avatar, Random random) {
        User user = new User();
        user.setId(id);
        user.setFirstName(FIRST_NAMES[random.nextInt(FIRST_NAMES.length)]);
        user.setSecondName(SECOND_NAMES[random.nextInt(SECOND_NAMES.length)]);
        user.setV(0);
        user.setSpecialization("Android");
        user.setRole("user");
        user.setUpdated(UPDATED);
        user.setContacts(createContacts());
        user.setProfileValues(createProfileValues());
        user.setPublicInfo(createPublicInfo(userPhoto, avatar));
        user.setRepositories(createRepositories(id));

        return user;
    }
}
