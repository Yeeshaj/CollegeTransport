package com.example.dellpc.collegetransport;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;

public class update extends AppCompatActivity
{
    EditText etname, etid, etadd,etcontact;
    TextView txtrollno, txtname, txtemail;
    SqlManager sm;
    SQLiteDatabase sb;
    String name,address,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        sm = new SqlManager(this);
        sb = sm.openDB();
        etid = (EditText)findViewById(R.id.etid);


    }
    public void show(View v)
    {
        etname = (EditText) findViewById(R.id.etname);
        etadd = (EditText) findViewById(R.id.etadd);
        etcontact = (EditText) findViewById(R.id.etcontact);
        String id = etid.getText().toString();
        String[] args = {id};
        Cursor c = sb.query(SqlConstants.TBL_STUDENT_NAME, null, SqlConstants.COL_STUDENT_SID + "=?", args, null, null, null, null);
        if (c != null && c.moveToFirst()) {
            do {
                name = c.getString(c.getColumnIndex(SqlConstants.COL_STUDENT_NAME));
                etname.setText(name);
                address = c.getString(c.getColumnIndex(SqlConstants.COL_STUDENT_ADDRESS));
                etadd.setText(address);
                contact = c.getString(c.getColumnIndex(SqlConstants.COL_STUDENT_CONTACT_NO));
                etcontact.setText(contact);

            } while (c.moveToNext());
            c.close();
        }
       // Toast.makeText(this, +name, Toast.LENGTH_SHORT).show();
    }
    public void updaterecord(View v) {
        etname=(EditText)findViewById(R.id.etname);
        etadd=(EditText)findViewById(R.id.etadd);
        etcontact=(EditText)findViewById(R.id.etcontact);
        String id = etid.getText().toString();
        String name = etname.getText().toString();
        String address = etadd.getText().toString();
        String contact=etcontact.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(SqlConstants.COL_STUDENT_NAME, name);
        cv.put(SqlConstants.COL_STUDENT_ADDRESS, address);
        cv.put(SqlConstants.COL_STUDENT_CONTACT_NO,contact);
        String[] args = {id};
        Cursor c = sb.query(SqlConstants.TBL_STUDENT_NAME, null, SqlConstants.COL_STUDENT_SID + "=?", args, null, null, null, null);
        if (c != null && c.moveToFirst()) {
            int rw = sb.update(SqlConstants.TBL_STUDENT_NAME, cv, SqlConstants.COL_STUDENT_SID + " =?", args);
            if (rw > 0) {
                Toast.makeText(this, "DATA UPDATED", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "DATA NOT UPDATED", Toast.LENGTH_SHORT).show();
        }


    }
}






