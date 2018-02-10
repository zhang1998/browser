package com.ucpro.feature.downloadpage.dirselect.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class e extends bd<a> implements OnClickListener {
    List<d> c = new ArrayList();
    c d;
    private Context e;

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        View aTTextView = new ATTextView(this.e);
        aTTextView.setTextColor(a.c("default_commentstext_gray"));
        aTTextView.setTextSize(0, (float) a.c((int) R.dimen.dialog_common_indicator));
        aTTextView.setLayoutParams(new LayoutParams(-2, -2));
        aTTextView.setOnClickListener(this);
        return new a(aTTextView);
    }

    public final /* synthetic */ void a(bh bhVar, int i) {
        a aVar = (a) bhVar;
        aVar.l.setText(((d) this.c.get(aVar.d())).b);
    }

    public e(Context context) {
        this.e = context;
    }

    public final int a() {
        return this.c.size();
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        if (((d) this.c.get(aVar.d())).a == b.a && this.d != null) {
            aVar.d();
        }
    }
}
