package android.support.v7.widget;

import android.support.v7.app.aj;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* compiled from: ProGuard */
final class ec extends BaseAdapter {
    final /* synthetic */ fu a;

    private ec(fu fuVar) {
        this.a = fuVar;
    }

    public final int getCount() {
        return this.a.d.getChildCount();
    }

    public final Object getItem(int i) {
        return ((fr) this.a.d.getChildAt(i)).a;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return fu.a(this.a, (aj) getItem(i));
        }
        fr frVar = (fr) view;
        frVar.a = (aj) getItem(i);
        frVar.a();
        return view;
    }
}
