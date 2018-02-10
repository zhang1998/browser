package com.ucpro.feature.s.b;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.bumptech.glide.c;
import com.quark.browser.R;
import com.ucpro.base.b.b;
import com.ucpro.feature.s.a.g;
import com.ucpro.model.keepproguard.discnavi.DiscoveryNaviDataParse.SiteItem;
import com.ucpro.ui.c.a;
import java.io.File;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class i extends BaseAdapter {
    private final Context a;
    private final ArrayList<SiteItem> b;
    private final a c;
    private boolean d = false;

    public i(Context context, ArrayList<SiteItem> arrayList, boolean z, j jVar) {
        this.a = context;
        this.b = arrayList;
        this.d = z;
        this.c = new a(context, jVar);
    }

    public final int getCount() {
        return this.b.size();
    }

    public final Object getItem(int i) {
        if (i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        SiteItem siteItem = (SiteItem) this.b.get(i);
        if (view == null) {
            a aVar = this.c;
            View fVar = new f(aVar.a, aVar.b);
            fVar.setLayoutParams(new LayoutParams(-2, a.c((int) R.dimen.discovery_navi_itemview_height)));
            view2 = fVar;
        } else {
            view2 = view;
        }
        e eVar = (e) view2;
        eVar.setTitle(siteItem.title);
        eVar.setDescription(siteItem.description);
        if (this.d) {
            eVar.setIconDrawable(a.b(siteItem.iconName));
        } else if (com.ucweb.common.util.n.a.b(siteItem.iconUrl)) {
            ((b) c.b(this.a)).b(siteItem.iconUrl).a(eVar.getImageView());
        } else {
            if (siteItem.a == null) {
                siteItem.a = Uri.fromFile(new File(g.e().b(siteItem.iconName)));
            }
            ((b) c.b(this.a)).b(siteItem.a).a(eVar.getImageView());
        }
        eVar.setUrl(siteItem.url);
        return view2;
    }
}
