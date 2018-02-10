package com.loc;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.uc.webview.browser.interfaces.IWebResources;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

/* compiled from: ProGuard */
public final class z extends Thread implements bk {
    private aa a;
    private bl b;
    private ep c;
    private String d;
    private RandomAccessFile e;
    private Context f;

    public z(Context context, aa aaVar, ep epVar) {
        try {
            this.f = context.getApplicationContext();
            this.c = epVar;
            if (aaVar != null) {
                this.a = aaVar;
                this.b = new bl(new ah(this.a));
                this.d = ak.a(context, this.a.c);
            }
        } catch (Throwable th) {
            es.a(th, "DexDownLoad", "DexDownLoad()");
        }
    }

    private boolean a(n nVar, aq aqVar, aa aaVar) {
        String str = aaVar.d;
        String str2 = aaVar.e;
        String str3 = aaVar.f;
        String str4 = aaVar.g;
        if ("errorstatus".equals(aqVar.e)) {
            if (!new File(ak.b(this.f, this.c.a(), this.c.b())).exists()) {
                if (TextUtils.isEmpty(ak.a(this.f, nVar, this.c))) {
                    return true;
                }
                try {
                    ag.a().b(this.f, this.c);
                } catch (Throwable th) {
                }
            }
            return true;
        } else if (!new File(this.d).exists()) {
            return false;
        } else {
            if (nVar.a(aq.a(ak.a(this.f, str, str2), str, str2, str3), aq.class, false).size() > 0) {
                return true;
            }
            try {
                ap apVar = new ap(ak.a(this.f, str, this.c.b()), str4, str, str2, str3);
                apVar.f = "used";
                ak.a(this.f, nVar, this.c, apVar.a(), this.d);
                ag.a().b(this.f, this.c);
            } catch (Throwable th2) {
                es.a(th2, "DexDownLoad", "processDownloadedFile()");
            }
            return true;
        }
    }

    private boolean d() {
        n nVar = new n(this.f, ao.b());
        try {
            List a = aj.a(nVar, this.a.d, "used");
            if (a != null && a.size() > 0 && av.a(((aq) a.get(0)).d, this.a.f) > 0) {
                return true;
            }
        } catch (Throwable th) {
            es.a(th, "DexDownLoad", "isDownloaded()");
        }
        aq a2 = aj.a(nVar, this.a.c);
        return a2 != null ? a(nVar, a2, this.a) : false;
    }

    private boolean e() {
        try {
            Object obj = (this.c != null && this.c.a().equals(this.a.d) && this.c.b().equals(this.a.e)) ? 1 : null;
            if (!(obj == null || d())) {
                obj = (VERSION.SDK_INT < this.a.i || VERSION.SDK_INT > this.a.h) ? null : 1;
                if (obj != null) {
                    if ((ei.m(this.f) == 1 ? 1 : null) != null) {
                        Context context = this.f;
                        String a = this.c.a();
                        n nVar = new n(context, ao.b());
                        List a2 = aj.a(nVar, a, IWebResources.TEXT_COPY);
                        ak.a(a2);
                        if (a2 != null && a2.size() > 1) {
                            int size = a2.size();
                            for (int i = 1; i < size; i++) {
                                ak.b(context, nVar, ((aq) a2.get(i)).a);
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            es.a(th, "DexDownLoad", "isNeedDownload()");
            return false;
        }
    }

    public final void a() {
        try {
            if (this.e != null) {
                this.e.close();
            }
        } catch (Throwable th) {
            es.a(th, "DexDownLoad", "onException()");
        }
    }

    public final void a(byte[] bArr, long j) {
        try {
            if (this.e == null) {
                File file = new File(this.d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.e = new RandomAccessFile(file, "rw");
            }
            this.e.seek(j);
            this.e.write(bArr);
        } catch (Throwable th) {
            es.a(th, "DexDownLoad", "onDownload()");
        }
    }

    public final void b() {
        try {
            if (this.e != null) {
                try {
                    this.e.close();
                } catch (Throwable th) {
                    es.a(th, "DexDownLoad", "onFinish3");
                }
                String str = this.a.b;
                if (ak.a(this.d, str)) {
                    String str2 = this.a.e;
                    n nVar = new n(this.f, ao.b());
                    ap apVar = new ap(this.a.c, str, this.a.d, str2, this.a.f);
                    apVar.f = IWebResources.TEXT_COPY;
                    nVar.a(apVar.a(), aq.a(this.a.c, this.a.d, str2, this.a.f));
                    Editor edit = this.f.getSharedPreferences(this.a.d, 0).edit();
                    edit.clear();
                    edit.commit();
                    apVar = new ap(ak.a(this.f, this.a.d, this.c.b()), str, this.a.d, str2, this.a.f);
                    apVar.f = "used";
                    ak.a(this.f, nVar, this.c, apVar.a(), this.d);
                    ag.a().b(this.f, this.c);
                    return;
                }
                try {
                    new File(this.d).delete();
                } catch (Throwable th2) {
                    es.a(th2, "DexDownLoad", "onFinish");
                }
            }
        } catch (Throwable th22) {
            es.a(th22, "DexDownLoad", "onFinish()");
        }
    }

    public final void c() {
    }

    public final void run() {
        try {
            if (e()) {
                this.b.a(this);
            }
        } catch (Throwable th) {
            es.a(th, "DexDownLoad", "run()");
        }
    }
}
