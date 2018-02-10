package com.ucpro.feature.z.g.b;

import kotlin.Metadata;
import kotlin.jvm.a.f;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ucpro/feature/searchpage/data/searchengine/SearchEngine;", "", "id", "", "label", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLabel", "getUrl", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "browser_standardRelease"}, k = 1, mv = {1, 1, 6})
/* compiled from: ProGuard */
public final class i {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public String c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0026;
    L_0x0002:
        r0 = r3 instanceof com.ucpro.feature.z.g.b.i;
        if (r0 == 0) goto L_0x0028;
    L_0x0006:
        r3 = (com.ucpro.feature.z.g.b.i) r3;
        r0 = r2.a;
        r1 = r3.a;
        r0 = kotlin.jvm.a.f.a(r0, r1);
        if (r0 == 0) goto L_0x0028;
    L_0x0012:
        r0 = r2.b;
        r1 = r3.b;
        r0 = kotlin.jvm.a.f.a(r0, r1);
        if (r0 == 0) goto L_0x0028;
    L_0x001c:
        r0 = r2.c;
        r1 = r3.c;
        r0 = kotlin.jvm.a.f.a(r0, r1);
        if (r0 == 0) goto L_0x0028;
    L_0x0026:
        r0 = 1;
    L_0x0027:
        return r0;
    L_0x0028:
        r0 = 0;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.z.g.b.i.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = 0;
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        str = this.b;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final String toString() {
        return "SearchEngine(id=" + this.a + ", label=" + this.b + ", url=" + this.c + ")";
    }

    public i(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        f.b(str, "id");
        f.b(str2, "label");
        f.b(str3, "url");
        this.a = str;
        this.b = str2;
        this.c = str3;
    }
}
