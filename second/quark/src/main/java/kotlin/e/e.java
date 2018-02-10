package kotlin.e;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-runtime"}, k = 1, mv = {1, 1, 6})
/* compiled from: ProGuard */
public class e implements Iterable<Integer> {
    public static final d e = new d();
    public final int b;
    public final int c;
    public final int d = 1;

    public e(int i, int i2, int i3) {
        this.b = i;
        this.c = i2 - a.a(a.a(i2, 1) - a.a(i, 1), 1);
    }

    public boolean a() {
        return this.d > 0 ? this.b > this.c : this.b < this.c;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof e) && ((a() && ((e) obj).a()) || (this.b == ((e) obj).b && this.c == ((e) obj).c && this.d == ((e) obj).d));
    }

    public int hashCode() {
        return a() ? -1 : (((this.b * 31) + this.c) * 31) + this.d;
    }

    @NotNull
    public String toString() {
        return this.d > 0 ? this.b + ".." + this.c + " step " + this.d : this.b + " downTo " + this.c + " step " + (-this.d);
    }

    public /* synthetic */ Iterator iterator() {
        return new c(this.b, this.c, this.d);
    }
}
