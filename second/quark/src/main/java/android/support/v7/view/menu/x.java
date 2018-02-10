package android.support.v7.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class x extends BaseAdapter {
    final /* synthetic */ b a;
    private int b = -1;

    public final /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public x(b bVar) {
        this.a = bVar;
        a();
    }

    public final int getCount() {
        int size = this.a.c.k().size() - this.a.i;
        return this.b < 0 ? size : size - 1;
    }

    public final i a(int i) {
        ArrayList k = this.a.c.k();
        int a = this.a.i + i;
        if (this.b >= 0 && a >= this.b) {
            a++;
        }
        return (i) k.get(a);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.a.b.inflate(this.a.f, viewGroup, false);
        } else {
            inflate = view;
        }
        ((k) inflate).a(a(i));
        return inflate;
    }

    private void a() {
        i iVar = this.a.c.k;
        if (iVar != null) {
            ArrayList k = this.a.c.k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                if (((i) k.get(i)) == iVar) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
