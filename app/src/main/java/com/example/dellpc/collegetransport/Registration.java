package com.example.dellpc.collegetransport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registration extends AppCompatActivity
{
    RadioGroup rg;
    RadioButton rb; String data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        rg=(RadioGroup)findViewById(R.id.rg);
    }
    public void show(View v)
    {
        int id=rg.getCheckedRadioButtonId();
        RadioButton rb=(RadioButton)rg.findViewById(id);
        data=rb.getText().toString();
        if(data.equalsIgnoreCase("Bus Registration"))
        {
            Intent i=new Intent(this,busRegistration.class);
            startActivity(i);
        }
        if(data.equalsIgnoreCase("Student Registration"))
        {
            Intent i=new Intent(this,studentRegistration.class);
            startActivity(i);
        }
        if(data.equalsIgnoreCase("View Bus"))
        {
            Intent i=new Intent(this,viewBus.class);
            startActivity(i);
        }
        if(data.equalsIgnoreCase("Driver Registration"))
        {
            Intent i=new Intent(this,driverRegitration.class);
            startActivity(i);
        }
        if(data.equalsIgnoreCase("Bus Allotment"))
        {
            Intent i= new Intent(this,BusAllotment.class);
            startActivity(i);
        }
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.delete:
                //Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(this,delete.class);
                startActivity(i);
                break;
            case R.id.update:
                Intent x=new Intent(this,update.class);
                startActivity(x);
                break;
            case R.id.vstud:
                Intent z=new Intent(this,ViewStudentDetailsMainActivity.class);
                startActivity(z);
                break;
            case R.id.vdr:
                Intent b=new Intent(this,ViewDriverDetailsMainActivity.class);
                startActivity(b);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mp=getMenuInflater();
        mp.inflate(R.menu.placemenu,menu);



        return super.onCreateOptionsMenu(menu);
    }
}
