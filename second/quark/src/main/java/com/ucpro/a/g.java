package com.ucpro.a;

import android.content.Context;
import android.os.SystemClock;
import com.uc.webview.browser.interfaces.BrowserMobileWebKit;
import com.uc.webview.export.Build;
import com.uc.webview.export.extension.ILocationManager;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.ucpro.a.a.a;
import com.ucpro.a.a.b;
import com.ucpro.a.c.e;
import com.ucpro.a.c.k;
import com.ucpro.a.c.r;
import com.ucpro.a.d.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ProGuard */
public final class g implements n {
    private static g j = null;
    f a;
    public k b;
    public BrowserMobileWebKit c;
    b d;
    ILocationManager e;
    r f;
    e g;
    public com.ucpro.a.d.e h;
    public ClassLoader i;
    private Context k;
    private q l = new q();
    private int m = 1;
    private a n;
    private com.ucpro.a.b.a o;
    private d p;

    private g(Context context) {
        this.k = context;
        this.a = new f(context);
    }

    public static synchronized void a(Context context) {
        synchronized (g.class) {
            if (j == null) {
                j = new g(context);
            }
        }
    }

    public static g a() {
        if (j != null) {
            return j;
        }
        throw new NullPointerException("getInstance() is Null, please call WebCoreManager.createInstance(context) first!");
    }

    public final d b() {
        if (this.p == null) {
            this.p = new d();
        }
        return this.p;
    }

    public final void a(d dVar) {
        if (!c()) {
            this.l.a.add(new WeakReference(dVar));
        } else if (dVar != null) {
            dVar.a();
        }
    }

    public final boolean c() {
        return this.m == 4;
    }

