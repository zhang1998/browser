package com.ucpro.feature.webwindow.b;

import com.ucweb.common.util.h.m;
import com.ucweb.common.util.n.a;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: ProGuard */
public final class w {
    private static String[] a = new String[]{"!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "*", "+", ",", "-", ".", ":", ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^", "`", "{", "|", "}", "~", "/", " ", "！", "“", "”", "#", "￥", "%", "&", "‘", "’", "（", "）", "*", "+", "，", "、", "：", "；", "《", "=", "》", "？", "@", "【", "·", "】", "……", "。", "-", "{", "|", "}", "——", "/", "`", "^", "『", "』", "「", "」"};
    private static String[] b = new String[]{"jpg", "bmp", "jpeg", "png", "JPG", "BMP", "PNG", "JPEG"};

    public static String a(String str) {
        if (a.a(str)) {
            return str;
        }
        HashSet hashSet = new HashSet(Arrays.asList(a));
        String str2 = null;
        for (int i = 0; i < str.length() - 1; i++) {
            CharSequence substring = str.substring(i, i + 1);
            if (hashSet.contains(substring)) {
                str2 = str.replace(substring, "_");
            }
        }
        if (a.a(str2)) {
            return str;
        }
        return str2;
    }

    public static void a(String str, int i, int i2, m mVar) {
        m.a(1, new s(str, i, i2, mVar));
    }

    private static byte[] b(File file) {
        try {
            return com.ucweb.common.util.k.a.d(file);
        } catch (IOException e) {
            return null;
        }
    }
}
