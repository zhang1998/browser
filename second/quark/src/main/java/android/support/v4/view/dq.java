package android.support.v4.view;

import android.view.KeyEvent;

/* compiled from: ProGuard */
final class dq extends ai {
    dq() {
    }

    public final int b(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public final boolean a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public final boolean a(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
