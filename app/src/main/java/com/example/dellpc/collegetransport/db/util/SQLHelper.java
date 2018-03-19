package com.example.dellpc.collegetransport.db.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by DELL PC on 02-07-2017.
 */

public class SQLHelper extends SQLiteOpenHelper
{
    Context context;

    public SQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        this.context=context;
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
       sqLiteDatabase.execSQL(SqlConstants.CREATE_BUS_QUERY);
        Toast.makeText(context, "Table Created", Toast.LENGTH_LONG).show();
        sqLiteDatabase.execSQL(SqlConstants.CREATE_STUDENT_QUERY);
        Toast.makeText(context, "Table Created", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.execSQL(SqlConstants.CREATE_BUS_ALLOTMENT_QUERY);
        Toast.makeText(context, "Table Created", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.execSQL(SqlConstants.CREATE_DRIVER_QUERY);
        Toast.makeText(context, "Table Created", Toast.LENGTH_SHORT).show();
  }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

        /*sqLiteDatabase.execSQL(SqlConstants.CREATE_BUS_QUERY);
        Toast.makeText(context, "Table Created", Toast.LENGTH_LONG).show();
        sqLiteDatabase.execSQL(SqlConstants.CREATE_STUDENT_QUERY);
        Toast.makeText(context, "Table Created", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.execSQL(SqlConstants.CREATE_BUS_ALLOTMENT_QUERY);
        Toast.makeText(context, "Table Created", Toast.LENGTH_SHORT).show();*/

    }
}
