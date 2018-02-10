package com.uc.framework.resources;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class d {
    private static String e;
    private static String f;
    private static String g;
    public int a;
    private String b;
    private String c = null;
    private String d = null;

    static {
        a("");
    }

    public d(String str) {
        this.b = str;
        if (this.b == null || this.b.trim().length() == 0) {
            this.a = 4105;
        } else if (this.b.startsWith("/data/")) {
            this.a = SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
        } else if (a(this.b)) {
            this.a = 4098;
            if ((this.b.startsWith("/sdcard/") && !"/sdcard/".equals(g)) || this.b.startsWith(f)) {
                return;
            }
            if (this.b.startsWith(File.separator)) {
                this.b = new StringBuilder(String.valueOf(f.substring(0, f.length() - 1))).append(this.b).toString();
            } else {
                this.b = f + this.b;
            }
        } else {
            this.a = 4097;
            int indexOf = this.b.indexOf("/", this.b.indexOf("/") + 1);
            if (indexOf > 5) {
                String stringBuilder = new StringBuilder(String.valueOf(this.b.substring(0, indexOf))).append(".tdx").toString();
                a.a();
                if (a.b(stringBuilder)) {
                    this.a = 4099;
                    this.c = stringBuilder;
                    this.d = this.b.substring(indexOf + 1);
                }
            }
        }
    }

    public final InputStream a() {
        if (this.a == 4097) {
            a.a();
            return a.a(this.b);
        } else if (this.a == 4099) {
            return c.a().a(this.c, this.d);
        } else {
            if (this.a != SpdyProtocol.SLIGHTSSL_0_RTT_MODE && this.a != 4098) {
                return null;
            }
            try {
                return new FileInputStream(this.b);
            } catch (FileNotFoundException e) {
                return null;
            }
        }
    }

    final byte[] b() {
        if (this.a == 4099) {
            return c.a().b(this.c, this.d);
        }
        InputStream a = a();
        if (a != null) {
            return b.a(a);
        }
        Log.w("FileAdapter", "File can not found: " + this.b);
        return null;
    }

    private static boolean a(String str) {
        String str2 = null;
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.startsWith("/sdcard/")) {
            return true;
        }
        if (e == null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            String absolutePath = externalStorageDirectory != null ? externalStorageDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                str2 = absolutePath.trim();
            }
            if (str2 != null && str2.length() > 0) {
                if (str2.endsWith(File.separator)) {
                    e = str2;
                } else {
                    e = new StringBuilder(String.valueOf(str2)).append(File.separator).toString();
                }
                int indexOf = e.substring(1).indexOf(File.separator);
                if (indexOf >= 0 && indexOf < e.length()) {
                    f = e.substring(0, indexOf + 2);
                    g = e.substring(indexOf + 1);
                }
            }
        }
        if (trim.startsWith(e) || trim.startsWith(f)) {
            return true;
        }
        return false;
    }
}
