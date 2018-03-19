package com.example.dellpc.collegetransport;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;
import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;

import java.util.ArrayList;

public class ViewDriverDetailsMainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView ll;
    String no;
    ArrayList<ViewDriverDetails>drlist;
    ViewDriverDetails dr;
    SqlManager sm;
    SQLiteDatabase se;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_driver_details_main);
        ll=(ListView)findViewById(R.id.ll);
        sm=new SqlManager(this);
        se=sm.openDB();
        drlist=new ArrayList<>();
        filllist();
        MyAdapterDriver ad=new MyAdapterDriver(this,drlist);
        ll.setAdapter(ad);
        ll.setOnItemClickListener(this);


    }
  public void filllist()
  {
      Cursor c=se.query(SqlConstants.TBL_DRIVER_NAME,null,null,null,null,null,null);
      if (c!=null&&c.moveToFirst())
      {
         do {
             String name = c.getString(c.getColumnIndex(SqlConstants.COL_DRIVER_NAME));
             byte[] id = c.getBlob(c.getColumnIndex(SqlConstants.COL_DRIVER_PHOTO));
             dr = new ViewDriverDetails();
             dr.setName(name);
             dr.setId(id);
             drlist.add(dr);
         }while(c.moveToNext());
                  c.close();
  }
  }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ViewDriverDetails v=drlist.get(position);
        String name=v.getName();
        String [] arg={name};
        Cursor c=se.query(SqlConstants.TBL_DRIVER_NAME,null,SqlConstants.COL_DRIVER_NAME+"=?",arg,null,null,null,null);
        if(c!=null&&c.moveToFirst())
        {
            do {


             no=c.getString(c.getColumnIndex(SqlConstants.COL_STUDENT_CONTACT_NO));
            }while(c.moveToNext());
        }
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Contact");
        adb.setMessage("Choose Your Action");
        adb.setIcon(R.mipmap.ic_launcher);
        adb.setPositiveButton("Call", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" +no ));
                if (ActivityCompat.checkSelfPermission(ViewDriverDetailsMainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(i);
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }
}
