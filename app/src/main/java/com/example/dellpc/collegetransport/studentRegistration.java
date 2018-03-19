package com.example.dellpc.collegetransport;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;

import java.io.ByteArrayOutputStream;

public class studentRegistration extends AppCompatActivity {
    ImageView iv;
    EditText stdid, stdname, stdadd, stdcontact;
    SqlManager sm;
    SQLiteDatabase se;
    Bitmap bmp;
    Snackbar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        stdid = (EditText) findViewById(R.id.stdid);
        stdname = (EditText) findViewById(R.id.stdname);
        stdadd = (EditText) findViewById(R.id.stdadd);
        stdcontact = (EditText) findViewById(R.id.stdcontact);
        iv = (ImageView) findViewById(R.id.iv);
        sm = new SqlManager(this);
        se = sm.openDB();
    }

    public void click(View v) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b = data.getExtras();
        bmp = (Bitmap) b.get("data");
        iv.setImageBitmap(bmp);

    }

    public void submit(View v) {
        final String name = stdname.getText().toString();
        int did = Integer.parseInt(stdid.getText().toString());
        String add = stdadd.getText().toString();
        String contact = stdcontact.getText().toString();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] imgarr = bos.toByteArray();
        ContentValues cv = new ContentValues();
        cv.put(SqlConstants.COL_STUDENT_SID, did);
        cv.put(SqlConstants.COL_STUDENT_NAME, name);
        cv.put(SqlConstants.COL_STUDENT_ADDRESS, add);
        cv.put(SqlConstants.COL_STUDENT_CONTACT_NO, contact);
        cv.put(SqlConstants.COL_STUDENT_PHOTO, imgarr);
        long l = se.insert(SqlConstants.TBL_STUDENT_NAME, null, cv);
        if (l > 0)
        {
            Toast.makeText(this, "DATA IS INSERTED", Toast.LENGTH_SHORT).show();
        } else
            {
            sb = Snackbar.make(v, "Wrong Vales!", Snackbar.LENGTH_INDEFINITE);
            sb.setAction("Retry", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(studentRegistration.this, "Retry", Toast.LENGTH_SHORT).show();
                    stdid.setText("");
                    stdname.setText("");
                    stdadd.setText("");
                    stdcontact.setText("");
                }
            });
            sb.setActionTextColor(Color.GREEN);
            View v1 = sb.getView();
            TextView tv = (TextView) v1.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextColor(Color.RED);
            sb.show();
        }
    }
}