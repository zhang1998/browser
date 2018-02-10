package com.ucpro.ui.e;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout.LayoutParams;
import com.ucpro.ui.e.a.c;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a<T extends e> extends RecyclerView {
    private int s = 1;
    private c t;
    private GridLayoutManager u;
    private c v;

    public a(Context context, c cVar) {
        super(context);
        if (cVar == null) {
            throw new RuntimeException("please impl IConfigItemViewHolder interface");
        }
        this.v = cVar;
        this.t = new c(context);
        setLayoutParams(new LayoutParams(-1, -1));
        this.u = new GridLayoutManager(getContext(), this.s);
        setLayoutManager(this.u);
        setAdapter(this.t);
    }

    public final void j() {
        setData(this.v.getConfig());
    }

    public final void setSpanCount(int i) {
        this.s = i;
        setLayoutManager(new GridLayoutManager(getContext(), this.s));
    }

    public final void setOrientation(int i) {
        this.u.g(i);
    }

    private void setData(ArrayList<T> arrayList) {
        c cVar = this.t;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (cVar.d.containsKey(dVar.a)) {
                    com.ucweb.common.util.c.b(true);
                } else {
                    cVar.d.put(dVar.a, Integer.valueOf(i));
                }
                int i2 = i + 1;
                cVar.c.put(i, dVar);
                i = i2;
            }
        }
        this.t.a.a();
    }

    public final void k() {
        this.t.a.a();
    }
}
