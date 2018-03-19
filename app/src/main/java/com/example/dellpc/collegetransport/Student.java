package com.example.dellpc.collegetransport;

/**
 * Created by DELL PC on 21-07-2017.
 */

public class Student
{
///    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
   /* String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
*/
    String contactno;
    public String toString()
    {
        return "id"+id;
    }


}
