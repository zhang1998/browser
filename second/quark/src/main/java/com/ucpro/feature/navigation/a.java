package com.ucpro.feature.navigation;

import android.animation.ObjectAnimator;
import android.os.Message;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.a.j;
import com.ucpro.base.e.e;
import com.ucpro.feature.navigation.b.c;
import com.ucpro.feature.navigation.b.d;
import com.ucpro.feature.navigation.b.i;
import com.ucpro.feature.navigation.b.n;
import com.ucpro.feature.navigation.b.q;
import com.ucpro.feature.navigation.b.u;
import com.ucpro.feature.navigation.view.aq;
import com.ucpro.feature.navigation.view.ax;
import com.ucpro.feature.y.b;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.i.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ProGuard */
public class a extends e implements c, q {
    p c;
    b d;
    g e;
    f f;
    private aq g;
    private q h;
    private boolean i;

    public a() {
        if (com.ucweb.common.util.j.a.b(this.b, "850BA8850E0B6050", "8FBA27ACEB86A6BE", true)) {
            i.a.c = true;
            com.ucweb.common.util.j.a.a(this.b, "850BA8850E0B6050", "8FBA27ACEB86A6BE", false);
        }
    }

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.a == i) {
            this.d = (b) message.obj;
            this.g = new aq(this.b);
            this.g.setId(R.id.home_navigation_view);
            this.c = new p(this, this.g);
            this.g.setPresenter(this.c);
            this.d.a(this.g);
            m.a(0, new h(new o(this)));
        } else if (com.ucpro.base.a.e.b == i) {
            ax axVar;
            com.ucweb.common.util.c.a(message.obj);
            com.ucweb.common.util.c.b(message.obj instanceof Object[]);
            r0 = (Object[]) message.obj;
            r1 = (String) r0[0];
            String str = (String) r0[1];
            String str2 = (String) r0[2];
            r0 = (ValueCallback) r0[3];
            if (i()) {
                axVar = null;
            } else if (this.h == null) {
                axVar = null;
            } else {
                boolean z;
                String b = com.ucpro.feature.navigation.b.b.b(str);
                String b2 = com.ucpro.feature.navigation.b.b.b(str);
                String a = com.ucpro.b.b.b.a(r1);
                if (a != null) {
                    a = b2 + "_" + String.valueOf(a.charAt(0));
                } else {
                    a = null;
                }
                if (str == null || !str.startsWith("ext:navifunc:")) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    if (i.a.a(this.b, b, null, f.c(str)) == null) {
                        if (TextUtils.isEmpty(str2)) {
                            i.a.a(this.b, a, r1);
                            n a2 = i.a;
                            String[] strArr = new String[]{r1};
                            String[] strArr2 = new String[]{str};
                            if (a2.a == null) {
                                a2.a = new com.ucpro.feature.navigation.b.m();
                            }
                            com.ucpro.feature.navigation.b.m mVar = a2.a;
                            mVar.a = "http://mynavi.ucweb.com/geticon.php";
                            if (!TextUtils.isEmpty(mVar.a)) {
                                mVar.b = new u(strArr, strArr2, a2);
                                mVar.e();
                            }
                            str2 = b;
                        } else {
                            i.a.a(this.b, a, r1);
                            com.ucpro.feature.navigation.b.b a3 = i.a;
                            b = "extra/" + com.ucpro.feature.navigation.b.b.b(str);
                            new d(a3, str2, b).e();
                            str2 = b;
                        }
                        i.a.b = new WeakReference(this);
                        b = str2;
                    }
                }
                axVar = this.h.a(r1, str, b, a);
                this.c.a();
            }
            if (axVar != null) {
                if (r0 != null) {
                    r0.onReceiveValue(Boolean.valueOf(true));
                }
                e();
            } else if (r0 != null) {
                r0.onReceiveValue(Boolean.valueOf(false));
            }
        } else if (com.ucpro.base.a.e.c == i) {
            ((ValueCallback) message.obj).onReceiveValue(Boolean.valueOf(i()));
        } else if (com.ucpro.base.a.e.d == i) {
            boolean z2;
            r0 = (Object[]) message.obj;
            r1 = (String) r0[0];
            r0 = (ValueCallback) r0[1];
            if (this.h == null) {
                z2 = false;
            } else if (this.h.a(r1) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            r0.onReceiveValue(Boolean.valueOf(z2));
        } else if (com.ucpro.base.a.e.e == i) {
            com.ucweb.common.util.c.a(message.obj);
            com.ucweb.common.util.c.b(message.obj instanceof String);
            String str3 = (String) message.obj;
            if (this.h != null) {
                ax a4 = this.h.a(str3);
                if (a4 != null) {
                    this.h.a(a4);
                    this.c.a.f();
                }
            }
        }
    }

    public final void a(q qVar) {
        int i;
        Object obj = null;
        this.h = qVar;
        if (this.h == null || this.h.a() == null) {
            i = 0;
        } else {
            i = this.h.a().size();
        }
        p pVar = this.c;
        pVar.b = this.h;
        if (pVar.b != null) {
            pVar.a.setData(pVar.b.a());
        }
        if (this.h != null) {
            Object obj2;
            ArrayList a = this.h.a();
            if (a != null) {
                obj2 = 1;
                for (int i2 = 0; i2 < a.size(); i2++) {
                    ax axVar = (ax) a.get(i2);
                    if (axVar != null && axVar.b == 0) {
                        obj2 = null;
                    }
                }
            } else {
                obj2 = 1;
            }
            obj = obj2;
        }
        if (obj != null) {
            this.c.a.e();
        }
        if (this.i) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.g, "alpha", new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
            ofFloat.setDuration(100);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.start();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("count", String.valueOf(i));
        com.ucpro.business.stat.m.a("navigation", "widget_count", hashMap);
        if (this.h != null) {
            a(this.h.a());
        }
    }

    private static void a(ArrayList<ax> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                if (com.ucpro.feature.navigation.a.a.a((ax) it.next())) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("count", String.valueOf(i));
            com.ucpro.business.stat.m.a("navigation", "navi_la_count", hashMap);
        }
    }

    public final void b(int i, Message message) {
        if (i == j.f) {
            if (this.c != null) {
                this.c.a.d();
            }
        } else if (i == j.q) {
            this.i = true;
        }
    }

    static boolean a(ax axVar) {
        return (axVar == null || axVar.d == null || !axVar.d.startsWith("ext:navifunc:")) ? false : true;
    }

    private boolean i() {
        if (this.h == null) {
            return false;
        }
        Iterator it = this.h.a().iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            if (((ax) it.next()).b == 0) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i >= 10) {
            return true;
        }
        return false;
    }

    public final void d() {
        m.a(2, new j(this), 300);
    }

    public final void e() {
        if (this.h != null) {
            this.h.b();
        }
    }
}
