package com.ucpro.feature.x;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.mini.support.annotation.Nullable;
import android.support.v7.graphics.f;
import android.support.v7.graphics.h;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.util.b;
import com.ucpro.c.c;
import com.ucpro.ui.c.a;
import com.ucpro.ui.d.g;
import com.ucpro.ui.d.i;
import com.ucweb.common.util.h.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public final class e {
    private static String a;
    private static String b;

    public static boolean a() {
        try {
            return new File(b()).exists();
        } catch (Exception e) {
            return false;
        }
    }

    public static String b() {
        if (a == null) {
            a = c.a("navigation") + "/wallpaper";
        }
        return a;
    }

    public static String c() {
        if (b == null) {
            b = c.d().getAbsolutePath() + "/share_wallpaper";
        }
        return b;
    }

    static boolean a(String str, Bitmap bitmap) {
        if (str == null || str.trim().length() == 0 || bitmap == null) {
            return false;
        }
        OutputStream fileOutputStream;
        File file = new File(str + "_tmp");
        if (file.exists()) {
            file.delete();
        }
        boolean z = true;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            z = false;
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            } catch (Throwable th2) {
                z = false;
            }
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                z = false;
            }
            try {
                fileOutputStream.close();
            } catch (Throwable th3) {
                z = false;
            }
        }
        if (z) {
            try {
                File file2 = new File(str);
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            } catch (Exception e2) {
                return false;
            }
        }
        return z;
    }

    @Nullable
    public static Bitmap a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmap2 = null;
        try {
            bitmap2 = b.a(720, 1280, Config.ARGB_8888);
            try {
                Drawable a;
                Paint paint = new Paint();
                paint.setFilterBitmap(true);
                paint.setDither(true);
                paint.setAntiAlias(true);
                Canvas canvas = new Canvas(bitmap2);
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                rect = new Rect();
                rect.set(0, 0, canvas.getWidth(), canvas.getHeight());
                com.ucpro.ui.d.c cVar = new com.ucpro.ui.d.c();
                cVar.a = g.f;
                cVar.b = 4.0f;
                cVar.c = 5.0f;
                cVar.d = 2;
                Bitmap a2 = i.a(bitmap, cVar);
                if (a2 != null) {
                    canvas.drawBitmap(a2, new Rect(0, 0, a2.getWidth(), a2.getHeight()), rect, paint);
                    a2.recycle();
                }
                canvas.drawColor(1275068416);
                float b = (320.0f / ((float) com.ucpro.base.system.b.a.b())) * 0.8f;
                int c = (int) (((float) a.c((int) R.dimen.homepage_baseline_offset_y)) * b);
                int c2 = (int) (((float) a.c((int) R.dimen.homepage_searchbar_height)) * b);
                int c3 = (int) (((float) a.c((int) R.dimen.homepage_logo_margin_bottom)) * b);
                int c4 = (int) (((float) a.c((int) R.dimen.homepage_searchbar_margin_baseline)) * b);
                int c5 = (int) (((float) a.c((int) R.dimen.homepage_searchbar_marginx)) * b);
                Rect rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                Rect rect3 = new Rect();
                int width = (int) (((float) canvas.getWidth()) * 0.8f);
                int height = (int) ((((float) bitmap.getHeight()) / ((float) bitmap.getWidth())) * ((float) width));
                int width2 = (int) (((float) canvas.getWidth()) * 0.1f);
                int c6 = (int) (b * ((float) a.c((int) R.dimen.quark_lab_wallpaper_share_margin_top)));
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
                com.ucpro.ui.widget.i iVar = new com.ucpro.ui.widget.i(a.c((int) R.dimen.multi_window_cardview2_corner_radius), -1);
                iVar.setBounds(width2, c6, width2 + width, c6 + height);
                iVar.draw(canvas);
                paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                rect3.set(width2, c6, width2 + width, c6 + height);
                canvas.drawBitmap(bitmap, rect2, rect3, paint);
                paint.setXfermode(null);
                canvas.restoreToCount(saveLayer);
                boolean a3 = a(a(bitmap));
                if (a3) {
                    a = a.a("searchpage_fake_input_frame_bg_dark.xml");
                } else {
                    a = a.a("searchpage_fake_input_frame_bg.xml");
                }
                int i = width - (c5 * 2);
                int i2 = ((width - i) / 2) + width2;
                int i3 = (((height / 2) + c) + c4) + c6;
                a.setBounds(i2, i3 - c2, i + i2, i3);
                a.draw(canvas);
                if (z) {
                    a = a.a("home_logo.svg");
                    if (a3) {
                        a.setColorFilter(-11184811, Mode.SRC_ATOP);
                    } else {
                        a.setColorFilter(-1, Mode.SRC_ATOP);
                    }
                    i = ((width - 320) / 2) + width2;
                    i3 = (i3 - c2) - c3;
                    a.setBounds(i, i3 - 100, i + 320, i3);
                    a.draw(canvas);
                }
                a = a.a("wallpaper_fake_toolbar.svg");
                if (a3) {
                    a.setColorFilter(-11184811, Mode.SRC_ATOP);
                } else {
                    a.setColorFilter(-1, Mode.SRC_ATOP);
                }
                i3 = c6 + height;
                a.setBounds(width2, i3 - ((int) ((((float) width) / ((float) a.getIntrinsicWidth())) * ((float) a.getIntrinsicHeight()))), width2 + width, i3);
                a.draw(canvas);
                if (a3) {
                    a = a.a("wallpaper_share_qrcode.png");
                } else {
                    a = a.a("wallpaper_share_qrcode_white.png");
                }
                int width3 = (canvas.getWidth() - 506) / 2;
                i = (((((canvas.getHeight() - height) - c6) - 88) / 2) + height) + c6;
                a.setBounds(width3, i, width3 + 506, i + 88);
                a.draw(canvas);
                return bitmap2;
            } catch (Exception e) {
                return bitmap2;
            }
        } catch (Exception e2) {
            return bitmap2;
        }
    }

    public static int a(Bitmap bitmap) {
        Bitmap a;
        Bitmap bitmap2;
        android.support.v7.graphics.c[] cVarArr = null;
        int i = -16777216;
        if (b(bitmap)) {
            a = b.a(56, 100, Config.RGB_565);
            if (a != null) {
                new Canvas(a).drawBitmap(bitmap, new Rect(0, (int) (((float) bitmap.getHeight()) * 0.9f), bitmap.getWidth(), bitmap.getHeight()), new RectF(0.0f, 0.0f, (float) a.getWidth(), (float) a.getHeight()), new Paint());
            }
            bitmap2 = a;
        } else {
            bitmap2 = null;
        }
        if (b(bitmap2)) {
            List list;
            h hVar = new h(bitmap2);
            hVar.d = 1;
            if (hVar.b != null) {
                Bitmap bitmap3;
                a = hVar.b;
                double d = -1.0d;
                int width;
                if (hVar.e > 0) {
                    width = a.getWidth() * a.getHeight();
                    if (width > hVar.e) {
                        d = ((double) hVar.e) / ((double) width);
                    }
                } else if (hVar.f > 0) {
                    width = Math.max(a.getWidth(), a.getHeight());
                    if (width > hVar.f) {
                        d = ((double) hVar.f) / ((double) width);
                    }
                }
                if (d <= 0.0d) {
                    bitmap3 = a;
                } else {
                    bitmap3 = Bitmap.createScaledBitmap(a, (int) Math.ceil(((double) a.getWidth()) * d), (int) Math.ceil(d * ((double) a.getHeight())), false);
                }
                Rect rect = hVar.h;
                if (!(bitmap3 == hVar.b || rect == null)) {
                    d = ((double) bitmap3.getWidth()) / ((double) hVar.b.getWidth());
                    rect.left = (int) Math.floor(((double) rect.left) * d);
                    rect.top = (int) Math.floor(((double) rect.top) * d);
                    rect.right = Math.min((int) Math.ceil(((double) rect.right) * d), bitmap3.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(d * ((double) rect.bottom)), bitmap3.getHeight());
                }
                int[] a2 = hVar.a(bitmap3);
                int i2 = hVar.d;
                if (!hVar.g.isEmpty()) {
                    cVarArr = (android.support.v7.graphics.c[]) hVar.g.toArray(new android.support.v7.graphics.c[hVar.g.size()]);
                }
                f fVar = new f(a2, i2, cVarArr);
                if (bitmap3 != hVar.b) {
                    bitmap3.recycle();
                }
                list = fVar.c;
            } else {
                list = hVar.a;
            }
            android.support.v7.graphics.i iVar = new android.support.v7.graphics.i(list, hVar.c);
            android.support.v7.graphics.i.a(iVar);
            list = Collections.unmodifiableList(iVar.a);
            if (list == null || list.size() <= 0) {
                i = bitmap2.getPixel(bitmap2.getWidth() / 2, 0);
            } else {
                int i3;
                android.support.v7.graphics.b bVar = (android.support.v7.graphics.b) list.get(0);
                if (bVar != null) {
                    i3 = bVar.a;
                } else {
                    i3 = -16777216;
                }
                i = i3;
            }
            if (!(bitmap2 == null || bitmap2.isRecycled())) {
                bitmap2.recycle();
            }
        }
        return i;
    }

    private static boolean b(Bitmap bitmap) {
        return bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0;
    }

    public static boolean a(int i) {
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float f = fArr[1];
        float f2 = fArr[2];
        if (f2 == IPictureView.DEFAULT_MIN_SCALE) {
            return true;
        }
        if (f > 0.5f || f2 < 0.77f) {
            return false;
        }
        return true;
    }

    public static void b(Bitmap bitmap, boolean z) {
        com.ucpro.ui.b.e.a().a(a.d((int) R.string.quark_lab_wallpaper_share_toast), 0);
        m.a(0, new f(bitmap, z));
    }
}
