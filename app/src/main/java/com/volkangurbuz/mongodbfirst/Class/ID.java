package com.volkangurbuz.mongodbfirst.Class;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VolkanGurbuz on 2/22/2018.
 */

public class ID {
    @SerializedName("$oid")
    private String oid;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
