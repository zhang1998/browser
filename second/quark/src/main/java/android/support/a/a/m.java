package android.support.a.a;

import android.content.res.TypedArray;

/* compiled from: ProGuard */
final class m extends k {
    public m(m mVar) {
        super(mVar);
    }

    final void a(TypedArray typedArray) {
        String string = typedArray.getString(0);
        if (string != null) {
            this.n = string;
        }
        string = typedArray.getString(1);
        if (string != null) {
            this.m = a.a(string);
        }
    }

    public final boolean a() {
        return true;
    }
}
