package android.mini.support.v7.widget;

import android.database.Observable;

/* compiled from: ProGuard */
public final class an extends Observable<ao> {
    an() {
    }

    public final boolean a() {
        return !this.mObservers.isEmpty();
    }

    public final void b() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((ao) this.mObservers.get(size)).a();
        }
    }

    public final void a(int i) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((ao) this.mObservers.get(size)).a(i, 1);
        }
    }

    public final void b(int i) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((ao) this.mObservers.get(size)).a(i);
        }
    }

    public final void c(int i) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((ao) this.mObservers.get(size)).b(i);
        }
    }
}
