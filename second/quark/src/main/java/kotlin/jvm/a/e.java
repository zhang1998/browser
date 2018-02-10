package kotlin.jvm.a;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class e {
    private static final Object[] a = new Object[0];

    public static <T, E> T[] a(Collection<E> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length >= size) {
            T[] tArr2 = tArr;
        } else {
            Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        }
        Iterator it = collection.iterator();
        int i = 0;
        while (i < tArr2.length) {
            if (it.hasNext()) {
                tArr2[i] = it.next();
                i++;
            } else if (tArr != tArr2) {
                return Arrays.copyOf(tArr2, i);
            } else {
                tArr2[i] = null;
                return tArr2;
            }
        }
        if (!it.hasNext()) {
            return tArr2;
        }
        T[] tArr3 = tArr2;
        size = tArr2.length;
        while (it.hasNext()) {
            T[] copyOf;
            int length = tArr3.length;
            if (size == length) {
                int i2 = ((length / 2) + 1) * 3;
                if (i2 <= length) {
                    if (length == Integer.MAX_VALUE) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    i2 = Integer.MAX_VALUE;
                }
                copyOf = Arrays.copyOf(tArr3, i2);
            } else {
                copyOf = tArr3;
            }
            i = size + 1;
            copyOf[size] = it.next();
            size = i;
            tArr3 = copyOf;
        }
        return size == tArr3.length ? tArr3 : Arrays.copyOf(tArr3, size);
    }
}
