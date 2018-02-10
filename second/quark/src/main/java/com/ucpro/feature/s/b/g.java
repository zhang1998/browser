package com.ucpro.feature.s.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.ucpro.model.keepproguard.discnavi.DiscoveryNaviDataParse;
import com.ucpro.model.keepproguard.discnavi.DiscoveryNavigationData;
import com.ucpro.ui.c.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class g extends com.ucpro.ui.widget.viewpager.g {
    View b;
    private final DiscoveryNavigationData c;
    private final View[] d = new View[this.c.array.size()];
    private final Context e;
    private final j f;

    public g(Context context, DiscoveryNavigationData discoveryNavigationData, j jVar) {
        this.e = context;
        this.c = discoveryNavigationData;
        this.f = jVar;
    }

    public final int a() {
        return this.c.array.size();
    }

    public final Object a(ViewGroup viewGroup, int i) {
        View view;
        if (i < 0 || i >= this.d.length) {
            view = null;
        } else {
            if (this.d[i] == null) {
                View[] viewArr = this.d;
                d dVar = new d(this.e, this.f);
                int c = a.c((int) R.dimen.discovery_navi_itemview_vertical_space);
                dVar.setVerticalSpacing(c);
                dVar.setPadding(0, 0, 0, a.c((int) R.dimen.discovery_navi_view_bottombar_height));
                dVar.setHorizontalSpacing(c);
                dVar.setNumColumns(2);
                DiscoveryNaviDataParse discoveryNaviDataParse = (DiscoveryNaviDataParse) this.c.array.get(i);
                ArrayList arrayList = discoveryNaviDataParse.dataList;
                boolean z = discoveryNaviDataParse.a;
                dVar.b = arrayList;
                dVar.c = z;
                dVar.setAdapter(new i(dVar.getContext(), dVar.b, dVar.c, dVar.a));
                viewArr[i] = dVar;
            }
            view = this.d[i];
        }
        viewGroup.addView(view);
        return view;
    }

    public final void a(ViewGroup viewGroup, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final void a(Object obj) {
        this.b = (View) obj;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final CharSequence a(int i) {
        return ((DiscoveryNaviDataParse) this.c.array.get(i)).tabTitle;
    }
}
