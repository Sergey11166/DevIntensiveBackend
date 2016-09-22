package hello.domain;

@SuppressWarnings("unused")
public class PublicInfo {

    private String bio;

    private String avatar;

    private String photo;

    private String updated;

    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUpdated() {
        return updated;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public static PublicInfo createPublicInfo() {
        PublicInfo info = new PublicInfo();
        info.setBio("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        info.setAvatar("https://www.tm-town.com/assets/default_male600x600-79218392a28f78af249216e097aaf683.png");
        info.setUpdated("2016-06-17T14:57:33.423Z");
        return info;
    }
}
