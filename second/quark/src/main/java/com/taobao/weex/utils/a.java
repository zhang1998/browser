package com.taobao.weex.utils;

import android.graphics.Typeface;
import android.net.Uri;
import com.taobao.weex.ac;
import com.taobao.weex.i;

/* compiled from: ProGuard */
public final class a {
    public final String a;
    public String b = "";
    int c = 1;
    Typeface d;
    int e = -1;

    public a(String str, String str2, ac acVar) {
        this.a = str;
        String trim = str2 != null ? str2.trim() : "";
        if (trim.isEmpty()) {
            this.e = -1;
            WXLogUtils.e("TypefaceUtil", "font src is empty.");
            return;
        }
        if (trim.matches("^url\\('.*'\\)$")) {
            Uri parse = Uri.parse(trim.substring(5, trim.length() - 2));
            if (acVar != null) {
                parse = acVar.a(parse);
            }
            this.b = parse.toString();
            try {
                String scheme = parse.getScheme();
                if ("http".equals(scheme) || "https".equals(scheme)) {
                    this.c = 1;
                } else if ("file".equals(scheme)) {
                    this.c = 2;
                    this.b = parse.getPath();
                } else if ("local".equals(scheme)) {
                    this.c = 3;
                } else {
                    this.c = 0;
                }
                this.e = 0;
            } catch (Exception e) {
                this.c = -1;
                WXLogUtils.e("TypefaceUtil", "URI.create(mUrl) failed mUrl: " + this.b);
            }
        } else {
            this.b = trim;
            this.e = -1;
        }
        if (i.c()) {
            WXLogUtils.d("TypefaceUtil", "src:" + trim + ", mUrl:" + this.b + ", mType:" + this.c);
        }
    }
}
