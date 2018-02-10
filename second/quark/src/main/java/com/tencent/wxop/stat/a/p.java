package com.tencent.wxop.stat.a;

import android.util.Log;
import com.tencent.wxop.stat.i;

public final class p {
    boolean a = true;
    private String b = "default";
    private int c = 2;

    public p(String str) {
        this.b = str;
    }

    private String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public final void a(Throwable th) {
        if (this.c <= 6) {
            Log.e(this.b, "", th);
            i.w();
        }
    }

    public final void b(Object obj) {
        if (this.c <= 5) {
            String a = a();
            Log.w(this.b, a == null ? obj.toString() : a + " - " + obj);
            i.w();
        }
    }

    public final void d(Object obj) {
        if (this.c <= 6) {
            String a = a();
            Log.e(this.b, a == null ? obj.toString() : a + " - " + obj);
            i.w();
        }
    }

    public final void f(Object obj) {
        if (this.c <= 3) {
            String a = a();
            if (a == null) {
                obj.toString();
            } else {
                new StringBuilder().append(a).append(" - ").append(obj);
            }
            i.w();
        }
    }

    public final void a(Object obj) {
        if (this.a && this.c <= 4) {
            String a = a();
            if (a == null) {
                obj.toString();
            } else {
                new StringBuilder().append(a).append(" - ").append(obj);
            }
            i.w();
        }
    }

    public final void c(Object obj) {
        if (this.a) {
            b(obj);
        }
    }

    public final void e(Object obj) {
        if (this.a) {
            d(obj);
        }
    }

    public final void b(Throwable th) {
        if (this.a) {
            a(th);
        }
    }

    public final void g(Object obj) {
        if (this.a) {
            f(obj);
        }
    }
}
