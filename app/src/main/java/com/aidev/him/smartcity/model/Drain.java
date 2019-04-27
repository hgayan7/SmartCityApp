package com.aidev.him.smartcity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Drain {

    @SerializedName("clogging")
    @Expose
    private Boolean clogging;
    @SerializedName("gas")
    @Expose
    private Boolean gas;
    @SerializedName("id")
    @Expose
    private Integer id;

    public Boolean getClogging() {
        return clogging;
    }

    public void setClogging(Boolean clogging) {
        this.clogging = clogging;
    }

    public Boolean getGas() {
        return gas;
    }

    public void setGas(Boolean gas) {
        this.gas = gas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}