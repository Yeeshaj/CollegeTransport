package com.example.dellpc.collegetransport;

/**
 * Created by DELL PC on 18-07-2017.
 */

public class Bus
{
    public int busno;
    int tseat;

    public int getTseat() {
        return tseat;
    }

    public void setTseat(int tseat) {
        this.tseat = tseat;
    }

    public int getAseat() {
        return aseat;
    }

    public void setAseat(int aseat) {
        this.aseat = aseat;
    }

    int aseat;
    //int sid;

    public int getBusno()
    {
        return busno;
    }

    public void setBusno(int busno)
    {
        this.busno = busno;
    }

   /* public int getSid()
    {
        return sid;
    }

    public void setSid(int sid)
    {
        this.sid = sid;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getReceiptno()
    {
        return receiptno;
    }

    public void setReceiptno(int receiptno)
    {
        this.receiptno = receiptno;
    }

   // int year;
   // int receiptno;*/
    public String toString()
    {
        return "Bus No= "+busno+" Toatal seat=" +tseat+" Available seat="+aseat+" ";
    }

}
