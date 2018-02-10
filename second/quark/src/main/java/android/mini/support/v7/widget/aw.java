package android.mini.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class aw {
    SparseArray<ArrayList<bf>> a = new SparseArray();
    SparseIntArray b = new SparseIntArray();
    int c = 0;

    public final void a(int i) {
        this.b.put(i, 0);
        ArrayList arrayList = (ArrayList) this.a.get(i);
        if (arrayList != null) {
            while (arrayList.size() > 0) {
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    final void a() {
        this.c++;
    }

    final void b() {
        this.c--;
    }
}
