package com.example.dellpc.collegetransport;

/**
 * Created by hp on 24-07-2017.
 */

public class ViewDriverDetails {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getId() {
        return id;
    }

    public void setId(byte[] id) {
        this.id = id;
    }

    String name;
    byte[] id;
    public ViewDriverDetails(String name ,byte[] id)
    {
        this.name=name;
        this.id=id;
    }
    public ViewDriverDetails()
    {}
}
