package com.uc.sync.f;

import android.util.SparseArray;
import com.uc.sync.b.c.a;
import com.uc.sync.b.c.b;
import com.uc.sync.b.c.d;
import com.uc.sync.b.c.f;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class j {
    int a;
    public int b;
    public int c;
    public String d;
    public int e = 1;
    public int f = 1;
    int g;
    long h = 0;
    int i = 0;
    public boolean j = false;
    int k = -1;
    public ArrayList<l> l = new ArrayList();
    public ArrayList<l> m = new ArrayList();
    private int n;
    private String o;
    private SparseArray<f> p;

    j(int i) {
        this.a = i;
    }

    j(f fVar, SparseArray<f> sparseArray, boolean z) {
        this.j = z;
        this.p = sparseArray;
        a aVar = fVar.a;
        b bVar = fVar.b;
        this.b = aVar.e;
        this.a = aVar.c;
        this.n = aVar.d;
        this.c = aVar.b;
        this.d = com.uc.sync.a.a.b(aVar.a);
        this.o = com.uc.sync.a.a.b(aVar.f);
        if (bVar != null && this.p != null) {
            this.e = bVar.a;
            this.f = bVar.d;
            a(bVar.c);
            if (!this.j) {
                b(bVar.b);
            }
        } else if (this.p == null) {
            this.b = 0;
        }
    }

    private void a(ArrayList<d> arrayList) {
        this.l.clear();
        l a;
        if (!this.j) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                int i = dVar.b;
                f fVar = (f) this.p.get(dVar.a);
                if (fVar != null) {
                    l lVar = fVar.g;
                    if (lVar != null) {
                        lVar.a(i);
                        if (i >= 3500) {
                            this.l.add(lVar);
                        } else {
                            int i2 = fVar.a;
                            if (i2 == 5 || i2 == 0) {
                                ArrayList arrayList2 = dVar.c;
                                if (arrayList2.size() != 1) {
                                    lVar.a(3501);
                                    this.l.add(lVar);
                                } else {
                                    a = a((com.uc.sync.b.a.b) arrayList2.get(0));
                                    if (a != null) {
                                        a.a(i);
                                        a.c(2);
                                        a.j = lVar.j;
                                        if (i2 == 5) {
                                            a.b(2);
                                            if (com.ucweb.common.util.n.a.a(a.e)) {
                                                a.e = lVar.e;
                                            }
                                            if (com.ucweb.common.util.n.a.a(a.b())) {
                                                a.a(lVar.b());
                                            }
                                            this.l.add(a);
                                        } else if (i2 == 0) {
                                            lVar.b(0);
                                            lVar.e = a.e;
                                            this.l.add(lVar);
                                        }
                                    }
                                }
                            } else if (i2 == 3) {
                                lVar.b(1);
                                this.l.add(lVar);
                            } else if (i2 == 2) {
                                lVar.b(4);
                                this.l.add(lVar);
                            } else if (i2 == 4) {
                                lVar.b(3);
                                this.l.add(lVar);
                            } else {
                                this.l.add(lVar);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() != 1) {
            this.b = 3501;
        } else {
            d dVar2 = (d) arrayList.get(0);
            int i3 = dVar2.b;
            if (i3 == 3200) {
                if (((f) this.p.get(dVar2.a)) == null) {
                    this.b = 3;
                    return;
                }
                Iterator it2 = dVar2.c.iterator();
                while (it2.hasNext()) {
                    a = a((com.uc.sync.b.a.b) it2.next());
                    if (a != null) {
                        a.a(i3);
                        this.l.add(a);
                    }
                }
                return;
            }
            this.b = i3;
        }
    }

    private void b(ArrayList<com.uc.sync.b.a.a> arrayList) {
        if (this.b == 2200) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.uc.sync.b.a.a aVar = (com.uc.sync.b.a.a) it.next();
                com.uc.sync.b.a.b bVar = aVar.d;
                if (bVar != null) {
                    int i = aVar.b;
                    byte[] bArr = aVar.c;
                    l a = a(bVar);
                    if (a != null) {
                        a.a(bArr);
                        a.c(2);
                        if (a != null) {
                            if (i == 0) {
                                a.b(0);
                            } else if (i == 3) {
                                a.b(1);
                            } else if (i == 4) {
                                a.b(3);
                            } else if (i == 2) {
                                a.b(4);
                            }
                            this.m.add(a);
                        }
                    }
                }
            }
        }
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("CloudSyncRes{");
        stringBuffer.append("mBussinessId=").append(this.a);
        stringBuffer.append(", mRetCode=").append(this.b);
        stringBuffer.append(", mSyncType=").append(this.n);
        stringBuffer.append(", mAnchor=").append(this.c);
        stringBuffer.append(", mSession='").append(this.d).append('\'');
        stringBuffer.append(", mRetMsg='").append(this.o).append('\'');
        stringBuffer.append(", mSequenceNo=").append(this.e);
        stringBuffer.append(", mLastest=").append(this.f);
        stringBuffer.append(", mTriggerType=").append(this.g);
        stringBuffer.append(", mStartTime=").append(this.h);
        stringBuffer.append(", mErrorCode=").append(this.i);
        stringBuffer.append(", mIsCheckCommand=").append(this.j);
        stringBuffer.append(", mLastAnchor=").append(this.k);
        stringBuffer.append(", mContentResList=").append(this.l);
        stringBuffer.append(", mContentCmdList=").append(this.m);
        stringBuffer.append(", mCommandMap=").append(this.p);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    private l a(com.uc.sync.b.a.b bVar) {
        Object a = com.uc.sync.e.f.a.a(this.a);
        c.a(a);
        l e = a.e();
        e.e = com.uc.sync.a.a.b(bVar.a);
        e.a(com.uc.sync.a.a.b(bVar.b));
        byte[] bArr = bVar.c;
        if (bArr == null) {
            return e;
        }
        com.uc.base.b.c.b.c d = a.d();
        if (!d.a(bArr)) {
            return e;
        }
        Object obj;
        String b = com.uc.sync.a.a.b(a.c(d));
        if (com.ucweb.common.util.n.a.a(b) || b.equals("pad") || b.equals("pc") || b.equals("phone")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        a.a(e, d);
        return e;
    }
}
