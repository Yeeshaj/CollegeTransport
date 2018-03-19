package com.example.dellpc.collegetransport;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;

public class delete extends AppCompatActivity {
EditText student;
    String bus,sid;
    SQLiteDatabase se;
    SqlManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        sm=new SqlManager(this);
        se=sm.openDB();
        student=(EditText)findViewById(R.id.stud);

    }
    public void delete(View v)
    {
        AlertDialog.Builder adb= new AlertDialog.Builder(this);
        adb.setTitle("Delete");
        adb.setMessage("Are you sure you want to delete");
        adb.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String studid=student.getText().toString();
                String [] arg2={studid};
                int r3=se.delete(SqlConstants.TBL_STUDENT_NAME,SqlConstants.COL_STUDENT_SID+"=?",arg2);
                int r4=se.delete(SqlConstants.TBL_BUS_ALLOTMENT_NAME,SqlConstants.COL_BUS_ALLOTMENT_SID+"=?",arg2);
                if(r3>0)
                {
                    Toast.makeText(delete.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        adb.setNegativeButton("NO",null);
        adb.setNeutralButton("Cancel",null);
        AlertDialog ad=adb.create();
        ad.show();
    }
}
