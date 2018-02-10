package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.view.View;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class k extends j implements d, h {
    private q g;
    private f h;
    private ATTextView i;
    private ArrayList<m> j;
    private ValueCallback<List<m>> k;

    public final void l() {
        super.l();
        this.f.a(a.a("back.svg"));
        this.h.setBackgroundColor(a.c("default_background_white"));
    }

    public final void setData(ArrayList<m> arrayList) {
        int size;
        this.j = arrayList;
        ATTextView aTTextView = this.i;
        String d = a.d((int) R.string.bookmark_select_tips);
        Object[] objArr = new Object[1];
        if (this.j != null) {
            size = this.j.size();
        } else {
            size = 0;
        }
        objArr[0] = Integer.valueOf(size);
        aTTextView.setText(String.format(d, objArr));
    }

    public final void setupListViewData(ArrayList<m> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (!(arrayList == null || arrayList.size() == 0)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (!(mVar.i == 4 || mVar.i == 3 || mVar.i == 2)) {
                    arrayList2.add(mVar);
                }
            }
        }
        this.g.b = arrayList2;
        this.g.notifyDataSetChanged();
    }

    public final void a(f fVar, View view, ad adVar) {
        g.a().a(e.aK);
    }

    public final void a(f fVar, View view, w wVar) {
    }

    public final void a(int i) {
    }

    public final ValueCallback<List<m>> getBookmarkDaoCallback() {
        return this.k;
    }

    public final void a(m mVar) {
        com.ucpro.business.stat.m.a("bookmark", "bookmark_move", new String[0]);
        g.a().a(e.aK, (int) mVar.b, (int) mVar.b, this.j);
    }

    public final void b(m mVar) {
    }

    public final void e(boolean z) {
    }
}
