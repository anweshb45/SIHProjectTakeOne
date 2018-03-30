package com.example.anwesh.sihprojecttakeone;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * Created by Anwesh on 30-03-2018.
 */

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
         parent.getItemAtPosition(pos);
         Log.d("SpinnerActivity" , "Chose option" + String.valueOf(pos));



    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        Log.d("SpinnerActivity" , "Nothing Selected");
    }

}
