package com.example.dellpc.collegetransport;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;

public class busRegistration extends AppCompatActivity {
    EditText busno,driverid,totalseats,availableseats,routeto,routefrom;
    String to,from;
    int id,no,tseat,aseat;
    SQLiteDatabase se;
    SqlManager sm;
    Snackbar sb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_registration);
        busno=(EditText)findViewById(R.id.busno);
        driverid=(EditText)findViewById(R.id.driverid);
        totalseats=(EditText)findViewById(R.id.totalseats);
        availableseats=(EditText)findViewById(R.id.availableseats);
        routeto=(EditText)findViewById(R.id.routeto);
        routefrom=(EditText)findViewById(R.id.routefrom);
        sm=new SqlManager(this);
        se=sm.openDB();
    }

    public  void submit(View v)
    {
        no=Integer.parseInt(busno.getText().toString());
        id=Integer.parseInt(driverid.getText().toString());
        tseat=Integer.parseInt(totalseats.getText().toString());
        aseat=Integer.parseInt(availableseats.getText().toString());
        to=routeto.getText().toString();
        from=routefrom.getText().toString();
        ContentValues cv=new ContentValues();
        cv.put(SqlConstants.COL_BUS_BUSNO,no);
        cv.put(SqlConstants.COL_BUS_DRIVERID,id);
        cv.put(SqlConstants.COL_BUS_TOTAL_SEAT,tseat);
        cv.put(SqlConstants.COL_BUS_AVAILAVBLE_SEAT,aseat);
        cv.put(SqlConstants.COL_BUS_ROUTE_TO,to);
        cv.put(SqlConstants.COL_BUS_ROUTE_FROM,from);
        long l=se.insert(SqlConstants.TBL_BUS_NAME,null,cv);
       if(l>0)
        {
            Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
        }
        else
        {
            sb= Snackbar.make(v,"Wrong Vales!",Snackbar.LENGTH_INDEFINITE);
            sb.setAction("Retry", new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(busRegistration.this, "Retry", Toast.LENGTH_SHORT).show();
                    busno.setText("");
                    driverid.setText("");
                    totalseats.setText("");
                    availableseats.setText("");
                    routefrom.setText("");
                    routeto.setText("");
                }
            });
            sb.setActionTextColor(Color.GREEN);
            View v1=sb.getView();
            TextView tv= (TextView)v1.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextColor(Color.RED);
            sb.show();
        }
    }
}

