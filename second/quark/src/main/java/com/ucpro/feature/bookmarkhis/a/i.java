package com.ucpro.feature.bookmarkhis.a;

import android.animation.ValueAnimator;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b;
import com.ucpro.base.c.b.g;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.m;
import com.ucpro.feature.bookmarkhis.a.a.d;
import com.ucpro.feature.bookmarkhis.a.a.f;
import com.ucpro.feature.bookmarkhis.a.b.a;
import com.ucpro.feature.webwindow.aj;
import com.ucpro.feature.webwindow.bb;
import com.ui.edittext.c;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class i extends e implements com.ucpro.feature.bookmarkhis.a.a.e, com.ucpro.feature.bookmarkhis.a.b.i {
    a c;
    boolean d;
    private d e = d.a();

    @DebugLog
    public i() {
        d dVar = this.e;
        Message message = new Message();
        message.what = 2;
        dVar.a(message);
    }

    public final void a(b bVar) {
        super.a(bVar);
    }

    public final a b(boolean z) {
        int i;
        int i2 = 0;
        if ((this.c == null || !z) && (this.c == null || !z)) {
            this.c = new a(this.b);
            this.c.setHistoryWindowCallBacks(this);
            this.c.d(z);
            this.c.setEnableSwipeGesture(z);
            if (!z) {
                this.c.f();
            }
        }
        g a = s_().a();
        if (!(a instanceof bb)) {
            i = -1;
        } else if (((bb) a).G()) {
            i = 0;
        } else {
            i = 1;
        }
        u_();
        e.a;
        if (i() != null) {
            i2 = i().size();
        }
        new StringBuilder("statHistoryOpen: \nfrom: ").append(String.valueOf(i)).append("\ntotalCount: ").append(String.valueOf(i2));
        HashMap hashMap = new HashMap();
        hashMap.put("from", String.valueOf(i));
        hashMap.put("count", String.valueOf(i2));
        m.a("histroy", "history_show", hashMap);
        if (z) {
            this.a.b().a(this.c, true);
        }
        return this.c;
    }

    @DebugLog
    public final void a(int i, Message message) {
        int i2 = 0;
        if (com.ucpro.base.a.e.ay == i) {
            b(true);
        } else if (com.ucpro.base.a.e.az == i) {
            try {
                r0 = (String[]) message.obj;
                if (r0 == null) {
                    return;
                }
                if (r0.length == 2) {
                    k.a;
                    if (!p.b(SettingKeys.RecordIsNoFootmark) && this.e != null) {
                        d dVar = this.e;
                        String str = r0[0];
                        String str2 = r0[1];
                        f fVar = new f();
                        fVar.b = str;
                        fVar.b(str2);
                        dVar.a(fVar);
                    }
                } else if (r0.length == 3) {
                    k.a;
                    if (!p.b(SettingKeys.RecordIsNoFootmark) && this.e != null) {
                        this.e.a(r0[0], r0[1], r0[2]);
                    }
                }
            } catch (Exception e) {
                e.getMessage();
                e.getCause();
            }
        } else if (com.ucpro.base.a.e.aA == i) {
            try {
                r0 = (String[]) message.obj;
                if (r0 != null && r0.length >= 3) {
                    k.a;
                    if (!p.b(SettingKeys.RecordIsNoFootmark) && this.e != null) {
                        this.e.a(r0[0], r0[1], r0[2]);
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
                e2.getCause();
            }
        } else if (com.ucpro.base.a.e.aC == i) {
            try {
                ValueCallback valueCallback = (ValueCallback) message.obj;
                Runnable jVar = new j(this);
                com.ucweb.common.util.h.m.a(0, jVar, new g(this, jVar, valueCallback));
            } catch (Exception e22) {
                e22.getMessage();
                e22.getCause();
            }
        } else if (com.ucpro.base.a.e.aD == i) {
            j();
        } else if (com.ucpro.base.a.e.aE == i) {
            this.d = false;
            if (i() != null) {
                i2 = i().size();
            }
            com.ucpro.ui.g.m mVar = new com.ucpro.ui.g.m(this.b);
            mVar.a(1);
            mVar.a(com.ucpro.ui.c.a.d((int) R.string.delete_history_dialog_tip));
            mVar.a(new d(this));
            mVar.setOnDismissListener(new k(this, i2));
            mVar.show();
        } else if (com.ucpro.base.a.e.aF == i) {
            a(true);
        }
    }

    @DebugLog
    public final void b(int i, Message message) {
        if (j.f == i && this.c != null) {
            this.c.l();
        }
    }

    public final void a(boolean z) {
        s_().a(z);
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof a) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        a(true);
        return true;
    }

    public final View a(View view) {
        return s_().b(s_().a());
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(c cVar, Object obj) {
        if ((obj instanceof Object[]) && cVar != null) {
            switch (cVar.a) {
                case 30018:
                    if (obj != null) {
                        Object[] objArr = (Object[]) obj;
                        com.ucpro.feature.bookmarkhis.a.b.d dVar = (com.ucpro.feature.bookmarkhis.a.b.d) objArr[1];
                        View view = (View) objArr[0];
                        if (dVar != null) {
                            int i;
                            e.a;
                            String str = dVar.a.b;
                            String e = com.ucweb.common.util.i.f.e(dVar.a.c);
                            int i2 = dVar.c;
                            if (i() == null) {
                                i = 0;
                            } else {
                                i = i().size();
                            }
                            new StringBuilder("statHistoryClickDelete: \ntitle: ").append(str).append("\nhostName: ").append(e).append("\nindex: ").append(String.valueOf(i2)).append("\ntotalCount: ").append(String.valueOf(i));
                            HashMap hashMap = new HashMap();
                            hashMap.put("click_delete", SettingsConst.TRUE);
                            hashMap.put("history_item_title", str);
                            hashMap.put("history_item_host_name", e);
                            hashMap.put("histroy_item_index", String.valueOf(i2));
                            hashMap.put("count", String.valueOf(i));
                            m.a("histroy", "histroy_action", hashMap);
                            Runnable bVar = new b(this, dVar);
                            if (this.c != null) {
                                a aVar = this.c;
                                if (!(dVar == null || aVar.g == null)) {
                                    com.ucpro.feature.bookmarkhis.a.b.f fVar = aVar.g;
                                    if (!(view == null || dVar == null)) {
                                        com.ucpro.ui.animation.f fVar2 = new com.ucpro.ui.animation.f();
                                        Runnable bVar2 = new com.ucpro.feature.bookmarkhis.a.b.b(fVar, dVar, bVar);
                                        if (!(view == null || view.getLayoutParams() == null)) {
                                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{view.getLayoutParams().height, 0});
                                            ofInt.setDuration(200);
                                            ofInt.setInterpolator(new DecelerateInterpolator());
                                            ofInt.addUpdateListener(new com.ucpro.ui.animation.j(fVar2, view));
                                            ofInt.addListener(new com.ucpro.ui.animation.d(fVar2, bVar2));
                                            ofInt.start();
                                        }
                                    }
                                }
                                m.a(f.a);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(com.ucpro.feature.bookmarkhis.a.b.d dVar) {
        if (dVar != null && !TextUtils.isEmpty(dVar.a.c)) {
            int i;
            e.a;
            String str = dVar.a.b;
            String e = com.ucweb.common.util.i.f.e(dVar.a.c);
            int i2 = dVar.c;
            if (i() == null) {
                i = 0;
            } else {
                i = i().size();
            }
            new StringBuilder("statHistroyItemClick: \ntitle: ").append(str).append("\nhostName: ").append(e).append("\nindex: ").append(String.valueOf(i2)).append("\ntotalCount: ").append(String.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("history_item_title", str);
            hashMap.put("history_item_host_name", e);
            hashMap.put("histroy_item_index", String.valueOf(i2));
            m.a("histroy", "history_item_click", hashMap);
            s_().b(false);
            Object ajVar = new aj();
            ajVar.o = dVar.a.c;
            ajVar.s = aj.d;
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.k, ajVar);
            s_().a(false);
        }
    }

    public final void a(View view, com.ucpro.feature.bookmarkhis.a.b.d dVar) {
        com.ucweb.common.util.h.m.a(2, new a(this, dVar, view));
    }

    public final List<f> i() {
        if (this.e != null) {
            return this.e.b().a();
        }
        return null;
    }

    public final void j() {
        if (this.e != null) {
            d dVar = this.e;
            if (dVar.b != null) {
                dVar.b.a().clear();
                Message message = new Message();
                message.what = 5;
                dVar.a(message);
            }
            m.a(f.b);
        }
    }

    public final void a() {
        com.ucweb.common.util.h.m.a(2, new h(this));
    }

    public final void u_() {
        if (d.a().c()) {
            if (this.c != null) {
                this.c.a();
            }
        } else if (this.c != null) {
            a aVar = this.c;
            d a = d.a();
            com.ucpro.feature.bookmarkhis.a.a.a aVar2 = new com.ucpro.feature.bookmarkhis.a.a.a(a);
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            double time = (double) instance.getTime().getTime();
            List a2 = a.b.a();
            Collections.sort(a2, new com.ucpro.feature.bookmarkhis.a.a.b());
            for (int size = a2.size() - 1; size >= 0; size--) {
                int i;
                f fVar = (f) a2.get(size);
                double d = (time - ((double) fVar.a)) / 8.64E7d;
                if (d <= 0.0d) {
                    i = 0;
                } else {
                    i = ((int) d) + 1;
                }
                if (aVar2.b.contains(Integer.valueOf(i))) {
                    ((List) aVar2.a.get(aVar2.b.indexOf(Integer.valueOf(i)))).add(fVar);
                } else {
                    aVar2.b.add(Integer.valueOf(i));
                    List arrayList = new ArrayList();
                    arrayList.add(fVar);
                    aVar2.a.add(arrayList);
                }
            }
            aVar.a(aVar2);
        }
    }
}
