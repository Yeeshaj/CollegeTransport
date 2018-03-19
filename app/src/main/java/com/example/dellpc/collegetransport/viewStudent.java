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

public class viewStudent extends AppCompatActivity implements AdapterView.OnItemClickListener
{
SQLiteDatabase se;
    Student st;
    StudentBeans stb;
    SqlManager sm;
    String name;
    ListView ll;
    Student student;
    ArrayList<Student> studentlist;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        Intent i=getIntent();
        int busno=i.getIntExtra("busnum",0);
       sm=new SqlManager(this);
        se=sm.openDB();
        ll=(ListView)findViewById(R.id.ll);
        studentlist=new ArrayList<Student>();
        filllist(busno);
        ArrayAdapter<Student> ad=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,studentlist);
        ll.setAdapter(ad);
        ll.setOnItemClickListener(this);
    }



    public void filllist(int busno)
    {
        //Cursor c=se.query(SqlConstants.TBL_STUDENT_NAME,null,null,null,null,null,null);
        String x=String.valueOf(busno);
        String[] arg={x};

        //String strsql="select s.name from studentdetails s,busallotment b where s.sid=? and b.studentid=?";

     //   se.rawQuery(strsql,arg)
        Cursor c=se.query(SqlConstants.TBL_BUS_ALLOTMENT_NAME,null,SqlConstants.COL_BUS_ALLOTMENT_BUS_NO+"=?",arg,null,null,null);
        //select s.name from studentdetails as s,BusAllotment as b where s.sid=b.sid;
        if(c!=null&&c.moveToFirst())
        {
            do {
                /* int id=c.getInt(c.getColumnIndex(SqlConstants.COL_BUS_ALLOTMENT_SID));

                String []args={String.valueOf(id)};
                Cursor cd=se.query(SqlConstants.TBL_STUDENT_NAME,null,SqlConstants.COL_STUDENT_SID+"=?",args,null,null,null,null);
                if(cd!=null&&cd.moveToFirst())
                {
                    do {
                        stb= new StudentBeans();
                        String name=cd.getString(c.getColumnIndex(SqlConstants.COL_STUDENT_NAME));
                        stb.setName(name);
                        studentlist.add(stb);
                    }while (cd.moveToNext());
                    cd.close();
                }*/
                st=new Student();
            int id=c.getInt(c.getColumnIndex(SqlConstants.COL_BUS_ALLOTMENT_SID));
                st.setId(id);
                //String add=c.getString(c.getColumnIndex(SqlConstants.COL_STUDENT_ADDRESS));
                //String no=c.getString(c.getColumnIndex(SqlConstants.COL_STUDENT_CONTACT_NO));
                //student=new Student();
                //student.setAddress(add);
                //student.setContactno(no);
                //student.setName(name);
                studentlist.add(st);
            }while(c.moveToNext());
        }c.close();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Student st=studentlist.get(i);
        int id=st.getId();
       // Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();
        String []arg={String.valueOf(id)};
        Cursor c=se.query(SqlConstants.TBL_STUDENT_NAME,null,SqlConstants.COL_STUDENT_SID+"=?",arg,null,null,null);
        if(c!=null&&c.moveToFirst())
        {

                do {


                name=c.getString(c.getColumnIndex(SqlConstants.COL_STUDENT_NAME));
                }while(c.moveToNext());

            c.close();
        }
        Toast.makeText(this, "Name is"+name, Toast.LENGTH_SHORT).show();

    }
}
