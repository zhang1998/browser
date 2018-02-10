package com.ucpro.feature.webwindow.f;

/* compiled from: ProGuard */
public final class h implements Comparable {
    public int a;
    public String b;
    final /* synthetic */ c c;

    public h(c cVar, int i, String str) {
        this.c = cVar;
        this.a = i;
        this.b = str;
    }

    public final int compareTo(Object obj) {
        if (this.a > ((h) obj).a) {
            return -1;
        }
        if (this.a < ((h) obj).a) {
            return 1;
        }
        return 0;
    }
}
