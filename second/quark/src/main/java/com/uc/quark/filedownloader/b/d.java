package com.uc.quark.filedownloader.b;

import com.uc.quark.a.m;
import com.uc.quark.filedownloader.e.j;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

/* compiled from: ProGuard */
public class d {
    private static volatile Object a = new Object();
    private final HashMap<String, LinkedList<f>> b = new HashMap();

    public final boolean a(String str, f fVar) {
        boolean add;
        if (j.a) {
            j.f(this, "setListener %s", str);
        }
        Assert.assertNotNull("EventPoolImpl.add", fVar);
        LinkedList linkedList = (LinkedList) this.b.get(str);
        if (linkedList == null) {
            synchronized (a) {
                linkedList = (LinkedList) this.b.get(str);
                if (linkedList == null) {
                    HashMap hashMap = this.b;
                    linkedList = new LinkedList();
                    hashMap.put(str, linkedList);
                }
            }
        }
        synchronized (a) {
            add = linkedList.add(fVar);
        }
        return add;
    }

    public final boolean b(String str, f fVar) {
        LinkedList linkedList;
        if (j.a) {
            j.f(this, "removeListener %s", str);
        }
        LinkedList linkedList2 = (LinkedList) this.b.get(str);
        if (linkedList2 == null) {
            synchronized (a) {
                linkedList2 = (LinkedList) this.b.get(str);
            }
            linkedList = linkedList2;
        } else {
            linkedList = linkedList2;
        }
        if (linkedList == null || fVar == null) {
            return false;
        }
        boolean remove;
        synchronized (a) {
            remove = linkedList.remove(fVar);
            if (linkedList.size() <= 0) {
                this.b.remove(str);
            }
        }
        return remove;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.uc.quark.filedownloader.b.a r7) {
        /*
        r6 = this;
        r2 = 1;
        r1 = 0;
        r0 = com.uc.quark.filedownloader.e.j.a;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r0 = "publish %s";
        r3 = new java.lang.Object[r2];
        r4 = r7.a();
        r3[r1] = r4;
        com.uc.quark.filedownloader.e.j.f(r6, r0, r3);
    L_0x0013:
        r0 = "EventPoolImpl.publish";
        junit.framework.Assert.assertNotNull(r0, r7);
        r3 = r7.a();
        r0 = r6.b;
        r0 = r0.get(r3);
        r0 = (java.util.LinkedList) r0;
        if (r0 != 0) goto L_0x0046;
    L_0x0026:
        r4 = a;
        monitor-enter(r4);
        r0 = r6.b;	 Catch:{ all -> 0x0057 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0057 }
        r0 = (java.util.LinkedList) r0;	 Catch:{ all -> 0x0057 }
        if (r0 != 0) goto L_0x0045;
    L_0x0033:
        r0 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x0057 }
        if (r0 == 0) goto L_0x0042;
    L_0x0037:
        r0 = "No listener for this event %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0057 }
        r5 = 0;
        r2[r5] = r3;	 Catch:{ all -> 0x0057 }
        com.uc.quark.filedownloader.e.j.d(r6, r0, r2);	 Catch:{ all -> 0x0057 }
    L_0x0042:
        monitor-exit(r4);	 Catch:{ all -> 0x0057 }
        r0 = r1;
    L_0x0044:
        return r0;
    L_0x0045:
        monitor-exit(r4);	 Catch:{ all -> 0x0057 }
    L_0x0046:
        r3 = r0.toArray();
        r4 = r3.length;
    L_0x004b:
        if (r1 >= r4) goto L_0x005a;
    L_0x004d:
        r0 = r3[r1];
        r0 = (com.uc.quark.filedownloader.b.f) r0;
        r0.a(r7);
        r1 = r1 + 1;
        goto L_0x004b;
    L_0x0057:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0057 }
        throw r0;
    L_0x005a:
        r0 = r7.a;
        if (r0 == 0) goto L_0x0063;
    L_0x005e:
        r0 = r7.a;
        r0.run();
    L_0x0063:
        r0 = r2;
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.b.d.a(com.uc.quark.filedownloader.b.a):boolean");
    }

    public final void b(a aVar) {
        if (j.a) {
            j.f(this, "asyncPublishInNewThread %s", aVar.a());
        }
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", aVar);
        m.a(0, new c(this, aVar));
    }
}
