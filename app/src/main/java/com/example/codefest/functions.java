package com.example.codefest;

import android.content.Context;
import android.widget.Toast;

public class functions {
    public void toa(Context context, String mess){
        Toast toast = Toast.makeText(context, mess, Toast.LENGTH_SHORT);
        toast.show();
    }

    public functions(){

    }
}
