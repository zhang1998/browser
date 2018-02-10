package com.uc.webview.export.internal.setup;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.taobao.weex.ui.component.ab;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.cyclone.UCLogger;
import java.lang.ref.WeakReference;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: ProGuard */
public class UCAsyncTask<RETURN_TYPE extends UCAsyncTask, CALLBACK_TYPE extends UCAsyncTask> implements Runnable {
    protected static final String EVENT_COST = "cost";
    protected static final String EVENT_DIE = "die";
    protected static final String EVENT_EXCEPTION = "exception";
    protected static final String EVENT_GONE = "gone";
    protected static final String EVENT_PAUSE = "pause";
    protected static final String EVENT_PROGRESS = "progress";
    protected static final String EVENT_RESUME = "resume";
    protected static final String EVENT_START = "start";
    protected static final String EVENT_STOP = "stop";
    protected static final String EVENT_SUCCESS = "success";
    public static final int cleanThread = 10008;
    public static final int clearSubTasks = 10012;
    public static final int getBlankString = 10011;
    public static final int getCallback = 10007;
    public static final int getCosts = 10006;
    public static final int getEvent = 10009;
    public static final int getParent = 10005;
    public static final int getParentCnt = 10010;
    public static final int getPercent = 10017;
    public static final int getPriority = 10013;
    public static final int getRootTask = 10015;
    public static final int getTaskCount = 10014;
    public static final int inThread = 10016;
    public static final int isPaused = 10018;
    private static final Boolean n = Boolean.valueOf(false);
    public static final int post = 10004;
    public static final int setCallbacks = 10002;
    public static final int setParent = 10001;
    public static final int setPriority = 10003;
    private UCAsyncTask a;
    private ConcurrentLinkedQueue<UCAsyncTask> b;
    private int c;
    private final Object d;
    private final Integer e;
    private boolean f;
    private boolean g;
    private final bf h;
    private HandlerThread i;
    private Handler j;
    private String k;
    private long l;
    private Runnable m;
    protected ConcurrentHashMap<String, ValueCallback<CALLBACK_TYPE>> mCallbacks;
    protected UCSetupException mException;
    protected UCSetupException mExtraException;
    protected boolean mHasStarted;
    protected int mPercent;
    private Vector<Pair<String, Pair<Long, Long>>> o;

    /* compiled from: ProGuard */
    public final class a<CB_TYPE extends UCAsyncTask<CB_TYPE, CB_TYPE>> implements ValueCallback<CB_TYPE> {
        final /* synthetic */ UCAsyncTask a;

        public a(UCAsyncTask uCAsyncTask) {
            this.a = uCAsyncTask;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            this.a.callback((String) ((UCAsyncTask) obj).invokeO(10009, new Object[0]));
        }
    }

    /* compiled from: ProGuard */
    public final class b<CB_TYPE extends UCAsyncTask<CB_TYPE, CB_TYPE>> implements ValueCallback<CB_TYPE> {
        final /* synthetic */ UCAsyncTask a;

        public b(UCAsyncTask uCAsyncTask) {
            this.a = uCAsyncTask;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            this.a.setException(((UCAsyncTask) obj).getException());
        }
    }

    /* compiled from: ProGuard */
    public final class c<CB_TYPE extends UCAsyncTask<CB_TYPE, CB_TYPE>> implements ValueCallback<CB_TYPE> {
        final /* synthetic */ UCAsyncTask a;

        public c(UCAsyncTask uCAsyncTask) {
            this.a = uCAsyncTask;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            this.a.stop();
        }
    }

    static /* synthetic */ int e(UCAsyncTask uCAsyncTask) {
        int i = uCAsyncTask.c + 1;
        uCAsyncTask.c = i;
        return i;
    }

    public UCAsyncTask(Integer num) {
        Vector vector;
        this.c = 0;
        this.d = new Object();
        this.f = false;
        this.g = false;
        this.h = new bf();
        this.l = 0;
        this.mHasStarted = false;
        if (n.booleanValue()) {
            vector = new Vector();
        } else {
            vector = null;
        }
        this.o = vector;
        this.e = num;
    }

