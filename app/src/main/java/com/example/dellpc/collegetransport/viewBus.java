package com.example.dellpc.collegetransport;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;

import java.util.ArrayList;

public class viewBus extends AppCompatActivity implements AdapterView.OnItemClickListener
{
ListView ll;
    SqlManager sm;
    SQLiteDatabase se;
    ArrayList<Bus> buslist;
    int tseat,aseat;
    Bus bus;
    int busno,busnum;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bus);
        ll=(ListView)findViewById(R.id.ll);
        ll.setOnItemClickListener(this);
        sm=new SqlManager(this);
        se=sm.openDB();
        buslist=new ArrayList<>();
        filllist();
        ArrayAdapter<Bus> ad=new ArrayAdapter<Bus>(this,android.R.layout.simple_list_item_1,buslist);
        ll.setAdapter(ad);
        ll.setOnItemClickListener(this);
    }
    public void filllist()
    {
        Cursor c=se.query(SqlConstants.TBL_BUS_ALLOTMENT_NAME,null,null,null,null,null,null);
        //Cursor cd=se.query(SqlConstants.TBL_BUS_NAME,null,null,null,null,null,null);
        if(c!=null&c.moveToFirst())
        {
            do {
                 busno=c.getInt(c.getColumnIndex(SqlConstants.COL_BUS_ALLOTMENT_BUS_NO));
                /*int sid=c.getColumnIndex(SqlConstants.COL_BUS_ALLOTMENT_SID);
                int year=c.getColumnIndex(SqlConstants.COL_BUS_ALLOTMENT_YEAR);
                int receiptno=c.getColumnIndex(SqlConstants.COL_BUS_ALLOTMENT_RECEIPT_NO);*/
                /*tseat=cd.getInt(cd.getColumnIndex(SqlConstants.COL_BUS_TOTAL_SEAT));
                aseat=cd.getInt(cd.getColumnIndex(SqlConstants.COL_BUS_AVAILAVBLE_SEAT));
                */bus=new Bus();
                bus.setBusno(busno);
                //bus.setTseat(tseat);
                //bus.setAseat(aseat);
                buslist.add(bus);
              }while(c.moveToNext());
        }
        c.close();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
Bus B=buslist.get(position);
        busnum=B.getBusno();

       Toast.makeText(this, busnum+"", Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, busnum, Toast.LENGTH_SHORT).show();
       Intent x=new Intent(this,viewStudent.class);
       x.putExtra("busnum",busnum);

        startActivity(x);
    }
}
