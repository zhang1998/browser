package com.uc.quark.filedownloader.model;

import android.content.ContentValues;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;

/* compiled from: ProGuard */
public final class b {
    public int a;
    public String b;
    public String c;
    public boolean d;
    public String e;
    public byte f;
    public long g;
    public long h;
    public String i;
    public String j;
    public String k;
    public boolean l = true;
    public boolean m = true;
    public String n;
    public long o;
    public boolean p;

    public final void a(String str, boolean z) {
        this.c = str;
        this.d = z;
    }

    public final void a(long j) {
        this.p = j > 2147483647L;
        this.h = j;
    }

    public final String b() {
        if (a() == null) {
            return null;
        }
        return com.uc.quark.filedownloader.e.b.d(a());
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.j = str;
        }
    }

    public final ContentValues c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.a));
        contentValues.put("url", this.b);
        contentValues.put("path", this.c);
        contentValues.put(INoCaptchaComponent.status, Byte.valueOf(this.f));
        contentValues.put("sofar", Long.valueOf(this.g));
        contentValues.put("total", Long.valueOf(this.h));
        contentValues.put("errMsg", this.i);
        contentValues.put("etag", this.j);
        contentValues.put("pathAsDirectory", Boolean.valueOf(this.d));
        contentValues.put("postBody", this.k);
        if (this.d && this.e != null) {
            contentValues.put("filename", this.e);
        }
        contentValues.put("fileContinue", Boolean.valueOf(this.l));
        contentValues.put("isNeedRefer", Boolean.valueOf(this.m));
        contentValues.put("updateUrl", this.n);
        return contentValues;
    }

    public final String toString() {
        return com.uc.quark.filedownloader.e.b.a("id[%d], mUrl[%s], path[%s], status[%d], sofar[%d], total[%d], etag[%s], %s", Integer.valueOf(this.a), this.b, this.c, Byte.valueOf(this.f), Long.valueOf(this.g), Long.valueOf(this.h), this.j, super.toString());
    }

    public static ContentValues a(ContentValues contentValues) {
        if (contentValues != null) {
            contentValues.remove("errMsg");
            contentValues.remove("etag");
            contentValues.remove("pathAsDirectory");
            contentValues.remove("filename");
            contentValues.remove("postBody");
            contentValues.remove("fileContinue");
            contentValues.remove("isNeedRefer");
            contentValues.remove("updateUrl");
            if (((Byte) contentValues.get(INoCaptchaComponent.status)).byteValue() == (byte) 3 || ((Byte) contentValues.get(INoCaptchaComponent.status)).byteValue() == (byte) 2 || ((Byte) contentValues.get(INoCaptchaComponent.status)).byteValue() == (byte) 1) {
                contentValues.put(INoCaptchaComponent.status, Byte.valueOf((byte) -2));
            }
        }
        return contentValues;
    }

    public final b d() {
        b bVar = new b();
        bVar.a = this.a;
        bVar.b = this.b;
        bVar.c = this.c;
        bVar.e = this.e;
        bVar.d = this.d;
        bVar.f = this.f;
        bVar.g = this.g;
        bVar.h = this.h;
        bVar.i = this.i;
        bVar.j = this.j;
        bVar.k = this.k;
        bVar.p = this.p;
        bVar.l = this.l;
        bVar.m = this.m;
        bVar.n = this.n;
        return bVar;
    }

    public final String a() {
        return com.uc.quark.filedownloader.e.b.a(this.c, this.d, this.e);
    }
}
