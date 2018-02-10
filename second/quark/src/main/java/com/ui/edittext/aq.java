package com.ui.edittext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* compiled from: ProGuard */
final class aq extends BaseAdapter {
    final /* synthetic */ at a;
    private LayoutInflater b;

    private aq(at atVar) {
        this.a = atVar;
        this.b = (LayoutInflater) this.a.g.mContext.getSystemService("layout_inflater");
    }

    public final int getCount() {
        return this.a.i;
    }

    public final Object getItem(int i) {
        return this.a.h[i];
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        view = (TextView) view;
        if (view == null) {
            view2 = (TextView) this.b.inflate(this.a.g.N, viewGroup, false);
        } else {
            view2 = view;
        }
        ar arVar = this.a.h[i];
        view2.setText(arVar.e);
        if (!(arVar.d == -1 || arVar.d == -2)) {
            view2.a(null, null, null, null);
        }
        return view2;
    }
}
