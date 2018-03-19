package com.example.dellpc.collegetransport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginAdmin extends AppCompatActivity {
    EditText txtid,txtpass;
    SharedPreferences sp;
    SharedPreferences.Editor se;
    Snackbar sb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        txtid=(EditText)findViewById(R.id.txtuserid);
        txtpass=(EditText)findViewById(R.id.txtuserpass);
        sp=getSharedPreferences("Login",MODE_PRIVATE);
        se=sp.edit();

    }

    public void submit(View v)
    {
        String id=txtid.getText().toString().trim();
        String pass=txtpass.getText().toString().trim();
        if ((id.equalsIgnoreCase("admin"))&&(pass.equalsIgnoreCase("admin")))
        {
            Intent i=new Intent(this,Registration.class);
            startActivity(i);

        }
        else
        {
            sb= Snackbar.make(v,"Authentication Failed!",Snackbar.LENGTH_INDEFINITE);
            sb.setAction("Retry", new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(LoginAdmin.this, "Retry", Toast.LENGTH_SHORT).show();
                    txtid.setText(" ");
                    txtpass.setText(" ");
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
