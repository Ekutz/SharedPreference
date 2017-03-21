package com.jspark.android.sharedpreference;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by jsPark on 2017. 3. 21..
 */

public class PropertyUtil {
    private final static String PROP_FILE = "sp.properties";
    private static String internalStorePath;
    private static PropertyUtil instance = null;
    private static Context mContext;

    private PropertyUtil() {
        internalStorePath = mContext.getFilesDir().getAbsolutePath();
    }

    public static PropertyUtil getInstance(Context context) {
        mContext = context;
        if(instance==null) {
            instance = new PropertyUtil();
        }
        return instance;
    }

    public void saveProperty(String key, String value) {
        Properties prop = new Properties();
        prop.put(key, value);
        try {
            FileOutputStream fos = new FileOutputStream(internalStorePath+"/"+PROP_FILE);
            prop.store(fos, "코멘트테스트");
            fos.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(prop);
    }

    public String getProperty(String key) {
        String value = "";
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(internalStorePath+"/"+PROP_FILE);
            prop.load(fis);
            fis.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        value = prop.getProperty(key);

        return value;
    }
}
