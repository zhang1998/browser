package com.raizlabs.android.dbflow.a.b;

import android.database.DatabaseUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.a.d;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.f;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.d.a;

/* compiled from: ProGuard */
public abstract class c implements d {
    protected String a = "";
    protected Object b;
    @NonNull
    protected i c;
    protected String d;
    protected String e;
    protected boolean f;

    @Nullable
    public static String a(@Nullable Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return "NULL";
        }
        Object a;
        byte[] bArr;
        if (z2) {
            a e = FlowManager.e(obj.getClass());
            if (e != null) {
                a = e.a(obj);
                if (a instanceof Number) {
                    return String.valueOf(a);
                }
                if (a instanceof Enum) {
                    return DatabaseUtils.sqlEscapeString(((Enum) a).name());
                }
                if (!z && (a instanceof j)) {
                    return String.format("(%1s)", new Object[]{((j) a).a().trim()});
                } else if (a instanceof i) {
                    return ((i) a).a();
                } else {
                    if (a instanceof d) {
                        e eVar = new e();
                        ((d) a).a(eVar);
                        return eVar.toString();
                    } else if (a instanceof f) {
                        return ((f) a).a();
                    } else {
                        if (!(a instanceof com.raizlabs.android.dbflow.c.a) || (a instanceof byte[])) {
                            if (a instanceof com.raizlabs.android.dbflow.c.a) {
                                bArr = (byte[]) a;
                            } else {
                                bArr = ((com.raizlabs.android.dbflow.c.a) a).a;
                            }
                            return "X" + DatabaseUtils.sqlEscapeString(d.a(bArr));
                        }
                        String valueOf = String.valueOf(a);
                        if (valueOf.equals("?")) {
                            return valueOf;
                        }
                        return DatabaseUtils.sqlEscapeString(valueOf);
                    }
                }
            }
        }
        a = obj;
        if (a instanceof Number) {
            return String.valueOf(a);
        }
        if (a instanceof Enum) {
            return DatabaseUtils.sqlEscapeString(((Enum) a).name());
        }
        if (!z) {
        }
        if (a instanceof i) {
            return ((i) a).a();
        }
        if (a instanceof d) {
            e eVar2 = new e();
            ((d) a).a(eVar2);
            return eVar2.toString();
        } else if (a instanceof f) {
            return ((f) a).a();
        } else {
            if (a instanceof com.raizlabs.android.dbflow.c.a) {
            }
            if (a instanceof com.raizlabs.android.dbflow.c.a) {
                bArr = (byte[]) a;
            } else {
                bArr = ((com.raizlabs.android.dbflow.c.a) a).a;
            }
            return "X" + DatabaseUtils.sqlEscapeString(d.a(bArr));
        }
    }

    c(@NonNull i iVar) {
        this.c = iVar;
    }

    public final Object b() {
        return this.b;
    }

    @NonNull
    public final String c() {
        return this.c.a();
    }

    @NonNull
    public d b(@NonNull String str) {
        this.e = str;
        return this;
    }

    @Nullable
    public final String d() {
        return this.e;
    }

    public final boolean e() {
        return this.e != null && this.e.length() > 0;
    }

    @NonNull
    public final String f() {
        return this.a;
    }

    public final String g() {
        return this.d;
    }

    final i h() {
        return this.c;
    }

    public String a(Object obj, boolean z) {
        return a(obj, z, true);
    }
}
