package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: ProGuard */
public final class l {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];

    public static String a(byte[] bArr) {
        String str;
        synchronized (b) {
            char[] cArr = b;
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                cArr[i * 2] = a[i2 >>> 4];
                cArr[(i * 2) + 1] = a[i2 & 15];
            }
            str = new String(cArr);
        }
        return str;
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
        if (VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int a(int i, int i2, Config config) {
        int i3;
        int i4 = i * i2;
        if (config == null) {
            config = Config.ARGB_8888;
        }
        switch (k.a[config.ordinal()]) {
            case 1:
                i3 = 1;
                break;
            case 2:
            case 3:
                i3 = 2;
                break;
            default:
                i3 = 4;
                break;
        }
        return i3 * i4;
    }

    public static boolean a(int i, int i2) {
        return b(i) && b(i2);
    }

    private static boolean b(int i) {
        return i > 0 || i == SectionHeader.SHT_LOUSER;
    }

    public static void a() {
        if (!c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void b() {
        if (!d()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean d() {
        return !c();
    }

    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static <T> List<T> a(Collection<T> collection) {
        List<T> arrayList = new ArrayList(collection.size());
        for (T add : collection) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }
}
