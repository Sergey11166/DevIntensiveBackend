package hello.domain;

import static hello.Constants.UPDATED;
import static hello.Constants.USED_ID;

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

    public static User createUser(String userPhoto, String avatar) {
        User user = new User();
        user.setId(USED_ID);
        user.setFirstName("Сергей");
        user.setSecondName("Воробьёв");
        user.setV(0);
        user.setSpecialization("Android");
        user.setRole("user");
        user.setUpdated(UPDATED);

        user.setRepositories(Repositories.createRepositories());
        user.setContacts(Contacts.createContacts());
        user.setProfileValues(ProfileValues.createProfileValues());
        user.setPublicInfo(PublicInfo.createPublicInfo(userPhoto, avatar));

        return user;
    }
}
