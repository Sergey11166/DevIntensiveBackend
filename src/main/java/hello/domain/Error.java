package hello.domain;

/**
 * @author Sergey Vorobyev
 */

public class Error extends AbsEntity {

    private String err;

    public Error(String err) {
        this.err = err;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
