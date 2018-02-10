package com.uc.webview.export.cyclone;

import android.os.AsyncTask;
import android.os.Process;
import android.util.Pair;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

@Constant
/* compiled from: ProGuard */
public class UCLogger {
    private static final Class[] PARAMS_WITHOUT_THROWABLE = new Class[]{String.class, String.class};
    private static final Class[] PARAMS_WITH_THROWABLE = new Class[]{String.class, String.class, Throwable.class};
    private static boolean bAllowAllLevel = false;
    private static boolean bAllowAllTag = false;
    private static String sAllowLevels = "[all]";
    private static String sAllowTags = "[all]";
    private static AsyncTask<Object, Object, Object> sAsyncTask;
    private static ArrayList<Pair<Pair<String, String>, UCLogger>> sCachedLoggers;
    private static ValueCallback<Object[]> sCallbackChannel = null;
    private static boolean sEnabled = false;
    private static final ConcurrentLinkedQueue<Object[]> sLogItems = new ConcurrentLinkedQueue();
    private static Class<?> sLogcatChannel = null;
    private String mLevel;
    private String mTag;

    private UCLogger(String str, String str2) {
        this.mLevel = str;
        this.mTag = UCCyclone.logExtraTag + str2;
    }

    public static int createToken(String str, String str2) {
        Throwable th;
        if (sCachedLoggers == null) {
            synchronized (UCLogger.class) {
                if (sCachedLoggers == null) {
                    sCachedLoggers = new ArrayList(20);
                }
            }
        }
        int i = -1;
        try {
            synchronized (sCachedLoggers) {
                try {
                    int size;
                    if (sCachedLoggers.add(new Pair(new Pair(str, str2), create(str, str2)))) {
                        size = sCachedLoggers.size() - 1;
                    } else {
                        size = -1;
                    }
                    try {
                        return size;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        i = size;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    throw th;
                }
            }
        } catch (Throwable th5) {
            return i;
        }
    }

    public static boolean print(int i, String str, Throwable... thArr) {
        if (i >= 0 && sEnabled) {
            UCLogger uCLogger = (UCLogger) ((Pair) sCachedLoggers.get(i)).second;
            if (uCLogger != null) {
                uCLogger.print(str, thArr);
                return true;
            }
        }
        return false;
    }

    public static UCLogger create(String str, String str2) {
        Object obj = (!sEnabled || ((sLogcatChannel == null && sCallbackChannel == null) || !((bAllowAllLevel || sAllowLevels.contains(str)) && (bAllowAllTag || sAllowTags.contains("[" + str2 + "]"))))) ? null : 1;
        if (obj != null) {
            return new UCLogger(str, str2);
        }
        return null;
    }

    public void print(String str, Throwable... thArr) {
        if (sEnabled) {
            Object obj = (thArr == null || thArr.length <= 0 || thArr[0] == null) ? null : thArr[0];
            try {
                if (sLogcatChannel != null) {
                    UCCyclone.invoke(sLogcatChannel, this.mLevel, obj != null ? PARAMS_WITH_THROWABLE : PARAMS_WITHOUT_THROWABLE, obj != null ? new Object[]{this.mTag, str, obj} : new Object[]{this.mTag, str});
                }
            } catch (Throwable th) {
            }
            try {
                if (sCallbackChannel != null) {
                    sLogItems.add(new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), this.mLevel, this.mTag, str, obj});
                    if (sAsyncTask == null) {
                        sAsyncTask = new AsyncTask<Object, Object, Object>() {
                            protected java.lang.Object doInBackground(java.lang.Object... r7) {
                                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.uc.webview.export.cyclone.UCLogger.1.doInBackground(java.lang.Object[]):java.lang.Object. bs: [B:2:0x0007, B:16:0x0034]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                                /*
                                r6 = this;
                                r3 = 0;
                                r2 = com.uc.webview.export.cyclone.UCLogger.sCallbackChannel;
                                if (r2 != 0) goto L_0x0012;
                            L_0x0007:
                                r0 = com.uc.webview.export.cyclone.UCLogger.sLogItems;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                r0.clear();	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                            L_0x000e:
                                com.uc.webview.export.cyclone.UCLogger.sAsyncTask = r3;
                            L_0x0011:
                                return r3;
                            L_0x0012:
                                r1 = 1;
                            L_0x0013:
                                if (r1 == 0) goto L_0x000e;
                            L_0x0015:
                                r0 = com.uc.webview.export.cyclone.UCLogger.sLogItems;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                r0 = r0.poll();	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                r0 = (java.lang.Object[]) r0;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                            L_0x001f:
                                if (r0 == 0) goto L_0x002f;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                            L_0x0021:
                                r2.onReceiveValue(r0);	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                r0 = com.uc.webview.export.cyclone.UCLogger.sLogItems;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                r0 = r0.poll();	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                r0 = (java.lang.Object[]) r0;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                goto L_0x001f;
                            L_0x002f:
                                r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                                java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0051 }
                            L_0x0034:
                                r0 = com.uc.webview.export.cyclone.UCLogger.sLogItems;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                r0 = r0.peek();	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                r0 = (java.lang.Object[]) r0;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                if (r0 != 0) goto L_0x0053;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                            L_0x0040:
                                r0 = 0;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                com.uc.webview.export.cyclone.UCLogger.sAsyncTask = r0;	 Catch:{ Throwable -> 0x0047, all -> 0x004c }
                                r0 = 0;
                            L_0x0045:
                                r1 = r0;
                                goto L_0x0013;
                            L_0x0047:
                                r0 = move-exception;
                                com.uc.webview.export.cyclone.UCLogger.sAsyncTask = r3;
                                goto L_0x0011;
                            L_0x004c:
                                r0 = move-exception;
                                com.uc.webview.export.cyclone.UCLogger.sAsyncTask = r3;
                                throw r0;
                            L_0x0051:
                                r0 = move-exception;
                                goto L_0x0034;
                            L_0x0053:
                                r0 = r1;
                                goto L_0x0045;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.cyclone.UCLogger.1.doInBackground(java.lang.Object[]):java.lang.Object");
                            }
                        }.execute(new Object[0]);
                    }
                }
            } catch (Throwable th2) {
            }
        }
    }

    public static synchronized void setup(Object[] objArr) {
        synchronized (UCLogger.class) {
            int size;
            Pair pair;
            UCLogger create;
            Boolean bool = (Boolean) objArr[0];
            Boolean bool2 = (Boolean) objArr[1];
            ValueCallback valueCallback = (ValueCallback) objArr[2];
            String str = (String) objArr[3];
            String str2 = (String) objArr[4];
            if (bool == null || !bool.booleanValue()) {
                sEnabled = false;
            } else {
                sEnabled = true;
            }
            if (bool2 != null) {
                try {
                    if (bool2.booleanValue()) {
                        sLogcatChannel = bool2.booleanValue() ? Class.forName("android.util.Log") : null;
                        sCallbackChannel = valueCallback;
                        if (str == null) {
                            sAllowLevels = str;
                        } else {
                            sAllowLevels = "";
                        }
                        if (str2 == null) {
                            sAllowTags = str2;
                        } else {
                            sAllowTags = "";
                        }
                        bAllowAllLevel = sAllowLevels.contains("[all]");
                        bAllowAllTag = sAllowTags.contains("[all]");
                        if (sCachedLoggers != null) {
                            synchronized (sCachedLoggers) {
                                for (size = sCachedLoggers.size() - 1; size >= 0; size--) {
                                    pair = (Pair) sCachedLoggers.get(size);
                                    create = create((String) ((Pair) pair.first).first, (String) ((Pair) pair.first).second);
                                    if ((pair.second == null && create != null) || (pair.second != null && create == null)) {
                                        sCachedLoggers.set(size, new Pair(pair.first, create));
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                }
            }
            sLogcatChannel = null;
            sCallbackChannel = valueCallback;
            if (str == null) {
                sAllowLevels = "";
            } else {
                sAllowLevels = str;
            }
            if (str2 == null) {
                sAllowTags = "";
            } else {
                sAllowTags = str2;
            }
            bAllowAllLevel = sAllowLevels.contains("[all]");
            bAllowAllTag = sAllowTags.contains("[all]");
            try {
                if (sCachedLoggers != null) {
                    synchronized (sCachedLoggers) {
                        for (size = sCachedLoggers.size() - 1; size >= 0; size--) {
                            pair = (Pair) sCachedLoggers.get(size);
                            create = create((String) ((Pair) pair.first).first, (String) ((Pair) pair.first).second);
                            sCachedLoggers.set(size, new Pair(pair.first, create));
                        }
                    }
                }
            } catch (Throwable th2) {
            }
        }
    }
}
