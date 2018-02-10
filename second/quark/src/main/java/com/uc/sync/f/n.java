package com.uc.sync.f;

import android.os.Looper;
import android.util.SparseArray;
import com.uc.sync.b.b.b;
import com.uc.sync.b.b.f;
import com.uc.sync.b.c.e;
import com.uc.sync.c.a;
import com.ucweb.common.util.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
final class n implements Callback {
    LinkedList<c> a = new LinkedList();
    c b;
    private m c;
    private Looper d;

    public n(m mVar, Looper looper) {
        this.c = mVar;
        this.d = looper;
        if (this.d == null) {
            this.d = Looper.getMainLooper();
        }
    }

    final void a() {
        c b = b();
        this.b = b;
        if (b != null) {
            SparseArray sparseArray = b.a;
            if (sparseArray != null) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    o oVar = (o) sparseArray.get(sparseArray.keyAt(i));
                    if (oVar != null) {
                        oVar.o = System.currentTimeMillis();
                    }
                }
            }
            b bVar = b.b;
            a.h();
            if (a.j()) {
                com.uc.sync.d.a.a("请求参数：" + com.uc.sync.util.b.a((Object) bVar));
            }
            byte[] a = com.uc.sync.a.a.a(bVar);
            if (a == null) {
                a.h();
                if (a.j()) {
                    c.a("RequestBody.create params is null.");
                    return;
                }
                return;
            }
            Request build = new Builder().url(com.uc.sync.a.a.f).method(SpdyRequest.POST_METHOD, RequestBody.create(MediaType.parse("application/octet-stream"), a)).build();
            a.h();
            a.n().newCall(build).enqueue(this);
            com.uc.sync.d.a.a("网络层：：生成网络请求body，发送同步请求 body length is:" + a.length);
        }
    }

    private c b() {
        c cVar;
        synchronized (this.a) {
            cVar = (c) this.a.poll();
        }
        return cVar;
    }

    private void a(byte[] bArr) {
        if (bArr == null) {
            a(1, 5001);
        } else {
            com.uc.sync.b.c.c a = com.uc.sync.a.a.a(bArr);
            if (a == null) {
                a(4, 0);
            } else if (!(this.c == null || this.b == null)) {
                e eVar = a.a;
                int i = eVar.a;
                if (i != 1200) {
                    a(i, 0);
                } else {
                    com.uc.sync.d.a.a("返回：返回码正常");
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = eVar.b;
                    com.uc.sync.d.a.a("返回：设备list的size是：" + arrayList2.size());
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        arrayList.add(new b((f) arrayList2.get(i2)));
                    }
                    this.c.a((ArrayList) arrayList.clone());
                    ArrayList arrayList3 = a.b;
                    SparseArray sparseArray = this.b.a;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.uc.sync.b.c.f fVar = (com.uc.sync.b.c.f) it.next();
                        int i3 = fVar.a.c;
                        o oVar = (o) sparseArray.get(i3);
                        if (oVar == null) {
                            com.uc.sync.d.a.a("task is null ---> reture type : " + i3);
                        } else if (oVar.c == 3) {
                            a(oVar);
                        } else {
                            oVar.a(2);
                            this.c.a(new j(fVar, (SparseArray) this.b.c.get(i3), oVar.a()));
                        }
                    }
                }
            }
        }
        a();
    }

    public final void onFailure(Call call, IOException iOException) {
        a(1, 5002);
    }

    private void a(int i, int i2) {
        if (!(this.c == null || this.b == null)) {
            SparseArray sparseArray = this.b.a;
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                o oVar = (o) sparseArray.get(sparseArray.keyAt(i3));
                if (oVar.c == 3) {
                    a(oVar);
                } else {
                    oVar.a(2);
                    j jVar = new j(oVar.a);
                    jVar.b = i;
                    jVar.i = i2;
                    this.c.a(jVar);
                }
            }
        }
        a();
    }

    private void a(o oVar) {
        if (this.c != null) {
            j jVar = new j(oVar.a);
            jVar.b = 2;
            this.c.a(jVar);
        }
    }

    public final void onResponse(Call call, Response response) {
        int code = response.code();
        String message = response.message();
        response.protocol().toString();
        if (code == 200) {
            try {
                byte[] bytes = response.body().bytes();
                com.uc.sync.d.a.a("response body size: " + bytes.length);
                if (bytes != null) {
                    a(bytes);
                    return;
                } else {
                    a(1, 5001);
                    return;
                }
            } catch (IOException e) {
                a(1, 5002);
                return;
            }
        }
        com.uc.sync.d.a.a("http msg: " + message);
        a(1, 5003);
    }
}
