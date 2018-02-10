package com.ucpro.feature.navigation.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.c.c;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.i.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class b implements n {
    public m a;
    public WeakReference<c> b;
    public boolean c;
    private ArrayList<String> d;
    private final String e = (c.a("navigation") + "/icons");
    private boolean f;
    private HashMap<String, WeakReference<Drawable>> g = new HashMap();

    final void a() {
        if (!this.f) {
            this.f = true;
            File file = new File(this.e);
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public final Drawable a(Context context, String str, String str2, String str3) {
        Drawable d = d(str);
        if (d != null) {
            return d;
        }
        d = d(str2);
        if (d != null) {
            return d;
        }
        d = d(str3);
        if (d != null) {
            return d;
        }
        Drawable drawable;
        d = null;
        if (!TextUtils.isEmpty(str3)) {
            d = a.b(str3 + ".png");
            if (d == null) {
                String e = f.e(str3);
                if (TextUtils.isEmpty(e)) {
                    drawable = d;
                } else {
                    if ("weibo.cn".equals(e)) {
                        e = "weibo.com";
                    }
                    drawable = a.b(e + ".png");
                    if (drawable != null) {
                        e(str3);
                    }
                }
                d = drawable;
            } else {
                e(str3);
            }
        }
        if (d != null) {
            a(str3, d);
            return d;
        }
        String a = a(str);
        Bitmap a2 = com.uc.util.b.a(context.getResources(), a, false);
        if (a2 != null) {
            if (this.c) {
                a2 = a(a2);
                b(a, a2);
            }
            d = new BitmapDrawable(context.getResources(), a2);
            a(str, d);
            drawable = d;
        } else {
            if (!TextUtils.isEmpty(str2)) {
                a = a(str2);
                a2 = com.uc.util.b.a(context.getResources(), a, false);
                if (a2 != null) {
                    if (this.c) {
                        a2 = a(a2);
                        b(a, a2);
                    }
                    drawable = new BitmapDrawable(context.getResources(), a2);
                }
            }
            drawable = d;
        }
        return drawable;
    }

    private void b(String str, Bitmap bitmap) {
        m.a(1, new f(this, str, bitmap));
    }

    final String a(String str) {
        return this.e + "/" + str + ".png";
    }

    final void a(String str, Drawable drawable) {
        this.g.put(str, new WeakReference(drawable));
    }

    public final void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && d(str) == null) {
            Bitmap a = s.a(context, str2);
            if (a != null) {
                a(str, new BitmapDrawable(context.getResources(), a));
                a();
                a(a(str), a);
            }
        }
    }

    private Drawable d(String str) {
        WeakReference weakReference = (WeakReference) this.g.get(str);
        if (weakReference != null) {
            return (Drawable) weakReference.get();
        }
        return null;
    }

    private void e(String str) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(str);
    }

    public static String b(String str) {
        String e = f.e(str);
        if (!TextUtils.isEmpty(e)) {
            e = com.ucpro.b.b.b.a(str);
        }
        if (TextUtils.isEmpty(e)) {
            e = "index";
        }
        return e.toLowerCase();
    }

    static void a(String str, Bitmap bitmap) {
        if (str != null && str.trim().length() != 0 && bitmap != null) {
            OutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(com.ucweb.common.util.k.a.b(str));
            } catch (Throwable th) {
                fileOutputStream = null;
            }
            if (fileOutputStream != null) {
                try {
                    bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                } catch (Throwable th2) {
                }
                try {
                    fileOutputStream.flush();
                } catch (IOException e) {
                }
                try {
                    fileOutputStream.close();
                } catch (Throwable th3) {
                }
            }
        }
    }

    static Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int c = a.c((int) R.dimen.launcher_widget_iconview_width_portrait);
        Bitmap a = com.uc.util.b.a(c, c, Config.ARGB_8888);
        if (a == null) {
            return a;
        }
        Canvas canvas = new Canvas(a);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, c, c), paint);
        s.a(canvas, c, c);
        return a;
    }

    public static Drawable c(String str) {
        Drawable b;
        int i;
        if (com.ucpro.feature.navigation.a.a.a(str)) {
            String str2 = "url=";
            int indexOf = str.indexOf(str2);
            if (indexOf >= 0) {
                Object substring = str.substring(str2.length() + indexOf);
                indexOf = substring.indexOf("^");
                if (indexOf > 0) {
                    substring = substring.substring(0, indexOf);
                }
                if (!TextUtils.isEmpty(substring)) {
                    b = a.b(substring + ".png");
                    if (b != null) {
                        return b;
                    }
                    for (String[] strArr : o.a) {
                        if (strArr[0].equals(str)) {
                            return a.b(strArr[1]);
                        }
                    }
                    return null;
                }
            }
        }
        b = null;
        if (b != null) {
            return b;
        }
        for (i = 0; i < r4; i++) {
            if (strArr[0].equals(str)) {
                return a.b(strArr[1]);
            }
        }
        return null;
    }

    public final void a(p pVar, String str) {
        byte[] bArr = pVar.b;
        if (bArr != null) {
            Bitmap a = com.uc.util.b.a(bArr);
            Bitmap a2 = a(a);
            if (a2 != null) {
                String b = b(str);
                a(b, new BitmapDrawable(d.c(), a2));
                b = a(b);
                a();
                a(b, a2);
            }
            if (a != null) {
                a.recycle();
            }
        }
        if (this.b != null && this.b.get() != null) {
            ((c) this.b.get()).d();
        }
    }
}
