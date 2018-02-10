package com.uc.a.d;

import android.text.TextUtils;
import android.util.Log;
import com.uc.a.b;
import com.uc.a.b.g;
import com.uc.a.b.h;
import com.uc.a.d;
import com.uc.a.e;
import com.uc.a.f;
import com.uc.a.l;
import com.uc.a.n;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.b.c.c.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.OkHttpClient;

/* compiled from: ProGuard */
public final class m implements l {
    protected ArrayList<WeakReference<d>> a = new ArrayList();
    protected ArrayList<i> b = new ArrayList();
    protected af c;
    protected Map<String, j> d = new ConcurrentHashMap();
    protected ArrayList<f> e = new ArrayList();
    protected b f;

    public m(OkHttpClient okHttpClient) {
        this.f = new b(okHttpClient);
        this.f.a((l) this);
        a("reslist", c.a());
        a(c.a());
    }

    private static n a(String str, int i, Object obj) {
        HashMap hashMap = (HashMap) obj;
        int a = a.a((String) hashMap.get("server_type"), 1);
        boolean z = a.a((String) hashMap.get("full_update"), 0) == 1;
        g gVar = (g) hashMap.get("server");
        ArrayList arrayList = (ArrayList) hashMap.get("items");
        String str2 = (String) hashMap.get("update_type");
        if (str2 == null) {
            str2 = "";
        }
        ac acVar = new ac();
        acVar.a(str, a, i, str2);
        acVar.a(arrayList, z);
        acVar.a(gVar);
        acVar.a("update_type", str2);
        HashMap hashMap2 = (HashMap) hashMap.get("extra_map");
        if (!(hashMap2 == null || hashMap2.isEmpty())) {
            for (Entry entry : hashMap2.entrySet()) {
                acVar.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return acVar.a();
    }

    public final void a(i iVar) {
        synchronized (this.b) {
            if (!this.b.contains(iVar)) {
                this.b.add(iVar);
            }
        }
    }

    public final void a(d dVar) {
        if (e.a == e.a && dVar != null) {
            synchronized (this.a) {
                this.a.add(new WeakReference(dVar));
            }
        }
    }

    public final void a(String str, j jVar) {
        if (jVar != null && !TextUtils.isEmpty(str)) {
            this.d.put(str, jVar);
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d.remove(str);
        }
    }

    private f b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar != null && fVar.a()) {
                return fVar;
            }
        }
        return null;
    }

    public final void a(n nVar, byte[] bArr) {
        int a;
        int i = 0;
        w.a("receive us server response, receive data len(bytes)=" + (bArr != null ? bArr.length : 0));
        StringBuilder stringBuilder = new StringBuilder("[us] receive us server response, receive data len(bytes)=");
        if (bArr != null) {
            i = bArr.length;
        }
        stringBuilder.append(i);
        int i2 = -1;
        if (nVar != null) {
            i2 = nVar.c();
            String b = nVar.b("update_type");
            a = a.a(nVar.b("server_type"), 1);
            w.a("req type=[" + i2 + ", " + b + "], serverType:" + (a == 1 ? "sub us" : "main us") + ", the response us server url:" + nVar.a());
        } else {
            a = 1;
        }
        h.b(new r(this, bArr, nVar, a, i2));
    }

    public final void a(String str, n nVar) {
        int a;
        int i;
        w.a("request us failed, errorId:-1, errorMsg:" + (str != null ? str : ""));
        Log.e("us", "[us] request us failed, errorId:-1, errorMsg:" + (str != null ? str : ""));
        if (nVar != null) {
            int c = nVar.c();
            a = a.a(nVar.b("server_type"), 1);
            w.a("req type=[" + c + ", " + nVar.b("update_type") + "], serverType:" + (a == 1 ? "sub us" : "main us") + ", failed, request us server url:" + nVar.a());
            i = a;
            a = c;
        } else {
            i = 1;
            a = -1;
        }
        a(i, a, -1, str);
        w.a();
    }

    protected final void a(int i, int i2) {
        ArrayList arrayList;
        f fVar = new f(e.a, i2, 0, new Object[]{String.valueOf(i), String.valueOf(i2), null});
        synchronized (this.a) {
            arrayList = (ArrayList) this.a.clone();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null) {
                d dVar = (d) weakReference.get();
                if (dVar != null) {
                    dVar.a(fVar);
                }
            }
        }
    }

    public final void a(int i, int i2, int i3, String str) {
        ArrayList arrayList;
        f fVar = new f(e.a, i2, -1, new Object[]{String.valueOf(i), String.valueOf(i2), str});
        synchronized (this.a) {
            arrayList = (ArrayList) this.a.clone();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null) {
                d dVar = (d) weakReference.get();
                if (dVar != null) {
                    dVar.a(fVar);
                }
            }
        }
    }

    protected final void b(h hVar) {
        if (this.c != null) {
            com.uc.a.b.f fVar = hVar.h;
            if (fVar != null && !TextUtils.isEmpty(fVar.b())) {
                try {
                    fVar.b();
                    if (fVar.a != null) {
                        fVar.a.toString();
                    }
                    if (fVar.b != null) {
                        fVar.b.toString();
                    }
                } catch (Throwable th) {
                    com.uc.base.b.b.a.a(th);
                }
            }
        }
    }

    protected final void a(int i, h hVar) {
        ArrayList arrayList;
        w.a("handleUsBaseData...");
        HashMap hashMap = new HashMap();
        if (hVar != null) {
            CharSequence charSequence;
            if (i == 0) {
                if (hVar.c == null) {
                    charSequence = null;
                } else {
                    charSequence = hVar.c.toString();
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    hashMap.put("sn", charSequence);
                }
                if (hVar.d == null) {
                    charSequence = null;
                } else {
                    charSequence = hVar.d.toString();
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    hashMap.put("dn", charSequence);
                }
                if (hVar.f == null) {
                    charSequence = null;
                } else {
                    charSequence = hVar.f.toString();
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    hashMap.put("cp_param", charSequence);
                }
            }
            if (hVar.e == null) {
                charSequence = null;
            } else {
                charSequence = hVar.e.toString();
            }
            if (!TextUtils.isEmpty(charSequence)) {
                hashMap.put("ext_param", charSequence);
            }
            int i2 = hVar.g;
            if (-1 != i2) {
                hashMap.put("st_flag", String.valueOf(i2));
            }
            Iterator it = hVar.i.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar != null) {
                    CharSequence charSequence2;
                    if (gVar.a == null) {
                        charSequence2 = null;
                    } else {
                        charSequence2 = gVar.a.toString();
                    }
                    if (gVar.b == null) {
                        charSequence = null;
                    } else {
                        charSequence = gVar.b.toString();
                    }
                    if (!(TextUtils.isEmpty(charSequence2) || TextUtils.isEmpty(charSequence))) {
                        hashMap.put(charSequence2, charSequence);
                    }
                }
            }
        }
        w.a("US base data:" + hashMap);
        synchronized (this.b) {
            arrayList = (ArrayList) this.b.clone();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i iVar = (i) it2.next();
            if (iVar != null) {
                try {
                    iVar.a(i, hashMap);
                } catch (Throwable th) {
                    com.uc.base.b.b.a.a(th);
                }
            }
        }
    }

    protected final void b(int i, h hVar) {
        w.a("handleUsItems...");
        Iterator it = hVar.a.iterator();
        while (it.hasNext()) {
            com.uc.a.b.e eVar = (com.uc.a.b.e) it.next();
            if (eVar != null) {
                int length;
                String b = eVar.b();
                w.a("handleUsItem, reqType=" + i + ", resCode=" + b + ", suminfo:" + eVar.c() + ", data len(bytes)=" + (eVar.d() != null ? eVar.d().length : 0));
                StringBuilder append = new StringBuilder("[us] receive item reqType=").append(i).append(",  resCode=").append(b).append(", suminfo:").append(eVar.c()).append(", data len(bytes)=");
                if (eVar.d() != null) {
                    length = eVar.d().length;
                } else {
                    length = 0;
                }
                append.append(length);
                try {
                    j jVar;
                    String b2;
                    if (TextUtils.isEmpty(b)) {
                        jVar = null;
                    } else {
                        jVar = (j) this.d.get(b);
                        if (jVar == null) {
                            this.d.remove(b);
                        }
                    }
                    if (jVar != null) {
                        jVar.a(b, eVar);
                    } else {
                        f b3 = b(b);
                        if (b3 == null) {
                            b2 = eVar.b();
                            boolean equals = "00000000".equals(eVar.c());
                            if (!equals && eVar.a == 1) {
                                h.b(new aa(this, b2, eVar));
                                eVar.a = 0;
                            } else if (equals) {
                                h.b(new v(this, b2));
                            }
                        } else if (b3.a != null) {
                            jVar = (j) b3.a.get();
                            if (jVar != null) {
                                jVar.a(b, eVar);
                            }
                        }
                    }
                    Object obj = 7 == i ? 1 : null;
                    Object obj2;
                    if (9 == i) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj == null && r1 == null) {
                        b2 = null;
                    } else {
                        c.a();
                        g a = c.a(b);
                        if (a != null) {
                            b2 = a.c;
                        } else {
                            c.a();
                            a = c.b();
                            if (a != null) {
                                b2 = a.c;
                            } else {
                                b2 = "http://ucus.ucweb.com/usquery.php";
                            }
                        }
                    }
                    c.a().b(b2, eVar);
                } catch (Throwable th) {
                    com.uc.base.b.b.a.a(th);
                }
            }
        }
    }

    public final void a() {
        w.a("begin force update main us data...");
        c.a();
        g b = c.b();
        if (b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("server", b);
            hashMap.put("server_type", String.valueOf(b.b));
            hashMap.put("full_update", String.valueOf(SettingsConst.TRUE));
            hashMap.put("update_type", "force_update");
            this.f.a(a(b.c, 4, hashMap));
            c.a().b(b);
        }
    }

    protected final void a(h hVar) {
        Object obj;
        if (hVar.b == null) {
            obj = null;
        } else {
            obj = hVar.b.toString();
        }
        if (!TextUtils.isEmpty(obj)) {
            HashMap hashMap = new HashMap();
            hashMap.put("server_type", SettingsConst.FALSE);
            this.f.a(a(obj, 6, hashMap));
        }
    }
}
