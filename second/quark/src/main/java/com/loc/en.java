package com.loc;

import android.content.Context;
import java.io.File;
import java.io.RandomAccessFile;

/* compiled from: ProGuard */
public final class en extends Thread implements bk {
    private static String h = "sodownload";
    private static String i = "sofail";
    em a;
    String b;
    private bl c = new bl(this.a);
    private RandomAccessFile d;
    private String e;
    private String f;
    private Context g;

    public en(Context context, String str, String str2, String str3) {
        this.g = context;
        this.f = str3;
        this.e = a(context, str + "temp.so");
        this.b = a(context, "libwgs2gcj.so");
        this.a = new em(str2);
    }

    public static String a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "libso" + File.separator + str;
    }

    private void d() {
        File file = new File(this.e);
        if (file.exists()) {
            file.delete();
        }
    }

    public final void a() {
        try {
            if (this.d != null) {
                this.d.close();
            }
            d();
            File file = new File(a(this.g, "tempfile"));
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdir();
                }
                file.createNewFile();
            }
        } catch (Throwable th) {
            es.a(th, "SDKCoordinatorDownload", "onException");
        }
    }

    public final void a(byte[] bArr, long j) {
        try {
            if (this.d == null) {
                File file = new File(this.e);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.d = new RandomAccessFile(file, "rw");
            }
        } catch (Throwable e) {
            es.a(e, "SDKCoordinatorDownload", "onDownload");
            d();
        } catch (Throwable e2) {
            d();
            es.a(e2, "SDKCoordinatorDownload", "onDownload");
            return;
        }
        if (this.d != null) {
            try {
                this.d.seek(j);
                this.d.write(bArr);
            } catch (Throwable e22) {
                d();
                es.a(e22, "SDKCoordinatorDownload", "onDownload");
            }
        }
    }

    public final void b() {
        try {
            if (this.d != null) {
                this.d.close();
            }
            String a = ek.a(this.e);
            if (a == null || !a.equalsIgnoreCase(this.f)) {
                d();
            } else if (new File(this.b).exists()) {
                d();
            } else {
                new File(this.e).renameTo(new File(this.b));
            }
        } catch (Throwable th) {
            d();
            File file = new File(this.b);
            if (file.exists()) {
                file.delete();
            }
            es.a(th, "SDKCoordinatorDownload", "onFinish");
        }
    }

    public final void c() {
        d();
    }

    public final void run() {
        try {
            File file = new File(a(this.g, "tempfile"));
            if (file.exists()) {
                file.delete();
            }
            this.c.a(this);
        } catch (Throwable th) {
            es.a(th, "SDKCoordinatorDownload", "run");
            d();
        }
    }
}
