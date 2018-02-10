package android.support.v7.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class ad extends BaseAdapter {
    final /* synthetic */ ae a;
    private u b;
    private int c = -1;

    public final /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public ad(ae aeVar, u uVar) {
        this.a = aeVar;
        this.b = uVar;
        a();
    }

    public final int getCount() {
        ArrayList k = this.a.k ? this.b.k() : this.b.i();
        if (this.c < 0) {
            return k.size();
        }
        return k.size() - 1;
    }

    public final i a(int i) {
        ArrayList k = this.a.k ? this.b.k() : this.b.i();
        if (this.c >= 0 && i >= this.c) {
            i++;
        }
        return (i) k.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.a.h.inflate(ae.a, viewGroup, false);
        } else {
            inflate = view;
        }
        k kVar = (k) inflate;
        if (this.a.e) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        kVar.a(a(i));
        return inflate;
    }

    private void a() {
        i iVar = this.a.i.k;
        if (iVar != null) {
            ArrayList k = this.a.i.k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                if (((i) k.get(i)) == iVar) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
