package hello.response;

import hello.domain.LikesData;

/**
 * @author Sergey Vorobyev
 */

@SuppressWarnings("unused")
public class LikeResponse extends AbsResponse {

    private LikesData data;

    public LikeResponse() {
        super(true);
    }

    public LikeResponse(LikesData data) {
        this();
        this.data = data;
    }

    public LikesData getData() {
        return data;
    }
    public void setData(LikesData data) {
        this.data = data;
    }
}
