package com.example.anwesh.sihprojecttakeone;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anwesh on 30-03-2018.
 */

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private JSONObject jsonObject;
    private Context context;
    private TextView infoTextView;

    public SpinnerActivity(Context context , TextView textView, JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        this.context = context;
        infoTextView = textView;
    }

    //RequestQueue queue = Volley.newRequestQueue(context);


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
         parent.getItemAtPosition(pos);
         Log.d("SpinnerActivity" , "Chose option" + String.valueOf(pos));

         try {
            Log.d("SpinnerActivity" , jsonObject.toString());
             switch (pos) {
                 case 0: infoTextView.setText(":    " + jsonObject.getString("literacy"));
                        break;
                 case 1: infoTextView.setText(":    " + jsonObject.getString("women_literacy"));
                        break;
                 case 2: infoTextView.setText(":    " + jsonObject.getString("sex_ratio"));
                        break;
                 case 3 : infoTextView.setText(":   " + jsonObject.getString("population"));
                        break;
                 case 4: infoTextView.setText(":    " + jsonObject.getString("employment"));
                        break;
                 case 5: infoTextView.setText(":    " + jsonObject.getString("child_population"));
                        break;
                 case 6: infoTextView.setText(":    " + jsonObject.getString("no_school"));
                        break;
                 case 7: infoTextView.setText(":    " + jsonObject.getString("no_fair_price_shop"));
                        break;
                 case 8: infoTextView.setText(":    " + jsonObject.getString("no_girl_primary"));
                        break;
                 case 9: infoTextView.setText(":    " + jsonObject.getString("no_pregnant"));
                        break;
                 case 10: infoTextView.setText(":   " + jsonObject.getString("no_special_disease"));
                        break;
                 case 11: infoTextView.setText(":   " + jsonObject.getString("no_bpl"));
                        break;
                 case 12: infoTextView.setText(":   "+ jsonObject.getString("no_antyodaya"));
                        break;
                 case 13: infoTextView.setText(":   " + jsonObject.getString("no_malnutrition_women"));
                        break;
                 case 14: infoTextView.setText(":   " + jsonObject.getString("no_malnutrition_child"));
                        break;
                 case 15: infoTextView.setText(":   " + jsonObject.getString("no_women_health_issues"));
                        break;
                 case 16: infoTextView.setText(":   " + jsonObject.getString("percentage _depend_agriculture"));
                        break;
                 case 17: infoTextView.setText(":   " + jsonObject.getString("percentage_minority"));
                        break;
                 case 18: infoTextView.setText(":   " + jsonObject.getString("no_pregnant_women_health_issues"));
                        break;
                 case 19: infoTextView.setText(":   " + jsonObject.getString("percentage_depend_other"));
                        break;
                 case 20: infoTextView.setText(":   "+jsonObject.getString("percentage_sc"));
                        break;
                 case 21: infoTextView.setText(":    " + jsonObject.getString("percentage_st"));
                        break;
                 case 22: infoTextView.setText(":    " + jsonObject.getString("village"));
                        break;
                 case 23:
                     infoTextView.setText(":     " + jsonObject.getString("percentage_depend_service"));
                     break;
                 case 24: infoTextView.setText(":     " + jsonObject.getString("no_job_cards"));
                        break;
                 case 25: infoTextView.setText(":     " + jsonObject.getString("no_female_job_cards"));
                        break;
             }
         } catch (JSONException e) {
             Log.d("SpinnerActivity","Json Error");
         }

        //queue.add(villageInfoReq);

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        Log.d("SpinnerActivity" , "Nothing Selected");
    }

}
