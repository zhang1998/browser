package com.ucpro.services.download.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.v4.app.bf;
import android.support.v4.app.cq;
import com.quark.browser.R;
import com.uc.quark.af;
import com.uc.quark.filedownloader.aa;
import com.uc.quark.filedownloader.e.e;
import com.uc.quark.x;
import com.ucpro.BrowserActivity;
import com.ucpro.services.download.broadcast.DonwloadBroadcastReceiver;
import com.ucweb.common.util.h.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: ProGuard */
public final class d implements af {
    private static long i = 0;
    private static long j = 1000;
    cq a;
    public f b;
    private SimpleDateFormat c = new SimpleDateFormat("mm':'ss");
    private Date d = new Date();
    private long e = -1;
    private long f = -1;
    private int g = 0;
    private ArrayList<Long> h = new ArrayList();
    private NotificationManager k;
    private Runnable l = new b(this);

    static /* synthetic */ void a(d dVar) {
        if (dVar.b != null && !dVar.b.c()) {
            dVar.d();
        } else if (dVar.h == null || dVar.h.size() == 0) {
            int[] m = x.a().m();
            String str = com.ucweb.common.util.d.a().getString(R.string.app_name) + com.ucweb.common.util.d.a().getString(R.string.download);
            String str2 = (m[1] > 0 ? com.ucweb.common.util.d.a().getString(R.string.download_notification_task) + " " + m[1] + " | " : "") + com.ucweb.common.util.d.a().getString(R.string.download_notification_complete) + " " + m[0];
            dVar.g = 0;
            dVar.a.a(2, false);
            dVar.a.a(0, 0, false);
            if (m[0] == 0 && m[1] == 0) {
                dVar.d();
            } else {
                dVar.a(str, str2, false);
            }
        }
    }

    public static d b() {
        return e.a;
    }

    public d() {
        int i;
        Intent[] intentArr = new Intent[2];
        intentArr[0] = new Intent(com.ucweb.common.util.d.a(), BrowserActivity.class);
        intentArr[0].putExtra("open_type", "enter_download_interface");
        intentArr[1] = new Intent(com.ucweb.common.util.d.a(), DonwloadBroadcastReceiver.class);
        intentArr[1].putExtra("open_type", "pause_all");
        PendingIntent[] pendingIntentArr = new PendingIntent[]{PendingIntent.getActivity(com.ucweb.common.util.d.a(), 0, intentArr[0], 134217728), PendingIntent.getBroadcast(com.ucweb.common.util.d.a(), 1, intentArr[1], 134217728)};
        this.a = new cq(e.a());
        cq cqVar = this.a;
        cqVar.a(2, true);
        cqVar.B.ledARGB = 0;
        cqVar.B.ledOnMS = 0;
        cqVar.B.ledOffMS = 0;
        boolean z = (cqVar.B.ledOnMS == 0 || cqVar.B.ledOffMS == 0) ? false : true;
        Notification notification = cqVar.B;
        int i2 = cqVar.B.flags & -2;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        notification.flags = i | i2;
        cqVar.j = 2;
        cqVar.d = pendingIntentArr[0];
        cqVar.B.when = 0;
        cqVar.a(16, true);
        cqVar.B.icon = R.mipmap.notification_small_icon;
        cqVar.g = BitmapFactory.decodeResource(com.ucweb.common.util.d.a().getResources(), R.mipmap.ic_launcher);
        cqVar.u.add(new bf(e.a().getString(R.string.download_notification_pause_all), pendingIntentArr[1]));
    }

    public final NotificationManager c() {
        if (this.k == null) {
            this.k = (NotificationManager) com.ucweb.common.util.d.a().getSystemService("notification");
        }
        return this.k;
    }

