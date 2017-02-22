package com.av.thegroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import ParserJson.App;
import ParserJson.CommonVars;
import ParserJson.CustomRequest;
import ParserJson.ParseUtilites;
import StoreData.StoreData;
import at.markushi.ui.CircleButton;

public class LoginActivity extends AppCompatActivity {
    CircleButton Login_In,Fringer_Print;
    EditText txt_InverstorNo,txt_Password;
    public static Context contextOfApplication;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        contextOfApplication=getApplicationContext();
        txt_InverstorNo=(EditText)findViewById(R.id.txt_InverstorNo);
        txt_Password=(EditText)findViewById(R.id.txt_Password);

        txt_InverstorNo.setText("209037");
        txt_InverstorNo.setTextColor(getResources().getColor(R.color.color_itemtext));

        txt_Password.setText("12345");
        txt_Password.setTextColor(getResources().getColor(R.color.color_itemtext));

        Login_In=(CircleButton)findViewById(R.id.btn_login);


       /* FirebaseDatabase database= FirebaseDatabase.getInstance();
        myRef = database.getReference();
        //myRef = myRef.child("Market_Data");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String test=  dataSnapshot.child("Market_Data").child("ChangePercentage").getValue(String.class);

                //dataSnapshot.toString();
                txt_InverstorNo.setText(test);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/


        Login_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject JsonResult=ParseUtilites.parseLogin("209037","12345");
                        if(JsonResult.getJSONObject("ResponseStatus").get("ResCode").equals("0")){
                            App.SessionID = JsonResult.getJSONObject("Message").getJSONObject("LogResponse").getString("SessionID");
/*/*
                            new StoreData().SavePassword(txt_Password.getText().toString());
                            new StoreData().SaveInverstorNumber(txt_InverstorNo.getText().toString());*//*
                            App.Tag_Login = 1;
                            new StoreData().Save_LoginState(App.Tag_Login);*/

                            Intent i=new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(i);
                        }
                        else{
                            String failer=JsonResult.getJSONObject("ResponseStatus").getString("ResDesc");
                            Toast.makeText(LoginActivity.this,failer,Toast.LENGTH_LONG).show();
                        }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
