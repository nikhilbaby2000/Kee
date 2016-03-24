package com.apps.cerelium.kee.DataManager;

/**
 * Created by Nikhil on 27-02-2016.
 */
public class HolderTypes {

    protected String HolderTypeName;

    protected Holder[] allHolderObjects;

    public void setAllHolderObjects(Holder[] allHolderObjects) {
        this.allHolderObjects = allHolderObjects;
    }

    public void setHolderTypeName(String holderTypeName) {
        HolderTypeName = holderTypeName;
    }

    public Holder[] getAllHolderObjects() {
        return allHolderObjects;
    }

    public String getHolderTypeName() {
        return HolderTypeName;
    }

}
