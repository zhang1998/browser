package com.ucpro.feature.setting.d;

/* compiled from: ProGuard */
public final class b {
    long a;

    public b(long j) {
        new StringBuilder("WipeCacheManager init with: ").append(Long.toBinaryString(j));
        this.a = j;
    }

    public final void a(int i, boolean z) {
        new StringBuilder("before setFlag: ").append(Long.toBinaryString(this.a)).append("\nkey: ").append(String.valueOf(1 << i)).append("\ncurrentValue: ").append(String.valueOf(a(i))).append("\nsetValue: ").append(String.valueOf(z));
        if (z) {
            this.a |= 1 << i;
        } else {
            this.a &= (1 << i) ^ -1;
        }
        new StringBuilder("after setFlag: ").append(Long.toBinaryString(this.a));
    }

    public final boolean a(int i) {
        new StringBuilder("getFlagValue: ").append(Long.toBinaryString(this.a)).append("\nkey: ").append(String.valueOf(1 << i));
        return (1 << i) == (this.a & (1 << i));
    }
}
