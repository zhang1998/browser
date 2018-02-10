package com.yunos.faceunlock.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.uc.apollo.impl.SettingsConst;
import com.yunos.a.a.a;
import java.util.Random;

/* compiled from: ProGuard */
public class Util {
    private static String mUuid = "";

    public static String getUuid() {
        if (!mUuid.isEmpty()) {
            return mUuid;
        }
        try {
            mUuid = (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"ro.aliyun.clouduuid"});
        } catch (Exception e) {
        }
        return mUuid;
    }

    public static String getUuid(Context context) {
        if (mUuid != null) {
            new StringBuilder("returned uuid = ").append(mUuid).append(", len = ").append(mUuid.length());
            return mUuid;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(context.getString(a.settings_key_facelock_uuid), "none");
        mUuid = string;
        if (string == null || mUuid.equalsIgnoreCase("none")) {
            Random random = new Random();
            string = Long.toHexString(random.nextLong()) + Long.toHexString(random.nextLong());
            mUuid = string;
            if (string.length() < 32) {
                int length = 32 - mUuid.length();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    stringBuilder.append(SettingsConst.FALSE);
                }
                mUuid += stringBuilder.toString();
            }
            if (mUuid.length() > 32) {
                mUuid = mUuid.substring(mUuid.length() - 32);
            }
            mUuid = mUuid.toUpperCase();
            Editor edit = defaultSharedPreferences.edit();
            edit.putString(context.getString(a.settings_key_facelock_uuid), mUuid);
            edit.apply();
            new StringBuilder("generate uuid = ").append(mUuid).append(", len = ").append(mUuid.length());
        }
        new StringBuilder("returned uuid = ").append(mUuid).append(", len = ").append(mUuid.length());
        return mUuid;
    }

    public static int getApiLevel() {
        return VERSION.SDK_INT;
    }

    public static int dpToPixel(Context context, int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return Math.round(displayMetrics.density * ((float) i));
    }

    public static Point getScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static int getVersionCode(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            return i;
        }
    }

    public static byte[] rotateYUV420Degree180(byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2 = new byte[(((i * i2) * 3) / 2)];
        int i4 = 0;
        for (i3 = (i * i2) - 1; i3 >= 0; i3--) {
            bArr2[i4] = bArr[i3];
            i4++;
        }
        for (i3 = (((i * i2) * 3) / 2) - 1; i3 >= i * i2; i3 -= 2) {
            int i5 = i4 + 1;
            bArr2[i4] = bArr[i3 - 1];
            i4 = i5 + 1;
            bArr2[i5] = bArr[i3];
        }
        return bArr2;
    }
}
