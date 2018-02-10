package com.ucpro.ui.widget.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ProGuard */
public abstract class g {
    public final DataSetObservable a = new DataSetObservable();
    private DataSetObserver b;

    public abstract int a();

    public abstract boolean a(View view, Object obj);

    public void a(Object obj) {
    }

    public final void b() {
        synchronized (this) {
            if (this.b != null) {
                this.b.onChanged();
            }
        }
        this.a.notifyChanged();
    }

    final void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.b = dataSetObserver;
        }
    }

    public CharSequence a(int i) {
        return null;
    }

    public Object a(ViewGroup viewGroup, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void a(ViewGroup viewGroup, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }
}
