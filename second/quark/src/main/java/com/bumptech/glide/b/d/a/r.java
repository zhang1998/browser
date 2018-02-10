package com.bumptech.glide.b.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.b.b;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.f;
import com.bumptech.glide.b.h;
import com.bumptech.glide.b.l;
import com.bumptech.glide.b.m;
import com.bumptech.glide.util.j;
import com.uc.imagecodec.export.IPictureView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: ProGuard */
public final class r {
    public static final l<b> a = l.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.c);
    public static final l<z> b = l.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", z.c);
    public static final l<Boolean> c = l.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.valueOf(false));
    static final q d = new p();
    private static final Set<String> e = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
    private static final Set<f> f = Collections.unmodifiableSet(EnumSet.of(f.JPEG, f.PNG_A, f.PNG));
    private static final Queue<Options> g = com.bumptech.glide.util.l.a(0);
    private final g h;
    private final DisplayMetrics i;
    private final com.bumptech.glide.b.b.a.b j;
    private final List<com.bumptech.glide.b.g> k;

    public r(List<com.bumptech.glide.b.g> list, DisplayMetrics displayMetrics, g gVar, com.bumptech.glide.b.b.a.b bVar) {
        this.k = list;
        this.i = (DisplayMetrics) j.a((Object) displayMetrics, "Argument must not be null");
        this.h = (g) j.a((Object) gVar, "Argument must not be null");
        this.j = (com.bumptech.glide.b.b.a.b) j.a((Object) bVar, "Argument must not be null");
    }

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return true;
    }

    public final au<Bitmap> a(InputStream inputStream, int i, int i2, m mVar, q qVar) throws IOException {
        j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        Object obj = (byte[]) this.j.a(65536, byte[].class);
        Options c = c();
        c.inTempStorage = obj;
        b bVar = (b) mVar.a(a);
        z zVar = (z) mVar.a(b);
        boolean booleanValue = ((Boolean) mVar.a(c)).booleanValue();
        try {
            int i3;
            int i4;
            g gVar = this.h;
            c.inJustDecodeBounds = true;
            a(inputStream, c, qVar, gVar);
            c.inJustDecodeBounds = false;
            int[] iArr = new int[]{c.outWidth, c.outHeight};
            int i5 = iArr[0];
            int i6 = iArr[1];
            String str = c.outMimeType;
            int b = h.b(this.k, inputStream, this.j);
            int a = ah.a(b);
            c.inPreferredConfig = a(inputStream, bVar);
            if (c.inPreferredConfig != Config.ARGB_8888) {
                c.inDither = true;
            }
            int i7 = i == Integer.MIN_VALUE ? i5 : i;
            if (i2 == Integer.MIN_VALUE) {
                i3 = i6;
            } else {
                i3 = i2;
            }
            if (i5 > 0 && i6 > 0) {
                float a2;
                if (a == 90 || a == 270) {
                    a2 = zVar.a(i6, i5, i7, i3);
                } else {
                    a2 = zVar.a(i5, i6, i7, i3);
                }
                if (a2 <= 0.0f) {
                    throw new IllegalArgumentException("Cannot scale with factor: " + a2 + " from: " + zVar);
                }
                int a3 = zVar.a();
                if (a3 == 0) {
                    throw new IllegalArgumentException("Cannot round with null rounding");
                }
                i4 = i5 / ((int) ((((float) i5) * a2) + 0.5f));
                int i8 = i6 / ((int) ((((float) i6) * a2) + 0.5f));
                if (a3 == y.a) {
                    i4 = Math.max(i4, i8);
                } else {
                    i4 = Math.min(i4, i8);
                }
                if (VERSION.SDK_INT > 23 || !e.contains(c.outMimeType)) {
                    i4 = Math.max(1, Integer.highestOneBit(i4));
                    if (a3 == y.a && ((float) i4) < IPictureView.DEFAULT_MIN_SCALE / a2) {
                        i4 <<= 1;
                    }
                } else {
                    i4 = 1;
                }
                float f = ((float) i4) * a2;
                c.inSampleSize = i4;
                if (VERSION.SDK_INT >= 19) {
                    c.inTargetDensity = (int) ((1000.0f * f) + 0.5f);
                    c.inDensity = 1000;
                }
                if (a(c)) {
                    c.inScaled = true;
                } else {
                    c.inTargetDensity = 0;
                    c.inDensity = 0;
                }
                if (Log.isLoggable("Downsampler", 2)) {
                    new StringBuilder("Calculate scaling, source: [").append(i5).append("x").append(i6).append("], target: [").append(i7).append("x").append(i3).append("], exact scale factor: ").append(a2).append(", power of 2 sample size: ").append(i4).append(", adjusted scale factor: ").append(f).append(", target density: ").append(c.inTargetDensity).append(", density: ").append(c.inDensity);
                }
            }
            Object obj2 = VERSION.SDK_INT >= 19 ? 1 : null;
            if ((c.inSampleSize == 1 || obj2 != null) && a(inputStream)) {
                if (!booleanValue || obj2 == null) {
                    float f2 = a(c) ? ((float) c.inTargetDensity) / ((float) c.inDensity) : IPictureView.DEFAULT_MIN_SCALE;
                    a = c.inSampleSize;
                    int ceil = (int) Math.ceil((double) (((float) i6) / ((float) a)));
                    i4 = Math.round(((float) ((int) Math.ceil((double) (((float) i5) / ((float) a))))) * f2);
                    i3 = Math.round(((float) ceil) * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        new StringBuilder("Calculated target [").append(i4).append("x").append(i3).append("] for source [").append(i5).append("x").append(i6).append("], sampleSize: ").append(a).append(", targetDensity: ").append(c.inTargetDensity).append(", density: ").append(c.inDensity).append(", density multiplier: ").append(f2);
                    }
                } else {
                    i4 = i7;
                }
                if (i4 > 0 && i3 > 0) {
                    c.inBitmap = this.h.b(i4, i3, c.inPreferredConfig);
                }
            }
            Bitmap a4 = a(inputStream, c, qVar, this.h);
            qVar.a(this.h, a4);
            if (Log.isLoggable("Downsampler", 2)) {
                new StringBuilder("Decoded ").append(a(a4)).append(" from [").append(i5).append("x").append(i6).append("] ").append(str).append(" with inBitmap ").append(a(c.inBitmap)).append(" for [").append(i).append("x").append(i2).append("], sample size: ").append(c.inSampleSize).append(", density: ").append(c.inDensity).append(", target density: ").append(c.inTargetDensity).append(", thread: ").append(Thread.currentThread().getName());
            }
            Bitmap bitmap = null;
            if (a4 != null) {
                a4.setDensity(this.i.densityDpi);
                bitmap = ah.a(this.h, a4, b);
                if (!a4.equals(bitmap)) {
                    this.h.a(a4);
                }
            }
            au<Bitmap> a5 = e.a(bitmap, this.h);
            return a5;
        } finally {
            b(c);
            this.j.a(obj, byte[].class);
        }
    }

    private boolean a(InputStream inputStream) throws IOException {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        try {
            return f.contains(h.a(this.k, inputStream, this.j));
        } catch (IOException e) {
            Log.isLoggable("Downsampler", 3);
            return false;
        }
    }

    private Config a(InputStream inputStream, b bVar) throws IOException {
        if (bVar == b.PREFER_ARGB_8888 || VERSION.SDK_INT == 16) {
            return Config.ARGB_8888;
        }
        boolean z = false;
        try {
            z = h.a(this.k, inputStream, this.j).i;
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                new StringBuilder("Cannot determine whether the image has alpha or not from header, format ").append(bVar);
            }
        }
        if (z) {
            return Config.ARGB_8888;
        }
        return Config.RGB_565;
    }

    private static Bitmap a(InputStream inputStream, Options options, q qVar, g gVar) throws IOException {
        Bitmap decodeStream;
        IOException iOException;
        if (options.inJustDecodeBounds) {
            inputStream.mark(5242880);
        } else {
            qVar.a();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        ah.a().lock();
        try {
            decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            ah.a().unlock();
            if (options.inJustDecodeBounds) {
                inputStream.reset();
            }
        } catch (IOException e) {
            throw iOException;
        } catch (Throwable e2) {
            iOException = new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + a(options.inBitmap), e2);
            Log.isLoggable("Downsampler", 3);
            if (options.inBitmap != null) {
                inputStream.reset();
                gVar.a(options.inBitmap);
                options.inBitmap = null;
                decodeStream = a(inputStream, options, qVar, gVar);
                ah.a().unlock();
            } else {
                throw iOException;
            }
        } catch (Throwable th) {
            ah.a().unlock();
        }
        return decodeStream;
    }

    private static boolean a(Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    @Nullable
    @TargetApi(19)
    private static String a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (VERSION.SDK_INT >= 19 ? " (" + bitmap.getAllocationByteCount() + ")" : "");
    }

    private static synchronized Options c() {
        Options options;
        synchronized (r.class) {
            synchronized (g) {
                options = (Options) g.poll();
            }
            if (options == null) {
                options = new Options();
                c(options);
            }
        }
        return options;
    }

    private static void b(Options options) {
        c(options);
        synchronized (g) {
            g.offer(options);
        }
    }

    private static void c(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
