package android.mini.support.v4.view;

import android.view.KeyEvent;

/* compiled from: ProGuard */
final class q extends p {
    q() {
    }

    public final int a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public final boolean b(int i) {
        return KeyEvent.metaStateHasModifiers(i, 1);
    }

    public final boolean c(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
