package com.example.dellpc.collegetransport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DELL PC on 21-07-2017.
 */

public class leftdelte extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater.inflate(R.layout.leftdelete,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
