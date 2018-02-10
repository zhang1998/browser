package com.ucpro.model.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.ucweb.common.util.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class b {
    public SharedPreferences a;
    private ArrayList<WeakReference<Object>> b;

    public static b a() {
        return a.a;
    }

    private b() {
        this.b = new ArrayList();
        this.a = d.a().getSharedPreferences("settings", 0);
        Editor edit = this.a.edit();
        edit.putBoolean("EnableInputEnhance", true);
        edit.apply();
    }

    public final String a(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public final int a(String str, int i) {
        return this.a.getInt(str, i);
    }

    public final float a(String str) {
        return this.a.getFloat(str, -1.0f);
    }

    public final boolean a(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public final void b(String str, String str2) {
        this.a.edit().putString(str, str2).apply();
    }

    public final void b(String str, boolean z) {
        this.a.edit().putBoolean(str, z).apply();
    }

    public final void b(String str, int i) {
        this.a.edit().putInt(str, i).apply();
    }
}
