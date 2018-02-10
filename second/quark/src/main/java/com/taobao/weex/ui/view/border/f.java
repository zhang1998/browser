package com.taobao.weex.ui.view.border;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.util.SparseArray;
import android.util.SparseIntArray;

/* compiled from: ProGuard */
final class f {
    static <T> T a(@Nullable SparseArray<T> sparseArray, int i, T t) {
        if (sparseArray == null) {
            return t;
        }
        return sparseArray.get(i, sparseArray.get(8));
    }

    static int a(@Nullable SparseIntArray sparseIntArray, int i, int i2) {
        if (sparseIntArray == null) {
            return i2;
        }
        return sparseIntArray.get(i, sparseIntArray.get(8));
    }

    static void b(@NonNull SparseIntArray sparseIntArray, int i, int i2) {
        if (i == 8) {
            sparseIntArray.put(8, i2);
            sparseIntArray.put(1, i2);
            sparseIntArray.put(0, i2);
            sparseIntArray.put(2, i2);
            sparseIntArray.put(3, i2);
            return;
        }
        sparseIntArray.put(i, i2);
    }

    static <T> void a(@NonNull SparseArray<T> sparseArray, int i, T t, boolean z) {
        if (z) {
            if (i == 8) {
                sparseArray.put(8, t);
                sparseArray.put(0, t);
                sparseArray.put(1, t);
                sparseArray.put(3, t);
                sparseArray.put(2, t);
                return;
            }
            sparseArray.put(i, t);
        } else if (i == 8) {
            sparseArray.put(8, t);
            sparseArray.put(1, t);
            sparseArray.put(0, t);
            sparseArray.put(2, t);
            sparseArray.put(3, t);
        } else {
            sparseArray.put(i, t);
        }
    }
}
