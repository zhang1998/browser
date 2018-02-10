package com.uc.quark.filedownloader.message;

import com.uc.quark.filedownloader.al;

/* compiled from: ProGuard */
public final class e {
    private volatile j a;
    private volatile c b;

    public final void a(c cVar) {
        this.b = cVar;
        if (cVar == null) {
            this.a = null;
        } else {
            this.a = new j(cVar);
        }
    }

    public final synchronized void a(MessageSnapshot messageSnapshot, boolean z) {
        if (this.b == null && !z) {
            a(new al());
        }
        if (messageSnapshot instanceof i) {
            if (this.b != null) {
                this.b.a(messageSnapshot);
            }
        } else if (this.a != null) {
            j jVar = this.a;
            f fVar = null;
            try {
                synchronized (jVar.a) {
                    int i = messageSnapshot.a;
                    for (f fVar2 : jVar.a) {
                        if (fVar2.a.contains(Integer.valueOf(i))) {
                            fVar = fVar2;
                            break;
                        }
                    }
                    if (fVar == null) {
                        int i2 = 0;
                        for (f fVar22 : jVar.a) {
                            if (fVar22.a.size() <= 0) {
                                fVar = fVar22;
                                break;
                            }
                            int i3;
                            f fVar3;
                            if (i2 != 0) {
                                if (fVar22.a.size() >= i2) {
                                    i3 = i2;
                                    fVar3 = fVar;
                                    fVar = fVar3;
                                    i2 = i3;
                                }
                            }
                            fVar3 = fVar22;
                            i3 = fVar22.a.size();
                            fVar = fVar3;
                            i2 = i3;
                        }
                    }
                    if (fVar != null) {
                        fVar.a.add(Integer.valueOf(i));
                    }
                }
                if (fVar != null) {
                    fVar.a(messageSnapshot);
                }
            } catch (Throwable th) {
                if (fVar != null) {
                    fVar.a(messageSnapshot);
                }
            }
        }
    }
}
