package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* compiled from: ProGuard */
public abstract class dr {
    final DataSetObservable a = new DataSetObservable();
    private DataSetObserver b;

    public abstract int a();

    public abstract boolean c();

    final void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.b = dataSetObserver;
        }
    }

    public static void b() {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }
}
