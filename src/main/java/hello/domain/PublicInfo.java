package hello.domain;

import hello.Constants;

import static hello.Constants.AVATAR_PATH;
import static hello.Constants.UPDATED;
import static hello.Constants.USER_PHOTO_PATH;

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

    public static PublicInfo createPublicInfo(String userPhoto, String avatar) {
        PublicInfo info = new PublicInfo();
        info.setBio(Constants.LOREM_IPSUM);
        info.setAvatar(AVATAR_PATH + avatar);
        info.setPhoto(USER_PHOTO_PATH + userPhoto);
        info.setUpdated(UPDATED);
        return info;
    }
}
