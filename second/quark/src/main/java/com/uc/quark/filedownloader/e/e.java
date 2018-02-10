package com.uc.quark.filedownloader.e;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.quark.filedownloader.contentprovider.a;
import com.uc.quark.filedownloader.f;
import com.uc.quark.filedownloader.message.d;
import com.uc.quark.filedownloader.model.b;
import java.io.File;

/* compiled from: ProGuard */
public final class e {
    public static String a;
    public static String b;
    public static String c;
    public static String d = "startList";
    public static String e = "pauseList";
    @SuppressLint({"StaticFieldLeak"})
    private static Context f;

    public static void a(Context context) {
        f = context;
        a.a(context);
        c = f.getPackageName() + ".provider";
        a = "content://" + c + "/filestatus";
        b = "content://" + c + "/threadnum";
    }

    public static Context a() {
        return f;
    }

    public static boolean a(int i, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        if (z || str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(i));
        contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) -3));
        contentValues.put("total", Long.valueOf(file.length()));
        contentValues.put("sofar", Long.valueOf(file.length()));
        try {
            f.getContentResolver().insert(Uri.parse(a), b.a(contentValues));
            contentValues.remove("_id");
            f.getContentResolver().update(Uri.parse(a), b.a(contentValues), "_id = ?", new String[]{String.valueOf(i)});
            com.uc.quark.filedownloader.message.b.a.a(d.a(i, file, z2, z3), z4);
            return true;
        } catch (Exception e) {
            com.uc.quark.filedownloader.message.b.a.a(d.a(i, file, z2, z3), z4);
            return true;
        } catch (Throwable th) {
            com.uc.quark.filedownloader.message.b.a.a(d.a(i, file, z2, z3), z4);
            return true;
        }
    }

    public static boolean a(int i, b bVar, f fVar, boolean z, boolean z2) {
        if (!fVar.a(bVar)) {
            return false;
        }
        com.uc.quark.filedownloader.message.b.a.a(d.a(i, bVar.g, bVar.h, z, z2), true);
        return true;
    }
}
