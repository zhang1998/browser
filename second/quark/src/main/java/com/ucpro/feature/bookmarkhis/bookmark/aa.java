package com.ucpro.feature.bookmarkhis.bookmark;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.alibaba.wireless.security.SecExceptionCode;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.b.b;
import com.ucpro.feature.bookmarkhis.bookmark.b.f;
import com.ucpro.feature.bookmarkhis.bookmark.b.h;
import com.ucpro.feature.bookmarkhis.bookmark.b.o;
import com.ucpro.feature.bookmarkhis.bookmark.b.q;
import com.ucpro.ui.a.a;
import com.ucpro.ui.g.m;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.af;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class aa extends j implements c, d, com.ucpro.feature.bookmarkhis.bookmark.b.d, h, q, af {
    private Context g;
    private a h;
    private q i;
    private f j;
    private b k;
    private com.ucpro.feature.bookmarkhis.bookmark.b.j l;
    private m m;
    private u n;
    private ah o;
    private String p;
    private com.ucpro.base.c.b.m q;
    private String r = "<font color='%s'>%s</font>";
    private v s;
    private b t;

    public aa(Context context) {
        super(context);
        this.g = context;
        setWindowCallBacks(this);
        this.f.a(com.ucpro.ui.c.a.a("back.svg"), w.DEFAULT);
        this.p = com.ucpro.ui.c.a.d((int) R.string.bookmark);
        this.f.a(this.p);
        this.h = new a(this.g);
        this.h.setVisibility(8);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.e.addView(this.h, layoutParams);
        this.j = new f(getContext());
        this.i = new q(getContext());
        this.i.c = this;
        this.j.setBackgroundColor(com.ucpro.ui.c.a.c("default_background_white"));
        this.j.setAdapter(this.i);
        layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.e.addView(this.j, layoutParams);
        this.k = new b(getContext());
        this.e.addView(this.k, new LinearLayout.LayoutParams(-1, com.ucpro.ui.c.a.c((int) R.dimen.bookmark_cloud_bar_height)));
        this.k.setOnClickListener(new a(this));
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.l = new com.ucpro.feature.bookmarkhis.bookmark.b.j(this.g);
        this.l.setOnClick(this);
        this.l.a(o.c).setVisibility(8);
        a(this.l, layoutParams);
        this.i.notifyDataSetChanged();
    }

    public final void a(boolean z) {
        if (this.o != null) {
            this.o.b(z);
        }
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (this.o == null) {
            return false;
        }
        return this.o.a(gVar, i, keyEvent);
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.q.b((g) view);
        }
        return null;
    }

    public final void setWindowManger(com.ucpro.base.c.b.m mVar) {
        this.q = mVar;
    }

    public final void setOnClickOpenItem(ah ahVar) {
        this.o = ahVar;
    }

    public final void setTitle(long j) {
        if (j == 0) {
            this.f.a(this.p);
            return;
        }
        s.a().a((long) ((int) j), new af(this));
    }

    public final boolean a() {
        return this.i == null ? false : this.i.d;
    }

    final void setLeftImageOff(ad adVar) {
        this.f.a(com.ucpro.ui.c.a.a("setting_item_checkbox_off.svg"), adVar);
    }

    private void setupListViewData$22871ed2(List<com.ucpro.feature.bookmarkhis.bookmark.a.m> list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            for (com.ucpro.feature.bookmarkhis.bookmark.a.m mVar : list) {
                if (!(mVar.i == 4 || mVar.i == 3 || mVar.i == 2)) {
                    arrayList.add(mVar);
                }
            }
        }
        if (arrayList.size() == 0) {
            f(true);
        } else {
            f(false);
        }
        this.i.b = arrayList;
        this.i.notifyDataSetChanged();
    }

    private void m() {
        if (this.i.e()) {
            boolean z;
            this.l.a(o.a, true);
            com.ucpro.feature.bookmarkhis.bookmark.b.j jVar = this.l;
            int i = o.b;
            q qVar = this.i;
            if (qVar.b == null) {
                z = false;
            } else {
                Iterator it = qVar.b.iterator();
                int i2 = -1;
                while (it.hasNext()) {
                    com.ucpro.feature.bookmarkhis.bookmark.a.m mVar = (com.ucpro.feature.bookmarkhis.bookmark.a.m) it.next();
                    if (mVar.w) {
                        if (i2 == -1) {
                            i2 = mVar.j;
                        } else if (i2 != mVar.j) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
            }
            jVar.a(i, z);
            this.l.a(o.c, this.i.f());
            return;
        }
        this.l.a(o.a, false);
        this.l.a(o.b, false);
        this.l.a(o.c, false);
    }

    private void f(boolean z) {
        if (z && !this.h.b()) {
            this.h.a("lottie/bookmark_empty/data.json", "lottie/bookmark_empty/images", "lottie/bookmark_empty/images_night");
            this.h.setText(com.ucpro.ui.c.a.d((int) R.string.empty_error_anim_page_bookmark_empty));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        if (z) {
            layoutParams.weight = 0.0f;
        } else {
            layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        }
        this.h.setVisibility(z ? 0 : 8);
    }

    public final void a(com.ucpro.feature.bookmarkhis.bookmark.a.m mVar) {
        if (mVar != null && this.o != null && !this.i.d) {
            if (mVar.g()) {
                this.f.a(mVar.e);
            }
            this.o.a(mVar);
        }
    }

    @DebugLog
    public final void b(com.ucpro.feature.bookmarkhis.bookmark.a.m mVar) {
        if (this.t != null) {
            this.t.a(mVar);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(boolean r2) {
        /*
        r1 = this;
        r0 = r1.i;
        r0 = r0.b();
        if (r0 != 0) goto L_0x002b;
    L_0x0008:
        r0 = r1.i;
        r0 = r0.a();
        if (r0 == 0) goto L_0x0019;
    L_0x0010:
        r0 = com.ucpro.feature.bookmarkhis.bookmark.w.CHECK_SELECT;
        r1.setLeftImageOn(r0);
    L_0x0015:
        r1.m();
        return;
    L_0x0019:
        r0 = r1.i;
        r0 = r0.e();
        if (r0 == 0) goto L_0x0029;
    L_0x0021:
        r0 = r1.i;
        r0 = r0.a();
        if (r0 != 0) goto L_0x002b;
    L_0x0029:
        if (r2 != 0) goto L_0x0015;
    L_0x002b:
        r0 = com.ucpro.feature.bookmarkhis.bookmark.w.CHECK_NORMAL;
        r1.setLeftImageOff(r0);
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.bookmarkhis.bookmark.aa.e(boolean):void");
    }

    private void setLeftImageOn(ad adVar) {
        this.f.a(com.ucpro.ui.c.a.a("setting_item_checkbox_on.svg"), adVar);
    }

    public final void b() {
        if (this.j != null) {
            com.ucpro.business.stat.m.a("bookmark", "bookmark_enter_editmode", new String[0]);
            this.f.a(com.ucpro.ui.c.a.a("setting_item_checkbox_off.svg"), w.CHECK_NORMAL);
            this.j.b();
            this.l.b();
        }
        if (this.s != null) {
            this.s.a(true);
        }
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, ad adVar) {
        if (adVar != null) {
            int a = adVar.a();
            if (a == w.DEFAULT.e) {
                com.ucpro.base.a.g.a().a(e.aI);
            } else if (a == w.CHECK_NORMAL.e) {
                com.ucpro.business.stat.m.a("bookmark", "bookmark_select_all", new String[0]);
                setLeftImageOn(w.CHECK_SELECT);
                this.i.c();
                m();
            } else if (a == w.CHECK_SELECT.e) {
                setLeftImageOff(w.CHECK_NORMAL);
                this.i.d();
                m();
            } else if (a == w.STATUS_NORMAL.e) {
                setLeftImageOff(w.CHECK_NORMAL);
            }
        }
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, w wVar) {
    }

    public final void f() {
        super.f();
    }

    public final void l() {
        super.l();
        this.j.a();
        this.h.a();
        this.l.a();
    }

    public final void a(int i) {
        if (i == o.d) {
            com.ucpro.business.stat.m.a("bookmark", "bookmark_complete", new String[0]);
            c();
            com.ucpro.business.stat.m.a(c.e);
        } else if (i == o.b) {
            com.ucpro.business.stat.m.a("bookmark", "bookmark_move_click", new String[0]);
            com.ucpro.base.a.g.a().a(e.aJ, getSelectItem());
            com.ucpro.business.stat.m.a(c.c);
        } else if (i == o.c) {
            com.ucpro.business.stat.m.a("bookmark", "bookmark_revise", new String[0]);
            com.ucpro.base.a.g.a().a(e.aL, getSingleSelectItem());
            com.ucpro.business.stat.m.a(c.d);
        } else if (i == o.a) {
            com.ucpro.business.stat.m.a("bookmark", "bookmark_delete_click", new String[0]);
            Object selectItem = getSelectItem();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = selectItem.iterator();
            while (it.hasNext()) {
                com.ucpro.feature.bookmarkhis.bookmark.a.m mVar = (com.ucpro.feature.bookmarkhis.bookmark.a.m) it.next();
                if (mVar.g()) {
                    arrayList2.add(Long.valueOf(mVar.b));
                }
                arrayList.add(Long.valueOf(mVar.b));
            }
            this.m = null;
            this.m = new m(this.g);
            this.m.a(1);
            com.ucweb.common.util.c.a(selectItem);
            if (selectItem != null) {
                this.m.a(String.format(com.ucpro.ui.c.a.d((int) R.string.bookmark_delete_tips), new Object[]{Integer.valueOf(selectItem.size())}));
            }
            this.m.a(new ac(this, selectItem, arrayList2, arrayList));
            this.m.show();
        }
    }

    public final void c() {
        this.f.a(com.ucpro.ui.c.a.a("back.svg"), w.DEFAULT);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.j.setLayoutParams(layoutParams);
        this.j.c();
        this.i.d();
        m();
        this.l.c();
        if (this.s != null) {
            this.s.a(false);
        }
    }

    public final ArrayList<com.ucpro.feature.bookmarkhis.bookmark.a.m> getSelectItem() {
        if (this.i != null) {
            return this.i.h();
        }
        return null;
    }

    private com.ucpro.feature.bookmarkhis.bookmark.a.m getSingleSelectItem() {
        if (this.i != null) {
            return this.i.g();
        }
        return null;
    }

    public final void setLoginName(String str) {
        this.k.setLoginName(str);
    }

    public final void setSyncTime(String str) {
        this.k.setSyncTime(str);
    }

    public final void a_(boolean z) {
        if (z) {
            b bVar = this.k;
            bVar.a.addUpdateListener(new com.ucpro.feature.bookmarkhis.bookmark.b.m(bVar));
            bVar.a.setDuration(1000);
            bVar.a.setRepeatCount(SecExceptionCode.SEC_ERROR_DYN_STORE);
            bVar.a.start();
            return;
        }
        this.k.a.setRepeatCount(0);
    }

    public final void setOnDeleteItem(u uVar) {
        this.n = uVar;
    }

    public final ArrayList<Long> getSelectItemId() {
        if (this.i != null) {
            return this.i.i();
        }
        return null;
    }

    public final void setOnBookmarkEditModel(v vVar) {
        this.s = vVar;
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.t = (b) bVar;
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9456956");
    }

    public final String getPageName() {
        return "Page_set_bookmark";
    }

    final void a(List<com.ucpro.feature.bookmarkhis.bookmark.a.m> list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            for (com.ucpro.feature.bookmarkhis.bookmark.a.m mVar : list) {
                if (!(mVar.i == 4 || mVar.i == 3 || mVar.i == 2)) {
                    arrayList.add(mVar);
                }
            }
        }
        if (arrayList.size() == 0) {
            f(true);
        } else {
            f(false);
        }
        this.i.b = arrayList;
        this.i.notifyDataSetChanged();
        m();
    }
}
