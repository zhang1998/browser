package com.ucpro.feature.bookmarkhis.b;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.c.b.c;
import com.ucpro.base.d.b;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.b.d;
import com.ucpro.feature.bookmarkhis.bookmark.b.f;
import com.ucpro.feature.bookmarkhis.bookmark.b.h;
import com.ucpro.feature.bookmarkhis.bookmark.b.o;
import com.ucpro.feature.bookmarkhis.bookmark.b.p;
import com.ucpro.feature.bookmarkhis.bookmark.b.q;
import com.ucpro.ui.c.a;
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
public final class g extends j implements c, n, d, h, af {
    private Context g;
    private p h;
    private q i;
    private f j;
    private com.ucpro.feature.bookmarkhis.bookmark.b.j k;
    private m l;
    private p m;
    private j n;
    private String o;
    private com.ucpro.base.c.b.m p;
    private String q = "<font color='%s'>%s</font>";
    private l r;
    private h s;
    private boolean t = false;

    public g(Context context) {
        super(context);
        this.g = context;
        f();
        setWindowCallBacks(this);
        this.f.a(a.a("privacy_mode_back.svg"), b.DEFAULT);
        this.f.a(a.a("privacy_mode_edit.svg"), a.DEFAULT);
        this.o = a.d((int) R.string.privacymode_bookmark);
        this.f.a(this.o);
        this.f.a.setBackgroundColor(a.c("default_background_dark"));
        this.f.b.setTextColor(a.c("privacymode_title_color"));
        this.f.a();
        if (com.ucpro.model.a.a.a.a("setting_status_bar_type", 1) == 1) {
            setTitlebarMarginTop(a.c((int) R.dimen.privacymode_close_icon_margintop));
        }
        this.h = new p(this.g);
        this.h.setVisibility(8);
        this.h.setBackgroundColor(a.c("default_background_dark"));
        this.j = new f(getContext());
        this.j.setLayoutParams(new LayoutParams(-1, -1));
        this.i = new q(getContext());
        this.i.c = this;
        q qVar = this.i;
        qVar.g = a.c("privacymode_bookmark_item_title_color");
        qVar.h = true;
        this.j.setAdapter(this.i);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.e.setBackgroundColor(a.c("default_background_dark"));
        this.e.addView(this.h, new LayoutParams(-1, -1));
        this.e.addView(this.j, layoutParams);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.k = new com.ucpro.feature.bookmarkhis.bookmark.b.j(this.g);
        this.k.setToolbarBackgroundColor(a.c("default_background_dark"));
        this.k.setTextViewColor(a.c("privacymode_title_color"));
        this.k.setOnClick(this);
        this.k.a(o.b).setVisibility(8);
        this.k.a(o.c).setVisibility(8);
        a(this.k, layoutParams);
        this.i.notifyDataSetChanged();
    }

    public final void a(boolean z) {
        com.ucpro.base.a.g.a().a(e.cD, Boolean.valueOf(false));
    }

    public final void a(com.ucpro.base.c.b.g gVar, byte b) {
    }

