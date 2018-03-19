package com.example.dellpc.collegetransport;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;

import java.util.ArrayList;

public class BusAllotment extends AppCompatActivity {
    EditText etbusno, etsid, etyear, etreceiptno;
    int busno, tseats;
    SQLiteDatabase se;
    SqlManager sm;
    Bus b;
    ArrayList<Bus> buslis;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_allotment);
        sm = new SqlManager(this);
        se = sm.openDB();
        sp = (Spinner) findViewById(R.id.sp);
        buslis = new ArrayList<>();
        filllist();
        ArrayAdapter<Bus> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, buslis);
        sp.setAdapter(ad);
        //  etbusno=(EditText)findViewById(R.id.etbusno);
        etsid = (EditText) findViewById(R.id.etsid);
        etyear = (EditText) findViewById(R.id.etyear);
        etreceiptno = (EditText) findViewById(R.id.etreceiptno);
    }

    public void filllist() {
        Cursor c = se.query(SqlConstants.TBL_BUS_NAME, null, null, null, null, null, null);
        if (c != null && c.moveToFirst()) {
            do {
                b = new Bus();
                int busno = c.getInt(c.getColumnIndex(SqlConstants.COL_BUS_BUSNO));
                int tseat=c.getInt(c.getColumnIndex(SqlConstants.COL_BUS_TOTAL_SEAT));
                int aseat=c.getInt(c.getColumnIndex(SqlConstants.COL_BUS_AVAILAVBLE_SEAT));
                b.setBusno(busno);
                b.setAseat(aseat);
                b.setTseat(tseat);
                buslis.add(b);
            } while (c.moveToNext());
            c.close();
        }
    }

    public void submit(View v)
    {
        Cursor sq = se.query(SqlConstants.TBL_BUS_NAME, null, null, null, null, null, null, null);
        if (sq != null && sq.moveToFirst())
        {


            busno = Integer.parseInt(etbusno.getText().toString());
            int sid = Integer.parseInt(etsid.getText().toString());
            int year = Integer.parseInt(etyear.getText().toString());
            int receiptno = Integer.parseInt(etreceiptno.getText().toString());
            ContentValues cv = new ContentValues();
            cv.put(SqlConstants.COL_BUS_ALLOTMENT_BUS_NO, busno);
            cv.put(SqlConstants.COL_BUS_ALLOTMENT_SID, sid);
            cv.put(SqlConstants.COL_BUS_ALLOTMENT_YEAR, year);
            cv.put(SqlConstants.COL_BUS_ALLOTMENT_RECEIPT_NO, receiptno);
            long l = se.insert(SqlConstants.TBL_BUS_ALLOTMENT_NAME, null, cv);
            if (l > 0)
            {
                Toast.makeText(this, "Bus Allotted", Toast.LENGTH_SHORT).show();
            } else
                {
                Toast.makeText(this, "Invalid values", Toast.LENGTH_SHORT).show();
            }
            String[] arg = {String.valueOf(busno)};
            Cursor c = se.query(SqlConstants.TBL_BUS_NAME, null, SqlConstants.COL_BUS_BUSNO + "=?", arg, null, null, null);
            if (c != null && c.moveToFirst())
            {
                do
                {
                    tseats = c.getInt(c.getColumnIndex(SqlConstants.COL_BUS_AVAILAVBLE_SEAT));

                } while (c.moveToNext());
            }
            tseats = tseats - 1;
            ContentValues dv = new ContentValues();
            dv.put(SqlConstants.COL_BUS_AVAILAVBLE_SEAT, tseats);
            se.update(SqlConstants.COL_BUS_BUSNO, cv, SqlConstants.COL_BUS_BUSNO + "=?", arg);
        }
    }
}
