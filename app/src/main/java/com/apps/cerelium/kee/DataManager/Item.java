package com.apps.cerelium.kee.DataManager;

/**
 * Created by Nikhil on 27-02-2016.
 */
public class Item {

    protected String key;

    protected String value;

    public void setValue(String value) {
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }


}
