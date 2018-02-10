package com.uc.a.f;

import com.uc.a.e;
import com.uc.a.f;
import com.uc.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.OkHttpClient;

/* compiled from: ProGuard */
public final class d implements f {
    protected Map<Integer, ArrayList<com.uc.a.d>> a = new HashMap();
    protected Map<Integer, Boolean> b = new ConcurrentHashMap();
    com.uc.a.e.d c;
    private OkHttpClient d;

    public d(OkHttpClient okHttpClient) {
        this.d = okHttpClient;
        this.a.put(Integer.valueOf(1), new ArrayList());
    }

    private void a(int i, boolean z) {
        this.b.put(Integer.valueOf(i), Boolean.valueOf(z));
    }

    public final boolean a(int i) {
        boolean booleanValue;
        Boolean bool = (Boolean) this.b.get(Integer.valueOf(i));
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            booleanValue = false;
        }
        if (booleanValue) {
            return true;
        }
        a(i, true);
        if (this.c == null) {
            throw new RuntimeException("Dispatcher request builder is not set!");
        }
        h.a();
        booleanValue = h.a(this.c, this.d).a(i, (f) this);
        if (booleanValue) {
            return booleanValue;
        }
        a(i, false);
        return booleanValue;
    }

    public final void a(int i, com.uc.a.d dVar) {
        synchronized (this.a) {
            ArrayList arrayList = (ArrayList) this.a.get(Integer.valueOf(i));
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayList.add(dVar);
                this.a.put(Integer.valueOf(i), arrayList);
            } else if (!arrayList.contains(dVar)) {
                arrayList.add(dVar);
            }
        }
    }

    public final void a(int i, HashMap<String, String> hashMap) {
        a(i, false);
        f fVar = new f(e.b, i);
        fVar.d = hashMap;
        synchronized (this.a) {
            ArrayList arrayList = (ArrayList) this.a.get(Integer.valueOf(i));
            if (arrayList != null) {
                arrayList = (ArrayList) arrayList.clone();
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.uc.a.d) it.next()).a(fVar);
            }
        }
    }

    public final void b(int i) {
        a(i, false);
        synchronized (this.a) {
            ArrayList arrayList = (ArrayList) this.a.get(Integer.valueOf(i));
            if (arrayList != null) {
                arrayList = (ArrayList) arrayList.clone();
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null) {
            f fVar = new f(e.b, i, (byte) 0);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.uc.a.d) it.next()).a(fVar);
            }
        }
    }
}