    public final void a(int i, aa aaVar) {
        if (aaVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - i >= j || i != 3) {
                i = currentTimeMillis;
                m.a(0, new a(this, i, aaVar));
            }
        }
    }

    private static int a(List<Long> list, int i) {
        if (list == null || list.size() == 0) {
            return -1;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((Long) list.get(i2)).longValue() == ((long) i)) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public final boolean a() {
        m.a(new c(this));
        return false;
    }

    private void a(String str, String str2, boolean z) {
        try {
            if (VERSION.SDK_INT >= 24) {
                this.a.a(str2).c(str);
            } else {
                this.a.a(str).b(str2);
            }
            this.a.i = this.g;
            Notification a = this.a.a();
            int identifier = com.ucweb.common.util.d.a().getResources().getIdentifier("right_icon", "id", android.R.class.getPackage().getName());
            if (identifier != 0) {
                if (a.contentView != null) {
                    a.contentView.setViewVisibility(identifier, 4);
                }
                if (VERSION.SDK_INT >= 16 && a.bigContentView != null) {
                    a.bigContentView.setViewVisibility(identifier, 4);
                }
            }
            if (z) {
                x.a();
                x.a(a);
                return;
            }
            x.a();
            if (x.l().length == 0) {
                x.a();
                x.d();
                c().notify(4628, a);
            }
        } catch (Exception e) {
        }
    }

    public final void d() {
        m.c(this.l);
        m.a(0, this.l);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.ucpro.services.download.b.d r14, int r15, com.uc.quark.filedownloader.aa r16) {
        /*
        if (r16 == 0) goto L_0x0011;
    L_0x0002:
        r0 = r14.b;
        if (r0 == 0) goto L_0x0012;
    L_0x0006:
        r0 = r14.b;
        r0 = r0.c();
        if (r0 != 0) goto L_0x0012;
    L_0x000e:
        r14.d();
    L_0x0011:
        return;
    L_0x0012:
        r0 = -3;
        if (r15 == r0) goto L_0x0048;
    L_0x0015:
        r0 = -1;
        if (r15 == r0) goto L_0x0048;
    L_0x0018:
        r0 = -2;
        if (r15 == r0) goto L_0x0048;
    L_0x001b:
        r0 = -5;
        if (r15 == r0) goto L_0x0048;
    L_0x001e:
        r0 = r14.e;
        r2 = -1;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0196;
    L_0x0026:
        r0 = java.lang.System.currentTimeMillis();
        r14.f = r0;
        r0 = r16.e();
        r0 = (long) r0;
        r14.e = r0;
        r0 = r14.h;
        r2 = r14.e;
        r1 = java.lang.Long.valueOf(r2);
        r0.add(r1);
        com.uc.quark.x.a();
        r0 = com.uc.quark.x.l();
        r0 = r0.length;
        r14.g = r0;
    L_0x0048:
        r0 = r16.e();
        r0 = (long) r0;
        r14.e = r0;
        r0 = r14.h;
        r2 = r14.e;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.contains(r1);
        if (r0 != 0) goto L_0x0068;
    L_0x005d:
        r0 = r14.h;
        r2 = r14.e;
        r1 = java.lang.Long.valueOf(r2);
        r0.add(r1);
    L_0x0068:
        switch(r15) {
            case -5: goto L_0x021f;
            case -4: goto L_0x006b;
            case -3: goto L_0x0247;
            case -2: goto L_0x021f;
            case -1: goto L_0x0204;
            case 0: goto L_0x006b;
            case 1: goto L_0x01df;
            case 2: goto L_0x006b;
            case 3: goto L_0x006b;
            case 4: goto L_0x006b;
            case 5: goto L_0x006b;
            case 6: goto L_0x01f8;
            default: goto L_0x006b;
        };
    L_0x006b:
        r0 = r14.h;
        r0 = r0.size();
        r1 = r14.g;
        if (r0 == r1) goto L_0x007f;
    L_0x0075:
        com.uc.quark.x.a();
        r0 = com.uc.quark.x.l();
        r0 = r0.length;
        r14.g = r0;
    L_0x007f:
        r2 = r16.r();
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x026f;
    L_0x0089:
        r0 = java.util.Locale.CHINESE;
        r1 = "%#.1fM/s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = (float) r2;
        r7 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r6 = r6 / r7;
        r6 = java.lang.Float.valueOf(r6);
        r4[r5] = r6;
        r0 = java.lang.String.format(r0, r1, r4);
    L_0x009f:
        r6 = r16.o();
        r8 = r16.q();
        r4 = 0;
        r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r1 > 0) goto L_0x0283;
    L_0x00ad:
        r1 = 0;
        r4 = r1;
    L_0x00af:
        r1 = -3;
        if (r15 != r1) goto L_0x00bb;
    L_0x00b2:
        com.uc.quark.x.a();
        r1 = com.uc.quark.x.k();
        if (r1 != 0) goto L_0x00c4;
    L_0x00bb:
        r1 = -1;
        if (r15 == r1) goto L_0x00c4;
    L_0x00be:
        r1 = -2;
        if (r15 == r1) goto L_0x00c4;
    L_0x00c1:
        r1 = -5;
        if (r15 != r1) goto L_0x0291;
    L_0x00c4:
        r1 = r14.h;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0291;
    L_0x00cc:
        r0 = com.ucpro.c.b.b();
        if (r0 == 0) goto L_0x00f6;
    L_0x00d2:
        r0 = "vanda";
        r1 = new java.lang.StringBuilder;
        r2 = "show status:";
        r1.<init>(r2);
        r1 = r1.append(r15);
        r2 = "   list size:";
        r1 = r1.append(r2);
        r2 = r14.h;
        r2 = r2.size();
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.e(r0, r1);
    L_0x00f6:
        r0 = com.uc.quark.x.a();
        r1 = r0.m();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = com.ucweb.common.util.d.a();
        r3 = 2131099686; // 0x7f060026 float:1.7811732E38 double:1.0529031427E-314;
        r2 = r2.getString(r3);
        r0 = r0.append(r2);
        r2 = com.ucweb.common.util.d.a();
        r3 = 2131099852; // 0x7f0600cc float:1.7812069E38 double:1.0529032247E-314;
        r2 = r2.getString(r3);
        r0 = r0.append(r2);
        r2 = r0.toString();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = 1;
        r0 = r1[r0];
        if (r0 <= 0) goto L_0x028d;
    L_0x012f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = com.ucweb.common.util.d.a();
        r5 = 2131099878; // 0x7f0600e6 float:1.7812122E38 double:1.0529032376E-314;
        r4 = r4.getString(r5);
        r0 = r0.append(r4);
        r4 = " ";
        r0 = r0.append(r4);
        r4 = 1;
        r4 = r1[r4];
        r0 = r0.append(r4);
        r4 = "  |  ";
        r0 = r0.append(r4);
        r0 = r0.toString();
    L_0x015a:
        r0 = r3.append(r0);
        r3 = com.ucweb.common.util.d.a();
        r4 = 2131099874; // 0x7f0600e2 float:1.7812114E38 double:1.0529032356E-314;
        r3 = r3.getString(r4);
        r0 = r0.append(r3);
        r3 = " ";
        r0 = r0.append(r3);
        r3 = 0;
        r1 = r1[r3];
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = 0;
        r14.g = r1;
        r1 = r14.a;
        r3 = 2;
        r4 = 0;
        r1.a(r3, r4);
        r1 = r14.a;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1.a(r3, r4, r5);
        r1 = 0;
        r14.a(r2, r0, r1);
        goto L_0x0011;
    L_0x0196:
        r0 = r14.h;
        r1 = r16.e();
        r2 = (long) r1;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x01bf;
    L_0x01a7:
        r0 = r14.e;
        r2 = r16.e();
        r2 = (long) r2;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x01bf;
    L_0x01b2:
        r0 = java.lang.System.currentTimeMillis();
        r2 = r14.f;
        r0 = r0 - r2;
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0011;
    L_0x01bf:
        r0 = r14.e;
        r2 = r16.e();
        r2 = (long) r2;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x0048;
    L_0x01ca:
        r0 = java.lang.System.currentTimeMillis();
        r2 = r14.f;
        r0 = r0 - r2;
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0048;
    L_0x01d7:
        r0 = java.lang.System.currentTimeMillis();
        r14.f = r0;
        goto L_0x0048;
    L_0x01df:
        r0 = com.ucpro.c.b.b();
        if (r0 == 0) goto L_0x01ec;
    L_0x01e5:
        r0 = "vanda";
        r1 = "notification pending";
        android.util.Log.e(r0, r1);
    L_0x01ec:
        com.uc.quark.x.a();
        r0 = com.uc.quark.x.l();
        r0 = r0.length;
        r14.g = r0;
        goto L_0x006b;
    L_0x01f8:
        com.uc.quark.x.a();
        r0 = com.uc.quark.x.l();
        r0 = r0.length;
        r14.g = r0;
        goto L_0x006b;
    L_0x0204:
        r0 = r14.h;
        r2 = r14.e;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x006b;
    L_0x0212:
        r0 = r14.h;
        r2 = r14.e;
        r1 = java.lang.Long.valueOf(r2);
        r0.remove(r1);
        goto L_0x006b;
    L_0x021f:
        r0 = com.ucpro.c.b.b();
        if (r0 == 0) goto L_0x022c;
    L_0x0225:
        r0 = "vanda";
        r1 = "notification pause";
        android.util.Log.e(r0, r1);
    L_0x022c:
        r0 = r14.h;
        r2 = r14.e;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x006b;
    L_0x023a:
        r0 = r14.h;
        r2 = r14.e;
        r1 = java.lang.Long.valueOf(r2);
        r0.remove(r1);
        goto L_0x006b;
    L_0x0247:
        r0 = com.ucpro.c.b.b();
        if (r0 == 0) goto L_0x0254;
    L_0x024d:
        r0 = "vanda";
        r1 = "notification completed";
        android.util.Log.e(r0, r1);
    L_0x0254:
        r0 = r14.h;
        r2 = r14.e;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x006b;
    L_0x0262:
        r0 = r14.h;
        r2 = r14.e;
        r1 = java.lang.Long.valueOf(r2);
        r0.remove(r1);
        goto L_0x006b;
    L_0x026f:
        r0 = java.util.Locale.CHINESE;
        r1 = "%dK/s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Long.valueOf(r2);
        r4[r5] = r6;
        r0 = java.lang.String.format(r0, r1, r4);
        goto L_0x009f;
    L_0x0283:
        r1 = (float) r6;
        r4 = (float) r8;
        r1 = r1 / r4;
        r4 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r1 = r1 * r4;
        r1 = (int) r1;
        r4 = r1;
        goto L_0x00af;
    L_0x028d:
        r0 = "";
        goto L_0x015a;
    L_0x0291:
        r1 = r14.g;
        r5 = 1;
        if (r1 <= r5) goto L_0x034c;
    L_0x0296:
        r1 = r14.h;
        r5 = r16.e();
        r1 = a(r1, r5);
    L_0x02a0:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        if (r1 <= 0) goto L_0x034f;
    L_0x02a7:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r1 = r10.append(r1);
        r10 = ". ";
        r1 = r1.append(r10);
        r1 = r1.toString();
    L_0x02ba:
        r1 = r5.append(r1);
        r5 = r16.k();
        r1 = r1.append(r5);
        r5 = r1.toString();
        r10 = 0;
        r1 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r1 > 0) goto L_0x0353;
    L_0x02d0:
        r2 = r8 - r6;
    L_0x02d2:
        r1 = r14.d;
        r1.setTime(r2);
        r10 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r1 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0359;
    L_0x02de:
        r1 = ">1 hour";
    L_0x02e0:
        r3 = "%s%s%s%s/%s%s%s%s%s";
        r2 = 9;
        r10 = new java.lang.Object[r2];
        r11 = 0;
        r12 = 0;
        r2 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r2 > 0) goto L_0x0363;
    L_0x02ed:
        r2 = "...";
    L_0x02ef:
        r10[r11] = r2;
        r2 = 1;
        r4 = "%";
        r10[r2] = r4;
        r2 = 2;
        r4 = "  |  ";
        r10[r2] = r4;
        r2 = 3;
        r4 = com.ucpro.base.system.b.a;
        r4 = r4.a(r6);
        r10[r2] = r4;
        r2 = 4;
        r4 = com.ucpro.base.system.b.a;
        r4 = r4.a(r8);
        r10[r2] = r4;
        r2 = 5;
        r4 = "  |  ";
        r10[r2] = r4;
        r2 = 6;
        r10[r2] = r0;
        r0 = 7;
        r2 = "  |  ";
        r10[r0] = r2;
        r0 = 8;
        r12 = 0;
        r2 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r2 > 0) goto L_0x0324;
    L_0x0322:
        r1 = "...";
    L_0x0324:
        r10[r0] = r1;
        r1 = java.lang.String.format(r3, r10);
        r0 = r14.a;
        r2 = 2;
        r3 = 1;
        r0.a(r2, r3);
        r2 = r14.a;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = (float) r6;
        r4 = (float) r8;
        r0 = r0 / r4;
        r4 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r0 = r0 * r4;
        r4 = (int) r0;
        r6 = 0;
        r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r0 > 0) goto L_0x0368;
    L_0x0342:
        r0 = 1;
    L_0x0343:
        r2.a(r3, r4, r0);
        r0 = 1;
        r14.a(r5, r1, r0);
        goto L_0x0011;
    L_0x034c:
        r1 = -1;
        goto L_0x02a0;
    L_0x034f:
        r1 = "";
        goto L_0x02ba;
    L_0x0353:
        r10 = r8 - r6;
        r2 = r10 / r2;
        goto L_0x02d2;
    L_0x0359:
        r1 = r14.c;
        r2 = r14.d;
        r1 = r1.format(r2);
        goto L_0x02e0;
    L_0x0363:
        r2 = java.lang.String.valueOf(r4);
        goto L_0x02ef;
    L_0x0368:
        r0 = 0;
        goto L_0x0343;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.services.download.b.d.a(com.ucpro.services.download.b.d, int, com.uc.quark.filedownloader.aa):void");
    }
}
