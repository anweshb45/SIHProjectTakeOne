package com.example.anwesh.sihprojecttakeone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends AppCompatActivity {

    String loginURL = "http://192.168.43.194:8086/alogin";
    //String data = "";
    RequestQueue queue;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        queue = Volley.newRequestQueue(this);

        /*Button login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //get login credentials
                String url = "http://my-json-feed";

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                //mTextView.setText("Response: " + response.toString());
                                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error

                            }
                        });

// Access the RequestQueue through your singleton class.
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
            }
        });*/


    }

    public void login(View view) {

        EditText usernameField = findViewById(R.id.username);
        EditText passwordField = findViewById(R.id.password);
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
        Log.d("LoginPage" , username);
        //JSONObject login_inp;
        if((username.equals("")) || (password.equals(""))) {
            Toast.makeText(getApplicationContext(),"Please enter login credentials" , Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            //tring login_inp = "{'username' : " + username + ",'password':" + password +"}";

            try {
                JSONObject login_inp = new JSONObject();
                login_inp.put("username" , username);
                login_inp.put("password" , password);

                JsonObjectRequest loginReq = new JsonObjectRequest(
                        Request.Method.POST,loginURL,login_inp,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    Log.d("LoginPage", response.getString("resp"));
                                    SharedPreferences user = getApplicationContext().getSharedPreferences("Arpit Shared Preferences" , MODE_PRIVATE);
                                    user.edit().putString("user" , username);
                                    user.edit().apply();
                                    Intent intent = new Intent(LoginPage.this , MainActivity.class);
                                    startActivity(intent);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                //hideProgressDialog();
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("LoginPage", "Error: " + error.getMessage());
                        Log.d("LoginPage" , "Error: " + error.getMessage());
                        Toast.makeText(getApplicationContext(),"Error logging in" , Toast.LENGTH_SHORT).show();
                        //hideProgressDialog();
                    }

                }) {


                     //Passing some request headers

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        return headers;
                    }
                };

                /*StringRequest loginReq = new StringRequest(Request.Method.POST, loginURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("LoginPage", response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("LoginPage" , "Error: " + error.getMessage());
                        Toast.makeText(getApplicationContext(),"Error logging in" , Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("username",username);
                        params.put("password",password);

                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        return headers;
                    }
                };*/
                queue.add(loginReq);

            }
            catch(Exception e) {
                Log.i("LoginPage" , "Exception while getting user creds");
            }

        }






        }


}
