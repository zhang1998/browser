package kotlin.a;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.a.e;
import kotlin.jvm.a.f;
import kotlin.jvm.a.k;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0002J\u0015\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0004¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lkotlin/collections/ArrayAsCollection;", "T", "", "values", "", "isVarargs", "", "([Ljava/lang/Object;Z)V", "()Z", "size", "", "getSize", "()I", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 6})
/* compiled from: ProGuard */
final class n<T> implements Collection<T> {
    @NotNull
    private final T[] a;
    private final boolean b = true;

    public final boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final <T> T[] toArray(T[] tArr) {
        return e.a(this, tArr);
    }

    public n(@NotNull T[] tArr) {
        f.b(tArr, "values");
        this.a = tArr;
    }

    public final boolean isEmpty() {
        return this.a.length == 0;
    }

    public final boolean contains(Object obj) {
        Object obj2 = this.a;
        f.b(obj2, "$receiver");
        f.b(obj2, "$receiver");
        int length;
        int i;
        if (obj != null) {
            length = obj2.length - 1;
            if (length >= 0) {
                i = 0;
                while (!f.a(obj, obj2[i])) {
                    if (i != length) {
                        i++;
                    }
                }
            }
            i = -1;
            break;
        }
        length = obj2.length - 1;
        if (length >= 0) {
            i = 0;
            while (obj2[i] != null) {
                if (i != length) {
                    i++;
                }
            }
        }
        i = -1;
        break;
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsAll(@NotNull Collection<? extends Object> collection) {
        f.b(collection, "elements");
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final Iterator<T> iterator() {
        Object obj = this.a;
        f.b(obj, "array");
        return new k(obj);
    }

    @NotNull
    public final Object[] toArray() {
        Object[] objArr = this.a;
        if (!this.b || !f.a(objArr.getClass(), (Object) Object[].class)) {
            Object copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
            f.a(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
            return copyOf;
        } else if (objArr != null) {
            return objArr;
        } else {
            throw new kotlin.f("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
    }

    public final /* bridge */ int size() {
        return this.a.length;
    }
}
