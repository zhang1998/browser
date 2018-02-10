package android.support.v7.widget;

import android.database.Observable;

/* compiled from: ProGuard */
public final class ba extends Observable<at> {
    ba() {
    }

    public final void a() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((at) this.mObservers.get(size)).a();
        }
    }

    public final void a(int i) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((at) this.mObservers.get(size)).a(i);
        }
    }

    public final void a(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((at) this.mObservers.get(size)).a(i, i2);
        }
    }
}
