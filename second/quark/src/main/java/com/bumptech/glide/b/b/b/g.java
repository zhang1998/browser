package com.bumptech.glide.b.b.b;

import com.bumptech.glide.b.i;
import com.bumptech.glide.util.j;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class g {
    final Map<i, e> a = new HashMap();
    final f b = new f();

    g() {
    }

    final void a(i iVar) {
        e eVar;
        synchronized (this) {
            eVar = (e) j.a(this.a.get(iVar), "Argument must not be null");
            if (eVar.b <= 0) {
                throw new IllegalStateException("Cannot release a lock that is not held, key: " + iVar + ", interestedThreads: " + eVar.b);
            }
            eVar.b--;
            if (eVar.b == 0) {
                e eVar2 = (e) this.a.remove(iVar);
                if (eVar2.equals(eVar)) {
                    f fVar = this.b;
                    synchronized (fVar.a) {
                        if (fVar.a.size() < 10) {
                            fVar.a.offer(eVar2);
                        }
                    }
                } else {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + eVar + ", but actually removed: " + eVar2 + ", key: " + iVar);
                }
            }
        }
        eVar.a.unlock();
    }
}
