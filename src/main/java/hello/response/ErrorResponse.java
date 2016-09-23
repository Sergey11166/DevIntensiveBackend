package hello.response;

/**
 * @author Sergey Vorobyev
 */

public class ErrorResponse extends AbsResponse {

    private String err;

    public ErrorResponse(boolean success) {
        super(success);
    }

    public ErrorResponse(String err) {
        super(false);
        this.err = err;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
