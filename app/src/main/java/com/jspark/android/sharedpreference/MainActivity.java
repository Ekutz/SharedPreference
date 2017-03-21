package com.jspark.android.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText editMail;
    Switch swShuffle;

    RelativeLayout relative2;

    PropertyUtil mPropertyUtil;

    public static final String SHARED_FILE = "aaa.prop";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWidget();

        mPropertyUtil = PropertyUtil.getInstance(this);

        if("false".equals(mPropertyUtil.getProperty("firstOpen"))) {
            relative2.setVisibility(View.GONE);
        }

        loadSetting();

    }

    private void setWidget() {
        editMail = (EditText)findViewById(R.id.editMail);
        swShuffle = (Switch)findViewById(R.id.swShuffle);
        relative2 = (RelativeLayout)findViewById(R.id.relative2);
    }

    public void saveSetting(View view) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("email", editMail.getText().toString());
        editor.putBoolean("shuffle", swShuffle.isChecked());
        editor.commit();
    }

    public void closeHelp(View view) {
        relative2.setVisibility(View.GONE);
        mPropertyUtil.saveProperty("firstOpen", "false");
    }

    public void loadSetting() {
        SharedPreferences sharedPref = getSharedPreferences(SHARED_FILE, Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", null);
        Boolean shuffle = sharedPref.getBoolean("shuffle", false);

        editMail.setText(email);
        swShuffle.setChecked(shuffle);
    }


}
