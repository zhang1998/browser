package com.a.a.a;

import android.content.Context;
import android.telephony.TelephonyManager;

/* compiled from: ProGuard */
public final class av extends as {
    private Context d;

    public av(Context context) {
        super("imei");
        this.d = context;
    }

    public final String b() {
        TelephonyManager telephonyManager = (TelephonyManager) this.d.getSystemService("phone");
        try {
            if (ey.a(this.d, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
        }
        return null;
    }
}
