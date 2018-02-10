package com.uc.framework.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.uc.framework.xml.XmlBlockModify;
import com.uc.framework.xml.d;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public final class x {
    private static final String[] a = new String[]{"selector"};
    private static String b;
    private static boolean c;
    private static String d;

    static void a(String str) {
        b = str;
    }

    public static void a() {
        c = false;
    }

    public static void b(String str) {
        d = str;
    }

    static ColorStateList a(Context context, String str) {
        ColorStateList a = a(context, str, b);
        if (a != null || b.a(b)) {
            return a;
        }
        String str2 = b;
        b = "theme/default/";
        a = a(context, str, b);
        b = str2;
        return a;
    }

    private static ColorStateList a(Context context, String str, String str2) {
        ColorStateList colorStateList = null;
        if (str == null || str.trim().length() == 0 || !str.endsWith(".xml")) {
            return null;
        }
        Object stringBuilder;
        String stringBuilder2;
        ColorStateList colorStateList2;
        if (str2 != null) {
            stringBuilder = str2.endsWith(File.separator) ? str2 : new StringBuilder(String.valueOf(str2)).append(File.separator).toString();
            stringBuilder2 = new StringBuilder(String.valueOf(stringBuilder)).append("drawable").append(File.separator).append(str).toString();
            if (d != null && c && b.c(str2)) {
                str = stringBuilder2;
                stringBuilder2 = new StringBuilder(String.valueOf(stringBuilder)).append("drawable-").append(d).append(File.separator).append(str).toString();
            } else {
                str = stringBuilder2;
                stringBuilder2 = null;
            }
        } else {
            stringBuilder2 = null;
        }
        if (stringBuilder2 != null) {
            stringBuilder = j.a(stringBuilder2);
            if (stringBuilder != null) {
                colorStateList = (ColorStateList) ((i) stringBuilder).d;
            }
        }
        if (colorStateList == null && str != null) {
            stringBuilder = j.a(str);
            if (stringBuilder != null) {
                colorStateList2 = (ColorStateList) ((i) stringBuilder).d;
                if (colorStateList2 == null && stringBuilder2 != null) {
                    colorStateList2 = b(context, stringBuilder2);
                    j.a(stringBuilder2, colorStateList2, 512);
                }
                if (colorStateList2 != null && str != null) {
                    colorStateList2 = b(context, str);
                    j.a(str, colorStateList2, 512);
                    return colorStateList2;
                }
            }
        }
        colorStateList2 = colorStateList;
        colorStateList2 = b(context, stringBuilder2);
        j.a(stringBuilder2, colorStateList2, 512);
        return colorStateList2 != null ? colorStateList2 : colorStateList2;
    }

    private static ColorStateList a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (xmlPullParser == null || attributeSet == null) {
            return null;
        }
        String name = xmlPullParser.getName();
        if (!name.equals(a[0])) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid drawable tag " + name);
        } else if (xmlPullParser == null || attributeSet == null) {
            return null;
        } else {
            Object obj;
            Object obj2;
            int depth = xmlPullParser.getDepth() + 1;
            int i = 20;
            Object obj3 = new int[20];
            Object obj4 = new int[20][];
            int i2 = 0;
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                }
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    break;
                } else if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    int i3;
                    int a;
                    Object obj5;
                    String str = null;
                    obj = null;
                    next = 0;
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i4 = 0;
                    while (i4 < attributeCount) {
                        String str2;
                        String attributeName = attributeSet.getAttributeName(i4);
                        if (attributeName != null) {
                            if (attributeName.equals("color")) {
                                str = attributeSet.getAttributeValue(i4);
                                if (str != null) {
                                    obj2 = 1;
                                    str2 = str;
                                }
                            } else {
                                int d = b.d(attributeName);
                                depth2 = next + 1;
                                if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                                    d = -d;
                                }
                                iArr[next] = d;
                                next = depth2;
                                obj2 = obj;
                                str2 = str;
                            }
                            i4++;
                            str = str2;
                            obj = obj2;
                        }
                        obj2 = obj;
                        str2 = str;
                        i4++;
                        str = str2;
                        obj = obj2;
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr, next);
                    if (str != null) {
                        if (str.startsWith("#")) {
                            next = Color.parseColor(str);
                        } else {
                            next = e.a(context, str, b);
                        }
                        i3 = next;
                    } else if (obj == null) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'android:color' attribute.");
                    } else {
                        i3 = -65536;
                    }
                    if (i2 + 1 >= i) {
                        a = a((i2 + 1) * 4) / 4;
                        obj2 = new int[a];
                        System.arraycopy(obj3, 0, obj2, 0, i2);
                        obj5 = new int[a][];
                        System.arraycopy(obj4, 0, obj5, 0, i2);
                    } else {
                        obj5 = obj4;
                        obj2 = obj3;
                        a = i;
                    }
                    obj2[i2] = i3;
                    obj5[i2] = trimStateSet;
                    obj4 = obj5;
                    obj3 = obj2;
                    i2++;
                    i = a;
                }
            }
            obj2 = new int[i2];
            obj = new int[i2][];
            System.arraycopy(obj3, 0, obj2, 0, i2);
            System.arraycopy(obj4, 0, obj, 0, i2);
            return new ColorStateList(obj, obj2);
        }
    }

    private static ColorStateList b(Context context, String str) {
        Object obj;
        ColorStateList colorStateList = null;
        Object[] objArr = new Object[2];
        if (str != null) {
            try {
                if (str.length() != 0) {
                    byte[] b = new d(str).b();
                    if (!(b == null || b.length == 0)) {
                        XmlPullParser a;
                        AttributeSet asAttributeSet;
                        try {
                            a = new XmlBlockModify(b).a();
                            try {
                                int next;
                                asAttributeSet = Xml.asAttributeSet(a);
                                do {
                                    try {
                                        next = a.next();
                                        if (next == 2) {
                                            break;
                                        }
                                    } catch (Throwable th) {
                                    }
                                } while (next != 1);
                                if (next != 2) {
                                    throw new XmlPullParserException("No start tag found");
                                }
                            } catch (Throwable th2) {
                                obj = colorStateList;
                            }
                        } catch (Throwable th3) {
                            Object obj2 = colorStateList;
                            obj = colorStateList;
                        }
                        objArr[0] = a;
                        objArr[1] = asAttributeSet;
                    }
                }
            } catch (XmlPullParserException e) {
            } catch (IOException e2) {
            }
        }
        if (objArr[0] == null || objArr[1] == null) {
            return colorStateList;
        }
        ColorStateList a2;
        try {
            context.getResources();
            a2 = a(context, (XmlPullParser) objArr[0], (AttributeSet) objArr[1]);
        } catch (XmlPullParserException e3) {
            a2 = colorStateList;
        } catch (IOException e4) {
            a2 = colorStateList;
        }
        if (a2 == null) {
            throw new RuntimeException("Drawable from xml is null!");
        }
        ((d) objArr[0]).close();
        return a2;
    }

    private static int a(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }
}
