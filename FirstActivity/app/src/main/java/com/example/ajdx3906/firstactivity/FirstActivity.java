package com.example.ajdx3906.firstactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
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
public class FirstActivity extends Activity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity" , "This id is " + getTaskId());
        setContentView(R.layout.first_layout); //在活动中加载布局
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText)findViewById(R.id.username_edit);
        passwordEdit = (EditText)findViewById(R.id.password_edit);
        rememberPass=(CheckBox)findViewById(R.id.checkBox);
        login = (Button) findViewById(R.id.botton);
        boolean isRemember = pref.getBoolean("checkBox",false);
        if(isRemember){
            String account = pref.getString("username_edit","");
            String password = pref.getString("password_edit","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        Button button1 = (Button) findViewById(R.id.botton1) ;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "请注册！", Toast.LENGTH_SHORT).show();  //小提示
//                Intent intent = new Intent(Intent.ACTION_DIAL); 用 inter 启动活动
//                intent.setData(Uri.parse("tel:10086"));
//                String Data = "hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this,SecendActivity.class);
                startActivity(intent);

            }
        });
        Button button2 = (Button) findViewById(R.id.botton2) ;
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "忘了就重新注册！", Toast.LENGTH_SHORT).show();  //小提示
//                Intent intent = new Intent(Intent.ACTION_DIAL); 用 inter 启动活动
//                intent.setData(Uri.parse("tel:10086"));
//                String Data = "hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this,SecendActivity.class);
                startActivity(intent);

            }
        });
//        Button button3 = (Button) findViewById(R.id.botton) ;  //编辑 button 的按键功能，要不然finish 功能 就用不了
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(FirstActivity.this, "登陆成功！感谢使用~", Toast.LENGTH_SHORT).show();  //小提示   LENGTH_SHORT LENGTH_LONG 时间长短
//
//                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
//                startActivity(intent);
//            }
//        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(account.equals(Data.account2) && password.equals(Data.password2)){
                    editor = pref.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("checkBox",true);
                        editor.putString("username_edit",account);
                        editor.putString("password_edit",password);
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                    Toast.makeText(FirstActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();  //小提示   LENGTH_SHORT LENGTH_LONG 时间长短
                    Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "First Page", // TODO: Define a title for the content shown.
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

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_itme:
                Toast.makeText(this , "You check Add" , Toast.LENGTH_SHORT).show();
            case R.id.remove_itme:
                Toast.makeText(this , "You check Remove" , Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
    protected void onRestart(){
        super.onRestart();
        Log.d("FirstActivity", "onRestart");

    }
}


