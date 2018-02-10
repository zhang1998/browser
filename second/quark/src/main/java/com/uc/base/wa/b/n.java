package com.uc.base.wa.b;

import android.os.Looper;
import com.uc.base.wa.config.c;
import com.uc.base.wa.f.e;
import com.uc.base.wa.g.a;
import java.util.HashMap;
import java.util.LinkedList;

/* compiled from: ProGuard */
final class n {
    LinkedList<Integer> a = new LinkedList();
    private int b;
    private k c;
    private HashMap<String, String> d;
    private boolean e;
    private HashMap<String, String> f = new HashMap();
    private h g;
    private HashMap<String, String> h = new HashMap();
    private m i;

    public n(k kVar, h hVar, HashMap<String, String> hashMap, boolean z, m mVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.b = 1;
        } else if (Looper.myLooper() == e.a()) {
            this.b = 2;
        } else {
            this.b = 3;
        }
        this.c = kVar;
        this.g = hVar;
        this.d = hashMap;
        this.e = z;
        this.i = mVar;
    }

    public final void a(int i) {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                this.a.add(Integer.valueOf(i));
                if (b(i)) {
                    this.a.remove();
                }
            } else {
                this.a.add(Integer.valueOf(i));
            }
        }
    }

    private void a(c cVar) {
        if (cVar != null) {
            String a;
            String a2;
            String[] strArr = cVar.a;
            if (strArr != null) {
                for (String a3 : strArr) {
                    if (!(a3 == null || this.d.containsKey(a3))) {
                        this.f.put(a3, this.c.a(a3));
                    }
                }
            }
            String[] strArr2 = cVar.c;
            if (strArr2 != null) {
                for (String a22 : strArr2) {
                    if (!(a22 == null || this.d.containsKey(a22))) {
                        Object a4 = p.a().a(a22);
                        if (a4 != null) {
                            a4 = a.a(a4);
                        }
                        this.f.put(a22, a4);
                    }
                }
            }
            if (!this.e) {
                strArr = cVar.b;
                if (strArr != null) {
                    for (String a32 : strArr) {
                        if (a32 != null) {
                            if (this.f.containsKey(a32)) {
                                this.h.put(a32, this.f.get(a32));
                            } else {
                                a22 = this.c.a(a32);
                                if (a22 != null) {
                                    this.h.put(a32, a22);
                                }
                            }
                        }
                    }
                }
                strArr = cVar.d;
                if (strArr != null) {
                    for (String str : strArr) {
                        if (str != null) {
                            if (this.f.containsKey(str)) {
                                this.h.put(str, this.f.get(str));
                            } else {
                                a32 = p.a().a(str);
                                if (a32 != null) {
                                    this.h.put(str, a.a(a32));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    final boolean b(int i) {
        switch (this.b) {
            case 1:
                if (i == 1) {
                    a(this.g.c);
                    return true;
                } else if (i == 2) {
                    a(this.g.a);
                    return true;
                } else if (i == 3) {
                    c(2);
                    return false;
                } else if (i != 4) {
                    return true;
                } else {
                    c(4);
                    return false;
                }
            case 2:
                if (i == 1) {
                    a(this.g.c);
                    return true;
                } else if (i == 2) {
                    c(1);
                    return false;
                } else if (i == 3) {
                    a(this.g.b);
                    return true;
                } else if (i != 4) {
                    return true;
                } else {
                    c(4);
                    return false;
                }
            case 3:
                if (i == 1) {
                    a(this.g.c);
                    return true;
                } else if (i == 2) {
                    c(1);
                    return false;
                } else if (i == 3) {
                    c(2);
                    return false;
                } else if (i != 4) {
                    return true;
                } else {
                    c(4);
                    return false;
                }
            case 4:
                if (!(this.h == null || this.h.isEmpty())) {
                    HashMap hashMap = new HashMap();
                    this.c.a(hashMap);
                    if (hashMap.size() > 0) {
                        this.h.putAll(hashMap);
                    }
                }
                this.i.a(this.f, this.h);
                return true;
            default:
                return true;
        }
    }

    private void c(int i) {
        if (i != this.b) {
            this.b = i;
            Runnable lVar = new l(this);
            switch (this.b) {
                case 1:
                    e.a(1, lVar);
                    return;
                case 2:
                    e.a(2, lVar);
                    return;
                case 3:
                    return;
                case 4:
                    lVar.run();
                    return;
                default:
                    return;
            }
        }
    }
}
