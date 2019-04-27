package com.aidev.him.smartcity.model;




import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parking {

    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("id")
    @Expose
    private Integer id;

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}