package com.ucpro.feature.navigation.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.util.b;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.business.stat.m;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class s {
    private static final String[] a = new String[]{"绿", "草"};
    private static char[] b = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static int[] c = new int[]{-1091773, -7495681, -11959809, -9395457, -10244616, -12930830, -10559271, -9640040, -9776286, -8634, -25536, -29921, -1091773, -7495681, -11959809, -9395457, -10244616, -12930830, -10559271, -9640040, -9776286, -8634, -25536, -29921, -1091773, -7495681, -11959809, -9395457, -10244616, -12930830, -10559271, -9640040, -9776286, -8634, -25536, -29921};

    public static Bitmap a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int c = a.c((int) R.dimen.launcher_widget_iconview_width_portrait);
        Bitmap a = b.a(c, c, Config.ARGB_8888);
        if (!(a == null || str == null || str.trim().length() <= 0)) {
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setTextSize(20.0f);
            textView.setTextColor(-1);
            String valueOf = String.valueOf(str.trim().charAt(0));
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = "-";
            }
            textView.setText(valueOf);
            a.eraseColor(a(str, valueOf));
            textView.measure(MeasureSpec.makeMeasureSpec(c, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(c, UCCore.VERIFY_POLICY_QUICK));
            textView.layout(0, 0, c, c);
            Canvas canvas = new Canvas(a);
            if (textView.getPaint() != null) {
                textView.getPaint().setFakeBoldText(true);
            }
            canvas.save();
            textView.draw(canvas);
            canvas.restore();
            a(canvas, c, c);
        }
        return a;
    }

    public static void a(Canvas canvas, int i, int i2) {
        Drawable a = a.a("home_nav_mask.svg");
        if (a != null) {
            Bitmap a2 = b.a(i, i2, Config.ARGB_8888);
            if (a2 != null) {
                a2.eraseColor(0);
                Canvas canvas2 = new Canvas(a2);
                a.setBounds(0, 0, a2.getWidth(), a2.getHeight());
                a.draw(canvas2);
                Xfermode porterDuffXfermode = new PorterDuffXfermode(Mode.DST_IN);
                Paint paint = new Paint();
                paint.setXfermode(porterDuffXfermode);
                canvas.drawBitmap(a2, 0.0f, 0.0f, paint);
                a2.recycle();
            }
        }
    }

    private static int a(String str, String str2) {
        int i;
        int i2 = 0;
        for (String equals : a) {
            if (equals.equals(str2)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i != 0) {
            m.a("navigation", "title_mat_green", "content", str);
            return -9776286;
        }
        String a = com.ucpro.b.b.b.a(str);
        if (a == null || a.length() <= 0) {
            return -10713360;
        }
        try {
            char charAt = a.toLowerCase().charAt(0);
            while (i2 < b.length) {
                if (charAt != b[i2]) {
                    i2++;
                } else if (i2 < c.length) {
                    return c[i2];
                } else {
                    return -10713360;
                }
            }
            return -10713360;
        } catch (Exception e) {
            return -10713360;
        }
    }
}
