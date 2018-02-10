package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.APSServiceBase;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.uc.apollo.impl.SettingsConst;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class au implements APSServiceBase {
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private long H = 0;
    private long I = 0;
    private cb J = null;
    private boolean K = true;
    private String L = "";
    Context a;
    boolean b = false;
    Messenger c = null;
    String d = null;
    Messenger e;
    as f = new as(this, this);
    ar g = null;
    Vector<Messenger> h = new Vector();
    Vector<Messenger> i = new Vector();
    boolean j = false;
    volatile boolean k = false;
    boolean l = false;
    Object m = new Object();
    AmapLoc n;
    long o = dm.b();
    long p = 0;
    volatile int q = 0;
    JSONObject r = new JSONObject();
    AmapLoc s;
    volatile ServerSocket t = null;
    boolean u = false;
    volatile Socket v = null;
    boolean w = false;
    at x;
    private volatile boolean y = false;
    private int z = 0;

    public au(Context context) {
        this.a = context.getApplicationContext();
    }

    private static AmapLoc b(int i, String str) {
        try {
            AmapLoc amapLoc = new AmapLoc();
            amapLoc.a(i);
            amapLoc.a(str);
            return amapLoc;
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    private boolean c() {
        boolean z;
        synchronized (this.m) {
            z = this.k;
        }
        return z;
    }

    private void d() {
        try {
            if (!this.y) {
                e();
            }
        } catch (Throwable th) {
            this.K = false;
            this.L = th.getMessage();
            cq.a(th, "APSServiceCore", "init");
        }
    }

    private void e() {
        try {
            cq.a(this.a);
            this.r.put("User-Agent", "AMAP_Location_SDK_Android 2.8.0");
            this.r.put("netloc", SettingsConst.FALSE);
            this.r.put("gpsstatus", SettingsConst.FALSE);
            this.r.put("nbssid", SettingsConst.FALSE);
            if (!this.r.has("reversegeo")) {
                this.r.put("reversegeo", true);
            }
            if (!this.r.has("isOffset")) {
                this.r.put("isOffset", true);
            }
            this.r.put("wait1stwifi", SettingsConst.FALSE);
            this.r.put("autoup", SettingsConst.FALSE);
            this.r.put("upcolmobile", 1);
            if (!this.r.has("enablegetreq")) {
                this.r.put("enablegetreq", 1);
            }
            if (!this.r.has("wifiactivescan")) {
                this.r.put("wifiactivescan", 1);
            }
            if (!this.r.has("isLocationCacheEnable")) {
                this.r.put("isLocationCacheEnable", true);
            }
        } catch (Throwable th) {
            this.L = th.getMessage();
            this.K = false;
            cq.a(th, "APSServiceCore", "doInit part3");
            return;
        }
        this.y = true;
        this.J.a(this.r);
        this.J.c(this.a);
    }

    public final synchronized void a() {
        try {
            if (!this.w) {
                this.x = new at(this);
                this.x.start();
                this.w = true;
            }
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "startSocket");
        }
    }

    public final synchronized void b() {
        try {
            if (this.t != null) {
                this.t.close();
            }
            if (this.v != null) {
                this.v.close();
            }
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "stopScocket");
        }
        this.t = null;
        this.x = null;
        this.w = false;
        this.u = false;
    }

    public IBinder onBind(Intent intent) {
        Object stringExtra = intent.getStringExtra("apiKey");
        if (!TextUtils.isEmpty(stringExtra)) {
            ee.a(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("packageName");
        String stringExtra3 = intent.getStringExtra("sha1AndPackage");
        this.j = "true".equals(intent.getStringExtra("as"));
        if (this.j && this.f != null) {
            this.f.sendEmptyMessageDelayed(9, 100);
        }
        dx.a(stringExtra2);
        dx.b(stringExtra3);
        this.e = new Messenger(this.f);
        return this.e.getBinder();
    }

    public void onCreate() {
        try {
            this.J = new cb();
            this.d = this.a.getApplicationContext().getPackageName();
            this.k = true;
            this.g = new ar(this);
            this.g.setName("serviceThread");
            this.g.start();
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "onCreate");
        }
    }

    public void onDestroy() {
        try {
            synchronized (this.m) {
                this.k = false;
                this.m.notify();
            }
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "onDestroy");
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 0;
    }

    static /* synthetic */ void a(au auVar, JSONObject jSONObject) {
        try {
            if (auVar.J != null) {
                auVar.J.a(jSONObject);
            }
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "setExtra");
        }
    }

    static /* synthetic */ void m(au auVar) {
        try {
            auVar.J.d(auVar.a);
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "initAuth");
        }
    }

    static /* synthetic */ void a(au auVar, boolean z, Context context) {
        try {
            auVar.J.a(z, context);
        } catch (Throwable th) {
        }
    }

    static /* synthetic */ void a(au auVar, Messenger messenger) {
        try {
            if (de.r()) {
                if (messenger == null && !auVar.h.isEmpty()) {
                    messenger = (Messenger) auVar.h.get(0);
                }
                if (messenger != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 100;
                    messenger.send(obtain);
                }
            }
            if (de.a(auVar.I) && !auVar.C && auVar.n != null && (auVar.q == 2 || auVar.q == 4)) {
                auVar.D = true;
                auVar.C = true;
            }
            if (de.a() && !auVar.A) {
                auVar.A = true;
                auVar.f.sendEmptyMessage(4);
            }
            if (de.c() && de.d() > 2 && !auVar.B) {
                auVar.B = true;
                auVar.f.sendEmptyMessage(5);
            }
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "checkConfig");
        }
    }

    static /* synthetic */ void n(au auVar) {
        try {
            auVar.d();
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "doFusionLocaiton:init");
        }
        if (auVar.D) {
            auVar.I = dm.b();
            auVar.D = false;
            auVar.J.b();
        }
        if (auVar.E) {
            auVar.E = false;
            auVar.J.b();
        }
        if (auVar.F) {
            auVar.F = false;
            auVar.J.b();
        }
        if (auVar.G && de.b(auVar.H)) {
            auVar.H = dm.a();
            auVar.G = false;
            auVar.J.b();
        }
    }

    static /* synthetic */ void o(au auVar) {
        Object obj = 1;
        try {
            if (auVar.J != null) {
                cb cbVar = auVar.J;
                if (de.u()) {
                    Context context = cbVar.a;
                    if (cbVar.c == null) {
                        cbVar.c = ac.a(context, cq.a("Collection", "1.0.0"), cbVar.j, null, new Class[]{Context.class}, new Object[]{context});
                    }
                }
                if (!cbVar.o || !de.u() || cbVar.e() || !cbVar.d()) {
                    return;
                }
                if (de.u()) {
                    if (dm.a(cbVar.b, "coll")) {
                        try {
                            Object obj2;
                            if (cbVar.b.getString("coll").equals(SettingsConst.FALSE)) {
                                obj2 = null;
                            } else {
                                int i = 1;
                            }
                            obj = obj2;
                        } catch (Throwable th) {
                            cq.a(th, "APS", "start3rdCM");
                        }
                    }
                    if (obj == null) {
                        cbVar.g();
                        return;
                    } else if (!cbVar.e()) {
                        try {
                            cbVar.f();
                            try {
                                dg.a(cbVar.c, "start", new Object[0]);
                                return;
                            } catch (Throwable th2) {
                                return;
                            }
                        } catch (Throwable th3) {
                            cq.a(th3, "APS", "start3rdCM");
                            return;
                        }
                    } else {
                        return;
                    }
                }
                cbVar.g();
            }
        } catch (Throwable th32) {
            cq.a(th32, "APSServiceCore", "startColl");
        }
    }

    static /* synthetic */ void p(au auVar) {
        try {
            auVar.b();
            auVar.y = false;
            auVar.A = false;
            auVar.B = false;
            auVar.z = 0;
            auVar.J.c();
            auVar.h.clear();
            fa.a();
            if (auVar.b) {
                Process.killProcess(Process.myPid());
            }
            if (auVar.f != null) {
                auVar.f.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            cq.a(th, "APSServiceCore", "threadDestroy");
        }
    }

    static /* synthetic */ void a(au auVar, Socket socket) {
        Throwable th;
        PrintStream printStream;
        String str = null;
        int i = 0;
        if (socket != null) {
            int i2 = 30000;
            try {
                String str2 = "jsonp1";
                System.currentTimeMillis();
                BufferedReader bufferedReader;
                PrintStream printStream2;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    String readLine = bufferedReader.readLine();
                    if (readLine != null && readLine.length() > 0) {
                        String[] split = readLine.split(" ");
                        if (split != null && split.length > 1) {
                            split = split[1].split("\\?");
                            if (split != null && split.length > 1) {
                                split = split[1].split("&");
                                if (split != null && split.length > 0) {
                                    String str3 = str2;
                                    int i3 = 30000;
                                    String str4 = str3;
                                    while (i < split.length) {
                                        try {
                                            String[] split2 = split[i].split("=");
                                            if (split2 != null && split2.length > 1) {
                                                if ("to".equals(split2[0])) {
                                                    i3 = Integer.parseInt(split2[1]);
                                                }
                                                if ("callback".equals(split2[0])) {
                                                    str4 = split2[1];
                                                }
                                                if ("_".equals(split2[0])) {
                                                    Long.parseLong(split2[1]);
                                                }
                                            }
                                            i++;
                                        } catch (Throwable th2) {
                                            Throwable th3 = th2;
                                            str2 = str4;
                                            th = th3;
                                        }
                                    }
                                    str3 = str4;
                                    i2 = i3;
                                    str2 = str3;
                                }
                            }
                        }
                    }
                    try {
                        i = cq.e;
                        cq.e = i2;
                        long currentTimeMillis = System.currentTimeMillis();
                        if ((auVar.s == null || currentTimeMillis - auVar.s.e > 5000) && !dm.d(auVar.a)) {
                            auVar.s = auVar.J.a();
                            if (auVar.s.g != 0) {
                                str = str2 + "&&" + str2 + "({'package':'" + auVar.d + "','error_code':" + auVar.s.g + ",'error':'" + auVar.s.h + "'})";
                            }
                            cq.e = i;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            str = str2 + "&&" + str2 + "({'package':'" + auVar.d + "','error_code':1,'error':'params error'})";
                            cq.a(th, "APSServiceCore", "invoke part2");
                            try {
                                printStream2 = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                                new StringBuilder("Content-Length:").append(str.getBytes("UTF-8").length);
                                printStream2.close();
                                try {
                                    bufferedReader.close();
                                    socket.close();
                                } catch (Throwable th5) {
                                    cq.a(th5, "APSServiceCore", "invoke part4");
                                    return;
                                }
                            } catch (Throwable th52) {
                                cq.a(th52, "APSServiceCore", "invoke part4");
                                return;
                            }
                        } catch (Throwable th6) {
                            th52 = th6;
                            try {
                                printStream = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                                new StringBuilder("Content-Length:").append(str.getBytes("UTF-8").length);
                                printStream.close();
                                try {
                                    bufferedReader.close();
                                    socket.close();
                                } catch (Throwable th22) {
                                    cq.a(th22, "APSServiceCore", "invoke part4");
                                }
                            } catch (Throwable th222) {
                                cq.a(th222, "APSServiceCore", "invoke part4");
                            }
                            throw th52;
                        }
                    }
                    if (str == null) {
                        if (auVar.s == null) {
                            str = str2 + "&&" + str2 + "({'package':'" + auVar.d + "','error_code':8,'error':'unknown error'})";
                        } else {
                            AmapLoc amapLoc = auVar.s;
                            str = str2 + "&&" + str2 + "({'package':'" + auVar.d + "','error_code':0,'error':'','location':{'y':" + amapLoc.c + ",'precision':" + amapLoc.d + ",'x':" + amapLoc.b + "},'version_code':'2.8.0','version':'2.8.0'})";
                        }
                        if (dm.d(auVar.a)) {
                            str = str2 + "&&" + str2 + "({'package':'" + auVar.d + "','error_code':36,'error':'app is background'})";
                        }
                    }
                    try {
                        printStream2 = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                        new StringBuilder("Content-Length:").append(str.getBytes("UTF-8").length);
                        printStream2.close();
                        bufferedReader.close();
                        socket.close();
                    } catch (Throwable th522) {
                        cq.a(th522, "APSServiceCore", "invoke part4");
                    }
                } catch (Throwable th7) {
                    th522 = th7;
                    bufferedReader = null;
                    printStream = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                    new StringBuilder("Content-Length:").append(str.getBytes("UTF-8").length);
                    printStream.close();
                    bufferedReader.close();
                    socket.close();
                    throw th522;
                }
            } catch (Throwable th5222) {
                cq.a(th5222, "APSServiceCore", "invoke part5");
            }
        }
    }
}
