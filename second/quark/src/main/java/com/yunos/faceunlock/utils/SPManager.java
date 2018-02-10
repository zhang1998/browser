package com.yunos.faceunlock.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: ProGuard */
public class SPManager {
    private static final String NAME = "com.yunos.faceunlock";
    private Context mContext;
    private String mName = NAME;
    private SharedPreferences mSharedPreferences;

    public static synchronized SPManager newInstance(Context context) {
        SPManager newInstance;
        synchronized (SPManager.class) {
            newInstance = newInstance(context, NAME);
        }
        return newInstance;
    }

    public static synchronized SPManager newInstance(Context context, String str) {
        SPManager sPManager;
        synchronized (SPManager.class) {
            sPManager = new SPManager(context, str);
        }
        return sPManager;
    }

    private SPManager(Context context, String str) {
        this.mContext = context;
        if (str == null) {
            this.mName = NAME;
        }
        this.mSharedPreferences = context.getSharedPreferences(this.mName, 4);
    }

    public Object get(String str, Object obj) {
        if (obj instanceof Integer) {
            return Integer.valueOf(this.mSharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof String) {
            return this.mSharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(this.mSharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        return null;
    }

    public void put(String str, Object obj) {
        Editor edit = this.mSharedPreferences.edit();
        if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        edit.commit();
    }
}
