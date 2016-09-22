package hello.response;

import hello.domain.AbsEntity;
import hello.domain.Data;

/**
 * @author Sergey Vorobyev.
 */

@SuppressWarnings("unused")
public class UserModelResponse extends AbsEntity {

    private boolean success;

    private Data data;

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }

    public static UserModelResponse createUserModelResponse() {
        UserModelResponse response = new UserModelResponse();
        response.setSuccess(true);
        response.setData(Data.createData());
        return response;
    }
}
