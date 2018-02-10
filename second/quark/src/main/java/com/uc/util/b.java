package com.uc.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import com.uc.framework.resources.d;
import com.uc.imagecodec.export.IPictureView;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class b {
    private static boolean a = false;
    private static Field b;
    private static boolean c = false;
    private static final Canvas d = new Canvas();
    private static final Paint e = new Paint();
    private static final Rect f = new Rect();
    private static final Rect g = new Rect();
    private static Bitmap h;
    private static Method i;
    private static Field j;
    private static Class k;
    private static Object[] l = new Object[3];
    private static boolean m;
    private static boolean n;

    static {
        try {
            e.setFilterBitmap(true);
            e.setAntiAlias(true);
            h = Bitmap.createBitmap(2, 2, Config.RGB_565);
            k = Class.forName("android.graphics.BitmapFactory");
            try {
                Method declaredMethod = k.getDeclaredMethod("nativeScaleNinePatch", new Class[]{byte[].class, Float.TYPE, Rect.class});
                i = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable th) {
            }
            Field declaredField = Bitmap.class.getDeclaredField("mNinePatchChunk");
            j = declaredField;
            declaredField.setAccessible(true);
            n = true;
        } catch (Throwable th2) {
            n = false;
        }
    }

    public static void a() {
        a = true;
    }

    public static Bitmap a(int i, int i2, Config config) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        try {
            if (a) {
                return Bitmap.createBitmap(i, i2, config);
            }
            boolean z = VERSION.SDK_INT >= 23 || (VERSION.SDK_INT == 22 && ("MNC".equals(VERSION.CODENAME) || "M".equals(VERSION.RELEASE)));
            return BitmapEx.a(i, i2, config, z);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return a(bitmap, bitmap.getWidth(), bitmap.getHeight());
    }

    private static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap;
        if (i > 0 && i2 > 0) {
            try {
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, i, i2, null, false);
            } catch (Throwable th) {
            }
            return createBitmap;
        }
        createBitmap = null;
        return createBitmap;
    }

    public static Bitmap a(byte[] bArr) {
        Bitmap bitmap = null;
        if (!(bArr == null || bArr.length == 0)) {
            try {
                bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            } catch (Throwable th) {
            }
        }
        return bitmap;
    }

    private static boolean a(Options options) {
        boolean z = true;
        if (options == null) {
            return false;
        }
        if (!c && b == null) {
            try {
                b = Options.class.getField("inNativeAlloc");
            } catch (SecurityException e) {
            } catch (NoSuchFieldException e2) {
            }
            c = true;
        }
        if (b != null) {
            try {
                b.setBoolean(options, true);
            } catch (IllegalArgumentException e3) {
                z = false;
            } catch (IllegalAccessException e4) {
            }
            return z;
        }
        z = false;
        return z;
    }

    public static void b() {
        m = true;
    }

    private static synchronized Bitmap a(Bitmap bitmap, int i, Rect rect, float f) {
        Bitmap bitmap2;
        synchronized (b.class) {
            if (bitmap != null) {
                if (n) {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    int i2 = (int) ((((float) width) * f) + 0.5f);
                    int i3 = (int) ((((float) height) * f) + 0.5f);
                    if (width <= 0 || height <= 0 || i2 <= 0 || i3 <= 0) {
                        bitmap2 = null;
                    } else {
                        try {
                            bitmap2 = a(i2, i3, Config.ARGB_8888);
                            if (bitmap2 == null) {
                                bitmap2 = null;
                            } else {
                                try {
                                    d.setBitmap(bitmap2);
                                    f.set(0, 0, width, height);
                                    g.set(0, 0, i2, i3);
                                    d.drawBitmap(bitmap, f, g, e);
                                    d.setBitmap(h);
                                    bitmap2.setDensity(i);
                                    Object ninePatchChunk = bitmap.getNinePatchChunk();
                                    if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                                        if (i != null) {
                                            l[0] = ninePatchChunk;
                                            l[1] = Float.valueOf(f);
                                            l[2] = rect;
                                            i.invoke(k, l);
                                        } else {
                                            BitmapEx.nativeScaleNinePatch(ninePatchChunk, f, rect);
                                        }
                                        j.set(bitmap2, ninePatchChunk);
                                    }
                                } catch (Throwable th) {
                                }
                            }
                        } catch (Throwable th2) {
                            bitmap2 = null;
                        }
                    }
                }
            }
            bitmap2 = null;
        }
        return bitmap2;
    }

    private static Bitmap a(Resources resources, InputStream inputStream, a aVar, int i, Rect rect, float f, float f2) {
        boolean z = true;
        float f3 = IPictureView.DEFAULT_MIN_SCALE;
        if (inputStream == null) {
            return null;
        }
        Options options;
        if (!(m && n)) {
            aVar.c = false;
        }
        if (aVar.e != null) {
            options = aVar.e;
        } else {
            options = new Options();
        }
        int i2 = resources.getDisplayMetrics().densityDpi;
        Bitmap decodeStream;
        if (aVar.c) {
            if (options != null) {
                boolean z2;
                int i3 = VERSION.SDK_INT;
                if (i3 < 7 || i3 > 9) {
                    z2 = false;
                } else {
                    z2 = a(options);
                }
                if (!(z2 || options == null)) {
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                }
            }
            try {
                if (aVar.a && aVar.b) {
                    decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
                } else if (aVar.a) {
                    if (VERSION.SDK_INT >= 19 && options != null) {
                        options.inPurgeable = false;
                        options.inInputShareable = false;
                    }
                    decodeStream = BitmapFactory.decodeFileDescriptor(((FileInputStream) inputStream).getFD(), rect, options);
                } else {
                    decodeStream = null;
                }
                float width = (f <= 0.0f || f2 <= 0.0f) ? IPictureView.DEFAULT_MIN_SCALE : f / ((float) decodeStream.getWidth());
                if (Math.abs(width - IPictureView.DEFAULT_MIN_SCALE) <= 1.0E-5f) {
                    z = false;
                }
                if (i <= 0 || i != i2 || r5) {
                    if (decodeStream != null) {
                        int i4 = i <= 0 ? 240 : i;
                        if (i2 != i4 || r5) {
                            float f4;
                            Bitmap a;
                            if (aVar.d) {
                                f4 = (((float) i2) / ((float) i4)) * width;
                            } else {
                                f4 = width;
                            }
                            if (i > 0) {
                                width = (((float) i2) / ((float) i)) * width;
                            } else {
                                width = f4;
                            }
                            if (Math.abs(width - IPictureView.DEFAULT_MIN_SCALE) > 1.0E-5f) {
                                if (resources != null) {
                                    i4 = resources.getDisplayMetrics().densityDpi;
                                } else {
                                    i4 = 240;
                                }
                                a = a(decodeStream, i4, rect, width);
                            } else {
                                a = decodeStream;
                            }
                            if (!(a == null || a == decodeStream)) {
                                decodeStream.recycle();
                                decodeStream = a;
                            }
                        }
                    } else {
                        decodeStream = null;
                    }
                }
            } catch (Throwable th) {
                decodeStream = null;
            }
            if (decodeStream != null) {
                decodeStream.setDensity(i2);
            }
            if (inputStream == null) {
                return decodeStream;
            }
            try {
                inputStream.close();
                return decodeStream;
            } catch (Exception e) {
                return decodeStream;
            }
        }
        InputStream inputStream2;
        if (f <= 0.0f || f2 <= 0.0f) {
            inputStream2 = null;
        } else {
            InputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                bufferedInputStream.mark(inputStream.available() + 1);
            } catch (IOException e2) {
            }
            Options options2 = new Options();
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(bufferedInputStream, rect, options2);
            if (options2.outWidth > 0 && options2.outHeight > 0) {
                f3 = ((float) options2.outWidth) / f;
            }
            try {
                bufferedInputStream.reset();
                inputStream2 = bufferedInputStream;
            } catch (IOException e3) {
                inputStream2 = bufferedInputStream;
            }
        }
        if (i > 0) {
            options.inDensity = i;
        } else if (aVar.d) {
            options.inDensity = 240;
        } else {
            options.inDensity = i2;
        }
        options.inDensity = (int) (((float) options.inDensity) * f3);
        options.inTargetDensity = i2;
        if (inputStream2 != null) {
            inputStream = inputStream2;
        }
        decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
        if (decodeStream != null) {
            decodeStream.setDensity(i2);
        }
        if (inputStream == null) {
            return decodeStream;
        }
        try {
            inputStream.close();
            return decodeStream;
        } catch (Exception e4) {
            return decodeStream;
        }
    }

    public static Bitmap a(Resources resources, int i, String str, Rect rect, float f, float f2, boolean z, boolean z2) {
        if (str == null || resources == null) {
            return null;
        }
        d dVar = new d(str);
        InputStream a = dVar.a();
        if (a == null) {
            return null;
        }
        a aVar = new a();
        boolean z3 = dVar.a == 4097 || dVar.a == 4099;
        aVar.b = z3;
        aVar.d = z;
        if (z2 || a) {
            aVar.c = false;
        }
        return a(resources, a, aVar, i, rect, f, f2);
    }

    public static Bitmap a(Resources resources, String str, boolean z) {
        return a(resources, 0, str, null, 0.0f, 0.0f, z, false);
    }

    public static Bitmap a(Resources resources, String str) {
        return a(resources, str, true);
    }

    public static Drawable a(Resources resources, Bitmap bitmap, Rect rect, String str) {
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (ninePatchChunk != null) {
            return new NinePatchDrawable(resources, bitmap, ninePatchChunk, rect, str);
        }
        return new BitmapDrawable(resources, bitmap);
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap a = a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        if (a != null) {
            Canvas canvas = new Canvas(a);
            drawable.draw(canvas);
            canvas.setBitmap(null);
        }
        return a;
    }
}