    public final boolean a(com.ucpro.base.c.b.g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof g) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        com.ucpro.base.a.g.a().a(e.cD, Boolean.valueOf(true));
        return true;
    }

    public final View a(View view) {
        if (view instanceof com.ucpro.base.c.b.g) {
            return this.p.b((com.ucpro.base.c.b.g) view);
        }
        return null;
    }

    public final void setWindowManger(com.ucpro.base.c.b.m mVar) {
        this.p = mVar;
    }

    public final void setOnClickOpenItem(j jVar) {
        this.n = jVar;
    }

    public final void setTitle(long j) {
        if (j == 0) {
            this.f.a(this.o);
            return;
        }
        s.a().a((long) ((int) j), new f(this));
    }

    private void setLeftImageOff(ad adVar) {
        this.f.a(a.a("setting_item_checkbox_off.svg"), adVar);
    }

    private void setupListViewData(List<com.ucpro.feature.bookmarkhis.bookmark.a.m> list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            for (com.ucpro.feature.bookmarkhis.bookmark.a.m mVar : list) {
                if (mVar.i == 5) {
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

    private void a() {
        if (this.i.e()) {
            Iterator it;
            com.ucpro.feature.bookmarkhis.bookmark.a.m mVar;
            boolean z;
            this.k.a(o.a, true);
            com.ucpro.feature.bookmarkhis.bookmark.b.j jVar = this.k;
            int i = o.b;
            q qVar = this.i;
            if (qVar.b != null) {
                it = qVar.b.iterator();
                while (it.hasNext()) {
                    mVar = (com.ucpro.feature.bookmarkhis.bookmark.a.m) it.next();
                    if (mVar.w && mVar.g()) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
                qVar = this.i;
                if (qVar.b != null) {
                    it = qVar.b.iterator();
                    while (it.hasNext()) {
                        mVar = (com.ucpro.feature.bookmarkhis.bookmark.a.m) it.next();
                        if (mVar.d == 0) {
                            if (mVar.g()) {
                            }
                        }
                        z = true;
                    }
                }
                z = false;
                if (z) {
                    z = true;
                    jVar.a(i, z);
                    this.k.a(o.c, this.i.f());
                    return;
                }
            }
            z = false;
            jVar.a(i, z);
            this.k.a(o.c, this.i.f());
            return;
        }
        this.k.a(o.a, false);
        this.k.a(o.b, false);
        this.k.a(o.c, false);
    }

    private void f(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
        if (z) {
            this.h.setContentText(a.d((int) R.string.privacymode_bookmark_empty_content));
        }
    }

    public final void a(com.ucpro.feature.bookmarkhis.bookmark.a.m mVar) {
        if (mVar != null && this.n != null && !this.i.d) {
            if (mVar.g()) {
                this.f.a(mVar.e);
                String toHexString = Integer.toHexString(a.c("bookmark_empty_folder_text_color"));
                toHexString = toHexString.substring(2, toHexString.length());
                toHexString = String.format(this.q, new Object[]{"#" + toHexString, mVar.e});
                this.h.setContentText(String.format(a.d((int) R.string.no_bookmark_text), new Object[]{toHexString}));
            }
            this.n.a(mVar);
        }
    }

    @DebugLog
    public final void b(com.ucpro.feature.bookmarkhis.bookmark.a.m mVar) {
        if (this.s != null) {
            this.s.a(mVar);
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
        r0 = com.ucpro.feature.bookmarkhis.b.b.CHECK_SELECT;
        r1.setLeftImageOn(r0);
    L_0x0015:
        r1.a();
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
        r0 = com.ucpro.feature.bookmarkhis.b.b.CHECK_NORMAL;
        r1.setLeftImageOff(r0);
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.bookmarkhis.b.g.e(boolean):void");
    }

    private void setLeftImageOn(ad adVar) {
        this.f.a(a.a("setting_item_checkbox_on.svg"), adVar);
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, ad adVar) {
        if (adVar != null) {
            int a = adVar.a();
            if (a == b.DEFAULT.e) {
                com.ucpro.base.a.g.a().a(e.cD, Boolean.valueOf(true));
                com.ucpro.business.stat.m.a("privacy_mode", "privacy_bookmark_back", new String[0]);
            } else if (a == b.CHECK_NORMAL.e) {
                com.ucpro.business.stat.m.a("bookmark", "bookmark_select_all", new String[0]);
                setLeftImageOn(b.CHECK_SELECT);
                this.i.c();
                a();
            } else if (a == b.CHECK_SELECT.e) {
                setLeftImageOff(b.CHECK_NORMAL);
                this.i.d();
                a();
            } else if (a == b.STATUS_NORMAL.e) {
                setLeftImageOff(b.CHECK_NORMAL);
            }
        }
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, w wVar) {
        if (wVar == null) {
            return;
        }
        if (wVar.a() == a.DEFAULT.c) {
            if (this.j != null) {
                com.ucpro.business.stat.m.a("bookmark", "bookmark_enter_editmode", new String[0]);
                this.f.a(a.a("setting_item_checkbox_off.svg"), b.CHECK_NORMAL);
                this.f.a(null, a.ADD);
                LayoutParams layoutParams = (LayoutParams) this.j.getLayoutParams();
                layoutParams.bottomMargin = a.c((int) R.dimen.common_bottom_titlebar_height);
                this.j.setLayoutParams(layoutParams);
                this.j.b();
                this.k.b();
            }
            com.ucpro.business.stat.m.a("privacy_mode", "privacy_bookmark_edit", new String[0]);
            return;
        }
        int i = a.ADD.c;
    }

    public final void l() {
        super.l();
        this.j.a();
        this.h.a();
    }

    public final void a(int i) {
        if (i == o.d) {
            this.f.a(a.a("privacy_mode_back.svg"), b.DEFAULT);
            this.f.a(a.a("privacy_mode_edit.svg"), a.DEFAULT);
            LayoutParams layoutParams = (LayoutParams) this.j.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.j.setLayoutParams(layoutParams);
            this.j.c();
            this.i.d();
            a();
            this.k.c();
        } else if (i == o.b) {
            com.ucpro.base.a.g.a().a(e.aJ, getSelectItem());
        } else if (i == o.c) {
            com.ucpro.base.a.g.a().a(e.aL, getSingleSelectItem());
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
            this.l = null;
            this.l = new m(this.g);
            this.l.a(1);
            com.ucweb.common.util.c.a(selectItem);
            if (selectItem != null) {
                this.l.a(String.format(a.d((int) R.string.bookmark_delete_tips), new Object[]{Integer.valueOf(selectItem.size())}));
            }
            this.l.a(new o(this, arrayList));
            this.l.show();
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

    public final void setOnDeleteItem(p pVar) {
        this.m = pVar;
    }

    public final ArrayList<Long> getSelectItemId() {
        if (this.i != null) {
            return this.i.i();
        }
        return null;
    }

    public final void setOnBookmarkEditModel(l lVar) {
        this.r = lVar;
    }

    public final void setPresenter(b bVar) {
        this.s = (h) bVar;
    }

    public final void setupBookmarkView(List<com.ucpro.feature.bookmarkhis.bookmark.a.m> list) {
        boolean z;
        if (this.i == null) {
            z = false;
        } else {
            z = this.i.d;
        }
        if (z) {
            setLeftImageOff(b.CHECK_NORMAL);
        }
        setupListViewData(list);
        a();
    }
}
