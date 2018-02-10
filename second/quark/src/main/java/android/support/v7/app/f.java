package android.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: ProGuard */
public final class f implements OnItemClickListener {
    final /* synthetic */ aa a;
    final /* synthetic */ b b;

    public f(b bVar, aa aaVar) {
        this.b = bVar;
        this.a = aaVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.b.u.onClick(this.a.b, i);
        if (!this.b.E) {
            this.a.b.dismiss();
        }
    }
}
