package com.example.dellpc.collegetransport.db.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by DELL PC on 02-07-2017.
 */

public class SqlManager
{
    Context context;
    SQLHelper sqlhelper;
    SQLiteDatabase sb;
    public SqlManager(Context context)
    {
        this.context=context;
      sqlhelper = new SQLHelper(context,SqlConstants.DB_NAME,null,SqlConstants.DB_VERSION);

    }
    public SQLiteDatabase openDB()
    {
        sb= sqlhelper.getWritableDatabase();
        return  sb;
    }



    public  void closeDB()
    {
        sqlhelper.close();
    }






}
