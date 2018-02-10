package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.f;
import com.raizlabs.android.dbflow.annotation.a;

/* compiled from: ProGuard */
public final class m implements f {
    public boolean a;
    private i b;
    private a c;
    private String d;

    @NonNull
    public static m a(@NonNull b bVar) {
        return new m(bVar.b());
    }

    private m(i iVar) {
        this.b = iVar;
    }

    m(i iVar, byte b) {
        this(iVar);
        this.a = true;
    }

    public final String a() {
        if (this.d != null) {
            return this.d;
        }
        StringBuilder append = new StringBuilder().append(this.b).append(" ");
        if (this.c != null) {
            append.append("COLLATE ").append(this.c).append(" ");
        }
        append.append(this.a ? "ASC" : "DESC");
        return append.toString();
    }

    public final String toString() {
        return a();
    }
}
