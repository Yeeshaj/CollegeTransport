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

public class driverRegitration extends AppCompatActivity {
    Bitmap bmp;
    Snackbar sb;
    ImageView ig;
    EditText nm,id,email,phoneno,adderess;
    SqlManager sm;
    SQLiteDatabase se;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_regitration);
        ig=(ImageView)findViewById(R.id.iv);
        nm=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        id=(EditText)findViewById(R.id.id);
        phoneno=(EditText)findViewById(R.id.phone);
        adderess=(EditText)findViewById(R.id.address);
        sm=new SqlManager(this);
        se=sm.openDB();

    }
    public void click(View v)
    {
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,1);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        Bundle b=data.getExtras();
        bmp=(Bitmap)b.get("data");
        ig.setImageBitmap(bmp);
    }
    public void submit(View v)
    {
       final String name= nm.getText().toString();
        int did=Integer.parseInt(id.getText().toString());
        String em=email.getText().toString();
        String no=phoneno.getText().toString();
        String add=adderess.getText().toString();
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG,100,bos);
        byte[]imgarr= bos.toByteArray();
        ContentValues cv= new ContentValues();
        cv.put(SqlConstants.COL_DRIVER_SID,did);
        cv.put(SqlConstants.COL_DRIVER_NAME,name);
        cv.put(SqlConstants.COL_DRIVER_EMAIL,em);
        cv.put(SqlConstants.COL_DRIVER_CONTACT_NO,no);
        cv.put(SqlConstants.COL_DRIVER_ADDRESS,add);
        cv.put(SqlConstants.COL_DRIVER_PHOTO,imgarr);
        long l=se.insert(SqlConstants.TBL_DRIVER_NAME,null,cv);
        if (l>0)
        {
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            sb= Snackbar.make(v,"Wrong Vales!",Snackbar.LENGTH_INDEFINITE);
            sb.setAction("Retry", new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(driverRegitration.this, "Retry", Toast.LENGTH_SHORT).show();
                    nm.setText( "");
                    id.setText("");
                    email.setText("");
                    phoneno.setText("");
                    adderess.setText("");
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
