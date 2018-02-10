package com.bumptech.glide.b.b;

import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.i;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public final class ap extends Exception {
    private static final StackTraceElement[] a = new StackTraceElement[0];
    private final List<Exception> b;
    private i c;
    private a d;
    private Class<?> e;

    public ap(String str) {
        this(str, Collections.emptyList());
    }

    public ap(String str, Exception exception) {
        this(str, Collections.singletonList(exception));
    }

    public ap(String str, List<Exception> list) {
        super(str);
        setStackTrace(a);
        this.b = list;
    }

    final void a(i iVar, a aVar, Class<?> cls) {
        this.c = iVar;
        this.d = aVar;
        this.e = cls;
    }

    public final Throwable fillInStackTrace() {
        return this;
    }

    public final void a(String str) {
        Log.e(str, getClass() + ": " + getMessage());
        List arrayList = new ArrayList();
        a((Exception) this, arrayList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            new StringBuilder("Root cause (").append(i + 1).append(" of ").append(size).append(")");
            arrayList.get(i);
        }
    }

    private void a(Exception exception, List<Exception> list) {
        if (exception instanceof ap) {
            for (Exception a : ((ap) exception).b) {
                a(a, (List) list);
            }
            return;
        }
        list.add(exception);
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        a((Appendable) printStream);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        a((Appendable) printWriter);
    }

    private void a(Appendable appendable) {
        a((Exception) this, appendable);
        List list = this.b;
        Appendable aoVar = new ao(appendable);
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                aoVar.append("Cause (").append(String.valueOf(i + 1)).append(" of ").append(String.valueOf(size)).append("): ");
                Exception exception = (Exception) list.get(i);
                if (exception instanceof ap) {
                    ((ap) exception).a(aoVar);
                } else {
                    a(exception, aoVar);
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final String getMessage() {
        return super.getMessage() + (this.e != null ? ", " + this.e : "") + (this.d != null ? ", " + this.d : "") + (this.c != null ? ", " + this.c : "");
    }

    private static void a(Exception exception, Appendable appendable) {
        try {
            appendable.append(exception.getClass().toString()).append(": ").append(exception.getMessage()).append('\n');
        } catch (IOException e) {
            throw new RuntimeException(exception);
        }
    }
}
