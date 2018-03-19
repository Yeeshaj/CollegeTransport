package com.example.dellpc.collegetransport;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellpc.collegetransport.db.util.SqlConstants;
import com.example.dellpc.collegetransport.db.util.SqlManager;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by DELL PC on 23-07-2017.
 */

public class MyAdapter extends BaseAdapter
{
    SqlManager sm;
    SQLiteDatabase se;
    private List<viewstudentdetails> mylist;
    String name;
    private LayoutInflater lf=null;
    Context ctx=null;
    public MyAdapter(Activity activity, List<viewstudentdetails>mylist)
    {
        ctx= activity.getApplicationContext();
        this.mylist=mylist;
        lf=LayoutInflater.from(activity);
    }

    @Override
    public int getCount()
    {
          return mylist.size();
    }

    @Override
    public Object getItem(int i)
    {
        return mylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Toast.makeText(ctx,"view created",Toast.LENGTH_LONG).show();
        if(view==null) {
            view = lf.inflate(R.layout.mycustom, viewGroup,false);
        }
        TextView tv=(TextView)view.findViewById(R.id.tv);
        ImageView im=(ImageView)view.findViewById(R.id.img1) ;
        viewstudentdetails st=mylist.get(i);

        byte[] id=st.getId();
        ByteArrayInputStream bis = new ByteArrayInputStream(id);
        Bitmap bm=   BitmapFactory.decodeStream(bis);
        tv.setText(st.getName());
        im.setImageBitmap(bm);

        return view;
    }
}
