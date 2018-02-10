package android.support.v7.widget;

/* compiled from: ProGuard */
final class al {
    public bh a;
    public bh b;
    public int c;
    public int d;
    public int e;
    public int f;

    private al(bh bhVar, bh bhVar2) {
        this.a = bhVar;
        this.b = bhVar2;
    }

    private al(bh bhVar, bh bhVar2, int i, int i2, int i3, int i4) {
        this(bhVar, bhVar2);
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public final String toString() {
        return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }
}
