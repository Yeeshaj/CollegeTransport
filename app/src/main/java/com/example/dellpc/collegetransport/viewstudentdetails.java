package com.example.dellpc.collegetransport;

/**
 * Created by DELL PC on 23-07-2017.
 */

public class viewstudentdetails
{
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
    public viewstudentdetails(String name,byte[] id)
    {
        this.name=name;
        this.id=id;
    }
public viewstudentdetails()
{

}
}
