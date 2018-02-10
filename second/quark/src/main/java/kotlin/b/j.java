package kotlin.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.e.a;
import kotlin.f;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000'\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\t\u0010\u001a\u001a\u00020\u001bH\u0002J\t\u0010\u001c\u001a\u00020\u0002H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\t¨\u0006\u001d"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "(Lkotlin/text/DelimitedRangesSequence;)V", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 1, 6})
/* compiled from: ProGuard */
public final class j implements Iterator<a> {
    final /* synthetic */ d a;
    private int b = -1;
    private int c;
    private int d;
    @Nullable
    private a e;
    private int f;

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    j(d dVar) {
        this.a = dVar;
        int i = dVar.b;
        int length = dVar.a.length();
        if (length < 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }
        if (i < 0) {
            i = 0;
        } else if (i > length) {
            i = length;
        }
        this.c = i;
        this.d = this.c;
    }

    public final /* synthetic */ Object next() {
        if (this.b == -1) {
            a();
        }
        if (this.b == 0) {
            throw new NoSuchElementException();
        }
        a aVar = this.e;
        if (aVar == null) {
            throw new f("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        this.e = null;
        this.b = -1;
        return aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
        r7 = this;
        r2 = 1;
        r3 = 0;
        r5 = -1;
        r0 = r7.d;
        if (r0 >= 0) goto L_0x000d;
    L_0x0007:
        r7.b = r3;
        r0 = 0;
        r7.e = r0;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r7.a;
        r0 = r0.c;
        if (r0 <= 0) goto L_0x0021;
    L_0x0013:
        r0 = r7.f;
        r0 = r0 + 1;
        r7.f = r0;
        r0 = r7.f;
        r1 = r7.a;
        r1 = r1.c;
        if (r0 >= r1) goto L_0x002d;
    L_0x0021:
        r0 = r7.d;
        r1 = r7.a;
        r1 = r1.a;
        r1 = r1.length();
        if (r0 <= r1) goto L_0x0043;
    L_0x002d:
        r0 = r7.c;
        r1 = new kotlin.e.a;
        r3 = r7.a;
        r3 = r3.a;
        r3 = kotlin.b.a.a(r3);
        r1.<init>(r0, r3);
        r7.e = r1;
        r7.d = r5;
    L_0x0040:
        r7.b = r2;
        goto L_0x000c;
    L_0x0043:
        r0 = r7.a;
        r0 = r0.d;
        r1 = r7.a;
        r1 = r1.a;
        r4 = r7.d;
        r4 = java.lang.Integer.valueOf(r4);
        r0 = r0.a(r1, r4);
        r0 = (kotlin.b) r0;
        if (r0 != 0) goto L_0x006d;
    L_0x0059:
        r0 = r7.c;
        r1 = new kotlin.e.a;
        r3 = r7.a;
        r3 = r3.a;
        r3 = kotlin.b.a.a(r3);
        r1.<init>(r0, r3);
        r7.e = r1;
        r7.d = r5;
        goto L_0x0040;
    L_0x006d:
        r1 = r0.a;
        r1 = (java.lang.Number) r1;
        r1 = r1.intValue();
        r0 = r0.b;
        r0 = (java.lang.Number) r0;
        r0 = r0.intValue();
        r4 = r7.c;
        r5 = new kotlin.e.a;
        r6 = r1 + -1;
        r5.<init>(r4, r6);
        r7.e = r5;
        r1 = r1 + r0;
        r7.c = r1;
        r1 = r7.c;
        if (r0 != 0) goto L_0x0094;
    L_0x008f:
        r0 = r2;
    L_0x0090:
        r0 = r0 + r1;
        r7.d = r0;
        goto L_0x0040;
    L_0x0094:
        r0 = r3;
        goto L_0x0090;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.b.j.a():void");
    }

    public final boolean hasNext() {
        if (this.b == -1) {
            a();
        }
        if (this.b == 1) {
            return true;
        }
        return false;
    }
}
