package com.taobao.weex.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import com.taobao.weex.a.j;
import com.taobao.weex.ad;
import com.taobao.weex.i;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class r {
    private static final Map<String, a> a = new HashMap();
    private static Typeface b;

    public static a a(String str) {
        return (a) a.get(str);
    }

    public static void a(Paint paint, int i, int i2, String str) {
        int i3 = 0;
        Typeface typeface = paint.getTypeface();
        int i4;
        if (typeface == null) {
            i4 = 0;
        } else {
            i4 = typeface.getStyle();
        }
        if (i2 == 1 || ((r3 & 1) != 0 && i2 == -1)) {
            i3 = 1;
        }
        if (i == 2 || ((r3 & 2) != 0 && i == -1)) {
            i3 |= 2;
        }
        if (str != null) {
            if ("@default_font_family".equals(str)) {
                typeface = b;
            } else {
                a aVar = (a) a.get(str);
                if (aVar == null || aVar.d == null) {
                    typeface = Typeface.create(str, i3);
                } else {
                    typeface = aVar.d;
                }
            }
        }
        if (typeface != null) {
            paint.setTypeface(Typeface.create(typeface, i3));
        } else {
            paint.setTypeface(Typeface.defaultFromStyle(i3));
        }
    }

    public static void b(a aVar) {
        if (aVar != null && aVar.d == null) {
            if (aVar.e == 3 || aVar.e == 0) {
                aVar.e = 1;
                if (aVar.c == 3) {
                    try {
                        Typeface createFromAsset = Typeface.createFromAsset(i.e().getAssets(), Uri.parse(aVar.b).getPath().substring(1));
                        if (createFromAsset != null) {
                            if (i.c()) {
                                WXLogUtils.d("TypefaceUtil", "load asset file success");
                            }
                            aVar.e = 2;
                            aVar.d = createFromAsset;
                            return;
                        }
                        WXLogUtils.e("TypefaceUtil", "Font asset file not found " + aVar.b);
                    } catch (Exception e) {
                        WXLogUtils.e("TypefaceUtil", e.toString());
                    }
                } else if (aVar.c == 1) {
                    String str = aVar.b;
                    String str2 = aVar.a;
                    String replace = str.replace('/', '_').replace(':', '_');
                    File file = new File(i.a(i.e()) + "/font-family");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    replace = file.getAbsolutePath() + File.separator + replace;
                    if (!b(replace, str2)) {
                        j c = ad.a().c();
                        if (c == null) {
                            WXLogUtils.e("TypefaceUtil", "downloadFontByNetwork() IWXHttpAdapter == null");
                            return;
                        }
                        com.taobao.weex.common.r rVar = new com.taobao.weex.common.r();
                        rVar.b = str;
                        rVar.c = SpdyRequest.GET_METHOD;
                        c.a(rVar, new q(str, replace, str2));
                    }
                } else if (aVar.c == 2 && !b(aVar.b, aVar.a)) {
                    aVar.e = 3;
                }
            }
        }
    }

    private static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            if (!new File(str).exists()) {
                return false;
            }
            Typeface createFromFile = Typeface.createFromFile(str);
            if (createFromFile != null) {
                a aVar = (a) a.get(str2);
                if (aVar != null) {
                    aVar.e = 2;
                    aVar.d = createFromFile;
                    if (i.c()) {
                        WXLogUtils.d("TypefaceUtil", "load local font file success");
                    }
                    return true;
                }
            }
            WXLogUtils.e("TypefaceUtil", "load local font file failed, can't create font.");
            return false;
        } catch (Exception e) {
            WXLogUtils.e("TypefaceUtil", e.toString());
        }
    }

    public static Typeface a() {
        return b;
    }

    public static void a(a aVar) {
        if (!TextUtils.isEmpty(aVar.a)) {
            a.put(aVar.a, aVar);
        }
    }
}
