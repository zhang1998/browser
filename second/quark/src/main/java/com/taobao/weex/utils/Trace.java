package com.taobao.weex.utils;

import android.annotation.TargetApi;

/* compiled from: ProGuard */
public class Trace {
    private static final String TAG = "Weex_Trace";
    private static final boolean sEnabled = false;
    private static final AbstractTrace sTrace = new TraceDummy();

    /* compiled from: ProGuard */
    abstract class AbstractTrace {
        abstract void beginSection(String str);

        abstract void endSection();

        private AbstractTrace() {
        }
    }

    /* compiled from: ProGuard */
    final class TraceDummy extends AbstractTrace {
        private TraceDummy() {
            super();
        }

        final void beginSection(String str) {
        }

        final void endSection() {
        }
    }

    @TargetApi(18)
    /* compiled from: ProGuard */
    final class TraceJBMR2 extends AbstractTrace {
        private TraceJBMR2() {
            super();
        }

        final void beginSection(String str) {
            android.os.Trace.beginSection(str);
        }

        final void endSection() {
            android.os.Trace.endSection();
        }
    }

    public static final boolean getTraceEnabled() {
        return sEnabled;
    }

    public static void beginSection(String str) {
        sTrace.beginSection(str);
    }

    public static void endSection() {
        sTrace.endSection();
    }
}
