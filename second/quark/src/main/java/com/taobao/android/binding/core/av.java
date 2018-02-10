package com.taobao.android.binding.core;

import android.mini.support.annotation.Nullable;

/* compiled from: ProGuard */
final class av {
    final String a;
    final String b;

    private av(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    static av a(@Nullable String str, @Nullable String str2) {
        return new av(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        av avVar = (av) obj;
        if (this.a == null ? avVar.a != null : !this.a.equals(avVar.a)) {
            return false;
        }
        if (this.b != null) {
            return this.b.equals(avVar.b);
        }
        if (avVar.b != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        if (this.a != null) {
            hashCode = this.a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode + i;
    }
}
