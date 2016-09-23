package hello.domain;

import hello.Constants;

import static hello.Constants.*;

/**
 * @author Sergey Vorobyev.
 */

public class ImageData {

    private String photo;
    private String updated;

    public ImageData() {
    }

    public ImageData(String photo, String updated) {
        this.photo = photo;
        this.updated = updated;
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

    public static ImageData createImageDataProfilePhoto() {
        ImageData data = new ImageData();
        data.setPhoto(USER_PHOTO_PATH);
        data.setUpdated(UPDATED);
        return data;
    }

    public static ImageData createImageDataAvatar() {
        ImageData data = new ImageData();
        data.setPhoto(AVATAR_PATH);
        data.setUpdated(UPDATED);
        return data;
    }
}
