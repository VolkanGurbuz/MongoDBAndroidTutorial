package com.volkangurbuz.mongodbfirst.Class;

/**
 * Created by VolkanGurbuz on 2/22/2018.
 */

public class User {

    private ID _id;
    private String user;

    public ID get_id() {
        return _id;
    }

    public void set_id(ID _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
