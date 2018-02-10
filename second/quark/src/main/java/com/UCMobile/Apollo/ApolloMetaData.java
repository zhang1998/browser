package com.UCMobile.Apollo;

import android.os.Bundle;

/* compiled from: ProGuard */
public class ApolloMetaData {
    public static final String KEY_BITRATE = "bitrate";
    public static final String KEY_HEADER = "header";
    public static final String KEY_IP = "ip";
    private Bundle a;

    public String getString(String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.getString(str);
    }

    public void update(Bundle bundle) {
        this.a = bundle;
    }
}
