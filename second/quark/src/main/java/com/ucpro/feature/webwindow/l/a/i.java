package com.ucpro.feature.webwindow.l.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ucpro.ui.c.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class i extends bd<j> implements OnClickListener {
    e c;
    private Context d;
    private ArrayList<a> e;
    private int f;

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        View dVar = new d(this.d);
        dVar.setLayoutParams(new LayoutParams(-2, -2));
        dVar.setOnClickListener(this);
        return new j(dVar);
    }

    public final /* synthetic */ void a(bh bhVar, int i) {
        j jVar = (j) bhVar;
        a aVar = (a) this.e.get(i);
        jVar.l.setBackgroundDrawable(a.c());
        jVar.l.setText(aVar.a);
        jVar.l.setTextColor(this.f);
        jVar.l.setTag(Integer.valueOf(aVar.b));
    }

    public i(Context context) {
        this.d = context;
        b();
    }

    public final int a() {
        return this.e.size();
    }

    public final void onClick(View view) {
        if (this.c != null) {
            this.c.f(((Integer) view.getTag()).intValue());
        }
    }

    public final void b() {
        this.f = a.c("default_maintext_gray");
        this.a.a();
    }

    static /* synthetic */ void a(i iVar, ArrayList arrayList) {
        iVar.e = arrayList;
        iVar.a.a();
    }
}
