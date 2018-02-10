package com.uc.framework.resources;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.uc.util.b;
import java.io.File;

/* compiled from: ProGuard */
public final class l {
    String a;
    String b;
    String c;
    Object d;
    boolean e = false;

    public l(String str, String str2) {
        this.c = str2;
        if (!str.endsWith(File.separator)) {
            str = new StringBuilder(String.valueOf(str)).append(File.separator).toString();
        }
        this.a = str;
        this.b = new StringBuilder(String.valueOf(str)).append("drawable").append(File.separator).toString();
    }

    final Drawable a(String str) {
        Object a = j.a(str);
        if (a == null) {
            return null;
        }
        Drawable drawable = (Drawable) ((i) a).d;
        this.d = a;
        return drawable;
    }

    final void a(String str, Drawable drawable) {
        if (drawable != null && this.d == null && str != null) {
            this.d = j.a(str, drawable, (long) ((drawable.getIntrinsicWidth() * drawable.getIntrinsicHeight()) * 4));
        }
    }

    final String a() {
        int indexOf = this.c.indexOf(46);
        if (indexOf != -1) {
            return this.c.substring(0, indexOf);
        }
        return this.c;
    }

    public final Drawable a(Context context, z zVar, float f, float f2) {
        String str = this.b + this.c.replace(".svg", ".png");
        Drawable a = a(str);
        if (a != null) {
            this.e = true;
            return a;
        }
        Drawable a2;
        Rect rect = new Rect();
        Bitmap a3 = b.a(context.getResources(), zVar.d, str, rect, f, f2, zVar.b, zVar.c);
        if (a3 != null) {
            byte[] ninePatchChunk = a3.getNinePatchChunk();
            if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                rect = null;
            }
            a2 = b.a(context.getResources(), a3, rect, str);
            if (zVar.a) {
                a(str, a2);
            }
        } else {
            a2 = a;
        }
        return a2;
    }
}
