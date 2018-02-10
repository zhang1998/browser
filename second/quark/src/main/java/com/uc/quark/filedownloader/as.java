package com.uc.quark.filedownloader;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import com.uc.quark.ad;
import com.uc.quark.filedownloader.contentprovider.a;
import com.uc.quark.filedownloader.e.b;
import com.uc.quark.filedownloader.e.e;
import com.uc.quark.filedownloader.e.h;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.model.FileDownloadTaskList;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public class as {
    public static final Object b = new Object();
    private static volatile Object c = new Object();
    private static volatile Object d = new Object();
    public Runnable a;
    private c e;

    public static as a() {
        return j.a;
    }

    public static aa a(String str) {
        return new s(str);
    }

    public static void a(ArrayList<Integer> arrayList, boolean z) {
        if (arrayList != null && n.a.d()) {
            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList(e.e, arrayList);
            n.a.a(bundle, z);
        }
    }

    private static void a(List<HashMap<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e.d, arrayList);
        n.a.a(bundle);
    }

    public static byte a(int i, String str) {
        byte c = (byte) a.c(i);
        if (c == (byte) -3 || c == (byte) -1) {
            return c;
        }
        if (!n.a.d()) {
            return c;
        }
        at b = ak.a.b(i);
        if (b == null) {
            c = n.a.d(i);
        } else {
            c = b.M().s();
        }
        if (str != null && c == (byte) 0) {
            File file = new File(str);
            if (b.c(e.a()) && file.exists()) {
                return (byte) -3;
            }
        }
        return c;
    }

    public static void a(ai aiVar) {
        a.a().a("event.service.connect.changed", aiVar);
    }

    public static void b(ai aiVar) {
        a.a().b("event.service.connect.changed", aiVar);
    }

    final c i() {
        if (this.e == null) {
            synchronized (d) {
                if (this.e == null) {
                    this.e = new i();
                    a((ai) this.e);
                }
            }
        }
        return this.e;
    }

    public static void a(Context context, ad adVar) {
        if (j.a) {
            j.d(as.class, "init Downloader", new Object[0]);
        }
        e.a(context);
        n.a.a = adVar;
        try {
            b.a(h.a().a);
            b.a(h.a().b);
        } catch (IllegalAccessException e) {
        }
    }

    public final int a(int i) {
        List<at> c = ak.a.c(i);
        if (c.isEmpty()) {
            j.e(this, "request pause but not exist %d", Integer.valueOf(i));
            return 0;
        }
        for (at M : c) {
            M.M().d();
        }
        return c.size();
    }

    public static void a(ArrayList<r> arrayList) {
        if (n.a.d()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            int i = 0;
            List list = arrayList2;
            while (it.hasNext()) {
                List arrayList3;
                int i2;
                r rVar = (r) it.next();
                int i3 = i + 1;
                list.add(new FileDownloadTaskList(rVar.a, rVar.b, rVar.c, rVar.d, rVar.e, rVar.f, rVar.g, rVar.h).k);
                if (i3 == 450) {
                    a(list);
                    arrayList3 = new ArrayList();
                    arrayList3.clear();
                    i2 = 0;
                } else {
                    i2 = i3;
                    arrayList3 = list;
                }
                list = arrayList3;
                i = i2;
            }
            if (i != 0) {
                a(list);
            }
        }
    }

    public static byte[] b() {
        return n.a.e();
    }

    public static void c() {
        if (!n.a.d()) {
            n.a.a(e.a());
        }
    }

    public static void d() {
        if (n.a.d()) {
            n.a.a(true);
            n.a.b(e.a());
        }
    }

    public static boolean e() {
        if (!n.a.d() || !ak.a.a.isEmpty() || !n.a.c()) {
            return false;
        }
        d();
        return true;
    }

    public static boolean f() {
        return n.a.d();
    }

    public static boolean g() {
        return n.a.c();
    }

    public static void a(int i, Notification notification) {
        n.a.a(i, notification);
    }

    public static void h() {
        n.a.a(true);
    }
}
