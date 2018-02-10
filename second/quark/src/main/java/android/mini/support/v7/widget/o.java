package android.mini.support.v7.widget;

/* compiled from: ProGuard */
final class o {
    public bf a;
    public bf b;
    public int c;
    public int d;
    public int e;
    public int f;

    private o(bf bfVar, bf bfVar2) {
        this.a = bfVar;
        this.b = bfVar2;
    }

    private o(bf bfVar, bf bfVar2, int i, int i2, int i3, int i4) {
        this(bfVar, bfVar2);
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public final String toString() {
        return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }
}
