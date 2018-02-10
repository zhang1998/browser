package com.ucpro.feature.t;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.c.a.a;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.a.c;
import com.ucpro.business.stat.m;
import com.ucpro.feature.navigation.b.s;
import com.ucpro.feature.t.a.d;
import com.ucpro.feature.t.b.i;
import com.ucpro.feature.t.b.j;
import com.ucpro.feature.t.b.n;
import com.ucpro.feature.t.b.q;
import com.ucpro.feature.t.c.g;
import com.ucpro.feature.webwindow.bb;
import com.ucweb.common.util.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class k extends e implements a {
    private h c;
    private c d;
    private l e = null;
    private j f = null;
    private g g = null;
    private d h = null;
    private boolean i = false;
    private f j = new s(this);

    static /* synthetic */ void c(k kVar) {
        if (kVar.e != null) {
            kVar.e.setVisibility(8);
        }
        if (!(kVar.e == null || kVar.e.getParent() == null)) {
            kVar.a.b().b(kVar.e);
            if (kVar.s_().a() instanceof c) {
                m.a(((c) kVar.s_().a()).getCurUtPage());
            }
        }
        if (kVar.f != null) {
            kVar.f.e();
        }
        if (kVar.d != null) {
            com.ucweb.common.util.h.m.a(2, new i(kVar.d));
        }
        kVar.d = null;
        kVar.c = null;
        kVar.e = null;
        kVar.f = null;
        kVar.g = null;
        com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.R);
        f.a(0);
    }

    protected final void a(b bVar) {
        super.a(bVar);
        t_().a((a) this);
    }

    public final void a(int i, Message message) {
        if (i == com.ucpro.base.a.e.J) {
            boolean z = false;
            boolean z2 = false;
            boolean z3 = true;
            com.ucpro.base.c.b.g gVar = (com.ucpro.base.c.b.g) message.obj;
            if (message.getData() != null) {
                z = message.getData().getBoolean("IS_FOREGROUND");
                z2 = message.getData().getBoolean("NEED_RESTRICT_BY_COUNT");
                z3 = message.getData().getBoolean("NEED_SHOW_MAX_COUNT_TIP", true);
            }
            if (z2 && i()) {
                if (z3) {
                    com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.reach_max_window_stack_count), 1);
                }
            } else if (z) {
                t_().b(gVar);
            } else {
                t_().a(gVar);
            }
        } else if (i == com.ucpro.base.a.e.B) {
            this.e = new l(this.b);
            this.e.setEnterAnimCallback(this.j);
            this.f = new i(this.e.getWheelView());
            this.g = new com.ucpro.feature.t.c.b(this.e.getToolbar());
            this.h = new com.ucpro.feature.t.a.e(this.e.getAnimCard());
            this.f.a(e());
            this.f.a(d());
            this.f.d();
            this.h.a(e());
            this.h.a(d());
            this.h.a();
            if (this.e != null && this.e.getParent() == null) {
                this.a.b().a(this.e);
                if (s_().a() instanceof c) {
                    ((c) s_().a()).getCurUtPage();
                }
                m.a(this.e);
            }
            r2 = message.arg1;
            if (this.f != null) {
                r3 = this.f.a();
                if (r2 == 1) {
                    m.a("multiwindow", "ent_fro_h", "count", String.valueOf(r3), "type", "enter");
                } else if (r2 == 2) {
                    m.a("multiwindow", "ent_fro_w", "count", String.valueOf(r3), "type", "enter");
                } else if (r2 == 3) {
                    m.a("multiwindow", "ent_fro_l", "count", String.valueOf(r3), "type", "enter");
                }
            }
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.Q);
        } else if (i == com.ucpro.base.a.e.C) {
            Object obj;
            if (this.i || this.f == null) {
                obj = null;
            } else {
                b(0);
                obj = 1;
            }
            if (obj != null) {
                r2 = message.arg1;
                if (this.f != null) {
                    r3 = this.f.a();
                    if (r2 == 1) {
                        m.a("multiwindow", "cli_bac_b", "count", String.valueOf(r3), "type", "exit");
                    } else if (r2 == 2) {
                        m.a("multiwindow", "cli_bac_k", "count", String.valueOf(r3), "type", "exit");
                    }
                }
            }
        } else if (i == com.ucpro.base.a.e.D) {
            b(message.arg1);
        } else if (i == com.ucpro.base.a.e.E) {
            j();
        } else if (i == com.ucpro.base.a.e.F && !this.i && this.f != null) {
            l lVar = this.e;
            f oVar = new o(this);
            n nVar = lVar.a;
            if (!nVar.b()) {
                int scrollX = ((View) nVar.getParent().getParent()).getScrollX();
                int measuredWidth = ((View) nVar.getParent().getParent()).getMeasuredWidth();
                for (r3 = 0; r3 < nVar.getChildCount(); r3++) {
                    com.ucpro.feature.t.b.k kVar = (com.ucpro.feature.t.b.k) nVar.getChildAt(r3);
                    if (kVar != null) {
                        int i2;
                        kVar.m.setVisibility(8);
                        kVar.n.setVisibility(8);
                        kVar.o.setVisibility(8);
                        int index = kVar.getIndex();
                        if (index > 2) {
                            i2 = 2;
                        } else {
                            i2 = index;
                        }
                        int measuredHeight = ((nVar.getMeasuredHeight() - kVar.getMeasuredHeight()) / 2) - (i2 * 30);
                        float f = IPictureView.DEFAULT_MIN_SCALE - (((float) i2) * 0.1f);
                        float f2 = IPictureView.DEFAULT_MIN_SCALE - (((float) i2) * 0.2f);
                        kVar.animate().translationX((float) ((((measuredWidth - kVar.getMeasuredWidth()) - nVar.b) / 2) + scrollX)).translationY((float) measuredHeight).scaleX(f).scaleY(f).alpha(f2).setDuration(300).setListener(new q(nVar, index, oVar, kVar)).start();
                    }
                }
            }
            lVar.d.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300).start();
        }
    }

    private n d() {
        if (this.d == null) {
            this.d = new c(s_());
            com.ucpro.base.c.b.g c = s_().c(t_().b());
            int[] a = a.a(c.getWidth(), c.getHeight(), true);
            c cVar = this.d;
            int i = a[0];
            int i2 = a[1];
            cVar.b = i;
            cVar.c = i2;
        }
        return this.d;
    }

    private h e() {
        if (this.c == null) {
            this.c = new h();
            ArrayList c = t_().c();
            SparseArray sparseArray = new SparseArray();
            Iterator it = c.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                Object obj = null;
                com.ucpro.base.c.b.g d = s_().d(intValue);
                if (d != null) {
                    obj = d.getTitle();
                }
                sparseArray.put(intValue, obj);
            }
            this.c.a(c, a(c), sparseArray);
        }
        return this.c;
    }

    private SparseArray<Drawable> a(ArrayList<Integer> arrayList) {
        SparseArray<Drawable> sparseArray = new SparseArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object a;
            int intValue = ((Integer) it.next()).intValue();
            com.ucpro.base.c.b.g d = s_().d(intValue);
            if (d != null) {
                if (d instanceof bb) {
                    a = com.ucpro.feature.navigation.b.i.a.a(this.b, null, null, com.ucweb.common.util.i.f.c(((bb) d).getUrl()));
                } else {
                    a = null;
                }
                if (a == null) {
                    Bitmap a2 = a(d.getIcon());
                    if (a2 != null) {
                        a = new BitmapDrawable(this.b.getResources(), a2);
                    }
                }
            } else {
                a = null;
            }
            sparseArray.put(intValue, a);
        }
        return sparseArray;
    }

    private static Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int c = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_icon_width);
        Bitmap a = com.uc.util.b.a(c, c, Config.ARGB_8888);
        if (a == null) {
            return a;
        }
        Canvas canvas = new Canvas(a);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, c, c), paint);
        s.a(canvas, c, c);
        return a;
    }

    public final void b(int i, Message message) {
        int i2;
        if (i == com.ucpro.base.a.j.e) {
            i2 = message.arg1;
            String str = (String) message.obj;
            if (this.c != null) {
                h hVar = this.c;
                if (hVar.a != null) {
                    Iterator it = hVar.a.iterator();
                    while (it.hasNext()) {
                        q qVar = (q) it.next();
                        if (qVar.c == i2) {
                            qVar.b = str;
                            if (qVar.b == null) {
                                qVar.b = "";
                            }
                            Iterator it2 = hVar.b.iterator();
                            while (it2.hasNext()) {
                                g gVar = (g) ((WeakReference) it2.next()).get();
                                if (gVar != null) {
                                    gVar.a(i2, str);
                                }
                            }
                            return;
                        }
                    }
                }
            }
        } else if (i == com.ucpro.base.a.j.d) {
            i2 = message.arg1;
            Bitmap bitmap = (Bitmap) message.obj;
            if (this.c != null) {
                Bitmap a;
                Drawable drawable;
                if (bitmap != null) {
                    a = a(bitmap);
                } else {
                    a = bitmap;
                }
                if (a == null) {
                    drawable = null;
                } else {
                    drawable = new BitmapDrawable(this.b.getResources(), a);
                }
                this.c.a(drawable, i2);
            }
        } else if (i == com.ucpro.base.a.j.c) {
            int i3 = message.arg1;
            if (this.c != null) {
                h hVar2 = this.c;
                hVar2.c.add(Integer.valueOf(i3));
                if (!hVar2.d) {
                    hVar2.d = true;
                    com.ucweb.common.util.h.m.a(2, new j(hVar2), 2000);
                }
            }
        } else if (i == com.ucpro.base.a.j.f && this.e != null) {
            this.e.c();
        }
    }

    private void a(ArrayList<Integer> arrayList, int i, boolean z) {
        int width;
        int height;
        com.ucpro.base.c.b.g c;
        com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.R);
        com.ucpro.base.c.b.g b = s_().b();
        if (b != null) {
            width = b.getWidth();
            height = b.getHeight();
        } else {
            height = 0;
            width = 0;
        }
        if (z) {
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.H, Boolean.FALSE);
            a(t_().a() - 1);
            b((ArrayList) arrayList);
        } else {
            c = s_().c(i);
            b((ArrayList) arrayList);
            a(s_().c(c));
        }
        c = s_().b();
        if (c != null) {
            c.measure(MeasureSpec.makeMeasureSpec(width, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(height, UCCore.VERIFY_POLICY_QUICK));
            c.layout(0, 0, width, height);
        }
    }

    private void a(int i) {
        t_().b(i);
    }

    private void b(ArrayList<Integer> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.ucpro.base.c.b.g c = s_().c(((Integer) it.next()).intValue());
            if (c != null) {
                arrayList2.add(c);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            t_().a(s_().c((com.ucpro.base.c.b.g) it2.next()));
        }
    }

    public final void a() {
    }

    public final void a(com.ucpro.base.c.b.g gVar) {
    }

    private void b(int i) {
        if (!this.i && this.f != null) {
            int a = this.f.a(i);
            if (a != -1) {
                this.h.a(a, false);
                this.e.post(new b(this, i));
            }
            a((ArrayList) this.f.b(), this.f.a(i), false);
        }
    }

    private void j() {
        if (!this.i && this.f != null) {
            ArrayList arrayList = (ArrayList) this.f.b();
            if (arrayList.size() == 0 && i()) {
                com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.reach_max_window_stack_count), 1);
                return;
            }
            a(arrayList, -1, true);
            int b = t_().b();
            if (b != -1) {
                this.h.a(b, true);
                l lVar = this.e;
                f eVar = new e(this);
                if (lVar.a.getChildCount() > 0) {
                    lVar.c.a(false, null);
                } else {
                    int[] iArr = new int[2];
                    lVar.d.getLocationInWindow(iArr);
                    lVar.c.a(true, iArr);
                }
                com.ucpro.feature.t.a.a aVar = lVar.c;
                aVar.b = IPictureView.DEFAULT_MIN_SCALE;
                aVar.c = IPictureView.DEFAULT_MIN_SCALE;
                aVar.I = 0.0f;
                aVar.e = 0.0f;
                aVar.J = (float) aVar.getMeasuredHeight();
                aVar.d = 0.0f;
                aVar.k = IPictureView.DEFAULT_MIN_SCALE;
                aVar.l = 0.0f;
                aVar.a(aVar.f, aVar.f, eVar, true);
                aVar.setVisibility(0);
                lVar.b.a();
            }
        }
    }

    private boolean i() {
        return this.a.c().a() >= 15;
    }

    static /* synthetic */ void a(k kVar, boolean z) {
        kVar.i = z;
        if (kVar.e == null) {
            return;
        }
        if (z) {
            kVar.e.setCanTouch(false);
        } else {
            kVar.e.setCanTouch(true);
        }
    }

    static /* synthetic */ void d(k kVar) {
        if (com.ucpro.feature.i.f.a.a()) {
            com.ucpro.feature.i.f.a;
            com.ucpro.feature.i.e.b(kVar.b);
        }
        int i;
        if ((kVar.s_().a() instanceof bb) && ((bb) kVar.s_().a()).G()) {
            i = 1;
        } else {
            i = 0;
        }
        if (!com.ucpro.ui.c.a.a() || r0 == 0) {
            com.ucpro.feature.i.f.a.a(kVar.b, com.ucpro.ui.c.a.c("status_bar_color"));
        } else {
            com.ucpro.feature.i.f.a.a(kVar.b, 0);
        }
    }

    static /* synthetic */ void f(k kVar) {
        if (com.ucpro.feature.i.f.a.a()) {
            com.ucpro.feature.i.f.a;
            com.ucpro.feature.i.e.c(kVar.b);
        }
        com.ucpro.feature.i.f.a.a(kVar.b, com.ucpro.ui.c.a.c("default_background_dark"));
    }
}
