package hello.response;

/**
 * @author Sergey Vorobyev
 */

public abstract class AbsResponse {

    private boolean success;

    public AbsResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
