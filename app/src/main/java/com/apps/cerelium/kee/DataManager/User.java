package com.apps.cerelium.kee.DataManager;

import java.util.List;

/**
 * Created by Nikhil on 27-02-2016.
 */
public class User {

    protected String userName;
    protected List<HolderTypes> holderTypesList;

    public void setHolderTypesList(List<HolderTypes> holderTypesList) {
        this.holderTypesList = holderTypesList;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<HolderTypes> getHolderTypesList() {
        return holderTypesList;
    }

    public String getUserName() {
        return userName;
    }

}
