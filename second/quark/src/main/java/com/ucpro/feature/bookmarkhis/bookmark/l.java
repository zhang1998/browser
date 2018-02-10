package com.ucpro.feature.bookmarkhis.bookmark;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.b.f;
import com.ucpro.feature.bookmarkhis.bookmark.b.h;
import com.ucpro.feature.bookmarkhis.bookmark.b.q;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class l extends j implements h {
    private Context g;
    private q h;
    private f i;
    private m j;
    private ValueCallback<List<m>> k;

    public l(Context context, m mVar) {
        this(context);
        this.g = context;
        if (mVar == null) {
            c.a("BookmarkSelectFolderBarView BookmarkItem is null!!!");
        }
        this.j = mVar;
        this.f.a(a.d((int) R.string.bookmark_select_folder));
        this.f.a(null, null);
        this.i = new f(getContext());
        this.i.setLayoutParams(new LayoutParams(-1, -1));
        this.h = new q(getContext());
        this.h.e = false;
        this.h.c = this;
        this.i.setAdapter(this.h);
        this.e.addView(this.i, new LayoutParams(-1, -1));
        this.h.notifyDataSetChanged();
        l();
        s.a().a(this.k);
    }

    private l(Context context) {
        super(context);
        this.k = new x(this);
    }

    public final void l() {
        super.l();
        this.f.a(a.a("back.svg"));
        this.i.setBackgroundColor(a.c("default_background_white"));
    }

    private void setupListViewData(ArrayList<m> arrayList) {
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
        this.h.b = arrayList2;
        this.h.notifyDataSetChanged();
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, ad adVar) {
        g.a().a(e.aQ);
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, w wVar) {
    }

    public final void a(m mVar) {
        g.a().a(e.aQ, (Object) mVar);
    }

    public final void b(m mVar) {
    }

    public final void e(boolean z) {
    }
}
