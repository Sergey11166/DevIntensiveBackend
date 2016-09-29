package hello.domain;

import static hello.Constants.AVATAR_PATH;
import static hello.Constants.UPDATED;
import static hello.Constants.USER_PHOTO_PATH;

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

    public static ImageData createImageDataProfilePhoto(String fileName) {
        ImageData data = new ImageData();
        data.setPhoto(USER_PHOTO_PATH.concat(fileName));
        data.setUpdated(UPDATED);
        return data;
    }

    public static ImageData createImageDataAvatar(String fileName) {
        ImageData data = new ImageData();
        data.setPhoto(AVATAR_PATH.concat(fileName));
        data.setUpdated(UPDATED);
        return data;
    }
}
