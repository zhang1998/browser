package kotlin.a;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.a.b;
import kotlin.jvm.b.c;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 1, 6})
/* compiled from: ProGuard */
public final class g extends b implements c<Iterator<? extends T>> {
    final /* synthetic */ Iterable a;

    public g(Iterable iterable) {
        this.a = iterable;
        super(0);
    }

    public final /* synthetic */ Object a() {
        return this.a.iterator();
    }
}
