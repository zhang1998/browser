package android.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/* compiled from: ProGuard */
public final class ad implements OnItemClickListener {
    final /* synthetic */ ListView a;
    final /* synthetic */ aa b;
    final /* synthetic */ b c;

    public ad(b bVar, ListView listView, aa aaVar) {
        this.c = bVar;
        this.a = listView;
        this.b = aaVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.c.C != null) {
            this.c.C[i] = this.a.isItemChecked(i);
        }
        this.c.G.onClick(this.b.b, i, this.a.isItemChecked(i));
    }
}
