package com.ucpro.feature.bookmarkhis.c.a;

import android.view.View;
import android.view.ViewGroup;
import com.ucpro.ui.widget.viewpager.g;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class b extends g {
    private ArrayList<c> b;

    public b(ArrayList<c> arrayList) {
        this.b = arrayList;
        if (this.b == null) {
            throw new RuntimeException("BookmarkHistoryTabAdapter must provider tab view");
        }
    }

    public final int a() {
        return this.b.size();
    }

    public final Object a(ViewGroup viewGroup, int i) {
        View view = ((c) this.b.get(i)).b;
        viewGroup.addView(view);
        return view;
    }

    public final void a(ViewGroup viewGroup, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final CharSequence a(int i) {
        return ((c) this.b.get(i)).a;
    }
}
