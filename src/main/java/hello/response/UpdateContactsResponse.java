package hello.response;

import hello.domain.Contacts;

import static hello.domain.Contacts.createContacts;

/**
 * @author Sergey Vorobyev.
 */

@SuppressWarnings("unused")
public class UpdateContactsResponse extends AbsResponse {

    private Contacts data;

    public UpdateContactsResponse() {
        super(true);
    }

    public UpdateContactsResponse(Contacts data) {
        this();
        this.data = data;
    }

    public Contacts getData() {
        return data;
    }
    public void setData(Contacts data) {
        this.data = data;
    }

    public static UpdateContactsResponse createUpdateContactsResponse() {
        return new UpdateContactsResponse(createContacts());
    }
}
