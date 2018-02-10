package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: ProGuard */
final class fz implements OnItemClickListener {
    final /* synthetic */ AppCompatSpinner a;
    final /* synthetic */ ej b;

    fz(ej ejVar, AppCompatSpinner appCompatSpinner) {
        this.b = ejVar;
        this.a = appCompatSpinner;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.b.m.setSelection(i);
        if (this.b.m.getOnItemClickListener() != null) {
            this.b.m.performItemClick(view, i, this.b.n.getItemId(i));
        }
        this.b.c();
    }
}
