package com.uc.webview.export.cyclone;

@Constant
/* compiled from: ProGuard */
public class UCKnownException extends RuntimeException {
    private int mCode;

    public UCKnownException(int i, String str, Throwable th) {
        super(str, th);
        this.mCode = -99999;
        this.mCode = i;
    }

    public UCKnownException(int i, Throwable th) {
        this(th);
        this.mCode = i;
    }

    public UCKnownException(int i, String str) {
        super(str);
        this.mCode = -99999;
        this.mCode = i;
    }

    public UCKnownException(Throwable th) {
        super(th);
        this.mCode = -99999;
        Throwable th2 = th;
        while (th2 != null) {
            if (th2 instanceof UCKnownException) {
                this.mCode = ((UCKnownException) th2).mCode;
                return;
            } else if (th2.getCause() != null && th2.getCause() != th2) {
                th2 = th2.getCause();
            } else {
                return;
            }
        }
    }

    public static UCKnownException create(Throwable th, int i) {
        if (th instanceof UCKnownException) {
            return (UCKnownException) th;
        }
        return new UCKnownException(i, th);
    }

    public UCKnownException(String str) {
        super(str);
        this.mCode = -99999;
    }

    public final int errCode() {
        return this.mCode;
    }

    public final String toString() {
        return this.mCode + ":" + super.toString();
    }

    public final Runnable toRunnable() {
        return new Runnable() {
            public void run() {
                throw UCKnownException.this;
            }
        };
    }

    public final Throwable getRootCause() {
        Throwable cause;
        while (cause.getCause() != null && cause.getCause() != cause) {
            cause = cause.getCause();
        }
        return cause;
    }
}
