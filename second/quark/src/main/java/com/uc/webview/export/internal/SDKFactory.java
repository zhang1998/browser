package com.uc.webview.export.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.UCMobile.Apollo.Global;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.extension.InitCallback;
import com.uc.webview.export.extension.NotAvailableUCListener;
import com.uc.webview.export.internal.android.WebViewAndroid;
import com.uc.webview.export.internal.interfaces.CommonDef;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IPreloadManager;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.SetupTask;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: ProGuard */
public final class SDKFactory {
    public static Map<String, Object> A = new HashMap();
    public static Map<String, String> B = null;
    public static String C = null;
    public static SetupTask D = null;
    static boolean E = false;
    static boolean F = false;
    static boolean G = false;
    static boolean H = false;
    private static int I = 0;
    private static IGlobalSettings J = null;
    private static IPreloadManager K = null;
    private static AbstractWebViewFactory L = new a();
    private static int M = -1;
    private static String N = null;
    private static final Object O = new Object();
    private static boolean P = false;
    public static NotAvailableUCListener a = null;
    public static ValueCallback<Pair<String, HashMap<String, String>>> b = null;
    public static ClassLoader c = SDKFactory.class.getClassLoader();
    public static UCMobileWebKit d = null;
    public static Context e = null;
    public static boolean f = false;
    public static String g = null;
    @Reflection
    public static final int getCoreType = 10020;
    @Reflection
    public static final int getGlobalSettings = 10022;
    public static int h = -1;
    @Reflection
    public static final int handlePerformanceTests = 10030;
    public static long i = 4000;
    @Reflection
    public static final int isInited = 10010;
    public static int j = 1;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static int n = 0;
    public static InitCallback o = null;
    public static boolean p = false;
    public static boolean q = false;
    public static boolean r = false;
    public static boolean s = true;
    @Reflection
    public static final int setBrowserFlag = 10009;
    @Reflection
    public static final int setCoreType = 10021;
    @Reflection
    public static final int setPreloadManager = 10059;
    @Reflection
    public static final int setWebViewFactory = 10008;
    public static String t = null;
    public static String u = null;
    public static ValueCallback<String> v = null;
    public static ValueCallback<String> w = null;
    public static ValueCallback<UCSetupException> x = null;
    public static long y = 0;
    public static Map<String, Integer> z = new HashMap();

    /* compiled from: ProGuard */
    final class a extends AbstractWebViewFactory {
        private a() {
        }

