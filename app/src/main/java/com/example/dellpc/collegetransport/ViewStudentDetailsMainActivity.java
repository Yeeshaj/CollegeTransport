package com.example.dellpc.collegetransport;

import android.Manifest;
import android.app.PendingIntent;
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
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;

import java.util.ArrayList;

import static android.R.string.no;

public class ViewStudentDetailsMainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
        {
            String no;
    SqlManager sm;
            SQLiteDatabase se;
            ListView ll;
            ArrayList<viewstudentdetails> stlist;
            viewstudentdetails st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_details_main);
        ll = (ListView) findViewById(R.id.ll);
        sm = new SqlManager(this);
        se = sm.openDB();
        stlist=new ArrayList<>();
        fillist();
         MyAdapter ad = new MyAdapter(this,stlist);

           ll.setAdapter(ad);
           ll.setOnItemClickListener(this);

    }
  public  void fillist()
  {
      Cursor c=se.query(SqlConstants.TBL_STUDENT_NAME,null,null,null,null,null,null);
      if(c!=null&&c.moveToFirst())
      {
          do {


              String name = c.getString(c.getColumnIndex(SqlConstants.COL_STUDENT_NAME));
              byte[] id=c.getBlob(c.getColumnIndex(SqlConstants.COL_STUDENT_PHOTO));
              // int id1=Integer.parseInt(id.toString());
              st = new viewstudentdetails();
              st.setName(name);
              st.setId(id);
              stlist.add(st);
          }while(c.moveToNext());
          c.close();
      }
  }
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

               // String name=stlist.get(i);
                viewstudentdetails v=stlist.get(i);
                String name=v.getName();
                String [] arg={name};
                Cursor c=se.query(SqlConstants.TBL_STUDENT_NAME,null,SqlConstants.COL_STUDENT_NAME+"=?",arg,null,null,null);
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
                    public void onClick(DialogInterface dialogInterface, int i)
                    {

                        Intent x = new Intent(Intent.ACTION_CALL);
                        x.setData(Uri.parse("tel:" + no));
                        if (ActivityCompat.checkSelfPermission(ViewStudentDetailsMainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        startActivity(x);

                    }
                });

                adb.setNegativeButton("Message", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        String message=" You Have Missed Your BUS";
                        Intent r=new Intent();
                        PendingIntent pi=PendingIntent.getActivity(ViewStudentDetailsMainActivity.this,1,r,PendingIntent.FLAG_ONE_SHOT);
                        SmsManager sm= SmsManager.getDefault();
                        sm.sendTextMessage(no,null,message,pi,null);
                        Toast.makeText(ViewStudentDetailsMainActivity.this, "Message Sent", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog ad=adb.create();
                ad.show();
            }
        }
