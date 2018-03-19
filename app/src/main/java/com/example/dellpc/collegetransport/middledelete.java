package com.example.dellpc.collegetransport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by DELL PC on 21-07-2017.
 */

public class middledelete extends Fragment
{
    RadioGroup rg;
    RadioButton rb;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater.inflate(R.layout.middledelete,container,false);
        rg=(RadioGroup)container.findViewById(R.id.rg);
        int id=rg.getCheckedRadioButtonId();
        rb=(RadioButton)rg.findViewById(id);
        String data=rb.getText().toString();

        if(data.equalsIgnoreCase("Bus Delete"))
        {

        }
        if(data.equalsIgnoreCase("Student Delete"))
        {

        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

