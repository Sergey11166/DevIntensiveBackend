package hello.domain;

import static hello.Constants.CONTACT_EMAIL;
import static hello.Constants.CONTACT_PHONE;
import static hello.Constants.CONTACT_VK;
import static hello.Constants.UPDATED;

@SuppressWarnings("unused")
public class Contacts {

    private String vk;

    private String phone;

    private String email;

    private String updated;

    public String getVk() {
        return vk;
    }
    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUpdated() {
        return updated;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public static Contacts createContacts() {
        Contacts contacts = new Contacts();
        contacts.setPhone(CONTACT_PHONE);
        contacts.setEmail(CONTACT_EMAIL);
        contacts.setVk(CONTACT_VK);
        contacts.setUpdated(UPDATED);
        return contacts;
    }
}