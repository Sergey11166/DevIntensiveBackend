package hello.response;

import hello.domain.ImageData;

/**
 * @author Sergey Vorobyev.
 */

public class ImageUploadedResponse extends AbsResponse {

    private ImageData data;

    public ImageUploadedResponse(boolean success, ImageData data) {
        super(success);
        this.data = data;
    }

    public ImageData getData() {
        return data;
    }

    public void setData(ImageData data) {
        this.data = data;
    }
}
