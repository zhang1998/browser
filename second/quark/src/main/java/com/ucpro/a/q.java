package com.ucpro.a;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class q {
    ArrayList<WeakReference> a = new ArrayList();

    public final void a(int i) {
        if (this.a != null && !this.a.isEmpty()) {
            Iterator it;
            WeakReference weakReference;
            switch (i) {
                case 4:
                    it = this.a.iterator();
                    while (it.hasNext()) {
                        weakReference = (WeakReference) it.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((d) weakReference.get()).a();
                        }
                    }
                    return;
                case 8:
                    it = this.a.iterator();
                    while (it.hasNext()) {
                        weakReference = (WeakReference) it.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((d) weakReference.get()).b();
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
