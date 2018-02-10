package com.uc.framework.resources;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.uc.framework.xml.XmlBlockModify;
import com.uc.framework.xml.d;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public final class e {
    private static final HashMap<String, HashMap<String, Object>> a = new HashMap();
    private static final HashMap<String, HashMap<String, Object>> b = new HashMap();
    private static final HashMap<String, Object[]> c = new HashMap();
    private static final HashMap<String, XmlPullParser> d = new HashMap();
    private static final HashMap<String, XmlPullParser> e = new HashMap();
    private static String f;
    private static boolean g;
    private static String h;

    static int a(Context context, String str) {
        return a(context, str, f);
    }

    static int a(Context context, String str, String str2) {
        if (str2 == null || str2.trim().length() == 0) {
            return 0;
        }
        String str3;
        if (str2.endsWith(File.separator)) {
            str3 = str2;
        } else {
            str3 = new StringBuilder(String.valueOf(str2)).append(File.separator).toString();
        }
        Integer b = b(context, str, str3);
        if (b == null && !b.a(str2)) {
            b = b(context, str, "theme/default/");
        }
        if (b != null) {
            return b.intValue();
        }
        Log.e("AttributesReader", "UC can not find color " + str);
        return 0;
    }

    private static Integer b(Context context, String str, String str2) {
        if (a == null || str == null || str.length() == 0) {
            return Integer.valueOf(0);
        }
        HashMap hashMap = (HashMap) a.get(str2);
        XmlPullParser xmlPullParser = (XmlPullParser) d.get(str2);
        if (hashMap == null || xmlPullParser != null) {
            int i;
            if (xmlPullParser == null || hashMap == null || !hashMap.containsKey(str)) {
                i = 0;
            } else {
                Object obj = hashMap.get(str);
                if (obj != null) {
                    return (Integer) obj;
                }
                i = 1;
            }
            if (i == 0) {
                a(context, str2, 0, str);
                if (hashMap == null) {
                    hashMap = (HashMap) a.get(str2);
                }
            }
        }
        return (Integer) hashMap.get(str);
    }

    private static float c(Context context, String str) {
        if (str == null || str.length() == 0) {
            return 0.0f;
        }
        if (str.endsWith("dp")) {
            return b.b(context, Float.valueOf(str.substring(0, str.length() - 2)).floatValue());
        }
        if (str.endsWith("dip")) {
            return b.b(context, Float.valueOf(str.substring(0, str.length() - 3)).floatValue());
        }
        if (str.endsWith("px")) {
            return Float.valueOf(str.substring(0, str.length() - 2)).floatValue();
        }
        if (str.endsWith("sp")) {
            return b.a(context, Float.valueOf(str.substring(0, str.length() - 2)).floatValue());
        }
        return Float.valueOf(str).floatValue();
    }

    static float b(Context context, String str) {
        if (Character.isDigit(str.charAt(0))) {
            return c(context, str);
        }
        String str2 = f;
        if (str2 == null || str2.trim().length() == 0) {
            return 0.0f;
        }
        Float c = c(context, str, str2.endsWith(File.separator) ? str2 : new StringBuilder(String.valueOf(str2)).append(File.separator).toString());
        if (c == null && !b.a(str2)) {
            c = c(context, str, "theme/default/");
        }
        if (c == null) {
            return 0.0f;
        }
        return c.floatValue();
    }

    private static Float c(Context context, String str, String str2) {
        if (b == null || str == null || str.trim().length() == 0) {
            return Float.valueOf(0.0f);
        }
        HashMap hashMap = (HashMap) b.get(str2);
        if (hashMap == null) {
            a(context, str2, 1, str);
            hashMap = (HashMap) b.get(str2);
        }
        return (Float) hashMap.get(str);
    }

    private static void a(Context context, String str, int i, String str2) {
        switch (i) {
            case 0:
                if (((HashMap) a.get(str)) == null) {
                    a.put(str, new HashMap());
                }
                b(context, new StringBuilder(String.valueOf(str)).append("color.xml").toString(), i, str2);
                return;
            case 1:
                b.put(str, new HashMap());
                b(context, new StringBuilder(String.valueOf(str)).append("dimen.xml").toString(), i, str2);
                return;
            default:
                return;
        }
    }

    private static void b(Context context, String str, int i, String str2) {
        try {
            XmlPullParser xmlPullParser;
            AttributeSet asAttributeSet;
            XmlPullParser xmlPullParser2;
            String substring = str.substring(0, str.lastIndexOf(File.separator) + 1);
            switch (i) {
                case 0:
                    xmlPullParser = (XmlPullParser) d.get(substring);
                    break;
                case 1:
                    xmlPullParser = (XmlPullParser) e.get(substring);
                    break;
                default:
                    xmlPullParser = null;
                    break;
            }
            if (xmlPullParser == null) {
                byte[] b = new d(str).b();
                if (b != null && b.length != 0) {
                    int next;
                    xmlPullParser = new XmlBlockModify(b).a();
                    asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                    do {
                        next = xmlPullParser.next();
                        if (next != 2) {
                        }
                        if (next != 2) {
                            throw new XmlPullParserException("No start tag found");
                        }
                    } while (next != 1);
                    if (next != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                }
                return;
            }
            asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            try {
                context.getResources();
                a(context, xmlPullParser, asAttributeSet, substring, i, str2);
            } catch (Exception e) {
            }
            switch (i) {
                case 0:
                    xmlPullParser2 = (XmlPullParser) d.get(substring);
                    break;
                case 1:
                    xmlPullParser2 = (XmlPullParser) e.get(substring);
                    break;
                default:
                    xmlPullParser2 = null;
                    break;
            }
            if (xmlPullParser2 == null) {
                ((d) xmlPullParser).close();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, java.lang.String r11, int r12, java.lang.String r13) throws java.lang.Exception {
        /*
        r3 = 0;
        if (r9 == 0) goto L_0x0005;
    L_0x0003:
        if (r10 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        switch(r12) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0086;
            default: goto L_0x0009;
        };
    L_0x0009:
        r1 = r3;
        r4 = r3;
    L_0x000b:
        r5 = r9.next();
        r2 = 1;
        if (r5 == r2) goto L_0x0005;
    L_0x0012:
        r2 = 4;
        if (r5 != r2) goto L_0x001d;
    L_0x0015:
        r2 = r9.getText();	 Catch:{ Throwable -> 0x0105 }
        switch(r12) {
            case 0: goto L_0x0094;
            case 1: goto L_0x00bd;
            default: goto L_0x001c;
        };	 Catch:{ Throwable -> 0x0105 }
    L_0x001c:
        r1 = r2;
    L_0x001d:
        r2 = 2;
        if (r5 != r2) goto L_0x000b;
    L_0x0020:
        r2 = 0;
        r2 = r10.getAttributeValue(r2);	 Catch:{ Throwable -> 0x0105 }
        r4 = r2;
        goto L_0x000b;
    L_0x0027:
        r1 = a;
        r1 = r1.get(r11);
        r1 = (java.util.HashMap) r1;
        r2 = d;
        r2 = r2.get(r11);
        r2 = (org.xmlpull.v1.XmlPullParser) r2;
        r4 = g;
        if (r4 == 0) goto L_0x0078;
    L_0x003b:
        if (r2 != 0) goto L_0x0042;
    L_0x003d:
        r2 = d;
        r2.put(r11, r9);
    L_0x0042:
        r2 = d;
        r2 = r2.get(r11);
        r2 = (org.xmlpull.v1.XmlPullParser) r2;
        if (r2 == 0) goto L_0x0107;
    L_0x004c:
        r9 = (com.uc.framework.xml.d) r9;
        r2 = r9.a;
        r2 = com.uc.framework.xml.XmlBlockModify.nativeGetTextByAttrValue(r2, r13);
        if (r2 < 0) goto L_0x0080;
    L_0x0056:
        r4 = r9.b;
        r4 = r4.b;
        r2 = r4.a(r2);
        r2 = r2.toString();
    L_0x0064:
        if (r2 == 0) goto L_0x0082;
    L_0x0066:
        r3 = "#00000000";
        r2 = com.uc.framework.resources.b.a(r2, r3);
        r2 = android.graphics.Color.parseColor(r2);
        r2 = java.lang.Integer.valueOf(r2);
        r1.put(r13, r2);
        goto L_0x0005;
    L_0x0078:
        if (r2 == 0) goto L_0x0042;
    L_0x007a:
        r2 = d;
        r2.put(r11, r3);
        goto L_0x0042;
    L_0x0080:
        r2 = r3;
        goto L_0x0064;
    L_0x0082:
        r1.put(r13, r3);
        goto L_0x0005;
    L_0x0086:
        r1 = b;
        r1 = r1.get(r11);
        r1 = (java.util.HashMap) r1;
        r4 = r3;
        r7 = r3;
        r3 = r1;
        r1 = r7;
        goto L_0x000b;
    L_0x0094:
        if (r2 == 0) goto L_0x00b6;
    L_0x0096:
        r0 = r2;
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00df }
        r1 = r0;
        r2 = r1.trim();	 Catch:{ Throwable -> 0x00df }
        r0 = r2;
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00df }
        r1 = r0;
        r6 = "#00000000";
        r1 = com.uc.framework.resources.b.a(r1, r6);	 Catch:{ Throwable -> 0x00df }
        r1 = android.graphics.Color.parseColor(r1);	 Catch:{ Throwable -> 0x00df }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x00df }
        r3.put(r4, r1);	 Catch:{ Throwable -> 0x00df }
        r1 = r2;
        goto L_0x001d;
    L_0x00b6:
        r1 = 0;
        r3.put(r13, r1);	 Catch:{ Throwable -> 0x00df }
        r1 = r2;
        goto L_0x001d;
    L_0x00bd:
        if (r2 == 0) goto L_0x00d9;
    L_0x00bf:
        r0 = r2;
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00df }
        r1 = r0;
        r2 = r1.trim();	 Catch:{ Throwable -> 0x00df }
        r0 = r2;
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00df }
        r1 = r0;
        r1 = c(r8, r1);	 Catch:{ Throwable -> 0x00df }
        r1 = java.lang.Float.valueOf(r1);	 Catch:{ Throwable -> 0x00df }
        r3.put(r4, r1);	 Catch:{ Throwable -> 0x00df }
        r1 = r2;
        goto L_0x001d;
    L_0x00d9:
        r1 = 0;
        r3.put(r13, r1);	 Catch:{ Throwable -> 0x00df }
        goto L_0x001c;
    L_0x00df:
        r1 = move-exception;
        r1 = r2;
    L_0x00e1:
        r2 = "AttributesReader";
        r5 = new java.lang.StringBuilder;
        r6 = java.lang.String.valueOf(r4);
        r5.<init>(r6);
        r6 = " = ";
        r5 = r5.append(r6);
        r5 = r5.append(r1);
        r6 = " is invalid!";
        r5 = r5.append(r6);
        r5 = r5.toString();
        android.util.Log.w(r2, r5);
        goto L_0x000b;
    L_0x0105:
        r2 = move-exception;
        goto L_0x00e1;
    L_0x0107:
        r4 = r3;
        r7 = r3;
        r3 = r1;
        r1 = r7;
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.framework.resources.e.a(android.content.Context, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, java.lang.String, int, java.lang.String):void");
    }

    static void a(String str) {
        f = str;
    }

    static void a() {
        g = true;
    }

    public static void b(String str) {
        h = str;
    }
}