    public UCAsyncTask(Runnable runnable) {
        this(Integer.valueOf(0));
        this.m = runnable;
    }

    public UCAsyncTask(UCAsyncTask uCAsyncTask) {
        this(null);
        invoke(10001, uCAsyncTask);
    }

    public final RETURN_TYPE invoke(int i, Object... objArr) {
        invokeO(i, objArr);
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeO(int r6, java.lang.Object... r7) {
        /*
        r5 = this;
        r0 = 1;
        r4 = 10005; // 0x2715 float:1.402E-41 double:4.943E-320;
        r2 = 0;
        r1 = 0;
        switch(r6) {
            case 10001: goto L_0x000a;
            case 10002: goto L_0x0011;
            case 10003: goto L_0x003a;
            case 10004: goto L_0x0046;
            case 10005: goto L_0x0084;
            case 10006: goto L_0x0087;
            case 10007: goto L_0x008a;
            case 10008: goto L_0x006e;
            case 10009: goto L_0x009f;
            case 10010: goto L_0x00a3;
            case 10011: goto L_0x00c2;
            case 10012: goto L_0x007a;
            case 10013: goto L_0x00e0;
            case 10014: goto L_0x00e4;
            case 10015: goto L_0x00f8;
            case 10016: goto L_0x010d;
            case 10017: goto L_0x011d;
            case 10018: goto L_0x0125;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = r2;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = r7[r1];
        r0 = (com.uc.webview.export.internal.setup.UCAsyncTask) r0;
        r5.a = r0;
        goto L_0x0008;
    L_0x0011:
        r0 = r7[r1];
        r0 = (java.util.concurrent.ConcurrentHashMap) r0;
        r0 = r0.entrySet();
        r3 = r0.iterator();
    L_0x001d:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0008;
    L_0x0023:
        r0 = r3.next();
        r1 = r0;
        r1 = (java.util.Map.Entry) r1;
        r0 = r1.getKey();
        r0 = (java.lang.String) r0;
        r1 = r1.getValue();
        r1 = (android.webkit.ValueCallback) r1;
        r5.onEvent(r0, r1);
        goto L_0x001d;
    L_0x003a:
        r0 = r7[r1];
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        android.os.Process.setThreadPriority(r0);
        goto L_0x0008;
    L_0x0046:
        r0 = r7[r1];
        r0 = (com.uc.webview.export.internal.setup.UCAsyncTask) r0;
        r1 = r0.a;
        if (r1 == r5) goto L_0x0056;
    L_0x004e:
        r0 = new java.lang.RuntimeException;
        r1 = "Please use \"new UCAsyncTask(parentTask).start()\" instead of \"post(new UCAsyncTask())\" to add sub task.";
        r0.<init>(r1);
        throw r0;
    L_0x0056:
        r1 = r5.d;
        monitor-enter(r1);
        r3 = r5.b;	 Catch:{ all -> 0x006b }
        if (r3 != 0) goto L_0x0064;
    L_0x005d:
        r3 = new java.util.concurrent.ConcurrentLinkedQueue;	 Catch:{ all -> 0x006b }
        r3.<init>();	 Catch:{ all -> 0x006b }
        r5.b = r3;	 Catch:{ all -> 0x006b }
    L_0x0064:
        r3 = r5.b;	 Catch:{ all -> 0x006b }
        r3.add(r0);	 Catch:{ all -> 0x006b }
        monitor-exit(r1);	 Catch:{ all -> 0x006b }
        goto L_0x0008;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r5.b = r2;
        r5.j = r2;
        r0 = r5.i;
        r0.quit();
        r5.i = r2;
        goto L_0x0008;
    L_0x007a:
        r0 = r5.b;
        if (r0 == 0) goto L_0x0008;
    L_0x007e:
        r0 = r5.b;
        r0.clear();
        goto L_0x0008;
    L_0x0084:
        r0 = r5.a;
        goto L_0x0009;
    L_0x0087:
        r0 = r5.o;
        goto L_0x0009;
    L_0x008a:
        r0 = r7[r1];
        r0 = (java.lang.String) r0;
        r1 = r5.mCallbacks;
        if (r1 != 0) goto L_0x0095;
    L_0x0092:
        r0 = r2;
        goto L_0x0009;
    L_0x0095:
        r1 = r5.mCallbacks;
        r0 = r1.get(r0);
        r0 = (android.webkit.ValueCallback) r0;
        goto L_0x0009;
    L_0x009f:
        r0 = r5.k;
        goto L_0x0009;
    L_0x00a3:
        r0 = new java.lang.Object[r1];
        r0 = r5.invokeO(r4, r0);
        r0 = (com.uc.webview.export.internal.setup.UCAsyncTask) r0;
        r3 = r0;
        r0 = r1;
    L_0x00ad:
        if (r3 == 0) goto L_0x00bc;
    L_0x00af:
        r2 = r0 + 1;
        r0 = new java.lang.Object[r1];
        r0 = r3.invokeO(r4, r0);
        r0 = (com.uc.webview.export.internal.setup.UCAsyncTask) r0;
        r3 = r0;
        r0 = r2;
        goto L_0x00ad;
    L_0x00bc:
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x0009;
    L_0x00c2:
        r0 = r7[r1];
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
    L_0x00cf:
        r1 = r0 + -1;
        if (r0 <= 0) goto L_0x00da;
    L_0x00d3:
        r0 = "    ";
        r2.append(r0);
        r0 = r1;
        goto L_0x00cf;
    L_0x00da:
        r0 = r2.toString();
        goto L_0x0009;
    L_0x00e0:
        r0 = r5.e;
        goto L_0x0009;
    L_0x00e4:
        r1 = r5.b;
        if (r1 != 0) goto L_0x00ee;
    L_0x00e8:
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x0009;
    L_0x00ee:
        r0 = r5.b;
        r0 = r0.size();
        r1 = r5.c;
        r0 = r0 + r1;
        goto L_0x00e8;
    L_0x00f8:
        r0 = new java.lang.Object[r1];
        r0 = r5.invokeO(r4, r0);
        if (r0 == 0) goto L_0x010a;
    L_0x0100:
        r0 = new java.lang.Object[r1];
        r0 = r5.invokeO(r4, r0);
        r0 = (com.uc.webview.export.internal.setup.UCAsyncTask) r0;
        r5 = r0;
        goto L_0x00f8;
    L_0x010a:
        r0 = r5;
        goto L_0x0009;
    L_0x010d:
        r2 = java.lang.Thread.currentThread();
        r3 = r5.i;
        if (r2 != r3) goto L_0x011b;
    L_0x0115:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0009;
    L_0x011b:
        r0 = r1;
        goto L_0x0115;
    L_0x011d:
        r0 = r5.mPercent;
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x0009;
    L_0x0125:
        r0 = 10015; // 0x271f float:1.4034E-41 double:4.948E-320;
        r1 = new java.lang.Object[r1];
        r0 = r5.invokeO(r0, r1);
        r0 = (com.uc.webview.export.internal.setup.UCAsyncTask) r0;
        r1 = r0.h;
        monitor-enter(r1);
        r0 = r0.h;	 Catch:{ all -> 0x013d }
        r0 = r0.a;	 Catch:{ all -> 0x013d }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x013d }
        monitor-exit(r1);	 Catch:{ all -> 0x013d }
        goto L_0x0009;
    L_0x013d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x013d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.UCAsyncTask.invokeO(int, java.lang.Object[]):java.lang.Object");
    }

    protected void callback(String str) {
        this.k = str;
        try {
            Throwable exception = getException();
            if (!"stat".equals(str)) {
                UCLogger create = UCLogger.create("d", "UCAsyncTask");
                if (create != null) {
                    StringBuilder append;
                    String uCSetupException;
                    if (!"cost".equals(str)) {
                        append = new StringBuilder("callback: ").append(invokeO(10011, (Integer) invokeO(10010, new Object[0]))).append(getClass().getSimpleName()).append(".").append(str).append(" ").append(EVENT_PROGRESS.equals(str) ? invokeO(getPercent, new Object[0]) : "");
                        uCSetupException = (!EVENT_EXCEPTION.equals(str) || exception == null) ? "" : exception.toString();
                    } else if (n.booleanValue()) {
                        append = new StringBuilder("callback: ").append(invokeO(10011, (Integer) invokeO(10010, new Object[0]))).append(getClass().getSimpleName()).append(".").append(str).append(" cost:").append(String.format("%5s", new Object[]{((Pair) ((Pair) this.o.lastElement()).second).first})).append(" cost_cpu:").append(String.format("%5s", new Object[]{((Pair) ((Pair) this.o.lastElement()).second).second})).append(" task:");
                        uCSetupException = (String) r0.first;
                    }
                    create.print(append.append(uCSetupException).toString(), new Throwable[0]);
                }
            }
            if (EVENT_EXCEPTION.equals(str) && (this instanceof UCSetupTask) && exception != null) {
                UCLogger create2 = UCLogger.create(ab.PROP_FS_WRAP_CONTENT, "UCAsyncTask");
                if (create2 != null) {
                    create2.print("callback: exception: ", exception);
                    if (exception != exception.getRootCause()) {
                        create2.print("callback: rootCause: ", exception.getRootCause());
                    }
                }
            }
        } catch (Throwable th) {
        }
        Object invokeO = invokeO(10007, str);
        if (invokeO instanceof WeakReference) {
            invokeO = ((WeakReference) invokeO).get();
        }
        if (invokeO instanceof ValueCallback) {
            try {
                ((ValueCallback) invokeO).onReceiveValue(this);
            } catch (Throwable th2) {
            }
        }
    }

    public RETURN_TYPE start() {
        synchronized (this.d) {
            if (!this.mHasStarted || (this.a == null && this.i == null)) {
                this.mHasStarted = true;
                if (this.a != null) {
                    this.a.invoke(10004, this);
                } else {
                    HandlerThread bgVar = new bg(this, UCAsyncTask.class.getSimpleName(), this.e.intValue());
                    this.i = bgVar;
                    bgVar.start();
                }
            }
        }
        return this;
    }

    public final RETURN_TYPE start(long j) {
        this.l = j;
        return start();
    }

    public RETURN_TYPE stop() {
        synchronized (this.h) {
            resume();
            this.g = true;
        }
        return this;
    }

    public RETURN_TYPE pause() {
        UCAsyncTask uCAsyncTask = (UCAsyncTask) invokeO(getRootTask, new Object[0]);
        synchronized (uCAsyncTask.h) {
            if (!uCAsyncTask.h.a) {
                uCAsyncTask.f = true;
            }
        }
        return this;
    }

    public RETURN_TYPE resume() {
        UCAsyncTask uCAsyncTask = (UCAsyncTask) invokeO(getRootTask, new Object[0]);
        synchronized (uCAsyncTask.h) {
            uCAsyncTask.f = false;
            if (uCAsyncTask.h.a) {
                uCAsyncTask.h.a(0, null);
            }
        }
        return this;
    }

    public void run() {
        if (this.m != null) {
            this.m.run();
        }
    }

    public RETURN_TYPE onEvent(String str, ValueCallback<CALLBACK_TYPE> valueCallback) {
        if (str != null) {
            if (this.mCallbacks == null) {
                synchronized (this) {
                    if (this.mCallbacks == null) {
                        this.mCallbacks = new ConcurrentHashMap();
                    }
                }
            }
            if (valueCallback == null) {
                this.mCallbacks.remove(str);
            } else {
                this.mCallbacks.put(str, valueCallback);
            }
        }
        return this;
    }

    @Reflection
    public UCSetupException getException() {
        return this.mException;
    }

    public void setException(UCSetupException uCSetupException) {
        this.mException = uCSetupException;
    }

    @Reflection
    public UCSetupException getExtraException() {
        return this.mExtraException;
    }

    public void setExtraException(UCSetupException uCSetupException) {
        this.mExtraException = uCSetupException;
    }
}
