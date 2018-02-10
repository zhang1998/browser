package com.uc.quark.filedownloader.model;

import android.content.ContentValues;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;

/* compiled from: ProGuard */
public final class f {
    public int a;
    public String b;
    public long c;
    public long d;
    public int e;
    public long f;
    public byte g = (byte) 0;
    public long h;
    public long i;

    public f(String str, long j, long j2, int i, long j3, long j4, long j5) {
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = i;
        this.f = j3;
        this.h = j4;
        this.i = j5;
    }

    public final ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", this.b);
        contentValues.put("download_length", Long.valueOf(this.c));
        contentValues.put("sofar", Long.valueOf(this.d));
        contentValues.put("thread_id", Integer.valueOf(this.e));
        contentValues.put("downloadfile_id", Long.valueOf(this.f));
        contentValues.put(INoCaptchaComponent.status, Byte.valueOf(this.g));
        contentValues.put("normal_size", Long.valueOf(this.h));
        contentValues.put("ext_size", Long.valueOf(this.i));
        return contentValues;
    }

    public final String toString() {
        return "[taskid = " + this.f + "\nthreadid = " + this.e + "\ndownloadlength = " + this.c + "\nnormalsize = " + this.h + "\nextsize = " + this.i + "\nsofar = " + this.d;
    }
}
