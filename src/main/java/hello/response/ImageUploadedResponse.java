package hello.response;

import hello.domain.ImageData;

/**
 * @author Sergey Vorobyev.
 */

@SuppressWarnings("unused")
public class ImageUploadedResponse extends AbsResponse {

    private ImageData data;

    public ImageUploadedResponse() {
        super(true);
    }

    public ImageUploadedResponse(ImageData data) {
        this();
        this.data = data;
    }

    public ImageData getData() {
        return data;
    }

    public void setData(ImageData data) {
        this.data = data;
    }
}
