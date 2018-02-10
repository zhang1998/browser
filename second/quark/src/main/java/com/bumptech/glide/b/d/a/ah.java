package com.bumptech.glide.b.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.b.b.a.g;
import com.uc.imagecodec.export.IPictureView;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ProGuard */
public final class ah {
    private static final Paint a = new Paint(6);
    private static final Paint b = new Paint(7);
    private static final Paint c;
    private static final List<String> d;
    private static final Lock e;

    static {
        List asList = Arrays.asList(new String[]{"XT1097", "XT1085"});
        d = asList;
        Lock reentrantLock = (asList.contains(Build.MODEL) && VERSION.SDK_INT == 22) ? new ReentrantLock() : new ag();
        e = reentrantLock;
        Paint paint = new Paint(7);
        c = paint;
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
    }

    public static Lock a() {
        return e;
    }

    public static Bitmap a(@NonNull g gVar, @NonNull Bitmap bitmap, int i, int i2) {
        float f = 0.0f;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        float height;
        float width;
        Matrix matrix = new Matrix();
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            height = ((float) i2) / ((float) bitmap.getHeight());
            width = (((float) i) - (((float) bitmap.getWidth()) * height)) * 0.5f;
        } else {
            height = ((float) i) / ((float) bitmap.getWidth());
            width = 0.0f;
            f = (((float) i2) - (((float) bitmap.getHeight()) * height)) * 0.5f;
        }
        matrix.setScale(height, height);
        matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (f + 0.5f)));
        Bitmap a = gVar.a(i, i2, a(bitmap));
        a(bitmap, a);
        a(bitmap, a, matrix);
        return a;
    }

    public static Bitmap b(@NonNull g gVar, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        int width = (int) (((float) bitmap.getWidth()) * min);
        int height = (int) (((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        Bitmap a = gVar.a(width, height, a(bitmap));
        a(bitmap, a);
        if (Log.isLoggable("TransformationUtils", 2)) {
            new StringBuilder("request: ").append(i).append("x").append(i2);
            new StringBuilder("toFit:   ").append(bitmap.getWidth()).append("x").append(bitmap.getHeight());
            new StringBuilder("toReuse: ").append(a.getWidth()).append("x").append(a.getHeight());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, a, matrix);
        return a;
    }

    public static Bitmap c(@NonNull g gVar, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            Log.isLoggable("TransformationUtils", 2);
            return b(gVar, bitmap, i, i2);
        }
        Log.isLoggable("TransformationUtils", 2);
        return bitmap;
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static int a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap a(@NonNull g gVar, @NonNull Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, IPictureView.DEFAULT_MIN_SCALE);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, IPictureView.DEFAULT_MIN_SCALE);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, IPictureView.DEFAULT_MIN_SCALE);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, IPictureView.DEFAULT_MIN_SCALE);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap a = gVar.a(Math.round(rectF.width()), Math.round(rectF.height()), a(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        a(bitmap, a, matrix);
        return a;
    }

    public static Bitmap d(@NonNull g gVar, @NonNull Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        int min = Math.min(i, i2);
        float f = ((float) min) / 2.0f;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float max = Math.max(((float) min) / ((float) width), ((float) min) / ((float) height));
        float f2 = ((float) width) * max;
        float f3 = ((float) height) * max;
        max = (((float) min) - f2) / 2.0f;
        float f4 = (((float) min) - f3) / 2.0f;
        RectF rectF = new RectF(max, f4, f2 + max, f3 + f4);
        if (Config.ARGB_8888.equals(bitmap.getConfig())) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = gVar.a(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
            new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, null);
        }
        Bitmap a = gVar.a(min, min, Config.ARGB_8888);
        a.setHasAlpha(true);
        e.lock();
        try {
            Canvas canvas = new Canvas(a);
            canvas.drawCircle(f, f, f, b);
            canvas.drawBitmap(bitmap2, null, rectF, c);
            canvas.setBitmap(null);
            if (!bitmap2.equals(bitmap)) {
                gVar.a(bitmap2);
            }
            return a;
        } finally {
            a = e;
            a.unlock();
        }
    }

    private static Config a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        e.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, a);
            canvas.setBitmap(null);
        } finally {
            e.unlock();
        }
    }
}
