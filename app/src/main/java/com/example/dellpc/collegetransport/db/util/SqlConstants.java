package com.example.dellpc.collegetransport.db.util;

/**
 * Created by DELL PC on 14-07-2017.
 */

public class SqlConstants
{
    public  static  final String DB_NAME="Transport";
    public  static  final int DB_VERSION=1;


    public  static  final String TBL_BUS_NAME="busdetails";
    public  static  final String COL_BUS_BUSNO="busno";
    public  static  final String COL_BUS_DRIVERID="driverid";
    public  static  final String COL_BUS_TOTAL_SEAT="totalseats";
    public  static  final String COL_BUS_AVAILAVBLE_SEAT="availableseats";
    public  static  final String COL_BUS_ROUTE_TO="routeto";
    public  static  final String COL_BUS_ROUTE_FROM="routefrom";

    public static final String CREATE_BUS_QUERY="create table "+TBL_BUS_NAME+"("+COL_BUS_BUSNO+" integer primary key,"+COL_BUS_DRIVERID+" integer,"+COL_BUS_TOTAL_SEAT+" integer,"+COL_BUS_AVAILAVBLE_SEAT+" integer,"+COL_BUS_ROUTE_TO+" text,"+COL_BUS_ROUTE_FROM+" text)";

    public  static  final String TBL_STUDENT_NAME="studentdetails";
    public  static  final String COL_STUDENT_SID="sid";
    public  static  final String COL_STUDENT_NAME="name";
    public  static  final String COL_STUDENT_ADDRESS="address";
    public  static  final String COL_STUDENT_CONTACT_NO="contactno";
    public  static  final String COL_STUDENT_PHOTO="photo";

    public static final String CREATE_STUDENT_QUERY="create table "+TBL_STUDENT_NAME+"("+COL_STUDENT_SID+" integer primary key,"+COL_STUDENT_NAME+" text,"+COL_STUDENT_ADDRESS+" text,"+COL_STUDENT_CONTACT_NO+" text,"+COL_STUDENT_PHOTO+" blob)";

    public  static  final String TBL_DRIVER_NAME="driverdetails";
    public  static  final String COL_DRIVER_SID="driverid";
    public  static  final String COL_DRIVER_NAME="name";
    public  static  final String COL_DRIVER_EMAIL="email";
    public  static  final String COL_DRIVER_CONTACT_NO="contactno";
    public  static  final String COL_DRIVER_ADDRESS="address";
    public  static  final String COL_DRIVER_PHOTO="photo";

    public static final String CREATE_DRIVER_QUERY="create table "+TBL_DRIVER_NAME+"("+COL_DRIVER_SID+" integer primary key,"+COL_DRIVER_NAME+" text,"+COL_DRIVER_EMAIL+" text,"+COL_DRIVER_CONTACT_NO+" text,"+COL_DRIVER_ADDRESS+" text,"+COL_DRIVER_PHOTO+" blob)";

    public  static  final String TBL_BUS_ALLOTMENT_NAME="busallotmentdetails";
    public  static  final String COL_BUS_ALLOTMENT_BUS_NO="busallotmentno";
    public  static  final  String COL_BUS_ALLOTMENT_SID="studentid";
    public  static  final String COL_BUS_ALLOTMENT_YEAR="year";
    public  static  final String COL_BUS_ALLOTMENT_RECEIPT_NO="receiptno";
    public  static  final String COL_BUS_ALLOTMENT_ALLOTMENT="busallotment";



           // COL_DRIVER_SID+" integer primary key ,"+COL_DRIVER_NAME+" text,"+COL_DRIVER_EMAIL+" text,"+COL_DRIVER_CONTACT_NO+"text,"+COL_DRIVER_ADDRESS+"text,"+COL_DRIVER_PHOTO+"blob"+TBL_BUS_ALLOTMENT_NAME+"("+COL_BUS_ALLOTMENT_BUS_NO+" integer primary key ,"+COL_BUS_ALLOTMENT_SID+" integer,"+COL_BUS_ALLOTMENT_YEAR+" integer,"+COL_BUS_ALLOTMENT_RECEIPT_NO+"text,"+COL_BUS_ALLOTMENT_ALLOTMENT+"integer autoincrement)";


     public static final String CREATE_BUS_ALLOTMENT_QUERY="create table "+TBL_BUS_ALLOTMENT_NAME+"("+COL_BUS_ALLOTMENT_BUS_NO+" integer primary key,"+COL_BUS_ALLOTMENT_SID+" integer,"+COL_BUS_ALLOTMENT_YEAR+" integer,"+COL_BUS_ALLOTMENT_RECEIPT_NO+" text)";






}
