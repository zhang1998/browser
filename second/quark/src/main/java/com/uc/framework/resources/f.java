package com.uc.framework.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.uc.b.a;
import com.uc.b.a.af;
import com.uc.imagecodec.export.IPictureView;
import java.io.File;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: ProGuard */
public final class f {
    public static final Drawable a = new ColorDrawable(-65536);
    public static final Drawable b = new ColorDrawable(-16776961);
    private static volatile boolean k;
    public int c = 0;
    public boolean d;
    public String e;
    public long f = 0;
    private Context g;
    private String h;
    private final u i = new u();
    private Properties j;

    public f(Context context) {
        this.g = context;
        this.j = new Properties();
        if (!k) {
            Context context2 = this.g;
            t.a = context2;
            a.a = context2.getAssets();
            c.a = t.a.getAssets();
            t.b = t.a.getResources();
            j.b();
            j.a();
            af.a(this.g.getResources().getDisplayMetrics().density / IPictureView.DEFAULT_MAX_SCALE);
            HashMap[] a = a.a(0);
            a.a = a;
            a.b = a;
            k = true;
        }
    }

    public final void a(String str) {
        if (str != null && str.length() != 0) {
            if (!str.endsWith(File.separator)) {
                str = new StringBuilder(String.valueOf(str)).append(File.separator).toString();
            }
            if (str.equals("theme/default/")) {
                this.c = 0;
            } else if (str.equals("theme/night/")) {
                this.c = 1;
            } else if (str.equals("theme/transparent/")) {
                this.c = 2;
            } else {
                this.c = 3;
            }
            if (this.c == 1) {
                this.i.a = 2;
            } else {
                this.i.a = 1;
            }
            this.h = str;
            String str2 = this.h;
            t.c = str2;
            e.a(str2);
            x.a(str2);
            aa.a(this.i);
        }
    }

    public final void a(Drawable drawable) {
        this.i.a(drawable);
    }

    public final Drawable a(String str, int i) {
        z zVar = new z();
        zVar.d = i;
        return a(str, zVar);
    }

    public final Drawable a(String str, z zVar) {
        if (y.b()) {
            y.a().a(str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Drawable a = new aa(t.c).a(t.a, str, zVar, 0.0f, 0.0f);
        if (a == null) {
            Log.e("Theme", "getDrawable is null!! name: " + str);
        }
        this.f += System.currentTimeMillis() - currentTimeMillis;
        if (y.b()) {
            y.a().b(str);
        }
        return a;
    }

    public static ColorStateList b(String str) {
        ColorStateList colorStateList = null;
        try {
            colorStateList = x.a(t.a, str);
        } catch (Exception e) {
        }
        if (colorStateList == null) {
            Log.w("Theme", "getColorStateList is null!! name: " + str);
        }
        return colorStateList;
    }

    public static float a(int i) {
        return t.a(i);
    }

    public static String b(int i) {
        return t.b(i);
    }

    public static int c(String str) {
        return e.a(t.a, str);
    }
}
