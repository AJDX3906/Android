package com.example.ajdx3906.firstactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.server.converter.StringToIntConverter;

/**
 * Created by AJDX3906 on 2016/10/25.
 */
public class SecendActivity extends Activity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public EditText accountEdit1;
    public EditText passwordEdit1;
    private Button login;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecendActivity" , "This id is " + getTaskId());
//        pref = PreferenceManager.getDefaultSharedPreferences(this);
//        accountEdit1 = (EditText)findViewById(R.id.username_edit);
//        passwordEdit1 = (EditText)findViewById(R.id.password_edit);
//        Data.account2 = pref.getString("username_edit","");
//        Data.password2 = pref.getString("password_edit","");
//        accountEdit1.setText(Data.account2);
//        passwordEdit1.setText(Data.password2);
//        login = (Button) findViewById(R.id.botton2);
        setContentView(R.layout.secend_layout);
        Button button2 = (Button) findViewById(R.id.button_2) ;  //编辑 button_2 的按键功能，要不然finish 功能 就用不了
        accountEdit1 = (EditText) findViewById(R.id.username_edit);
        passwordEdit1 = (EditText) findViewById(R.id.password_edit);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecendActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();  //小提示   LENGTH_SHORT LENGTH_LONG 时间长短
                Data.account2 = accountEdit1.getText().toString();
                Data.password2 = passwordEdit1.getText().toString();


                Intent intent = new Intent(SecendActivity.this,FirstActivity.class);
                startActivity(intent);


            }
        });
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String account1 = accountEdit1.getText().toString();
//                String password1 = passwordEdit1.getText().toString();
//                editor = pref.edit();
//                editor.apply();
//                Toast.makeText(SecendActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();  //小提示   LENGTH_SHORT LENGTH_LONG 时间长短
//                Intent intent = new Intent(SecendActivity.this,FirstActivity.class);
//                startActivity(intent);
//                finish();
//
//
//            }
//        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Secend Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.ajdx3906.firstactivity/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Secend Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.ajdx3906.firstactivity/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("SecendActivity" , "onDestroy");

    }
}
