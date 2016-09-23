package hello.response;

/**
 * @author Sergey Vorobyev
 */

@SuppressWarnings("unused")
public class ErrorResponse extends AbsResponse {

    private String err;

    public ErrorResponse() {
        super(false);
    }

    public ErrorResponse(String err) {
        this();
        this.err = err;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