    public static void a(com.ucweb.common.util.i.a aVar) {
        a a = a.a();
        if (a.a != null) {
            Iterator it = a.b().iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(aVar);
            }
        }
    }

    public final void d() {
        this.m = 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.uc.webview.export.internal.setup.UCMRunningInfo r13) {
        /*
        r12 = this;
        r7 = 3;
        r5 = -1;
        r6 = 2;
        r3 = 0;
        r2 = 1;
        r0 = r12.b();
        r8 = android.os.SystemClock.uptimeMillis();
        r0.b = r8;
        r0 = 4;
        r12.m = r0;
        r0 = com.ucpro.a.d.b.a();
        com.uc.webview.browser.interfaces.ICoreStat.CustomStat.setInstance(r0);
        com.ucpro.a.d.f.a();
        r0 = r12.h;
        r1 = a();
        r1 = r1.b();
        r8 = r1.b;
        r1 = a();
        r1 = r1.b();
        r10 = r1.a;
        r8 = r8 - r10;
        r1 = "load";
        r4 = 6;
        r4 = new java.lang.String[r4];
        r10 = "load_result";
        r4[r3] = r10;
        r10 = "success";
        r4[r2] = r10;
        r10 = "new_install";
        r4[r6] = r10;
        r10 = a();
        r10 = r10.b();
        r10 = r10.c;
        r10 = java.lang.String.valueOf(r10);
        r4[r7] = r10;
        r10 = 4;
        r11 = "load_time";
        r4[r10] = r11;
        r10 = 5;
        r8 = java.lang.String.valueOf(r8);
        r4[r10] = r8;
        r0.a(r1, r4);
        r0 = com.uc.webview.browser.BrowserCore.getMobileWebKit();
        r12.c = r0;
        r0 = r13.classLoader;
        r12.i = r0;
        r0 = new com.ucpro.a.k;
        r1 = r12.c;
        r0.<init>(r1);
        r12.b = r0;
        r0 = r12.d;
        if (r0 == 0) goto L_0x0083;
    L_0x007a:
        r0 = new com.ucpro.a.a.a;
        r1 = r12.d;
        r0.<init>(r1);
        r12.n = r0;
    L_0x0083:
        r0 = r12.n;
        if (r0 == 0) goto L_0x009a;
    L_0x0087:
        r0 = com.uc.webview.browser.BrowserCore.getAccessControl();
        if (r0 == 0) goto L_0x009a;
    L_0x008d:
        r0 = new com.ucpro.a.b.a;
        r1 = r12.n;
        r4 = com.uc.webview.browser.BrowserCore.getAccessControl();
        r0.<init>(r1, r4);
        r12.o = r0;
    L_0x009a:
        r0 = android.os.Looper.getMainLooper();
        r1 = android.os.Looper.myLooper();
        if (r0 != r1) goto L_0x014f;
    L_0x00a4:
        r0 = r2;
    L_0x00a5:
        com.ucweb.common.util.c.b(r0);
        r0 = r12.c;
        if (r0 == 0) goto L_0x00b7;
    L_0x00ac:
        r0 = r12.e;
        if (r0 == 0) goto L_0x00b7;
    L_0x00b0:
        r0 = r12.c;
        r1 = r12.e;
        r0.setLocationManagerUC(r1);
    L_0x00b7:
        r0 = r12.n;
        if (r0 == 0) goto L_0x00f2;
    L_0x00bb:
        r0 = r12.n;
        r1 = r0.b;
        com.ucweb.common.util.c.a(r1);
        r1 = r0.b;
        if (r1 == 0) goto L_0x00f2;
    L_0x00c6:
        r1 = "MobileUADefault";
        r4 = r0.b;
        r4 = r4.a(r2);
        r0.a(r1, r4);
        r1 = "MobileUAChrome";
        r4 = r0.b;
        r4 = r4.a(r6);
        r0.a(r1, r4);
        r1 = "MobileUAIphone";
        r4 = r0.b;
        r4 = r4.a(r7);
        r0.a(r1, r4);
        r1 = "XUCBrowserUA";
        r4 = r0.b;
        r4 = r4.a();
        r0.a(r1, r4);
    L_0x00f2:
        r0 = r12.o;
        if (r0 == 0) goto L_0x00fb;
    L_0x00f6:
        r0 = r12.o;
        r0.a();
    L_0x00fb:
        com.ucpro.a.c.k.a;
        com.ucpro.a.c.p.e();
        r0 = com.ucpro.a.c.k.a;
        r1 = r0.b;
        if (r1 == 0) goto L_0x0482;
    L_0x0109:
        r1 = r0.b;
        r1 = r1.isEmpty();
        if (r1 != 0) goto L_0x0482;
    L_0x0111:
        r8 = r0.b;
        r0 = com.ucpro.a.c.p.a();
        r4 = r0.iterator();
    L_0x011b:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0166;
    L_0x0121:
        r0 = r4.next();
        r1 = r0;
        r1 = (java.lang.String) r1;
        r0 = r8.get(r1);
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x011b;
    L_0x0130:
        r9 = com.ucweb.common.util.n.a.a(r1);
        if (r9 != 0) goto L_0x011b;
    L_0x0136:
        if (r0 == 0) goto L_0x011b;
    L_0x0138:
        if (r0 == 0) goto L_0x0164;
    L_0x013a:
        r9 = "true";
        r9 = r9.equals(r0);
        if (r9 != 0) goto L_0x014a;
    L_0x0142:
        r9 = "1";
        r9 = r9.equals(r0);
        if (r9 == 0) goto L_0x0152;
    L_0x014a:
        r0 = r2;
    L_0x014b:
        com.ucpro.a.c.p.a(r1, r0);
        goto L_0x011b;
    L_0x014f:
        r0 = r3;
        goto L_0x00a5;
    L_0x0152:
        r9 = "false";
        r9 = r9.equals(r0);
        if (r9 != 0) goto L_0x0162;
    L_0x015a:
        r9 = "0";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x0164;
    L_0x0162:
        r0 = r3;
        goto L_0x014b;
    L_0x0164:
        r0 = r3;
        goto L_0x014b;
    L_0x0166:
        r0 = com.ucpro.a.c.p.d();
        r9 = r0.iterator();
    L_0x016e:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x01e7;
    L_0x0174:
        r0 = r9.next();
        r1 = r0;
        r1 = (java.lang.String) r1;
        r0 = r8.get(r1);
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x016e;
    L_0x0183:
        r4 = com.ucweb.common.util.n.a.a(r1);
        if (r4 != 0) goto L_0x016e;
    L_0x0189:
        if (r0 == 0) goto L_0x016e;
    L_0x018b:
        r4 = new java.lang.StringBuilder;
        r10 = "setStringValueToWebCore, ";
        r4.<init>(r10);
        r4 = r4.append(r1);
        r10 = " : ";
        r4 = r4.append(r10);
        r4.append(r0);
        r4 = r1.hashCode();
        switch(r4) {
            case -1409599520: goto L_0x01ae;
            default: goto L_0x01a6;
        };
    L_0x01a6:
        r4 = r5;
    L_0x01a7:
        switch(r4) {
            case 0: goto L_0x01b8;
            default: goto L_0x01aa;
        };
    L_0x01aa:
        com.ucpro.a.c.p.a(r1, r0);
        goto L_0x016e;
    L_0x01ae:
        r4 = "UBISiLang";
        r4 = r1.equals(r4);
        if (r4 == 0) goto L_0x01a6;
    L_0x01b6:
        r4 = r3;
        goto L_0x01a7;
    L_0x01b8:
        r4 = "-";
        r4 = r0.indexOf(r4);
        if (r4 <= 0) goto L_0x04ab;
    L_0x01c0:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = r4 + 1;
        r11 = r0.substring(r3, r11);
        r10 = r10.append(r11);
        r4 = r4 + 1;
        r4 = r0.substring(r4);
        r4 = r4.toUpperCase();
        r4 = r10.append(r4);
        r4 = r4.toString();
    L_0x01e1:
        r10 = "UBISiLang";
        com.ucpro.a.c.p.a(r10, r4);
        goto L_0x01aa;
    L_0x01e7:
        r0 = com.ucpro.a.c.p.b();
        r9 = r0.iterator();
    L_0x01ef:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x044e;
    L_0x01f5:
        r0 = r9.next();
        r0 = (java.lang.String) r0;
        r1 = r8.get(r0);
        r1 = (java.lang.String) r1;
        if (r1 == 0) goto L_0x01ef;
    L_0x0203:
        r4 = com.ucweb.common.util.n.a.a(r0);
        if (r4 != 0) goto L_0x01ef;
    L_0x0209:
        if (r1 == 0) goto L_0x01ef;
    L_0x020b:
        r4 = new java.lang.StringBuilder;
        r10 = "setIntValueToWebCore, ";
        r4.<init>(r10);
        r4 = r4.append(r0);
        r10 = " : ";
        r4 = r4.append(r10);
        r4.append(r1);
        r4 = r0.hashCode();
        switch(r4) {
            case -2118530923: goto L_0x02bb;
            case -1797693698: goto L_0x0282;
            case -1680353873: goto L_0x02a3;
            case -1582674284: goto L_0x028d;
            case -1349143664: goto L_0x02c7;
            case -1209378232: goto L_0x0246;
            case -695660792: goto L_0x02df;
            case -626572153: goto L_0x0250;
            case -275444806: goto L_0x02d3;
            case 86919793: goto L_0x026e;
            case 239901669: goto L_0x02f7;
            case 714918324: goto L_0x0303;
            case 890742666: goto L_0x0232;
            case 946743550: goto L_0x025a;
            case 1061925940: goto L_0x02af;
            case 1142615538: goto L_0x0298;
            case 1366671921: goto L_0x0278;
            case 1413797700: goto L_0x0264;
            case 1580340677: goto L_0x02eb;
            case 1892146729: goto L_0x023c;
            default: goto L_0x0226;
        };
    L_0x0226:
        r4 = r5;
    L_0x0227:
        switch(r4) {
            case 0: goto L_0x030f;
            case 1: goto L_0x031d;
            case 2: goto L_0x032b;
            case 3: goto L_0x0339;
            case 4: goto L_0x0344;
            case 5: goto L_0x0352;
            case 6: goto L_0x0365;
            case 7: goto L_0x0375;
            case 8: goto L_0x038f;
            case 9: goto L_0x03a9;
            case 10: goto L_0x03b4;
            case 11: goto L_0x03c4;
            case 12: goto L_0x03d1;
            case 13: goto L_0x03dc;
            case 14: goto L_0x03ed;
            case 15: goto L_0x03fb;
            case 16: goto L_0x040b;
            case 17: goto L_0x0419;
            case 18: goto L_0x042d;
            case 19: goto L_0x043d;
            default: goto L_0x022a;
        };
    L_0x022a:
        r1 = com.ucpro.a.c.q.a(r1, r3);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x0232:
        r4 = "OperationMode";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x023a:
        r4 = r3;
        goto L_0x0227;
    L_0x023c:
        r4 = "ScreenSensorMode";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x0244:
        r4 = r2;
        goto L_0x0227;
    L_0x0246:
        r4 = "ScreenBrightnessCommon";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x024e:
        r4 = r6;
        goto L_0x0227;
    L_0x0250:
        r4 = "LayoutStyle";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x0258:
        r4 = r7;
        goto L_0x0227;
    L_0x025a:
        r4 = "LabelLineSpace";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x0262:
        r4 = 4;
        goto L_0x0227;
    L_0x0264:
        r4 = "ImageQuality";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x026c:
        r4 = 5;
        goto L_0x0227;
    L_0x026e:
        r4 = "CursorSpeed";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x0276:
        r4 = 6;
        goto L_0x0227;
    L_0x0278:
        r4 = "DefaultFontSize";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x0280:
        r4 = 7;
        goto L_0x0227;
    L_0x0282:
        r4 = "MinimumFontSize";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x028a:
        r4 = 8;
        goto L_0x0227;
    L_0x028d:
        r4 = "DefaultEncoding";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x0295:
        r4 = 9;
        goto L_0x0227;
    L_0x0298:
        r4 = "BackLightTimeOut";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x02a0:
        r4 = 10;
        goto L_0x0227;
    L_0x02a3:
        r4 = "UCCustomFontSize";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x02ab:
        r4 = 11;
        goto L_0x0227;
    L_0x02af:
        r4 = "UserAgentType";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x02b7:
        r4 = 12;
        goto L_0x0227;
    L_0x02bb:
        r4 = "CD_Recycle";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x02c3:
        r4 = 13;
        goto L_0x0227;
    L_0x02c7:
        r4 = "upload_order";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x02cf:
        r4 = 14;
        goto L_0x0227;
    L_0x02d3:
        r4 = "CachePageNumber";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x02db:
        r4 = 15;
        goto L_0x0227;
    L_0x02df:
        r4 = "DiskCacheMode";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x02e7:
        r4 = 16;
        goto L_0x0227;
    L_0x02eb:
        r4 = "PrereadOptions";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x02f3:
        r4 = 17;
        goto L_0x0227;
    L_0x02f7:
        r4 = "BackForwardListNumber";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x02ff:
        r4 = 18;
        goto L_0x0227;
    L_0x0303:
        r4 = "SegmentSize";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0226;
    L_0x030b:
        r4 = 19;
        goto L_0x0227;
    L_0x030f:
        r4 = "UIOprationMode should not set";
        com.ucweb.common.util.c.a(r4);
        r1 = com.ucpro.a.c.q.a(r1, r2);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x031d:
        r4 = "UIScreenSensorMode should not set";
        com.ucweb.common.util.c.a(r4);
        r1 = com.ucpro.a.c.q.a(r1, r5);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x032b:
        r4 = "UIBrightness should not set";
        com.ucweb.common.util.c.a(r4);
        r1 = com.ucpro.a.c.q.a(r1, r5);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x0339:
        r0 = com.ucpro.a.c.q.a(r1, r2);
        r1 = "LayoutStyle";
        com.ucpro.a.c.p.a(r1, r0);
        goto L_0x01ef;
    L_0x0344:
        r4 = "PageLineSpacing should not set";
        com.ucweb.common.util.c.a(r4);
        r1 = com.ucpro.a.c.q.a(r1, r6);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x0352:
        r0 = com.ucpro.a.c.t.a();
        r4 = com.ucpro.a.c.t.c;
        r4 = r4 + -1;
        r1 = com.ucpro.a.c.q.a(r1, r4);
        r0 = r0[r1];
        com.ucpro.a.c.j.b(r0);
        goto L_0x01ef;
    L_0x0365:
        r4 = "PageCursorSpeed should not set";
        com.ucweb.common.util.c.a(r4);
        r4 = 12;
        r1 = com.ucpro.a.c.q.a(r1, r4);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x0375:
        r4 = "PageDefaultFontSize should not set";
        com.ucweb.common.util.c.a(r4);
        r4 = 14;
        r1 = com.ucpro.a.c.q.a(r1, r4);
        if (r1 > 0) goto L_0x0388;
    L_0x0382:
        r1 = r2;
    L_0x0383:
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x0388:
        r4 = 72;
        if (r1 <= r4) goto L_0x0383;
    L_0x038c:
        r1 = 72;
        goto L_0x0383;
    L_0x038f:
        r4 = "PageMinimumFontSize should not set";
        com.ucweb.common.util.c.a(r4);
        r4 = 12;
        r1 = com.ucpro.a.c.q.a(r1, r4);
        if (r1 > 0) goto L_0x03a2;
    L_0x039c:
        r1 = r2;
    L_0x039d:
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x03a2:
        r4 = 72;
        if (r1 <= r4) goto L_0x039d;
    L_0x03a6:
        r1 = 72;
        goto L_0x039d;
    L_0x03a9:
        r0 = com.ucpro.a.c.q.a(r1, r2);
        r1 = "DefaultEncoding";
        com.ucpro.a.c.p.a(r1, r0);
        goto L_0x01ef;
    L_0x03b4:
        r4 = "PageBackLightTimeOut should not set";
        com.ucweb.common.util.c.a(r4);
        r4 = 50;
        r1 = com.ucpro.a.c.q.a(r1, r4);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x03c4:
        r0 = 100;
        r0 = com.ucpro.a.c.q.a(r1, r0);
        r1 = "UCCustomFontSize";
        com.ucpro.a.c.p.a(r1, r0);
        goto L_0x01ef;
    L_0x03d1:
        r0 = com.ucpro.a.c.q.a(r1, r2);
        r1 = "UserAgentType";
        com.ucpro.a.c.p.a(r1, r0);
        goto L_0x01ef;
    L_0x03dc:
        r4 = "NetworkCdRecylce should not set";
        com.ucweb.common.util.c.a(r4);
        r4 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r1 = com.ucpro.a.c.q.a(r1, r4);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x03ed:
        r4 = "NetworkStatsServiceUploadMode should not set";
        com.ucweb.common.util.c.a(r4);
        r1 = com.ucpro.a.c.q.a(r1, r6);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x03fb:
        r4 = "AdvancedPageCacheSize should not set";
        com.ucweb.common.util.c.a(r4);
        r4 = 10;
        r1 = com.ucpro.a.c.q.a(r1, r4);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x040b:
        r4 = "AdvancedDiskCacheMode should not set";
        com.ucweb.common.util.c.a(r4);
        r1 = com.ucpro.a.c.q.a(r1, r2);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x0419:
        r0 = com.ucpro.a.c.q.a(r1, r2);
        if (r0 < 0) goto L_0x0421;
    L_0x041f:
        if (r0 <= r7) goto L_0x0422;
    L_0x0421:
        r0 = r3;
    L_0x0422:
        r1 = com.ucpro.a.c.l.a();
        r0 = r1[r0];
        com.ucpro.a.c.j.a(r0);
        goto L_0x01ef;
    L_0x042d:
        r4 = "AdvancedBackForwardListSize should not set";
        com.ucweb.common.util.c.a(r4);
        r4 = 20;
        r1 = com.ucpro.a.c.q.a(r1, r4);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x043d:
        r4 = "DownloadSegmentSize should not set";
        com.ucweb.common.util.c.a(r4);
        r4 = 307200; // 0x4b000 float:4.30479E-40 double:1.51777E-318;
        r1 = com.ucpro.a.c.q.a(r1, r4);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x01ef;
    L_0x044e:
        r0 = com.ucpro.a.c.p.c();
        r4 = r0.iterator();
    L_0x0456:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0482;
    L_0x045c:
        r0 = r4.next();
        r0 = (java.lang.String) r0;
        r1 = r8.get(r0);
        r1 = (java.lang.String) r1;
        if (r1 == 0) goto L_0x0456;
    L_0x046a:
        r5 = com.ucweb.common.util.n.a.a(r0);
        if (r5 != 0) goto L_0x0456;
    L_0x0470:
        if (r1 == 0) goto L_0x0456;
    L_0x0472:
        r0.hashCode();
        r5 = "no other keys should set";
        com.ucweb.common.util.c.a(r5);
        r1 = com.ucpro.a.c.q.a(r1);
        com.ucpro.a.c.p.a(r0, r1);
        goto L_0x0456;
    L_0x0482:
        com.ucpro.a.c.p.g();
        r0 = com.ucpro.a.c.k.a;
        r1 = r0.a;
        if (r1 == 0) goto L_0x04a9;
    L_0x048d:
        r0 = r0.a;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x04a9;
    L_0x0495:
        if (r2 == 0) goto L_0x049e;
    L_0x0497:
        r0 = com.ucpro.a.c.k.a;
        r0.c();
    L_0x049e:
        r0 = r12.l;
        if (r0 == 0) goto L_0x04a8;
    L_0x04a2:
        r0 = r12.l;
        r1 = 4;
        r0.a(r1);
    L_0x04a8:
        return;
    L_0x04a9:
        r2 = r3;
        goto L_0x0495;
    L_0x04ab:
        r4 = r0;
        goto L_0x01e1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.a.g.a(com.uc.webview.export.internal.setup.UCMRunningInfo):void");
    }

    public final synchronized void e() {
        if (this.g != null) {
            m a = b.a;
            e eVar = this.g;
            if (eVar != null) {
                eVar.a(k.a.b(), new o(a));
            }
        }
    }

    public final synchronized void f() {
        if (this.f != null) {
            s a = p.a;
            r rVar = this.f;
            if (rVar != null) {
                Set a2 = k.a.a();
                if (a2 != null) {
                    rVar.a(a2, new j(a));
                }
            }
        }
        if (this.o != null) {
            this.o.a();
        }
    }

    public final void a(UCSetupException uCSetupException) {
        b().b = SystemClock.uptimeMillis();
        String str = "";
        String str2 = "";
        try {
            str = uCSetupException.getRootCause().getClass().getName();
            str2 = uCSetupException.getRootCause().getMessage();
        } catch (Throwable th) {
        }
        int errCode = uCSetupException.errCode();
        this.m = 8;
        com.ucpro.a.d.e eVar = this.h;
        long j = a().b().b - a().b().a;
        String str3 = UCCore.OPTION_LOAD_KERNEL_TYPE;
        String[] strArr = new String[12];
        strArr[0] = "load_result";
        strArr[1] = String.valueOf("error");
        strArr[2] = "new_install";
        strArr[3] = String.valueOf(a().b().c);
        strArr[4] = "load_time";
        strArr[5] = String.valueOf(j);
        strArr[6] = "error_code";
        strArr[7] = String.valueOf(errCode);
        strArr[8] = "error_cause";
        if (str == null) {
            str = "";
        }
        strArr[9] = str;
        strArr[10] = "error_message";
        if (str2 == null) {
            str2 = "";
        }
        strArr[11] = str2;
        eVar.a(str3, strArr);
        if (this.l != null) {
            this.l.a(8);
        }
    }

    public static boolean g() {
        String str = Build.CORE_VERSION;
        if (str.isEmpty() || !str.startsWith("2.")) {
            return false;
        }
        return true;
    }

    public static boolean h() {
        String str = Build.CORE_VERSION;
        if (str.isEmpty() || !str.startsWith("3.")) {
            return false;
        }
        return true;
    }
}
