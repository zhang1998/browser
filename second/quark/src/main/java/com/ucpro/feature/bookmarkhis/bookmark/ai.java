package com.ucpro.feature.bookmarkhis.bookmark;

import android.app.Activity;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.c.b;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.e.e;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.b.k;
import com.ucpro.feature.bookmarkhis.bookmark.thirdparty.a;
import com.ucpro.feature.collectpanel.i;
import com.ucpro.feature.collectpanel.l;
import com.ucpro.feature.webwindow.aj;
import com.ucweb.common.util.f;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class ai extends e implements c, ah, u {
    public long c = 0;
    public m d;
    private Activity e;
    private aa f;
    private k g;
    private m h;
    private r i;
    private l j;

    public final void a(int i, Message message) {
        long j = 0;
        if (i == com.ucpro.base.a.e.aH) {
            c(true);
        } else if (i == com.ucpro.base.a.e.aJ) {
            if (message.obj instanceof ArrayList) {
                r0 = (ArrayList) message.obj;
                l cVar = new com.ucpro.feature.collectpanel.view.c(this.b, 1);
                i iVar = new i(s_());
                iVar.f = this.c;
                if (!(r0.isEmpty() || r0.get(0) == null || !((m) r0.get(0)).g())) {
                    iVar.k = true;
                    if (iVar.a != null) {
                        iVar.a.setHandleDirectory(true);
                    }
                }
                iVar.a(cVar);
                cVar.setPresenter(iVar);
                if (iVar.a != null) {
                    iVar.b.a((View) iVar.a);
                    iVar.a.a("", "", false);
                    iVar.d = r0;
                }
            }
        } else if (i == com.ucpro.base.a.e.aI) {
            i();
        } else if (i == com.ucpro.base.a.e.aK) {
            if (message.obj instanceof ArrayList) {
                int i2 = message.arg1;
                r0 = (ArrayList) message.obj;
                if (r0 != null) {
                    int size = r0.size();
                    List arrayList = new ArrayList();
                    for (int i3 = 0; i3 < size; i3++) {
                        r1 = ((m) r0.get(i3)).j();
                        r1.d = (long) i2;
                        arrayList.add(r1);
                    }
                    s.a().b(arrayList, new s(this));
                } else {
                    return;
                }
            }
            l();
        } else if (i == com.ucpro.base.a.e.aL) {
            if (message != null && message.obj != null && (message.obj instanceof m)) {
                r0 = (m) message.obj;
                this.h = new m(this.e, r0);
                this.h.setWindowCallBacks(this);
                o oVar = new o(this.h, this.e, r0);
                this.a.b().a(this.h, true);
            }
        } else if (i == com.ucpro.base.a.e.aM) {
            if (message.obj instanceof m) {
                r0 = (m) message.obj;
                if (message.arg1 != -1) {
                    j = (long) message.arg1;
                }
                r1 = r0.j();
                r1.d = j;
                r1.f = r0.f;
                r1.e = r0.e;
                s.a().b(r1, new z(this, j));
            }
            m();
        } else if (i == com.ucpro.base.a.e.aN) {
            if (this.i == null) {
                this.i = new r(this.e);
                this.i.setWindowCallBacks(this);
            }
            this.a.b().a(this.i, true);
        } else if (i == com.ucpro.base.a.e.aO) {
            if (message.obj instanceof String) {
                s.a().a(m.a((String) message.obj), new i(this));
            }
            k();
        } else if (i == com.ucpro.base.a.e.aP) {
            if (message.obj instanceof m) {
                if (this.j == null) {
                    this.j = new l(this.e, (m) message.obj);
                    this.j.setWindowCallBacks(this);
                }
                this.a.b().a(this.j, true);
            }
        } else if (i == com.ucpro.base.a.e.aQ) {
            if (message.obj instanceof m) {
                this.h.a((m) message.obj);
            }
            n();
        } else if (i == com.ucpro.base.a.e.aR) {
            a(this.c);
        } else if (i == com.ucpro.base.a.e.aS) {
            if (this.f != null) {
                this.f.b();
            }
        } else if (i == com.ucpro.base.a.e.aT) {
            com.ucweb.common.util.c.b(message.obj instanceof m);
            r0 = (m) message.obj;
            if (r0.h()) {
                r0.d = 0;
                s.a().b(r0, new t(this));
            }
        } else if (i == com.ucpro.base.a.e.aU) {
            com.ucweb.common.util.c.b(message.obj instanceof m);
            a((m) message.obj, true);
        } else if (i == com.ucpro.base.a.e.aV) {
            com.ucweb.common.util.c.b(message.obj instanceof m);
            a((m) message.obj, false);
        }
    }

    public final void b(int i, Message message) {
    }

    @DebugLog
    public final void a(b bVar) {
        super.a(bVar);
        this.e = bVar.a();
    }

    public final aa c(boolean z) {
        if (this.f == null || !z) {
            this.f = new aa(this.e);
            com.ucpro.base.d.b nVar = new n(this.b, this.f);
            nVar.c = this;
            this.f.setPresenter(nVar);
            this.f.setWindowManger(s_());
            this.f.setOnDeleteItem(this);
            this.f.setOnClickOpenItem(this);
            this.f.d(z);
            this.f.setEnableSwipeGesture(z);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("content", String.valueOf(s.a().c()));
        com.ucpro.business.stat.m.a("bookmark", "bookmark_enter_window", hashMap);
        s.a().b(this.c, new y(this));
        if (z) {
            this.a.b().a(this.f, true);
        } else {
            this.f.f();
        }
        com.ucweb.common.util.h.m.a(0, new com.ucpro.feature.bookmarkhis.bookmark.thirdparty.b(new a()));
        return this.f;
    }

    public final void i() {
        if (this.c == 0 || this.d == null) {
            e(true);
            return;
        }
        this.c = this.d.d;
        if (this.f != null) {
            this.f.setTitle(this.c);
        }
        s.a().b(this.c, new p(this));
    }

    private void k() {
        if (this.i != null) {
            s_().a(true);
            this.i = null;
        }
    }

    private void a(long j) {
        s.a().b(j, new e(this));
    }

    @DebugLog
    private void e(boolean z) {
        if (this.f != null) {
            s_().a(z);
            this.f = null;
        }
    }

    private void l() {
        if (this.g != null) {
            s_().a(true);
            this.g = null;
        }
    }

    public final void j() {
        a(this.c);
    }

    private void m() {
        if (this.h != null) {
            s_().a(true);
            this.h = null;
        }
    }

    private void n() {
        if (this.j != null) {
            s_().a(true);
            this.j = null;
        }
    }

    private void a(m mVar, boolean z) {
        if (mVar != null && !mVar.g() && mVar.i() != z) {
            s a;
            m a2;
            if (z) {
                a = s.a();
                com.ucweb.common.util.c.a((Object) mVar);
                a2 = s.a(mVar.b);
                if (a2 != null) {
                    mVar.m = System.currentTimeMillis();
                    mVar.a(a2);
                    a.c.c(mVar);
                }
            } else {
                a = s.a();
                com.ucweb.common.util.c.a((Object) mVar);
                a2 = s.a(mVar.b);
                if (a2 != null) {
                    mVar.m = 0;
                    mVar.a(a2);
                    a.c.c(mVar);
                }
            }
            j();
        }
    }

    public final void a(boolean z) {
        s_().a(z);
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (gVar instanceof l) {
                n();
                return true;
            } else if (gVar instanceof m) {
                m();
                return true;
            } else if (gVar instanceof r) {
                k();
                return true;
            } else if (gVar instanceof k) {
                l();
                return true;
            } else if (gVar instanceof aa) {
                aa aaVar = (aa) gVar;
                if (aaVar.a()) {
                    aaVar.c();
                    return true;
                }
                i();
                return true;
            }
        }
        return false;
    }

    public final View a(View view) {
        f.a(this.e, view);
        if (view instanceof g) {
            return s_().b((g) view);
        }
        return null;
    }

    public final void a(ArrayList<Long> arrayList) {
        if (arrayList != null) {
            s.a().a((List) arrayList, new j(this));
        }
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }

    public final void a(m mVar) {
        com.ucweb.common.util.c.a((Object) mVar);
        if (mVar == null) {
            return;
        }
        if (mVar.g()) {
            this.d = mVar;
            this.c = mVar.b;
            a(this.c);
        } else if (mVar.h()) {
            com.ucpro.business.stat.m.a("bookmark", "bookmark_click", new String[0]);
            if (!TextUtils.isEmpty(mVar.f)) {
                s_().b(true);
                if (com.ucpro.feature.lightapp.d.a.b(mVar.f)) {
                    com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.bH, mVar.f);
                    return;
                }
                Object ajVar = new aj();
                ajVar.o = mVar.f;
                ajVar.s = aj.c;
                com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.k, ajVar);
            }
        }
    }

    public final void b(boolean z) {
        this.c = 0;
        e(z);
    }

    static /* synthetic */ void a(ai aiVar, List list) {
        if (aiVar.f != null && aiVar.f != null) {
            aa aaVar = aiVar.f;
            long j = aiVar.c;
            if (aaVar.a()) {
                aaVar.setLeftImageOff(w.CHECK_NORMAL);
            }
            if (j == 0) {
                aaVar.a(list);
            } else {
                aaVar.a(list);
            }
        }
    }

    static /* synthetic */ void d(boolean z) {
        String str = null;
        if (z) {
            str = com.ucpro.ui.c.a.d((int) R.string.edit_success);
        }
        if (!TextUtils.isEmpty(str)) {
            com.ucpro.ui.b.e.a().a(str, 0);
        }
    }
}
