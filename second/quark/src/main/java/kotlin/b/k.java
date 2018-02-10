package kotlin.b;

import kotlin.Metadata;
import kotlin.jvm.a.b;
import kotlin.jvm.a.f;
import kotlin.jvm.b.a;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, k = 3, mv = {1, 1, 6})
/* compiled from: ProGuard */
public final class k extends b implements a<kotlin.e.a, String> {
    final /* synthetic */ CharSequence a;

    public k(CharSequence charSequence) {
        this.a = charSequence;
        super(1);
    }

    public final /* synthetic */ Object a(Object obj) {
        kotlin.e.a aVar = (kotlin.e.a) obj;
        f.b(aVar, "it");
        CharSequence charSequence = this.a;
        f.b(charSequence, "$receiver");
        f.b(aVar, "range");
        return charSequence.subSequence(Integer.valueOf(aVar.b).intValue(), Integer.valueOf(aVar.c).intValue() + 1).toString();
    }
}
