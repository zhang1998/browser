package com.ucpro.feature.downloadpage.dirselect;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class n extends bd<h> implements OnClickListener {
    List<String> c = new ArrayList();
    p d = this;
    private Context e;
    private Drawable f;

    public final /* synthetic */ void a(bh bhVar, int i) {
        h hVar = (h) bhVar;
        hVar.m = i;
        hVar.l.setDirName((String) this.c.get(i));
        hVar.l.setDirDrawable(this.f);
    }

    public n(Context context) {
        this.e = context;
        this.f = a.a("dirmanager_folder.svg");
    }

    public final int a() {
        return this.c.size();
    }

    public final void onClick(View view) {
        h hVar = (h) view.getTag();
        if (this.d != null) {
            this.d.a(hVar.d());
        }
    }

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        View dirManagerItemView = new DirManagerItemView(this.e);
        dirManagerItemView.setLayoutParams(new LayoutParams(-1, a.c((int) R.dimen.dir_manager_item_height)));
        dirManagerItemView.setOnClickListener(this);
        return new h(dirManagerItemView);
    }
}