        public final IWebView createWebView(Context context, AttributeSet attributeSet, WebView webView, boolean z, int[] iArr) {
            int i;
            if (SDKFactory.e == null) {
                SDKFactory.e = context.getApplicationContext();
            }
            SDKFactory.invoke(UCMPackageInfo.getLibFilter, context);
            if (CommonDef.sOnCreateWindowType == 1 || z) {
                i = 2;
            } else if (CommonDef.sOnCreateWindowType == 2) {
                i = CoreFactory.getCoreType().intValue();
            } else {
                i = SDKFactory.I;
            }
            Log.d("SDKFactory", String.format("createWebView(forceUsSystem=%b, sOnCreateWindowType=%d)=%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(CommonDef.sOnCreateWindowType), Integer.valueOf(i)}));
            iArr[0] = i;
            if (i == 2) {
                return new WebViewAndroid(context, attributeSet, webView);
            }
            return CoreFactory.createWebView(context, attributeSet);
        }
    }

    /* compiled from: ProGuard */
    final class b extends Handler {
        private static final ConcurrentLinkedQueue<Runnable> a = new ConcurrentLinkedQueue();
        private static UCSetupException b = null;
        private static final Runnable c = new c();

        private b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (SDKFactory.a != null) {
                        SDKFactory.a.onNotAvailableUC(message.arg1);
                        SDKFactory.a = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        static void a(Runnable runnable) {
            if (runnable != null) {
                a.add(runnable);
                new b(Looper.getMainLooper()).post(c);
            }
            if (((Boolean) SDKFactory.invoke(UCMPackageInfo.hadInstallUCMobile, new Object[0])).booleanValue()) {
                if (b == null) {
                    c.run();
                }
                if (b != null) {
                    throw b;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.uc.webview.export.annotations.Reflection
    public static java.lang.Object invoke(int r12, java.lang.Object... r13) {
        /*
        r9 = 10029; // 0x272d float:1.4054E-41 double:4.955E-320;
        r7 = 0;
        r10 = 2;
        r3 = 1;
        r6 = 0;
        switch(r12) {
            case 10001: goto L_0x000a;
            case 10002: goto L_0x0018;
            case 10003: goto L_0x0029;
            case 10004: goto L_0x0042;
            case 10005: goto L_0x0123;
            case 10006: goto L_0x0142;
            case 10007: goto L_0x016a;
            case 10008: goto L_0x0182;
            case 10009: goto L_0x018a;
            case 10010: goto L_0x01ae;
            case 10011: goto L_0x01ba;
            case 10012: goto L_0x020c;
            case 10013: goto L_0x0275;
            case 10014: goto L_0x029d;
            case 10015: goto L_0x02c8;
            case 10016: goto L_0x02de;
            case 10017: goto L_0x02fa;
            case 10018: goto L_0x032b;
            case 10019: goto L_0x0347;
            case 10020: goto L_0x0363;
            case 10021: goto L_0x037a;
            case 10022: goto L_0x03ad;
            case 10023: goto L_0x03cd;
            case 10024: goto L_0x0443;
            case 10025: goto L_0x0462;
            case 10026: goto L_0x0479;
            case 10027: goto L_0x048b;
            case 10028: goto L_0x0494;
            case 10029: goto L_0x04ad;
            case 10030: goto L_0x0506;
            case 10031: goto L_0x0583;
            case 10032: goto L_0x05a6;
            case 10033: goto L_0x05ca;
            case 10034: goto L_0x0684;
            case 10035: goto L_0x0777;
            case 10036: goto L_0x0821;
            case 10037: goto L_0x08e6;
            case 10038: goto L_0x094a;
            case 10039: goto L_0x09dd;
            case 10040: goto L_0x0b19;
            case 10041: goto L_0x051f;
            case 10042: goto L_0x056f;
            case 10043: goto L_0x0577;
            case 10044: goto L_0x063c;
            case 10045: goto L_0x0b39;
            case 10046: goto L_0x01dc;
            case 10047: goto L_0x0136;
            case 10048: goto L_0x0c3c;
            case 10049: goto L_0x00c8;
            case 10050: goto L_0x013a;
            case 10051: goto L_0x0c76;
            case 10052: goto L_0x0c7a;
            case 10053: goto L_0x008f;
            case 10054: goto L_0x0316;
            case 10055: goto L_0x0c9a;
            case 10056: goto L_0x0cb5;
            case 10057: goto L_0x0cd2;
            case 10058: goto L_0x0ce9;
            case 10059: goto L_0x0cfd;
            case 10060: goto L_0x0d05;
            case 10061: goto L_0x0d18;
            case 10062: goto L_0x0d31;
            case 10063: goto L_0x0d4a;
            default: goto L_0x0009;
        };
    L_0x0009:
        return r7;
    L_0x000a:
        r0 = r13[r6];
        r0 = (java.lang.Long) r0;
        r0 = r0.longValue();
        r2 = y;
        r0 = r0 | r2;
        y = r0;
        goto L_0x0009;
    L_0x0018:
        r0 = r13[r6];
        r0 = (java.lang.Long) r0;
        r0 = r0.longValue();
        r2 = y;
        r4 = -1;
        r0 = r0 ^ r4;
        r0 = r0 & r2;
        y = r0;
        goto L_0x0009;
    L_0x0029:
        r0 = r13[r6];
        r0 = (java.lang.Long) r0;
        r0 = r0.longValue();
        r4 = y;
        r0 = r0 & r4;
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x0040;
    L_0x003a:
        r0 = r3;
    L_0x003b:
        r7 = java.lang.Boolean.valueOf(r0);
        goto L_0x0009;
    L_0x0040:
        r0 = r6;
        goto L_0x003b;
    L_0x0042:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x005d;
    L_0x0048:
        r1 = "JSON_CD";
        r1 = r0.startsWith(r1);
        if (r1 != 0) goto L_0x005d;
    L_0x0050:
        r1 = "JSON_CD";
        r1 = r0.indexOf(r1);
        r2 = -1;
        if (r1 == r2) goto L_0x005d;
    L_0x0059:
        r0 = r0.substring(r1);
    L_0x005d:
        r1 = com.uc.webview.export.internal.utility.d.a(r0);
        if (r1 != 0) goto L_0x0009;
    L_0x0063:
        r1 = "JSON_CD";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x0009;
    L_0x006b:
        r1 = "pub_key";
        r1 = r0.contains(r1);
        if (r1 == 0) goto L_0x0009;
    L_0x0073:
        N = r0;
        r1 = "com.uc.webview.export.cd.Utils";
        r2 = "addParamCD";
        r3 = 1;
        r3 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x008c }
        r4 = 0;
        r5 = java.lang.String.class;
        r3[r4] = r5;	 Catch:{ Exception -> 0x008c }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x008c }
        r5 = 0;
        r4[r5] = r0;	 Catch:{ Exception -> 0x008c }
        com.uc.webview.export.internal.utility.ReflectionUtil.invoke(r1, r2, r3, r4);	 Catch:{ Exception -> 0x008c }
        goto L_0x0009;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0009;
    L_0x008f:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = com.uc.webview.export.internal.utility.d.a(r0);
        if (r1 != 0) goto L_0x0009;
    L_0x0099:
        r1 = "pub_key";
        r1 = r0.contains(r1);
        if (r1 == 0) goto L_0x0009;
    L_0x00a1:
        r1 = 1;
        r1 = r13[r1];	 Catch:{ Exception -> 0x0d99 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0d99 }
        r2 = "com.uc.webview.export.cd.Utils";
        r3 = "addMiddlewareCD";
        r4 = 2;
        r4 = new java.lang.Class[r4];	 Catch:{ Exception -> 0x00c5 }
        r5 = 0;
        r6 = java.lang.String.class;
        r4[r5] = r6;	 Catch:{ Exception -> 0x00c5 }
        r5 = 1;
        r6 = java.lang.String.class;
        r4[r5] = r6;	 Catch:{ Exception -> 0x00c5 }
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00c5 }
        r6 = 0;
        r5[r6] = r0;	 Catch:{ Exception -> 0x00c5 }
        r0 = 1;
        r5[r0] = r1;	 Catch:{ Exception -> 0x00c5 }
        com.uc.webview.export.internal.utility.ReflectionUtil.invoke(r2, r3, r4, r5);	 Catch:{ Exception -> 0x00c5 }
        goto L_0x0009;
    L_0x00c5:
        r0 = move-exception;
        goto L_0x0009;
    L_0x00c8:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = com.uc.webview.export.internal.utility.d.a(r0);
        if (r1 == 0) goto L_0x00d6;
    L_0x00d2:
        B = r7;
        goto L_0x0009;
    L_0x00d6:
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = ";";
        r2 = r0.split(r2);
        r4 = r2.length;
        r0 = r6;
    L_0x00e3:
        if (r0 >= r4) goto L_0x00fe;
    L_0x00e5:
        r5 = r2[r0];
        r8 = "=";
        r5 = r5.split(r8);
        r8 = r5.length;
        if (r8 != r10) goto L_0x00fb;
    L_0x00f0:
        r8 = r5[r6];
        r8 = r8.trim();
        r5 = r5[r3];
        r1.put(r8, r5);
    L_0x00fb:
        r0 = r0 + 1;
        goto L_0x00e3;
    L_0x00fe:
        r0 = "tag_test_log";
        r2 = new java.lang.StringBuilder;
        r3 = "CDParam:";
        r2.<init>(r3);
        r2 = r2.append(r1);
        r2 = r2.toString();
        com.uc.webview.export.internal.utility.Log.i(r0, r2);
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x011a;
    L_0x0118:
        B = r1;
    L_0x011a:
        r0 = 10033; // 0x2731 float:1.4059E-41 double:4.957E-320;
        r1 = new java.lang.Object[r6];
        invoke(r0, r1);
        goto L_0x0009;
    L_0x0123:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = B;
        if (r1 == 0) goto L_0x0009;
    L_0x012b:
        r1 = B;
        r0 = r1.get(r0);
        r0 = (java.lang.String) r0;
        r7 = r0;
        goto L_0x0009;
    L_0x0136:
        r7 = N;
        goto L_0x0009;
    L_0x013a:
        r0 = q;
        r7 = java.lang.Boolean.valueOf(r0);
        goto L_0x0009;
    L_0x0142:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = r13[r3];
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        r2 = 10005; // 0x2715 float:1.402E-41 double:4.943E-320;
        r3 = new java.lang.Object[r3];
        r3[r6] = r0;
        r0 = invoke(r2, r3);
        r0 = (java.lang.String) r0;
        if (r0 != 0) goto L_0x0163;
    L_0x015c:
        r0 = r1;
    L_0x015d:
        r7 = java.lang.Boolean.valueOf(r0);
        goto L_0x0009;
    L_0x0163:
        r1 = "true";
        r0 = r1.equalsIgnoreCase(r0);
        goto L_0x015d;
    L_0x016a:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = B;
        if (r1 == 0) goto L_0x0180;
    L_0x0172:
        r1 = B;
        r0 = r1.containsKey(r0);
        if (r0 == 0) goto L_0x0180;
    L_0x017a:
        r7 = java.lang.Boolean.valueOf(r3);
        goto L_0x0009;
    L_0x0180:
        r3 = r6;
        goto L_0x017a;
    L_0x0182:
        r0 = r13[r6];
        r0 = (com.uc.webview.export.internal.AbstractWebViewFactory) r0;
        L = r0;
        goto L_0x0009;
    L_0x018a:
        f = r3;
        r0 = "i";
        r1 = "SDKFactory";
        r0 = com.uc.webview.export.cyclone.UCLogger.create(r0, r1);
        if (r0 == 0) goto L_0x0009;
    L_0x0196:
        r1 = new java.lang.StringBuilder;
        r2 = "setBrowserFlag: sIsBrowser=";
        r1.<init>(r2);
        r2 = f;
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = new java.lang.Throwable[r6];
        r0.print(r1, r2);
        goto L_0x0009;
    L_0x01ae:
        r0 = I;
        if (r0 == 0) goto L_0x01b8;
    L_0x01b2:
        r7 = java.lang.Boolean.valueOf(r3);
        goto L_0x0009;
    L_0x01b8:
        r3 = r6;
        goto L_0x01b2;
    L_0x01ba:
        r0 = 10010; // 0x271a float:1.4027E-41 double:4.9456E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x01da;
    L_0x01ca:
        r0 = com.uc.webview.export.internal.SDKFactory.b.a;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x01da;
    L_0x01d4:
        r7 = java.lang.Boolean.valueOf(r3);
        goto L_0x0009;
    L_0x01da:
        r3 = r6;
        goto L_0x01d4;
    L_0x01dc:
        r0 = 10010; // 0x271a float:1.4027E-41 double:4.9456E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x01f4;
    L_0x01ec:
        r0 = new java.lang.RuntimeException;
        r1 = "UC WebView Sdk not inited.";
        r0.<init>(r1);
        throw r0;
    L_0x01f4:
        r0 = 10020; // 0x2724 float:1.4041E-41 double:4.9505E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 != r10) goto L_0x0208;
    L_0x0204:
        r7 = "System WebView";
        goto L_0x0009;
    L_0x0208:
        r7 = g;
        goto L_0x0009;
    L_0x020c:
        com.uc.webview.export.internal.setup.z.a();
        r1 = r13[r6];
        r1 = (android.content.Context) r1;
        r2 = r13[r3];
        r2 = (android.util.AttributeSet) r2;
        r3 = r13[r10];
        r3 = (com.uc.webview.export.WebView) r3;
        r0 = 3;
        r0 = r13[r0];
        r0 = (java.lang.Boolean) r0;
        r4 = r0.booleanValue();
        r0 = 4;
        r0 = r13[r0];
        r0 = (java.lang.Boolean) r0;
        r8 = r0.booleanValue();
        r0 = 5;
        r5 = r13[r0];
        r5 = (int[]) r5;
        r0 = e;
        if (r0 != 0) goto L_0x023c;
    L_0x0236:
        r0 = r1.getApplicationContext();
        e = r0;
    L_0x023c:
        if (r8 != 0) goto L_0x0247;
    L_0x023e:
        r0 = f;
        if (r0 == 0) goto L_0x0247;
    L_0x0242:
        r0 = new java.lang.Object[r6];
        invoke(r9, r0);
    L_0x0247:
        r0 = b;
        if (r0 == 0) goto L_0x0257;
    L_0x024b:
        r0 = b;
        r6 = new android.util.Pair;
        r9 = "sdk_wv_b";
        r6.<init>(r9, r7);
        r0.onReceiveValue(r6);
    L_0x0257:
        r0 = L;
        r0 = r0.createWebView(r1, r2, r3, r4, r5);
        r1 = b;
        if (r1 == 0) goto L_0x026d;
    L_0x0261:
        r1 = b;
        r2 = new android.util.Pair;
        r3 = "sdk_wv_a";
        r2.<init>(r3, r7);
        r1.onReceiveValue(r2);
    L_0x026d:
        if (r8 != 0) goto L_0x0272;
    L_0x026f:
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.upload();
    L_0x0272:
        r7 = r0;
        goto L_0x0009;
    L_0x0275:
        r0 = r13[r6];
        r0 = (android.content.Context) r0;
        r1 = r13[r3];
        r1 = (com.uc.webview.export.internal.interfaces.IWebView) r1;
        r2 = r13[r10];
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r3 = e;
        if (r3 != 0) goto L_0x028f;
    L_0x0289:
        r0 = r0.getApplicationContext();
        e = r0;
    L_0x028f:
        r0 = new java.lang.Object[r6];
        invoke(r9, r0);
        if (r2 == r10) goto L_0x0009;
    L_0x0296:
        r7 = new com.uc.webview.export.extension.UCExtension;
        r7.<init>(r1);
        goto L_0x0009;
    L_0x029d:
        r0 = r13[r6];
        r0 = (java.lang.Integer) r0;
        r1 = r0.intValue();
        r0 = r13[r3];
        r0 = (android.content.Context) r0;
        r2 = e;
        if (r2 != 0) goto L_0x02b3;
    L_0x02ad:
        r2 = r0.getApplicationContext();
        e = r2;
    L_0x02b3:
        r2 = new java.lang.Object[r6];
        invoke(r9, r2);
        if (r1 != r10) goto L_0x02c1;
    L_0x02ba:
        r7 = new com.uc.webview.export.internal.android.v;
        r7.<init>();
        goto L_0x0009;
    L_0x02c1:
        r7 = new com.uc.webview.export.internal.uc.c;
        r7.<init>(r0);
        goto L_0x0009;
    L_0x02c8:
        r0 = 10020; // 0x2724 float:1.4041E-41 double:4.9505E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 == r10) goto L_0x0009;
    L_0x02d8:
        r7 = com.uc.webview.export.internal.uc.CoreFactory.getUCMobileWebKit();
        goto L_0x0009;
    L_0x02de:
        r0 = r13[r6];
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r1 = new java.lang.Object[r6];
        invoke(r9, r1);
        if (r0 != r10) goto L_0x02f4;
    L_0x02ed:
        r7 = new com.uc.webview.export.internal.android.q;
        r7.<init>();
        goto L_0x0009;
    L_0x02f4:
        r7 = com.uc.webview.export.internal.uc.CoreFactory.n();
        goto L_0x0009;
    L_0x02fa:
        r0 = r13[r6];
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r1 = new java.lang.Object[r6];
        invoke(r9, r1);
        if (r0 != r10) goto L_0x0310;
    L_0x0309:
        r7 = new com.uc.webview.export.internal.android.CookieManagerAndroid;
        r7.<init>();
        goto L_0x0009;
    L_0x0310:
        r7 = com.uc.webview.export.internal.uc.CoreFactory.getCookieManager();
        goto L_0x0009;
    L_0x0316:
        r0 = r13[r6];
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r1 = new java.lang.Object[r6];
        invoke(r9, r1);
        if (r0 == r10) goto L_0x0009;
    L_0x0325:
        r7 = com.uc.webview.export.internal.uc.CoreFactory.getServiceWorkerController();
        goto L_0x0009;
    L_0x032b:
        r0 = r13[r6];
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r1 = new java.lang.Object[r6];
        invoke(r9, r1);
        if (r0 != r10) goto L_0x0341;
    L_0x033a:
        r7 = new com.uc.webview.export.internal.android.b;
        r7.<init>();
        goto L_0x0009;
    L_0x0341:
        r7 = com.uc.webview.export.internal.uc.CoreFactory.m();
        goto L_0x0009;
    L_0x0347:
        r0 = r13[r6];
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r1 = new java.lang.Object[r6];
        invoke(r9, r1);
        if (r0 != r10) goto L_0x035d;
    L_0x0356:
        r7 = new com.uc.webview.export.internal.android.f;
        r7.<init>();
        goto L_0x0009;
    L_0x035d:
        r7 = com.uc.webview.export.internal.uc.CoreFactory.o();
        goto L_0x0009;
    L_0x0363:
        r0 = new java.lang.Object[r6];
        invoke(r9, r0);
        r0 = I;
        if (r0 != 0) goto L_0x0372;
    L_0x036c:
        r7 = java.lang.Integer.valueOf(r3);
        goto L_0x0009;
    L_0x0372:
        r0 = I;
        r7 = java.lang.Integer.valueOf(r0);
        goto L_0x0009;
    L_0x037a:
        r0 = r13[r6];
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 == 0) goto L_0x0009;
    L_0x0384:
        I = r0;
        r1 = 10025; // 0x2729 float:1.4048E-41 double:4.953E-320;
        r2 = new java.lang.Object[r6];
        invoke(r1, r2);
        r1 = "i";
        r2 = "SDKFactory";
        r1 = com.uc.webview.export.cyclone.UCLogger.create(r1, r2);
        if (r1 == 0) goto L_0x0009;
    L_0x0397:
        r2 = new java.lang.StringBuilder;
        r3 = "setCoreType: type=";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r2 = new java.lang.Throwable[r6];
        r1.print(r0, r2);
        goto L_0x0009;
    L_0x03ad:
        r0 = J;
        if (r0 == 0) goto L_0x03b5;
    L_0x03b1:
        r7 = J;
        goto L_0x0009;
    L_0x03b5:
        r0 = 10020; // 0x2724 float:1.4041E-41 double:4.9505E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 == r10) goto L_0x0009;
    L_0x03c5:
        r7 = com.uc.webview.export.internal.uc.CoreFactory.l();
        J = r7;
        goto L_0x0009;
    L_0x03cd:
        r0 = G;
        if (r0 == 0) goto L_0x03db;
    L_0x03d1:
        r0 = android.os.Looper.myLooper();
        r1 = android.os.Looper.getMainLooper();
        if (r0 == r1) goto L_0x0009;
    L_0x03db:
        r0 = r13[r6];
        r0 = (android.content.Context) r0;
        r1 = e;
        if (r1 != 0) goto L_0x03e9;
    L_0x03e3:
        r1 = r0.getApplicationContext();
        e = r1;
    L_0x03e9:
        r1 = f;
        if (r1 != 0) goto L_0x0009;
    L_0x03ed:
        r1 = 10010; // 0x271a float:1.4027E-41 double:4.9456E-320;
        r2 = new java.lang.Object[r6];
        r1 = invoke(r1, r2);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 != 0) goto L_0x0009;
    L_0x03fd:
        r1 = com.uc.webview.export.internal.SDKFactory.class;
        monitor-enter(r1);
        r2 = p;	 Catch:{ all -> 0x0440 }
        if (r2 != 0) goto L_0x040d;
    L_0x0404:
        r2 = D;	 Catch:{ all -> 0x0440 }
        if (r2 == 0) goto L_0x0417;
    L_0x0408:
        r0 = D;	 Catch:{ all -> 0x0440 }
        r0.start();	 Catch:{ all -> 0x0440 }
    L_0x040d:
        monitor-exit(r1);	 Catch:{ all -> 0x0440 }
        r0 = 10045; // 0x273d float:1.4076E-41 double:4.963E-320;
        r1 = new java.lang.Object[r6];
        invoke(r0, r1);
        goto L_0x0009;
    L_0x0417:
        r2 = new com.uc.webview.export.internal.setup.ba;	 Catch:{ all -> 0x0440 }
        r2.<init>();	 Catch:{ all -> 0x0440 }
        r3 = "CONTEXT";
        r0 = r0.getApplicationContext();	 Catch:{ all -> 0x0440 }
        r0 = r2.setup(r3, r0);	 Catch:{ all -> 0x0440 }
        r0 = (com.uc.webview.export.internal.setup.s) r0;	 Catch:{ all -> 0x0440 }
        r2 = "AC";
        r3 = "true";
        r0 = r0.setup(r2, r3);	 Catch:{ all -> 0x0440 }
        r0 = (com.uc.webview.export.internal.setup.s) r0;	 Catch:{ all -> 0x0440 }
        r2 = "VIDEO_AC";
        r3 = "false";
        r0 = r0.setup(r2, r3);	 Catch:{ all -> 0x0440 }
        r0 = (com.uc.webview.export.internal.setup.s) r0;	 Catch:{ all -> 0x0440 }
        r0.start();	 Catch:{ all -> 0x0440 }
        goto L_0x040d;
    L_0x0440:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0440 }
        throw r0;
    L_0x0443:
        r0 = r13[r6];
        r0 = (java.lang.Long) r0;
        r0 = r0.longValue();
        r2 = O;
        monitor-enter(r2);
        r3 = O;	 Catch:{ Exception -> 0x0459 }
        r3.wait(r0);	 Catch:{ Exception -> 0x0459 }
    L_0x0453:
        monitor-exit(r2);	 Catch:{ all -> 0x0456 }
        goto L_0x0009;
    L_0x0456:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0456 }
        throw r0;
    L_0x0459:
        r0 = move-exception;
        r1 = "tag_test_log";
        r3 = "getLock";
        com.uc.webview.export.internal.utility.Log.i(r1, r3, r0);	 Catch:{ all -> 0x0456 }
        goto L_0x0453;
    L_0x0462:
        r1 = O;
        monitor-enter(r1);
        r0 = O;	 Catch:{ Exception -> 0x0470 }
        r0.notifyAll();	 Catch:{ Exception -> 0x0470 }
    L_0x046a:
        monitor-exit(r1);	 Catch:{ all -> 0x046d }
        goto L_0x0009;
    L_0x046d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x046d }
        throw r0;
    L_0x0470:
        r0 = move-exception;
        r2 = "tag_test_log";
        r3 = "releaseLock";
        com.uc.webview.export.internal.utility.Log.i(r2, r3, r0);	 Catch:{ all -> 0x046d }
        goto L_0x046a;
    L_0x0479:
        r0 = android.os.Looper.getMainLooper();
        r1 = android.os.Looper.myLooper();
        if (r0 != r1) goto L_0x0489;
    L_0x0483:
        r7 = java.lang.Boolean.valueOf(r3);
        goto L_0x0009;
    L_0x0489:
        r3 = r6;
        goto L_0x0483;
    L_0x048b:
        r0 = r13[r6];
        r0 = (java.lang.Runnable) r0;
        com.uc.webview.export.internal.SDKFactory.b.a(r0);
        goto L_0x0009;
    L_0x0494:
        r0 = r13[r6];
        r0 = (android.content.Context) r0;
        r1 = e;
        if (r1 != 0) goto L_0x04a2;
    L_0x049c:
        r1 = r0.getApplicationContext();
        e = r1;
    L_0x04a2:
        r1 = P;
        if (r1 != 0) goto L_0x0009;
    L_0x04a6:
        com.uc.webview.export.internal.uc.wa.a.a(r0);
        P = r3;
        goto L_0x0009;
    L_0x04ad:
        r0 = H;
        if (r0 == 0) goto L_0x04bb;
    L_0x04b1:
        r0 = android.os.Looper.myLooper();
        r1 = android.os.Looper.getMainLooper();
        if (r0 == r1) goto L_0x0009;
    L_0x04bb:
        r0 = 10011; // 0x271b float:1.4028E-41 double:4.946E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0009;
    L_0x04cb:
        r0 = f;
        if (r0 == 0) goto L_0x04e8;
    L_0x04cf:
        r0 = 10010; // 0x271a float:1.4027E-41 double:4.9456E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x04e8;
    L_0x04df:
        r0 = o;
        if (r0 == 0) goto L_0x04e8;
    L_0x04e3:
        r0 = o;
        r0.notInit();
    L_0x04e8:
        r0 = f;
        if (r0 == 0) goto L_0x04f0;
    L_0x04ec:
        r0 = com.uc.webview.export.Build.IS_INTERNATIONAL_VERSION;
        if (r0 != 0) goto L_0x0009;
    L_0x04f0:
        r0 = p;
        if (r0 != 0) goto L_0x04fd;
    L_0x04f4:
        r0 = D;
        if (r0 == 0) goto L_0x04fd;
    L_0x04f8:
        r0 = D;
        r0.start();
    L_0x04fd:
        r0 = 10045; // 0x273d float:1.4076E-41 double:4.963E-320;
        r1 = new java.lang.Object[r6];
        invoke(r0, r1);
        goto L_0x0009;
    L_0x0506:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = 10020; // 0x2724 float:1.4041E-41 double:4.9505E-320;
        r2 = new java.lang.Object[r6];
        r1 = invoke(r1, r2);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        if (r1 == r10) goto L_0x0009;
    L_0x051a:
        com.uc.webview.export.internal.uc.CoreFactory.a(r0);
        goto L_0x0009;
    L_0x051f:
        r0 = 10020; // 0x2724 float:1.4041E-41 double:4.9505E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 == r10) goto L_0x0009;
    L_0x052f:
        r0 = 10015; // 0x271f float:1.4034E-41 double:4.948E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (com.uc.webview.export.internal.interfaces.UCMobileWebKit) r0;
        r1 = r0.getClass();	 Catch:{ Throwable -> 0x0565 }
        r2 = "sTrafficSent";
        r1 = r1.getField(r2);	 Catch:{ Throwable -> 0x0565 }
        r2 = r1.getLong(r0);	 Catch:{ Throwable -> 0x0565 }
        r1 = r0.getClass();	 Catch:{ Throwable -> 0x0565 }
        r4 = "sTrafficReceived";
        r1 = r1.getField(r4);	 Catch:{ Throwable -> 0x0565 }
        r4 = r1.getLong(r0);	 Catch:{ Throwable -> 0x0565 }
        r0 = new android.util.Pair;	 Catch:{ Throwable -> 0x0565 }
        r1 = java.lang.Long.valueOf(r2);	 Catch:{ Throwable -> 0x0565 }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x0565 }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0565 }
        r7 = r0;
        goto L_0x0009;
    L_0x0565:
        r0 = move-exception;
        r1 = "tag_test_log";
        r2 = "getTraffic";
        com.uc.webview.export.internal.utility.Log.d(r1, r2, r0);
        goto L_0x0009;
    L_0x056f:
        r0 = M;
        r7 = java.lang.Integer.valueOf(r0);
        goto L_0x0009;
    L_0x0577:
        r0 = r13[r6];
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        M = r0;
        goto L_0x0009;
    L_0x0583:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = 10020; // 0x2724 float:1.4041E-41 double:4.9505E-320;
        r2 = new java.lang.Object[r6];
        r1 = invoke(r1, r2);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        if (r1 == r10) goto L_0x0009;
    L_0x0597:
        r7 = com.uc.webview.export.internal.uc.CoreFactory.b(r0);	 Catch:{ Throwable -> 0x059d }
        goto L_0x0009;
    L_0x059d:
        r0 = move-exception;
        r0 = new java.lang.RuntimeException;
        r1 = "The getResponseByUrl() is not support in this version.";
        r0.<init>(r1);
        throw r0;
    L_0x05a6:
        r0 = r13[r6];
        r0 = (android.content.Context) r0;
        r1 = r13[r3];
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r2 = e;
        if (r2 != 0) goto L_0x05bc;
    L_0x05b6:
        r2 = r0.getApplicationContext();
        e = r2;
    L_0x05bc:
        r2 = new java.lang.Object[r6];
        invoke(r9, r2);
        if (r1 != r10) goto L_0x0009;
    L_0x05c3:
        r7 = new com.uc.webview.export.internal.android.u;
        r7.<init>(r0);
        goto L_0x0009;
    L_0x05ca:
        r0 = 10006; // 0x2716 float:1.4021E-41 double:4.9436E-320;
        r1 = new java.lang.Object[r10];
        r2 = "apollo";
        r1[r6] = r2;
        r2 = java.lang.Boolean.valueOf(r3);
        r1[r3] = r2;
        r0 = invoke(r0, r1);
        r0 = (java.lang.Boolean) r0;
        r1 = r0.booleanValue();
        if (r1 != 0) goto L_0x0622;
    L_0x05e4:
        r0 = 10001; // 0x2711 float:1.4014E-41 double:4.941E-320;
        r2 = new java.lang.Object[r3];
        r4 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r3 = java.lang.Long.valueOf(r4);
        r2[r6] = r3;
        invoke(r0, r2);
    L_0x05f4:
        r0 = 10010; // 0x271a float:1.4027E-41 double:4.9456E-320;
        r2 = new java.lang.Object[r6];
        r0 = invoke(r0, r2);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0009;
    L_0x0604:
        r0 = 10022; // 0x2726 float:1.4044E-41 double:4.9515E-320;
        r2 = new java.lang.Object[r6];
        r0 = invoke(r0, r2);
        r0 = (com.uc.webview.export.internal.interfaces.IGlobalSettings) r0;
        if (r0 == 0) goto L_0x0009;
    L_0x0610:
        if (r1 != 0) goto L_0x0633;
    L_0x0612:
        r1 = "tag_test_log";
        r2 = "sdk cd forbid apollo";
        com.uc.webview.export.internal.utility.Log.i(r1, r2);
        r1 = "sdk_apollo_forbid";
        r2 = "1";
        r0.setStringValue(r1, r2);
        goto L_0x0009;
    L_0x0622:
        r0 = 10002; // 0x2712 float:1.4016E-41 double:4.9416E-320;
        r2 = new java.lang.Object[r3];
        r4 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r3 = java.lang.Long.valueOf(r4);
        r2[r6] = r3;
        invoke(r0, r2);
        goto L_0x05f4;
    L_0x0633:
        r1 = "sdk_apollo_forbid";
        r2 = "0";
        r0.setStringValue(r1, r2);
        goto L_0x0009;
    L_0x063c:
        r0 = r13[r6];
        r0 = (java.util.Map) r0;
        if (r0 == 0) goto L_0x0660;
    L_0x0642:
        r1 = "ucPlayerRoot";
        r1 = r0.get(r1);
        if (r1 == 0) goto L_0x0650;
    L_0x064a:
        r1 = r1.toString();
        t = r1;
    L_0x0650:
        r1 = "ucPlayer";
        r0 = r0.get(r1);
        if (r0 == 0) goto L_0x0660;
    L_0x0658:
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        s = r0;
    L_0x0660:
        r0 = "tag_test_log";
        r1 = new java.lang.StringBuilder;
        r2 = "sUseUCPlayer:";
        r1.<init>(r2);
        r2 = s;
        r1 = r1.append(r2);
        r2 = ",sUCPlayerSoRoot:";
        r1 = r1.append(r2);
        r2 = t;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.uc.webview.export.internal.utility.Log.d(r0, r1);
        goto L_0x0009;
    L_0x0684:
        r0 = r13[r6];
        r0 = (android.content.Context) r0;
        r1 = e;
        if (r1 != 0) goto L_0x0692;
    L_0x068c:
        r1 = r0.getApplicationContext();
        e = r1;
    L_0x0692:
        r1 = s;
        if (r1 == 0) goto L_0x0009;
    L_0x0696:
        r1 = E;
        if (r1 != 0) goto L_0x0009;
    L_0x069a:
        r1 = 10010; // 0x271a float:1.4027E-41 double:4.9456E-320;
        r2 = new java.lang.Object[r6];
        r1 = invoke(r1, r2);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x0009;
    L_0x06aa:
        r1 = I;
        if (r1 == r10) goto L_0x0009;
    L_0x06ae:
        r1 = 10036; // 0x2734 float:1.4063E-41 double:4.9584E-320;
        r2 = new java.lang.Object[r3];
        r2[r6] = r0;
        r0 = invoke(r1, r2);
        r0 = (java.io.File) r0;
        if (r0 == 0) goto L_0x0009;
    L_0x06bc:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r0.getAbsolutePath();
        r1 = r1.append(r2);
        r2 = "/";
        r1 = r1.append(r2);
        r2 = r1.toString();
        r1 = "tag_test_log";
        r3 = new java.lang.StringBuilder;
        r4 = "ucPlayerDir:";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.uc.webview.export.internal.utility.Log.d(r1, r3);
        r1 = "com.uc.apollo.Settings";
        r3 = 1;
        r4 = c;	 Catch:{ Throwable -> 0x0728, all -> 0x0772 }
        r1 = java.lang.Class.forName(r1, r3, r4);	 Catch:{ Throwable -> 0x0728, all -> 0x0772 }
        r3 = "setApolloSoPath";
        r4 = 1;
        r4 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0728, all -> 0x0772 }
        r5 = 0;
        r6 = java.lang.String.class;
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0728, all -> 0x0772 }
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0728, all -> 0x0772 }
        r6 = 0;
        r5[r6] = r2;	 Catch:{ Throwable -> 0x0728, all -> 0x0772 }
        com.uc.webview.export.internal.utility.ReflectionUtil.invoke(r1, r3, r4, r5);	 Catch:{ Throwable -> 0x0728, all -> 0x0772 }
    L_0x0703:
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0763, all -> 0x076a }
        r3 = ".lock";
        r1.<init>(r0, r3);	 Catch:{ Throwable -> 0x0763, all -> 0x076a }
        r0 = r1.exists();	 Catch:{ Throwable -> 0x0763, all -> 0x076a }
        if (r0 != 0) goto L_0x0da5;
    L_0x0710:
        r0 = new java.io.FileWriter;	 Catch:{ Throwable -> 0x0763, all -> 0x076a }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0763, all -> 0x076a }
        r1 = "2.6.0.167";
        r0.write(r1);	 Catch:{ Throwable -> 0x0d96, all -> 0x0d90 }
        r1 = r0;
    L_0x071b:
        com.uc.webview.export.cyclone.UCCyclone.close(r1);	 Catch:{ Throwable -> 0x0770 }
    L_0x071e:
        u = r2;	 Catch:{ Throwable -> 0x0770 }
        r0 = 1;
        E = r0;	 Catch:{ Throwable -> 0x0770 }
        com.uc.webview.export.cyclone.UCCyclone.close(r1);
        goto L_0x0009;
    L_0x0728:
        r1 = move-exception;
        r1 = "com.uc.media.interfaces.IApolloHelper$Global";
        r3 = 1;
        r4 = c;	 Catch:{ Throwable -> 0x0746, all -> 0x0772 }
        r1 = java.lang.Class.forName(r1, r3, r4);	 Catch:{ Throwable -> 0x0746, all -> 0x0772 }
        r3 = "setApolloSoPath";
        r4 = 1;
        r4 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0746, all -> 0x0772 }
        r5 = 0;
        r6 = java.lang.String.class;
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0746, all -> 0x0772 }
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0746, all -> 0x0772 }
        r6 = 0;
        r5[r6] = r2;	 Catch:{ Throwable -> 0x0746, all -> 0x0772 }
        com.uc.webview.export.internal.utility.ReflectionUtil.invoke(r1, r3, r4, r5);	 Catch:{ Throwable -> 0x0746, all -> 0x0772 }
        goto L_0x0703;
    L_0x0746:
        r0 = move-exception;
        r1 = r7;
    L_0x0748:
        r2 = "tag_test_log";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0d81 }
        r4 = "setupForUCPlayer:";
        r3.<init>(r4);	 Catch:{ all -> 0x0d81 }
        r4 = c;	 Catch:{ all -> 0x0d81 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0d81 }
        r3 = r3.toString();	 Catch:{ all -> 0x0d81 }
        com.uc.webview.export.internal.utility.Log.d(r2, r3, r0);	 Catch:{ all -> 0x0d81 }
        com.uc.webview.export.cyclone.UCCyclone.close(r1);
        goto L_0x0009;
    L_0x0763:
        r0 = move-exception;
        r0 = r7;
    L_0x0765:
        com.uc.webview.export.cyclone.UCCyclone.close(r0);	 Catch:{ Throwable -> 0x0d8a, all -> 0x0d85 }
        r1 = r0;
        goto L_0x071e;
    L_0x076a:
        r0 = move-exception;
        r1 = r7;
    L_0x076c:
        com.uc.webview.export.cyclone.UCCyclone.close(r1);	 Catch:{ Throwable -> 0x0770 }
        throw r0;	 Catch:{ Throwable -> 0x0770 }
    L_0x0770:
        r0 = move-exception;
        goto L_0x0748;
    L_0x0772:
        r0 = move-exception;
    L_0x0773:
        com.uc.webview.export.cyclone.UCCyclone.close(r7);
        throw r0;
    L_0x0777:
        r0 = r13[r6];
        r0 = (android.content.Context) r0;
        r1 = r13[r3];
        r1 = (java.lang.String) r1;
        r2 = e;
        if (r2 != 0) goto L_0x0789;
    L_0x0783:
        r2 = r0.getApplicationContext();
        e = r2;
    L_0x0789:
        r2 = 2;
        r0 = r0.createPackageContext(r1, r2);	 Catch:{ Exception -> 0x0808, all -> 0x0818 }
        r1 = "sdk_2";
        r0 = r0.getFileStreamPath(r1);	 Catch:{ Exception -> 0x0808, all -> 0x0818 }
        r1 = r0.exists();	 Catch:{ Exception -> 0x0808, all -> 0x0818 }
        if (r1 == 0) goto L_0x0da2;
    L_0x079a:
        r1 = new java.io.FileReader;	 Catch:{ Exception -> 0x0808, all -> 0x0818 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0808, all -> 0x0818 }
        r0 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0d79 }
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0d79 }
        r2 = r0.readLine();	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        if (r2 == 0) goto L_0x07fb;
    L_0x07ac:
        r2 = r2.trim();	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r3 = r3.exists();	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        if (r3 == 0) goto L_0x07fb;
    L_0x07bb:
        r3 = "tag_test_log";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r5 = "setupUCPlayerForThin:";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r4 = r4.append(r2);	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        com.uc.webview.export.internal.utility.Log.i(r3, r4);	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r3 = "com.uc.media.interfaces.IApolloHelper$Global";
        r4 = 1;
        r5 = c;	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r3 = java.lang.Class.forName(r3, r4, r5);	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r4 = "setApolloSoPath";
        r5 = 1;
        r5 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r7 = 0;
        r8 = java.lang.String.class;
        r5[r7] = r8;	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r8 = 0;
        r7[r8] = r2;	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        com.uc.webview.export.internal.utility.ReflectionUtil.invoke(r3, r4, r5, r7);	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r2 = 1;
        E = r2;	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        r2 = 1;
        r7 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x0d7c, all -> 0x0d74 }
        com.uc.webview.export.cyclone.UCCyclone.close(r0);
        com.uc.webview.export.cyclone.UCCyclone.close(r1);
        goto L_0x0009;
    L_0x07fb:
        r7 = r1;
    L_0x07fc:
        com.uc.webview.export.cyclone.UCCyclone.close(r0);
        com.uc.webview.export.cyclone.UCCyclone.close(r7);
    L_0x0802:
        r7 = java.lang.Boolean.valueOf(r6);
        goto L_0x0009;
    L_0x0808:
        r0 = move-exception;
        r1 = r7;
    L_0x080a:
        r2 = "tag_test_log";
        r3 = "setupUCPlayerForThin";
        com.uc.webview.export.internal.utility.Log.i(r2, r3, r0);	 Catch:{ all -> 0x0d71 }
        com.uc.webview.export.cyclone.UCCyclone.close(r7);
        com.uc.webview.export.cyclone.UCCyclone.close(r1);
        goto L_0x0802;
    L_0x0818:
        r0 = move-exception;
        r1 = r7;
    L_0x081a:
        com.uc.webview.export.cyclone.UCCyclone.close(r7);
        com.uc.webview.export.cyclone.UCCyclone.close(r1);
        throw r0;
    L_0x0821:
        r0 = r13[r6];
        r0 = (android.content.Context) r0;
        r1 = e;
        if (r1 != 0) goto L_0x082f;
    L_0x0829:
        r1 = r0.getApplicationContext();
        e = r1;
    L_0x082f:
        r1 = 1;
        r2 = new java.io.File[r1];	 Catch:{ Throwable -> 0x08dc }
        r1 = 0;
        r3 = 0;
        r2[r1] = r3;	 Catch:{ Throwable -> 0x08dc }
        r1 = com.uc.webview.export.utility.download.UpdateTask.getUCPlayerRoot(r0);	 Catch:{ Throwable -> 0x08dc }
        r0 = r0.getApplicationContext();	 Catch:{ Throwable -> 0x08dc }
        r0 = r0.getApplicationInfo();	 Catch:{ Throwable -> 0x08dc }
        r3 = r0.nativeLibraryDir;	 Catch:{ Throwable -> 0x08dc }
        if (r3 == 0) goto L_0x0d9f;
    L_0x0846:
        r0 = r1.getAbsolutePath();	 Catch:{ Throwable -> 0x08dc }
        r0 = r3.equals(r0);	 Catch:{ Throwable -> 0x08dc }
        if (r0 == 0) goto L_0x0d9f;
    L_0x0850:
        r0 = 10045; // 0x273d float:1.4076E-41 double:4.963E-320;
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x08dc }
        r4 = 0;
        r5 = e;	 Catch:{ Throwable -> 0x08dc }
        r1[r4] = r5;	 Catch:{ Throwable -> 0x08dc }
        r0 = com.uc.webview.export.internal.setup.UCMPackageInfo.invoke(r0, r1);	 Catch:{ Throwable -> 0x08dc }
        r0 = (java.io.File) r0;	 Catch:{ Throwable -> 0x08dc }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r4 = "libffmpeg.so";
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x08dc }
        r4 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r5 = "libffmpeg.so";
        r4.<init>(r0, r5);	 Catch:{ Throwable -> 0x08dc }
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r6 = "libffmpeg.so";
        r5.<init>(r0, r6);	 Catch:{ Throwable -> 0x08dc }
        r6 = 0;
        com.uc.webview.export.internal.utility.d.a(r1, r4, r5, r6);	 Catch:{ Throwable -> 0x08dc }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r4 = "libu3player.so";
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x08dc }
        r4 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r5 = "libu3player.so";
        r4.<init>(r0, r5);	 Catch:{ Throwable -> 0x08dc }
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r6 = "libu3player.so";
        r5.<init>(r0, r6);	 Catch:{ Throwable -> 0x08dc }
        r6 = 0;
        com.uc.webview.export.internal.utility.d.a(r1, r4, r5, r6);	 Catch:{ Throwable -> 0x08dc }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r4 = "librotate.so";
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x08dc }
        r4 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r5 = "librotate.so";
        r4.<init>(r0, r5);	 Catch:{ Throwable -> 0x08dc }
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r6 = "librotate.so";
        r5.<init>(r0, r6);	 Catch:{ Throwable -> 0x08dc }
        r6 = 0;
        com.uc.webview.export.internal.utility.d.a(r1, r4, r5, r6);	 Catch:{ Throwable -> 0x08dc }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r4 = "libinitHelper.so";
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x08dc }
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r4 = "libinitHelper.so";
        r3.<init>(r0, r4);	 Catch:{ Throwable -> 0x08dc }
        r4 = new java.io.File;	 Catch:{ Throwable -> 0x08dc }
        r5 = "libinitHelper.so";
        r4.<init>(r0, r5);	 Catch:{ Throwable -> 0x08dc }
        r5 = 0;
        com.uc.webview.export.internal.utility.d.a(r1, r3, r4, r5);	 Catch:{ Throwable -> 0x08dc }
    L_0x08c4:
        r1 = 10037; // 0x2735 float:1.4065E-41 double:4.959E-320;
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x08dc }
        r4 = 0;
        r3[r4] = r0;	 Catch:{ Throwable -> 0x08dc }
        r0 = 1;
        r3[r0] = r2;	 Catch:{ Throwable -> 0x08dc }
        invoke(r1, r3);	 Catch:{ Throwable -> 0x08dc }
        r0 = 0;
        r0 = r2[r0];	 Catch:{ Throwable -> 0x08dc }
        if (r0 == 0) goto L_0x0009;
    L_0x08d7:
        r0 = 0;
        r7 = r2[r0];	 Catch:{ Throwable -> 0x08dc }
        goto L_0x0009;
    L_0x08dc:
        r0 = move-exception;
        r1 = "tag_test_log";
        r2 = "getUCPlayerDir";
        com.uc.webview.export.internal.utility.Log.e(r1, r2, r0);
        goto L_0x0009;
    L_0x08e6:
        r0 = r13[r6];
        r0 = (java.io.File) r0;
        r1 = r13[r3];
        r1 = (java.io.File[]) r1;
        r2 = r0.exists();
        if (r2 == 0) goto L_0x0009;
    L_0x08f4:
        r2 = r0.isDirectory();
        if (r2 == 0) goto L_0x0009;
    L_0x08fa:
        r2 = new java.io.File;
        r4 = "libu3player.so";
        r2.<init>(r0, r4);
        r4 = r2.exists();
        if (r4 == 0) goto L_0x092a;
    L_0x0907:
        r4 = "libu3player.so";
        r4 = com.uc.webview.export.utility.download.UpdateTask.isFinished(r0, r4);
        if (r4 == 0) goto L_0x092a;
    L_0x090f:
        r4 = r1[r6];
        if (r4 == 0) goto L_0x0928;
    L_0x0913:
        r4 = r2.lastModified();
        r2 = new java.io.File;
        r8 = r1[r6];
        r9 = "libu3player.so";
        r2.<init>(r8, r9);
        r8 = r2.lastModified();
        r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x092a;
    L_0x0928:
        r1[r6] = r0;
    L_0x092a:
        r2 = r0.listFiles();
        if (r2 == 0) goto L_0x0009;
    L_0x0930:
        r4 = r2.length;
        r0 = r6;
    L_0x0932:
        if (r0 >= r4) goto L_0x0009;
    L_0x0934:
        r5 = r2[r0];
        r8 = r5.isDirectory();
        if (r8 == 0) goto L_0x0947;
    L_0x093c:
        r8 = 10037; // 0x2735 float:1.4065E-41 double:4.959E-320;
        r9 = new java.lang.Object[r10];
        r9[r6] = r5;
        r9[r3] = r1;
        invoke(r8, r9);
    L_0x0947:
        r0 = r0 + 1;
        goto L_0x0932;
    L_0x094a:
        r0 = 10006; // 0x2716 float:1.4021E-41 double:4.9436E-320;
        r1 = new java.lang.Object[r10];
        r2 = "swv";
        r1[r6] = r2;
        r2 = java.lang.Boolean.valueOf(r6);
        r1[r3] = r2;
        r0 = invoke(r0, r1);
        r0 = (java.lang.Boolean) r0;
        r1 = r0.booleanValue();
        r0 = 10010; // 0x271a float:1.4027E-41 double:4.9456E-320;
        r2 = new java.lang.Object[r6];
        r0 = invoke(r0, r2);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x09b7;
    L_0x0972:
        r0 = k;
        if (r0 == 0) goto L_0x0009;
    L_0x0976:
        if (r1 == 0) goto L_0x0009;
    L_0x0978:
        r0 = com.uc.webview.export.Build.UCM_VERSION;	 Catch:{ Exception -> 0x09ad }
        r2 = "\\.";
        r0 = r0.split(r2);	 Catch:{ Exception -> 0x09ad }
        r2 = 1;
        r2 = r0[r2];	 Catch:{ Exception -> 0x09ad }
        r2 = com.uc.webview.export.internal.utility.d.b(r2);	 Catch:{ Exception -> 0x09ad }
        r4 = 9;
        if (r2 < r4) goto L_0x0996;
    L_0x098b:
        r2 = 2;
        r0 = r0[r2];	 Catch:{ Exception -> 0x09ad }
        r0 = com.uc.webview.export.internal.utility.d.b(r0);	 Catch:{ Exception -> 0x09ad }
        r2 = 13;
        if (r0 >= r2) goto L_0x0d9c;
    L_0x0996:
        r0 = r6;
    L_0x0997:
        if (r0 == 0) goto L_0x0009;
    L_0x0999:
        I = r10;
        r0 = 10001; // 0x2711 float:1.4014E-41 double:4.941E-320;
        r1 = new java.lang.Object[r3];
        r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r2 = java.lang.Long.valueOf(r2);
        r1[r6] = r2;
        invoke(r0, r1);
        goto L_0x0009;
    L_0x09ad:
        r0 = move-exception;
        r1 = "tag_test_log";
        r2 = "checkForceSystemWebViewParam";
        com.uc.webview.export.internal.utility.Log.i(r1, r2, r0);
        r0 = r6;
        goto L_0x0997;
    L_0x09b7:
        if (r1 == 0) goto L_0x09cb;
    L_0x09b9:
        r0 = 10001; // 0x2711 float:1.4014E-41 double:4.941E-320;
        r1 = new java.lang.Object[r3];
        r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r2 = java.lang.Long.valueOf(r2);
        r1[r6] = r2;
        invoke(r0, r1);
        goto L_0x0009;
    L_0x09cb:
        r0 = 10002; // 0x2712 float:1.4016E-41 double:4.9416E-320;
        r1 = new java.lang.Object[r3];
        r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r2 = java.lang.Long.valueOf(r2);
        r1[r6] = r2;
        invoke(r0, r1);
        goto L_0x0009;
    L_0x09dd:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = r13[r3];
        r1 = (java.lang.Runnable) r1;
        r2 = e;
        if (r2 == 0) goto L_0x09f3;
    L_0x09e9:
        r2 = e;
        r2 = r2.getApplicationInfo();
        r2 = r2.dataDir;
        C = r2;
    L_0x09f3:
        r2 = 10020; // 0x2724 float:1.4041E-41 double:4.9505E-320;
        r4 = new java.lang.Object[r6];
        r2 = invoke(r2, r4);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        if (r2 == r10) goto L_0x0a07;
    L_0x0a03:
        r2 = C;
        if (r2 != 0) goto L_0x0a1f;
    L_0x0a07:
        r0 = "tag_test_log";
        r1 = new java.lang.StringBuilder;
        r2 = "is system webView - ";
        r1.<init>(r2);
        r2 = C;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.uc.webview.export.internal.utility.Log.w(r0, r1);
        goto L_0x0009;
    L_0x0a1f:
        r4 = new java.io.File;
        r2 = C;
        r5 = "shared_prefs";
        r4.<init>(r2, r5);
        r5 = new java.io.File;
        r2 = "typeface.xml";
        r5.<init>(r4, r2);
        r8 = new java.io.File;
        r2 = "uc_typeface_hash_";
        r8.<init>(r4, r2);
        if (r0 == 0) goto L_0x0a42;
    L_0x0a38:
        r2 = r0.trim();
        r2 = r2.length();
        if (r2 != 0) goto L_0x0a70;
    L_0x0a42:
        if (r3 == 0) goto L_0x0a72;
    L_0x0a44:
        r2 = "uc_font_sys";
        r2 = r2.hashCode();
        r2 = java.lang.String.valueOf(r2);
    L_0x0a4e:
        r9 = 45;
        r10 = 95;
        r2 = r2.replace(r9, r10);
        r9 = new java.io.File;
        r9.<init>(r8, r2);
        r2 = r9.exists();
        if (r2 == 0) goto L_0x0a9c;
    L_0x0a61:
        r2 = r5.exists();
        if (r2 == 0) goto L_0x0a9c;
    L_0x0a67:
        r0 = "tag_test_log";
        r1 = "字体没变化...";
        com.uc.webview.export.internal.utility.Log.d(r0, r1);
        goto L_0x0009;
    L_0x0a70:
        r3 = r6;
        goto L_0x0a42;
    L_0x0a72:
        r2 = new java.io.File;
        r2.<init>(r0);
        r9 = r2.exists();
        if (r9 != 0) goto L_0x0a93;
    L_0x0a7d:
        r0 = "tag_test_log";
        r1 = new java.lang.StringBuilder;
        r3 = "字体文件不存在-";
        r1.<init>(r3);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.uc.webview.export.internal.utility.Log.d(r0, r1);
        goto L_0x0009;
    L_0x0a93:
        r2 = r0.hashCode();
        r2 = java.lang.String.valueOf(r2);
        goto L_0x0a4e;
    L_0x0a9c:
        r2 = r8.exists();	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        if (r2 == 0) goto L_0x0ab1;
    L_0x0aa2:
        r2 = r8.listFiles();	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        r8 = r2.length;	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
    L_0x0aa7:
        if (r6 >= r8) goto L_0x0ab4;
    L_0x0aa9:
        r10 = r2[r6];	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        r10.delete();	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        r6 = r6 + 1;
        goto L_0x0aa7;
    L_0x0ab1:
        r8.mkdirs();	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
    L_0x0ab4:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        r6.<init>();	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        if (r3 == 0) goto L_0x0af5;
    L_0x0abb:
        r0 = "<?xml version='1.0' encoding='utf-8' standalone='yes' ?>\n<map />";
        r6.append(r0);	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
    L_0x0ac0:
        r0 = r4.exists();	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        if (r0 != 0) goto L_0x0ac9;
    L_0x0ac6:
        r4.mkdirs();	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
    L_0x0ac9:
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        r0 = r6.toString();	 Catch:{ Exception -> 0x0d6d, all -> 0x0d66 }
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x0d6d, all -> 0x0d66 }
        r2.write(r0);	 Catch:{ Exception -> 0x0d6d, all -> 0x0d66 }
        r9.createNewFile();	 Catch:{ Exception -> 0x0d6d, all -> 0x0d66 }
        r0 = d;	 Catch:{ Exception -> 0x0d6d, all -> 0x0d66 }
        r0.fontDownloadFinished();	 Catch:{ Exception -> 0x0d6d, all -> 0x0d66 }
        if (r1 == 0) goto L_0x0ae6;
    L_0x0ae3:
        r1.run();	 Catch:{ Exception -> 0x0d6d, all -> 0x0d66 }
    L_0x0ae6:
        com.uc.webview.export.cyclone.UCCyclone.close(r2);	 Catch:{ Exception -> 0x0aeb }
        goto L_0x0009;
    L_0x0aeb:
        r0 = move-exception;
        r1 = "tag_test_log";
        r2 = "updateTypefacePath";
        com.uc.webview.export.internal.utility.Log.i(r1, r2, r0);
        goto L_0x0009;
    L_0x0af5:
        r2 = "<?xml version='1.0' encoding='utf-8' standalone='yes' ?>\n<map>\n<string name=\"current_typeface_path\">";
        r2 = r6.append(r2);	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        r2 = "</string>\n</map>";
        r0.append(r2);	 Catch:{ Exception -> 0x0b05, all -> 0x0b13 }
        goto L_0x0ac0;
    L_0x0b05:
        r0 = move-exception;
        r1 = r7;
    L_0x0b07:
        r2 = "tag_test_log";
        r3 = "updateTypefacePath";
        com.uc.webview.export.internal.utility.Log.i(r2, r3, r0);	 Catch:{ all -> 0x0d69 }
        com.uc.webview.export.cyclone.UCCyclone.close(r1);	 Catch:{ Exception -> 0x0aeb }
        goto L_0x0009;
    L_0x0b13:
        r0 = move-exception;
        r2 = r7;
    L_0x0b15:
        com.uc.webview.export.cyclone.UCCyclone.close(r2);	 Catch:{ Exception -> 0x0aeb }
        throw r0;	 Catch:{ Exception -> 0x0aeb }
    L_0x0b19:
        r0 = 10020; // 0x2724 float:1.4041E-41 double:4.9505E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 != r10) goto L_0x0b2f;
    L_0x0b29:
        r7 = java.lang.Boolean.valueOf(r3);
        goto L_0x0009;
    L_0x0b2f:
        r0 = com.uc.webview.export.internal.uc.CoreFactory.p();
        r7 = java.lang.Boolean.valueOf(r0);
        goto L_0x0009;
    L_0x0b39:
        r0 = F;
        if (r0 == 0) goto L_0x0b47;
    L_0x0b3d:
        r0 = android.os.Looper.myLooper();
        r1 = android.os.Looper.getMainLooper();
        if (r0 == r1) goto L_0x0009;
    L_0x0b47:
        r1 = new com.uc.webview.export.cyclone.UCElapseTime;
        r1.<init>();
    L_0x0b4c:
        r0 = com.uc.webview.export.internal.setup.UCSetupTask.isSetupThread();
        if (r0 == 0) goto L_0x0ba5;
    L_0x0b52:
        r0 = 10010; // 0x271a float:1.4027E-41 double:4.9456E-320;
        r2 = new java.lang.Object[r6];
        r0 = invoke(r0, r2);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0ba5;
    L_0x0b62:
        r0 = java.lang.Thread.currentThread();
        r1 = r0.getStackTrace();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = 3;
    L_0x0b70:
        r3 = r1.length;
        if (r0 >= r3) goto L_0x0b99;
    L_0x0b73:
        r3 = 8;
        if (r0 >= r3) goto L_0x0b99;
    L_0x0b77:
        r3 = r1[r0];
        r3 = r3.toString();
        r4 = "com.uc.webview.export.";
        r5 = "";
        r3 = r3.replace(r4, r5);
        r4 = "\\(.+\\)";
        r5 = "";
        r3 = r3.replaceAll(r4, r5);
        r3 = r2.append(r3);
        r4 = ",";
        r3.append(r4);
        r0 = r0 + 1;
        goto L_0x0b70;
    L_0x0b99:
        r0 = new com.uc.webview.export.internal.setup.UCSetupException;
        r1 = 3013; // 0xbc5 float:4.222E-42 double:1.4886E-320;
        r2 = r2.toString();
        r0.<init>(r1, r2);
        throw r0;
    L_0x0ba5:
        com.uc.webview.export.internal.SDKFactory.b.a(r7);
        r0 = p;
        if (r0 == 0) goto L_0x0baf;
    L_0x0bac:
        com.uc.webview.export.internal.setup.UCSetupTask.resumeAll();
    L_0x0baf:
        r0 = I;
        if (r0 != 0) goto L_0x0bd0;
    L_0x0bb3:
        r0 = 10024; // 0x2728 float:1.4047E-41 double:4.9525E-320;
        r2 = new java.lang.Object[r3];
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r4 = java.lang.Long.valueOf(r4);
        r2[r6] = r4;
        invoke(r0, r2);
        r4 = r1.getMilis();
        r8 = i;
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 < 0) goto L_0x0b4c;
    L_0x0bcc:
        r0 = j;
        if (r0 == r3) goto L_0x0b4c;
    L_0x0bd0:
        com.uc.webview.export.internal.SDKFactory.b.a(r7);
        r1 = com.uc.webview.export.internal.SDKFactory.class;
        monitor-enter(r1);
        r0 = I;	 Catch:{ all -> 0x0c0f }
        if (r0 != 0) goto L_0x0be1;
    L_0x0bda:
        r0 = j;	 Catch:{ all -> 0x0c0f }
        if (r0 != r10) goto L_0x0c12;
    L_0x0bde:
        r0 = 2;
        I = r0;	 Catch:{ all -> 0x0c0f }
    L_0x0be1:
        r0 = "SDKFactory";
        r2 = java.util.Locale.CHINA;	 Catch:{ all -> 0x0c0f }
        r3 = "waitForInit(sWebViewPolicy=%d, sMaxWaitMillis=%d)=%d";
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0c0f }
        r5 = 0;
        r6 = j;	 Catch:{ all -> 0x0c0f }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0c0f }
        r4[r5] = r6;	 Catch:{ all -> 0x0c0f }
        r5 = 1;
        r8 = i;	 Catch:{ all -> 0x0c0f }
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x0c0f }
        r4[r5] = r6;	 Catch:{ all -> 0x0c0f }
        r5 = 2;
        r6 = I;	 Catch:{ all -> 0x0c0f }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0c0f }
        r4[r5] = r6;	 Catch:{ all -> 0x0c0f }
        r2 = java.lang.String.format(r2, r3, r4);	 Catch:{ all -> 0x0c0f }
        com.uc.webview.export.internal.utility.Log.d(r0, r2);	 Catch:{ all -> 0x0c0f }
        monitor-exit(r1);	 Catch:{ all -> 0x0c0f }
        goto L_0x0009;
    L_0x0c0f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0c0f }
        throw r0;
    L_0x0c12:
        r0 = j;	 Catch:{ all -> 0x0c0f }
        r2 = 3;
        if (r0 != r2) goto L_0x0be1;
    L_0x0c17:
        r0 = new com.uc.webview.export.internal.setup.UCSetupException;	 Catch:{ all -> 0x0c0f }
        r2 = 4009; // 0xfa9 float:5.618E-42 double:1.9807E-320;
        r3 = "Thread [%s] waitting for init is up to [%s] milis.";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0c0f }
        r5 = 0;
        r6 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0c0f }
        r6 = r6.getName();	 Catch:{ all -> 0x0c0f }
        r4[r5] = r6;	 Catch:{ all -> 0x0c0f }
        r5 = 1;
        r6 = i;	 Catch:{ all -> 0x0c0f }
        r6 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x0c0f }
        r4[r5] = r6;	 Catch:{ all -> 0x0c0f }
        r3 = java.lang.String.format(r3, r4);	 Catch:{ all -> 0x0c0f }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x0c0f }
        throw r0;	 Catch:{ all -> 0x0c0f }
    L_0x0c3c:
        r0 = r13[r6];
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        com.uc.webview.export.internal.utility.Log.sPrintLog = r0;
        r0 = "com.uc.webview.export.cd.CDUtil";
        r1 = "setEnablePrintLog";
        r2 = 1;
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0d63 }
        r4 = 0;
        r5 = java.lang.Boolean.class;
        r2[r4] = r5;	 Catch:{ Exception -> 0x0d63 }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0d63 }
        r5 = 0;
        r8 = com.uc.webview.export.internal.utility.Log.sPrintLog;	 Catch:{ Exception -> 0x0d63 }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ Exception -> 0x0d63 }
        r4[r5] = r8;	 Catch:{ Exception -> 0x0d63 }
        com.uc.webview.export.internal.utility.ReflectionUtil.invoke(r0, r1, r2, r4);	 Catch:{ Exception -> 0x0d63 }
    L_0x0c61:
        r0 = r13[r3];
        r0 = (java.lang.Object[]) r0;
        if (r0 == 0) goto L_0x0009;
    L_0x0c67:
        r1 = r0.length;
        r2 = 5;
        if (r1 != r2) goto L_0x0009;
    L_0x0c6b:
        r1 = r13[r6];
        r1 = (java.lang.Boolean) r1;
        r0[r6] = r1;
        com.uc.webview.export.cyclone.UCLogger.setup(r0);
        goto L_0x0009;
    L_0x0c76:
        r7 = e;
        goto L_0x0009;
    L_0x0c7a:
        r0 = 10022; // 0x2726 float:1.4044E-41 double:4.9515E-320;
        r1 = new java.lang.Object[r6];
        r0 = invoke(r0, r1);
        r0 = (com.uc.webview.export.internal.interfaces.IGlobalSettings) r0;
        if (r0 == 0) goto L_0x0c94;
    L_0x0c86:
        r1 = "IsRunningInWebViewSdk";
        r0 = r0.getBoolValue(r1);
        if (r0 == 0) goto L_0x0c94;
    L_0x0c8e:
        r7 = java.lang.Boolean.valueOf(r3);
        goto L_0x0009;
    L_0x0c94:
        r7 = java.lang.Boolean.valueOf(r6);
        goto L_0x0009;
    L_0x0c9a:
        r0 = I;
        if (r0 != r10) goto L_0x0ca7;
    L_0x0c9e:
        r0 = "android.webkit.WebView";
        r1 = "enableSlowWholeDocumentDraw";
        com.uc.webview.export.internal.utility.ReflectionUtil.invokeNoThrow(r0, r1);
        goto L_0x0009;
    L_0x0ca7:
        r0 = I;
        r1 = 3;
        if (r0 != r1) goto L_0x0009;
    L_0x0cac:
        r0 = "com.uc.webkit.WebView";
        r1 = "enableSlowWholeDocumentDraw";
        com.uc.webview.export.internal.utility.ReflectionUtil.invokeNoThrow(r0, r1);
        goto L_0x0009;
    L_0x0cb5:
        r0 = I;
        if (r0 != r10) goto L_0x0cc3;
    L_0x0cb9:
        r0 = "android.webkit.WebSettings";
        r1 = "getDefaultUserAgent";
        r7 = com.uc.webview.export.internal.utility.ReflectionUtil.invokeNoThrow(r0, r1);
        goto L_0x0009;
    L_0x0cc3:
        r0 = I;
        r1 = 3;
        if (r0 != r1) goto L_0x0009;
    L_0x0cc8:
        r0 = "com.uc.webkit.WebSettings";
        r1 = "getDefaultUserAgent";
        r7 = com.uc.webview.export.internal.utility.ReflectionUtil.invokeNoThrow(r0, r1);
        goto L_0x0009;
    L_0x0cd2:
        r0 = A;
        r0 = r0.size();
        r1 = 64;
        if (r0 >= r1) goto L_0x0009;
    L_0x0cdc:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = r13[r3];
        r2 = A;
        r2.put(r0, r1);
        goto L_0x0009;
    L_0x0ce9:
        r0 = r13[r6];
        r0 = (java.lang.String) r0;
        r1 = A;
        r1 = r1.containsKey(r0);
        if (r1 == 0) goto L_0x0009;
    L_0x0cf5:
        r1 = A;
        r7 = r1.get(r0);
        goto L_0x0009;
    L_0x0cfd:
        r0 = r13[r6];
        r0 = (com.uc.webview.export.internal.interfaces.IPreloadManager) r0;
        K = r0;
        goto L_0x0009;
    L_0x0d05:
        r0 = K;
        if (r0 == 0) goto L_0x0d14;
    L_0x0d09:
        r0 = e;
        if (r0 == 0) goto L_0x0d14;
    L_0x0d0d:
        r0 = K;
        r1 = e;
        r0.setContext(r1);
    L_0x0d14:
        r7 = K;
        goto L_0x0009;
    L_0x0d18:
        r0 = r13.length;
        if (r0 <= 0) goto L_0x0d2d;
    L_0x0d1b:
        r0 = r13[r6];
    L_0x0d1d:
        r1 = r0 instanceof java.lang.Boolean;
        if (r1 == 0) goto L_0x0d2f;
    L_0x0d21:
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0d2f;
    L_0x0d29:
        F = r3;
        goto L_0x0009;
    L_0x0d2d:
        r0 = r7;
        goto L_0x0d1d;
    L_0x0d2f:
        r3 = r6;
        goto L_0x0d29;
    L_0x0d31:
        r0 = r13.length;
        if (r0 <= 0) goto L_0x0d46;
    L_0x0d34:
        r0 = r13[r6];
    L_0x0d36:
        r1 = r0 instanceof java.lang.Boolean;
        if (r1 == 0) goto L_0x0d48;
    L_0x0d3a:
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0d48;
    L_0x0d42:
        G = r3;
        goto L_0x0009;
    L_0x0d46:
        r0 = r7;
        goto L_0x0d36;
    L_0x0d48:
        r3 = r6;
        goto L_0x0d42;
    L_0x0d4a:
        r0 = r13.length;
        if (r0 <= 0) goto L_0x0d5f;
    L_0x0d4d:
        r0 = r13[r6];
    L_0x0d4f:
        r1 = r0 instanceof java.lang.Boolean;
        if (r1 == 0) goto L_0x0d61;
    L_0x0d53:
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0d61;
    L_0x0d5b:
        H = r3;
        goto L_0x0009;
    L_0x0d5f:
        r0 = r7;
        goto L_0x0d4f;
    L_0x0d61:
        r3 = r6;
        goto L_0x0d5b;
    L_0x0d63:
        r0 = move-exception;
        goto L_0x0c61;
    L_0x0d66:
        r0 = move-exception;
        goto L_0x0b15;
    L_0x0d69:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0b15;
    L_0x0d6d:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0b07;
    L_0x0d71:
        r0 = move-exception;
        goto L_0x081a;
    L_0x0d74:
        r2 = move-exception;
        r7 = r0;
        r0 = r2;
        goto L_0x081a;
    L_0x0d79:
        r0 = move-exception;
        goto L_0x080a;
    L_0x0d7c:
        r2 = move-exception;
        r7 = r0;
        r0 = r2;
        goto L_0x080a;
    L_0x0d81:
        r0 = move-exception;
        r7 = r1;
        goto L_0x0773;
    L_0x0d85:
        r1 = move-exception;
        r7 = r0;
        r0 = r1;
        goto L_0x0773;
    L_0x0d8a:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x0748;
    L_0x0d90:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x076c;
    L_0x0d96:
        r1 = move-exception;
        goto L_0x0765;
    L_0x0d99:
        r0 = move-exception;
        goto L_0x0009;
    L_0x0d9c:
        r0 = r1;
        goto L_0x0997;
    L_0x0d9f:
        r0 = r1;
        goto L_0x08c4;
    L_0x0da2:
        r0 = r7;
        goto L_0x07fc;
    L_0x0da5:
        r1 = r7;
        goto L_0x071b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.SDKFactory.invoke(int, java.lang.Object[]):java.lang.Object");
    }

    public static String a(UCMPackageInfo uCMPackageInfo, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type:").append(str);
        if (uCMPackageInfo.pkgName != null) {
            stringBuilder.append("\nPackage Name:").append(uCMPackageInfo.pkgName);
        }
        stringBuilder.append("\nSo files path:").append(uCMPackageInfo.soDirPath).append("\nDex files:\n").append((String) uCMPackageInfo.sdkShellModule.first).append("\n").append((String) uCMPackageInfo.browserIFModule.first).append("\n").append((String) uCMPackageInfo.coreImplModule.first);
        return stringBuilder.toString();
    }

    public static void a(String str) {
        g = str;
    }

    public static void a(boolean z) {
        IGlobalSettings iGlobalSettings = (IGlobalSettings) invoke(10022, new Object[0]);
        if (iGlobalSettings != null) {
            iGlobalSettings.setStringValue(Global.EXT_KEY_APOLLO_STR, z ? "ap_cache3=1&ap_cache=1&ap_cache_preload=1&ap_enable_preload2=1&ap_enable_cache2=1&ap_next_buf=7000&ap_max_buf=15000" : "ap_cache3=0&ap_cache=0&ap_cache_preload=0&ap_enable_preload2=0&ap_enable_cache2=0");
        }
    }
}
