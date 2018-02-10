package com.uc.framework.resources;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.apollo.impl.SettingsConst;
import com.uc.framework.xml.XmlBlockModify;
import com.uc.framework.xml.d;
import com.uc.imagecodec.export.IPictureView;
import com.uc.util.b;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public final class aa {
    private static final String[] b = new String[]{"selector", "tile", "shape", "patch-drawable", "inset"};
    private static boolean c;
    private static String d;
    private static u e;
    private static boolean f = true;
    public String a;

    public aa(String str) {
        this.a = str;
    }

    public static void a() {
        c = false;
    }

    public static void a(String str) {
        d = str;
    }

    static void a(u uVar) {
        e = uVar;
    }

    public static boolean b(String str) {
        return str != null && str.indexOf(File.separator) == -1 && new d(str).a == 4097;
    }

    public static Bitmap a(Context context, String str, String str2) {
        Bitmap bitmap = null;
        if (str.trim().length() == 0) {
            return bitmap;
        }
        Bitmap a;
        Object obj;
        if (str2 != null) {
            Object stringBuilder = str2.endsWith(File.separator) ? str2 : new StringBuilder(String.valueOf(str2)).append(File.separator).toString();
            String stringBuilder2 = new StringBuilder(String.valueOf(stringBuilder)).append("drawable").append(File.separator).append(str).toString();
            if (d != null && c && b.c(str2)) {
                String stringBuilder3 = new StringBuilder(String.valueOf(stringBuilder)).append("drawable-").append(d).append(File.separator).append(str).toString();
                str = stringBuilder2;
            } else {
                str = stringBuilder2;
                obj = bitmap;
            }
        } else {
            obj = bitmap;
        }
        Rect rect = new Rect();
        if (stringBuilder3 != null) {
            try {
                bitmap = b.a(context.getResources(), 0, stringBuilder3, rect, 0.0f, 0.0f, true, false);
            } catch (Throwable th) {
            }
        }
        if (bitmap == null && str != null) {
            try {
                a = b.a(context.getResources(), 0, str, rect, 0.0f, 0.0f, true, false);
            } catch (Throwable th2) {
            }
            return a;
        }
        a = bitmap;
        return a;
    }

    final Drawable a(Context context, String str, z zVar, float f, float f2) {
        String str2;
        Drawable drawable;
        boolean b = b(str);
        if (b) {
            try {
                str2 = this.a;
            } catch (Exception e) {
                drawable = null;
            }
        } else {
            str2 = null;
        }
        drawable = a(context, str, zVar, 0.0f, 0.0f, str2);
        if (drawable == null && b && !b.a(this.a)) {
            return b(context, str, zVar, 0.0f, 0.0f);
        }
        if (b.b(this.a)) {
            return drawable;
        }
        u.a(drawable, 1);
        return drawable;
    }

    private Drawable b(Context context, String str, z zVar, float f, float f2) {
        Drawable drawable = null;
        if (!b.a(this.a)) {
            String str2 = this.a;
            this.a = "theme/default/";
            drawable = a(context, str, zVar, f, f2, this.a);
            if (e != null) {
                e.a(drawable);
            }
            this.a = str2;
        }
        return drawable;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(android.content.Context r17, java.lang.String r18, com.uc.framework.resources.z r19, float r20, float r21, java.lang.String r22) {
        /*
        r16 = this;
        if (r18 == 0) goto L_0x000c;
    L_0x0002:
        r4 = r18.trim();
        r4 = r4.length();
        if (r4 != 0) goto L_0x000e;
    L_0x000c:
        r4 = 0;
    L_0x000d:
        return r4;
    L_0x000e:
        r6 = 0;
        if (r22 == 0) goto L_0x02d4;
    L_0x0011:
        r4 = java.io.File.separator;
        r0 = r22;
        r4 = r0.endsWith(r4);
        if (r4 == 0) goto L_0x00c5;
    L_0x001b:
        r4 = r22;
    L_0x001d:
        r5 = new java.lang.StringBuilder;
        r7 = java.lang.String.valueOf(r4);
        r5.<init>(r7);
        r7 = "drawable";
        r5 = r5.append(r7);
        r7 = java.io.File.separator;
        r5 = r5.append(r7);
        r0 = r18;
        r5 = r5.append(r0);
        r14 = r5.toString();
        r5 = d;
        if (r5 == 0) goto L_0x00da;
    L_0x0040:
        r5 = c;
        if (r5 == 0) goto L_0x00da;
    L_0x0044:
        r5 = com.uc.framework.resources.b.c(r22);
        if (r5 == 0) goto L_0x00da;
    L_0x004a:
        r5 = new java.lang.StringBuilder;
        r4 = java.lang.String.valueOf(r4);
        r5.<init>(r4);
        r4 = "drawable-";
        r4 = r5.append(r4);
        r5 = d;
        r4 = r4.append(r5);
        r5 = java.io.File.separator;
        r4 = r4.append(r5);
        r0 = r18;
        r4 = r4.append(r0);
        r6 = r4.toString();
    L_0x006f:
        r5 = 0;
        r13 = 0;
        if (r6 == 0) goto L_0x0081;
    L_0x0073:
        r5 = com.uc.framework.resources.j.a(r6);
        if (r5 == 0) goto L_0x0081;
    L_0x0079:
        r4 = r5;
        r4 = (com.uc.framework.resources.i) r4;
        r4 = r4.d;
        r4 = (android.graphics.drawable.Drawable) r4;
        r13 = r4;
    L_0x0081:
        if (r5 != 0) goto L_0x02cb;
    L_0x0083:
        if (r14 == 0) goto L_0x02cb;
    L_0x0085:
        r5 = com.uc.framework.resources.j.a(r14);
        if (r5 == 0) goto L_0x02cb;
    L_0x008b:
        r4 = r5;
        r4 = (com.uc.framework.resources.i) r4;
        r4 = r4.d;
        r4 = (android.graphics.drawable.Drawable) r4;
        r12 = r5;
        r13 = r4;
    L_0x0094:
        if (r13 != 0) goto L_0x01d5;
    L_0x0096:
        r4 = 1;
        r15 = r4;
    L_0x0098:
        if (r15 == 0) goto L_0x02c1;
    L_0x009a:
        r4 = ".xml";
        r0 = r18;
        r4 = r0.endsWith(r4);
        if (r4 == 0) goto L_0x023d;
    L_0x00a4:
        r4 = 0;
        if (r6 == 0) goto L_0x02c8;
    L_0x00a7:
        r0 = r16;
        r1 = r17;
        r2 = r19;
        r5 = r0.a(r1, r6, r2);
        r4 = r6;
    L_0x00b2:
        if (r5 != 0) goto L_0x02c5;
    L_0x00b4:
        if (r14 == 0) goto L_0x02c5;
    L_0x00b6:
        r0 = r16;
        r1 = r17;
        r2 = r19;
        r5 = r0.a(r1, r14, r2);
    L_0x00c0:
        if (r5 != 0) goto L_0x01d9;
    L_0x00c2:
        r4 = 0;
        goto L_0x000d;
    L_0x00c5:
        r4 = new java.lang.StringBuilder;
        r5 = java.lang.String.valueOf(r22);
        r4.<init>(r5);
        r5 = java.io.File.separator;
        r4 = r4.append(r5);
        r4 = r4.toString();
        goto L_0x001d;
    L_0x00da:
        r4 = ".svg";
        r0 = r18;
        r4 = r0.endsWith(r4);
        if (r4 != 0) goto L_0x0147;
    L_0x00e4:
        r4 = ".png";
        r0 = r18;
        r4 = r0.endsWith(r4);
        if (r4 == 0) goto L_0x00f8;
    L_0x00ee:
        r4 = ".9.png";
        r0 = r18;
        r4 = r0.endsWith(r4);
        if (r4 == 0) goto L_0x0147;
    L_0x00f8:
        r4 = 0;
    L_0x00f9:
        if (r4 == 0) goto L_0x006f;
    L_0x00fb:
        r7 = new com.uc.framework.resources.l;
        r0 = r22;
        r1 = r18;
        r7.<init>(r0, r1);
        r4 = 0;
        r5 = ".svg";
        r0 = r18;
        r5 = r0.endsWith(r5);
        if (r5 == 0) goto L_0x019d;
    L_0x010f:
        r4 = com.uc.framework.resources.r.c();
        if (r4 == 0) goto L_0x018e;
    L_0x0115:
        r4 = new java.lang.StringBuilder;
        r5 = r7.b;
        r5 = java.lang.String.valueOf(r5);
        r4.<init>(r5);
        r5 = r7.c;
        r4 = r4.append(r5);
        r5 = r4.toString();
        r4 = r7.a(r5);
        if (r4 == 0) goto L_0x0149;
    L_0x0130:
        r5 = 1;
        r7.e = r5;
    L_0x0133:
        if (r4 != 0) goto L_0x02d1;
    L_0x0135:
        r0 = r17;
        r1 = r19;
        r2 = r20;
        r3 = r21;
        r4 = r7.a(r0, r1, r2, r3);
        r6 = r4;
    L_0x0142:
        if (r6 != 0) goto L_0x01c4;
    L_0x0144:
        r4 = 0;
        goto L_0x000d;
    L_0x0147:
        r4 = 1;
        goto L_0x00f9;
    L_0x0149:
        r6 = r7.a();
        r8 = r7.a;
        r0 = r20;
        r1 = r21;
        r8 = com.uc.b.a.a(r8, r6, r0, r1);
        if (r8 == 0) goto L_0x0133;
    L_0x0159:
        r8 = com.uc.util.b.a(r8);
        if (r8 != 0) goto L_0x017b;
    L_0x015f:
        r4 = "ThemeResourceHelper";
        r5 = new java.lang.StringBuilder;
        r8 = "From drawable ";
        r5.<init>(r8);
        r5 = r5.append(r6);
        r6 = " to bitmap is null";
        r5 = r5.append(r6);
        r5 = r5.toString();
        android.util.Log.w(r4, r5);
        r4 = 0;
        goto L_0x0133;
    L_0x017b:
        r4 = new android.graphics.drawable.BitmapDrawable;
        r6 = r17.getResources();
        r4.<init>(r6, r8);
        r0 = r19;
        r6 = r0.a;
        if (r6 == 0) goto L_0x0133;
    L_0x018a:
        r7.a(r5, r4);
        goto L_0x0133;
    L_0x018e:
        r4 = r7.a();
        r5 = r7.a;
        r0 = r20;
        r1 = r21;
        r4 = com.uc.b.a.a(r5, r4, r0, r1);
        goto L_0x0133;
    L_0x019d:
        r5 = ".png";
        r0 = r18;
        r5 = r0.endsWith(r5);
        if (r5 == 0) goto L_0x01c2;
    L_0x01a7:
        r5 = ".9.png";
        r0 = r18;
        r5 = r0.endsWith(r5);
        if (r5 != 0) goto L_0x01c2;
    L_0x01b1:
        r5 = 1;
    L_0x01b2:
        if (r5 == 0) goto L_0x02ce;
    L_0x01b4:
        r0 = r17;
        r1 = r19;
        r2 = r20;
        r3 = r21;
        r4 = r7.a(r0, r1, r2, r3);
        r6 = r4;
        goto L_0x0142;
    L_0x01c2:
        r5 = 0;
        goto L_0x01b2;
    L_0x01c4:
        r4 = r7.d;
        r4 = (com.uc.framework.resources.i) r4;
        r5 = r7.e;
        if (r5 == 0) goto L_0x01d3;
    L_0x01cc:
        r5 = 0;
    L_0x01cd:
        r4 = a(r6, r4, r5);
        goto L_0x000d;
    L_0x01d3:
        r5 = 1;
        goto L_0x01cd;
    L_0x01d5:
        r4 = 0;
        r15 = r4;
        goto L_0x0098;
    L_0x01d9:
        r0 = r19;
        r4 = r0.a;
        if (r4 == 0) goto L_0x02be;
    L_0x01df:
        if (r12 != 0) goto L_0x02be;
    L_0x01e1:
        r4 = r5 instanceof com.uc.framework.resources.s;
        if (r4 == 0) goto L_0x01f6;
    L_0x01e5:
        r4 = r5;
        r4 = (com.uc.framework.resources.s) r4;
        r6 = r4.b;
        r4 = com.uc.framework.resources.j.a(r14, r5, r6);
    L_0x01ee:
        r4 = (com.uc.framework.resources.i) r4;
        r4 = a(r5, r4, r15);
        goto L_0x000d;
    L_0x01f6:
        r4 = r5 instanceof android.graphics.drawable.BitmapDrawable;
        if (r4 != 0) goto L_0x01fe;
    L_0x01fa:
        r4 = r5 instanceof android.graphics.drawable.NinePatchDrawable;
        if (r4 == 0) goto L_0x020f;
    L_0x01fe:
        r4 = r5.getIntrinsicWidth();
        r4 = r4 * 4;
        r6 = r5.getIntrinsicHeight();
        r4 = r4 * r6;
        r6 = (long) r4;
        r4 = com.uc.framework.resources.j.a(r14, r5, r6);
        goto L_0x01ee;
    L_0x020f:
        r4 = r5 instanceof com.uc.framework.resources.q;
        if (r4 == 0) goto L_0x021d;
    L_0x0213:
        r4 = r5;
        r4 = (com.uc.framework.resources.q) r4;
        r6 = r4.a;
        r4 = com.uc.framework.resources.j.a(r14, r5, r6);
        goto L_0x01ee;
    L_0x021d:
        r4 = r5 instanceof android.graphics.drawable.InsetDrawable;
        if (r4 == 0) goto L_0x022b;
    L_0x0221:
        r4 = r5;
        r4 = (com.uc.framework.resources.k) r4;
        r6 = r4.a;
        r4 = com.uc.framework.resources.j.a(r14, r5, r6);
        goto L_0x01ee;
    L_0x022b:
        r4 = r5 instanceof com.uc.framework.resources.o;
        if (r4 == 0) goto L_0x0236;
    L_0x022f:
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = com.uc.framework.resources.j.a(r14, r5, r6);
        goto L_0x01ee;
    L_0x0236:
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = com.uc.framework.resources.j.a(r14, r5, r6);
        goto L_0x01ee;
    L_0x023d:
        r4 = ".fixed.9.png";
        r0 = r18;
        r4 = r0.endsWith(r4);
        if (r4 == 0) goto L_0x024c;
    L_0x0247:
        r4 = 0;
        r0 = r19;
        r0.b = r4;
    L_0x024c:
        r7 = new android.graphics.Rect;
        r7.<init>();
        r5 = 0;
        r4 = 0;
        if (r6 == 0) goto L_0x026e;
    L_0x0255:
        r4 = r17.getResources();
        r0 = r19;
        r5 = r0.d;
        r0 = r19;
        r10 = r0.b;
        r0 = r19;
        r11 = r0.c;
        r8 = r20;
        r9 = r21;
        r5 = com.uc.util.b.a(r4, r5, r6, r7, r8, r9, r10, r11);
        r4 = r6;
    L_0x026e:
        if (r5 != 0) goto L_0x028d;
    L_0x0270:
        if (r14 == 0) goto L_0x028d;
    L_0x0272:
        r4 = r17.getResources();
        r0 = r19;
        r5 = r0.d;
        r0 = r19;
        r10 = r0.b;
        r0 = r19;
        r11 = r0.c;
        r6 = r14;
        r8 = r20;
        r9 = r21;
        r4 = com.uc.util.b.a(r4, r5, r6, r7, r8, r9, r10, r11);
        r5 = r4;
        r4 = r14;
    L_0x028d:
        if (r5 == 0) goto L_0x02c1;
    L_0x028f:
        r6 = r5.getNinePatchChunk();
        if (r6 == 0) goto L_0x029b;
    L_0x0295:
        r6 = android.graphics.NinePatch.isNinePatchChunk(r6);
        if (r6 != 0) goto L_0x029c;
    L_0x029b:
        r7 = 0;
    L_0x029c:
        r6 = r17.getResources();
        r5 = com.uc.util.b.a(r6, r5, r7, r4);
        r6 = r5.getIntrinsicWidth();
        r7 = r5.getIntrinsicHeight();
        r6 = r6 * r7;
        r6 = r6 * 4;
        r6 = (long) r6;
        r0 = r19;
        r8 = r0.a;
        if (r8 == 0) goto L_0x02be;
    L_0x02b6:
        if (r12 != 0) goto L_0x02be;
    L_0x02b8:
        r4 = com.uc.framework.resources.j.a(r4, r5, r6);
        goto L_0x01ee;
    L_0x02be:
        r4 = r12;
        goto L_0x01ee;
    L_0x02c1:
        r4 = r12;
        r5 = r13;
        goto L_0x01ee;
    L_0x02c5:
        r14 = r4;
        goto L_0x00c0;
    L_0x02c8:
        r5 = r13;
        goto L_0x00b2;
    L_0x02cb:
        r12 = r5;
        goto L_0x0094;
    L_0x02ce:
        r6 = r4;
        goto L_0x0142;
    L_0x02d1:
        r6 = r4;
        goto L_0x0142;
    L_0x02d4:
        r14 = r18;
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.framework.resources.aa.a(android.content.Context, java.lang.String, com.uc.framework.resources.z, float, float, java.lang.String):android.graphics.drawable.Drawable");
    }

    private static Drawable a(Drawable drawable, i iVar, boolean z) {
        Drawable drawable2 = null;
        if (drawable != null) {
            boolean z2 = drawable instanceof s;
            if (drawable instanceof q) {
                drawable2 = (q) ((q) drawable).c.newDrawable();
                if (!f) {
                    drawable2.b = false;
                }
            } else if (!z2) {
                TileMode tileModeY;
                TileMode tileMode;
                Drawable newDrawable;
                if (drawable instanceof BitmapDrawable) {
                    TileMode tileModeX = ((BitmapDrawable) drawable).getTileModeX();
                    tileModeY = ((BitmapDrawable) drawable).getTileModeY();
                    tileMode = tileModeX;
                } else {
                    tileModeY = null;
                    tileMode = null;
                }
                if (z || (drawable instanceof InsetDrawable)) {
                    newDrawable = drawable.getConstantState().newDrawable();
                } else {
                    newDrawable = drawable.getConstantState().newDrawable().mutate();
                }
                if (newDrawable instanceof BitmapDrawable) {
                    ((BitmapDrawable) newDrawable).setTileModeX(tileMode);
                    ((BitmapDrawable) newDrawable).setTileModeY(tileModeY);
                    drawable2 = newDrawable;
                } else {
                    drawable2 = newDrawable;
                }
            } else if (z2) {
                s sVar = (s) drawable;
                drawable2 = new s();
                drawable2.a = new Hashtable(sVar.a);
                drawable2.b = sVar.b;
                drawable2.c = sVar.c;
            } else {
                drawable2 = drawable;
            }
            if (!(iVar == null || drawable2 == null)) {
                if (iVar.e) {
                    iVar.e = false;
                    j.d = j.d - iVar.b;
                }
                iVar.c++;
                h hVar = new h(iVar.a, drawable2, iVar.b);
                synchronized (j.i) {
                    j.i.d = hVar;
                    hVar.c = j.i;
                    j.i = hVar;
                }
                if (j.b) {
                    new StringBuilder("add ref:").append(iVar.a);
                }
            }
        }
        return drawable2;
    }

    private Drawable a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, z zVar, String str) throws XmlPullParserException, Exception {
        z zVar2 = new z();
        zVar2.a = false;
        zVar2.b = zVar.b;
        zVar2.d = zVar.d;
        String name = xmlPullParser.getName();
        if (name.equals(b[0])) {
            if (xmlPullParser == null || attributeSet == null) {
                return null;
            }
            Drawable qVar = new q();
            int depth = xmlPullParser.getDepth() + 1;
            long j = 0;
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                }
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    break;
                } else if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    Drawable a;
                    long intrinsicWidth;
                    String str2 = null;
                    String str3 = null;
                    next = 0;
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i = 0;
                    while (i < attributeCount) {
                        String attributeName = attributeSet.getAttributeName(i);
                        if (attributeName == null) {
                            attributeName = str3;
                        } else if (attributeName.equals("drawable")) {
                            str2 = attributeSet.getAttributeValue(i);
                            attributeName = str3;
                        } else if (attributeName.equals("color")) {
                            attributeName = attributeSet.getAttributeValue(i);
                        } else {
                            int d = b.d(attributeName);
                            depth2 = next + 1;
                            if (!attributeSet.getAttributeBooleanValue(i, false)) {
                                d = -d;
                            }
                            iArr[next] = d;
                            next = depth2;
                            attributeName = str3;
                        }
                        i++;
                        str3 = attributeName;
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr, next);
                    if (str2 != null && str2.length() != 0) {
                        a = a(context, str2, zVar2, 0.0f, 0.0f);
                    } else if (str3 == null || str3.length() == 0) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next != 2) {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        a = a(context, resources, xmlPullParser, attributeSet, zVar2, str);
                    } else {
                        a = new ae(a(context, str3));
                    }
                    if ((a instanceof BitmapDrawable) || (a instanceof NinePatchDrawable)) {
                        intrinsicWidth = ((long) ((a.getIntrinsicWidth() * 4) * a.getIntrinsicHeight())) + j;
                    } else if (a instanceof ae) {
                        intrinsicWidth = 1024 + j;
                    } else {
                        intrinsicWidth = j;
                    }
                    qVar.a(trimStateSet, a);
                    j = intrinsicWidth;
                }
            }
            qVar.a = j;
            return qVar;
        } else if (name.equals(b[1])) {
            return a(context, xmlPullParser, attributeSet, zVar2);
        } else {
            if (name.equals(b[2])) {
                return a(context, xmlPullParser, attributeSet);
            }
            if (name.equals(b[3])) {
                return a(context, xmlPullParser, attributeSet, zVar2, str);
            }
            if (name.equals(b[4])) {
                return b(context, resources, xmlPullParser, attributeSet, zVar2, str);
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid drawable tag " + name);
        }
    }

    private Drawable a(Context context, String str, z zVar) {
        Object[] objArr = new Object[2];
        try {
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
                        asAttributeSet = null;
                    }
                } catch (Throwable th3) {
                    asAttributeSet = null;
                    a = null;
                }
                objArr[0] = a;
                objArr[1] = asAttributeSet;
            }
        } catch (XmlPullParserException e) {
        } catch (IOException e2) {
        }
        if (objArr[0] == null || objArr[1] == null) {
            return null;
        }
        Drawable a2;
        try {
            a2 = a(context, context.getResources(), (XmlPullParser) objArr[0], (AttributeSet) objArr[1], zVar, str);
        } catch (XmlPullParserException e3) {
            a2 = null;
        } catch (Exception e4) {
            a2 = null;
        }
        ((d) objArr[0]).close();
        return a2;
    }

    private Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, z zVar) throws XmlPullParserException, IOException {
        if (xmlPullParser == null || attributeSet == null) {
            return null;
        }
        int depth = xmlPullParser.getDepth() + 1;
        Drawable drawable = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return drawable;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return drawable;
            }
            if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                int i = 0;
                String str = null;
                String str2 = null;
                while (i < 2) {
                    String attributeName;
                    try {
                        attributeName = attributeSet.getAttributeName(i);
                    } catch (Exception e) {
                        attributeName = null;
                    }
                    if (attributeName == null) {
                        attributeName = str;
                    } else if (attributeName.equals("drawable")) {
                        str2 = attributeSet.getAttributeValue(i);
                        attributeName = str;
                    } else {
                        attributeName = attributeSet.getAttributeValue(i);
                    }
                    i++;
                    str = attributeName;
                }
                if (!(str2 == null || str2.length() == 0)) {
                    drawable = a(context, str2, zVar, 0.0f, 0.0f);
                }
                if (drawable instanceof BitmapDrawable) {
                    if (str.equals("repeat_x")) {
                        ((BitmapDrawable) drawable).setTileModeX(TileMode.REPEAT);
                    } else if (str.equals("repeat_y")) {
                        ((BitmapDrawable) drawable).setTileModeY(TileMode.REPEAT);
                    } else if (str.equals("repeat_xy")) {
                        ((BitmapDrawable) drawable).setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
                    }
                }
                if (drawable != null) {
                    return drawable;
                }
            }
        }
    }

    private static int a(Context context, String str) {
        if (str.startsWith("#")) {
            return Color.parseColor(str);
        }
        return e.a(context, str);
    }

    private static Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (xmlPullParser == null || attributeSet == null) {
            return null;
        }
        Drawable oVar = new o();
        try {
            int i;
            String str;
            int intValue;
            m mVar = (m) oVar.getConstantState();
            String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "shape");
            String str2 = "rectangle";
            if (attributeValue != null) {
                str2 = attributeValue;
            }
            if (str2.equals("rectangle")) {
                i = 0;
            } else if (str2.equals("oval")) {
                i = 1;
            } else if (str2.equals("line")) {
                i = 2;
            } else if (str2.equals("ring")) {
                i = 3;
            } else {
                i = 0;
            }
            if (i == 3) {
                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "innerRadius");
                str = SettingsConst.FALSE;
                if (str2 != null) {
                    str = str2;
                }
                intValue = Integer.valueOf(str).intValue();
                mVar.v = intValue;
                if (intValue == -1) {
                    str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "innerRadiusRatio");
                    str = SettingsConst.FALSE;
                    if (str2 != null) {
                        str = str2;
                    }
                    mVar.t = Float.valueOf(str).floatValue();
                }
                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "thickness");
                str = SettingsConst.FALSE;
                if (str2 != null) {
                    str = str2;
                }
                intValue = Integer.valueOf(str).intValue();
                mVar.w = intValue;
                if (intValue == -1) {
                    str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "thicknessRatio");
                    str = SettingsConst.FALSE;
                    if (str2 != null) {
                        str = str2;
                    }
                    mVar.u = Float.valueOf(str).floatValue();
                }
                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "useLevel");
                str = SettingsConst.FALSE;
                if (str2 != null) {
                    str = str2;
                }
                mVar.B = Boolean.valueOf(str).booleanValue();
            }
            oVar.d = null;
            oVar.a.b = i;
            int depth = xmlPullParser.getDepth() + 1;
            while (true) {
                intValue = xmlPullParser.next();
                if (intValue != 1) {
                    int depth2 = xmlPullParser.getDepth();
                    if (depth2 >= depth || intValue != 3) {
                        if (intValue == 2 && depth2 <= depth) {
                            str = xmlPullParser.getName();
                            m mVar2;
                            if (str.equals("size")) {
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", Style.WIDTH);
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                i = (int) e.b(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", Style.HEIGHT);
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                intValue = (int) e.b(context, str);
                                mVar2 = oVar.a;
                                mVar2.r = i;
                                mVar2.s = intValue;
                            } else if (str.equals("gradient")) {
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "startColor");
                                str = "#00000000";
                                if (str2 != null) {
                                    str = str2;
                                }
                                r6 = a(context, str);
                                attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor");
                                str = "#00000000";
                                if (attributeValue != null) {
                                    str = attributeValue;
                                }
                                r7 = a(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "endColor");
                                str = "#00000000";
                                if (str2 != null) {
                                    str = str2;
                                }
                                r8 = a(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "type");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                int intValue2 = Integer.valueOf(str).intValue();
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "centerX");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                float b = e.b(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "centerY");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                r2 = e.b(context, str);
                                mVar2 = oVar.a;
                                mVar2.x = b;
                                mVar2.y = r2;
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "useLevel");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                oVar.a.A = Boolean.valueOf(str).booleanValue();
                                oVar.a.c = intValue2;
                                oVar.c = true;
                                if (intValue2 == 0) {
                                    str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "angle");
                                    str = SettingsConst.FALSE;
                                    if (str2 != null) {
                                        str = str2;
                                    }
                                    intValue = Float.valueOf(str).intValue() % 360;
                                    if (intValue % 45 == 0) {
                                        switch (intValue) {
                                            case 0:
                                                mVar.d = n.LEFT_RIGHT;
                                                break;
                                            case 45:
                                                mVar.d = n.BL_TR;
                                                break;
                                            case 90:
                                                mVar.d = n.BOTTOM_TOP;
                                                break;
                                            case 135:
                                                mVar.d = n.BR_TL;
                                                break;
                                            case 180:
                                                mVar.d = n.RIGHT_LEFT;
                                                break;
                                            case 225:
                                                mVar.d = n.TR_BL;
                                                break;
                                            case 270:
                                                mVar.d = n.TOP_BOTTOM;
                                                break;
                                            case 315:
                                                mVar.d = n.TL_BR;
                                                break;
                                        }
                                    }
                                    throw new XmlPullParserException(attributeSet.getPositionDescription() + "<gradient> tag requires 'angle' attribute to be a multiple of 45");
                                }
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "gradientRadius");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                oVar.a.z = e.b(context, str);
                                if (attributeValue != null) {
                                    mVar.e = new int[]{r6, r7, r8};
                                    float[] fArr = new float[3];
                                    fArr[0] = 0.0f;
                                    fArr[1] = mVar.x != 0.5f ? mVar.x : mVar.y;
                                    fArr[2] = IPictureView.DEFAULT_MIN_SCALE;
                                    mVar.h = fArr;
                                } else {
                                    mVar.e = new int[]{r6, r8};
                                }
                            } else if (str.equals("solid")) {
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "color");
                                str = "#00000000";
                                if (str2 != null) {
                                    str = str2;
                                }
                                intValue = a(context, str);
                                mVar2 = oVar.a;
                                mVar2.i = true;
                                mVar2.j = intValue;
                                mVar2.e = null;
                                oVar.b.setColor(intValue);
                            } else if (str.equals("stroke")) {
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", Style.WIDTH);
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                i = (int) e.b(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "color");
                                str = "#00000000";
                                if (str2 != null) {
                                    str = str2;
                                }
                                r6 = a(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "dashWidth");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                float b2 = e.b(context, str);
                                if (b2 != 0.0f) {
                                    str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "dashGap");
                                    str = SettingsConst.FALSE;
                                    if (str2 != null) {
                                        str = str2;
                                    }
                                    oVar.a(i, r6, b2, (float) ((int) e.b(context, str)));
                                } else {
                                    oVar.a(i, r6, 0.0f, 0.0f);
                                }
                            } else if (str.equals("corners")) {
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "radius");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                i = (int) e.b(context, str);
                                r2 = (float) i;
                                mVar2 = oVar.a;
                                if (r2 < 0.0f) {
                                    r2 = 0.0f;
                                }
                                mVar2.o = r2;
                                mVar2.p = null;
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "topLeftRadius");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                r6 = (int) e.b(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "topRightRadius");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                r7 = (int) e.b(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "bottomLeftRadius");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                r8 = (int) e.b(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "bottomRightRadius");
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                intValue = (int) e.b(context, str);
                                if (!(r6 == i || r7 == i || r8 == i || intValue == i)) {
                                    if (r6 != 0 || r7 != 0 || r8 != 0 || intValue != 0) {
                                        oVar.a.p = new float[]{(float) r6, (float) r6, (float) r7, (float) r7, (float) r8, (float) r8, (float) intValue, (float) intValue};
                                    }
                                }
                            } else if (str.equals("padding")) {
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", Style.LEFT);
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                r6 = (int) e.b(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", Style.TOP);
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                r7 = (int) e.b(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", Style.RIGHT);
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                r8 = (int) e.b(context, str);
                                str2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", Style.BOTTOM);
                                str = SettingsConst.FALSE;
                                if (str2 != null) {
                                    str = str2;
                                }
                                mVar.q = new Rect(r6, r7, r8, (int) e.b(context, str));
                            }
                        }
                    }
                }
                return oVar;
            }
        } catch (Exception e) {
        }
    }

    private Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, z zVar, String str) throws XmlPullParserException, Exception {
        if (xmlPullParser == null || attributeSet == null) {
            return null;
        }
        float f = ((float) context.getResources().getDisplayMetrics().densityDpi) / ((float) (zVar.d > 0 ? zVar.d : 240));
        Drawable drawable = null;
        Drawable sVar = new s();
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = null;
        String str2 = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                break;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                break;
            } else if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("patch")) {
                int i;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                String str3 = null;
                String str4 = str2;
                int i6 = 0;
                while (i6 < attributeSet.getAttributeCount()) {
                    int i7;
                    String str5;
                    String attributeName = attributeSet.getAttributeName(i6);
                    if (attributeName != null) {
                        if (attributeName.equals("drawable")) {
                            str4 = attributeSet.getAttributeValue(i6);
                            next = i2;
                            depth2 = i3;
                            i = i4;
                            i7 = i5;
                            str5 = str3;
                        } else if (attributeName.equals("x")) {
                            next = i2;
                            depth2 = i3;
                            i = i4;
                            i7 = (int) (((float) Integer.valueOf(attributeSet.getAttributeValue(i6)).intValue()) * f);
                            str5 = str3;
                        } else if (attributeName.equals("y")) {
                            next = i2;
                            depth2 = i3;
                            i = (int) (((float) Integer.valueOf(attributeSet.getAttributeValue(i6)).intValue()) * f);
                            i7 = i5;
                            str5 = str3;
                        } else if (attributeName.equals(Style.WIDTH)) {
                            next = i2;
                            depth2 = (int) (((float) Integer.valueOf(attributeSet.getAttributeValue(i6)).intValue()) * f);
                            i = i4;
                            i7 = i5;
                            str5 = str3;
                        } else if (attributeName.equals(Style.HEIGHT)) {
                            next = (int) (((float) Integer.valueOf(attributeSet.getAttributeValue(i6)).intValue()) * f);
                            depth2 = i3;
                            i = i4;
                            i7 = i5;
                            str5 = str3;
                        } else if (attributeName.equals("name")) {
                            next = i2;
                            depth2 = i3;
                            i = i4;
                            i7 = i5;
                            str5 = attributeSet.getAttributeValue(i6);
                        }
                        i6++;
                        i2 = next;
                        i3 = depth2;
                        i4 = i;
                        i5 = i7;
                        str3 = str5;
                    }
                    next = i2;
                    depth2 = i3;
                    i = i4;
                    i7 = i5;
                    str5 = str3;
                    i6++;
                    i2 = next;
                    i3 = depth2;
                    i4 = i;
                    i5 = i7;
                    str3 = str5;
                }
                if (!(str4 == null || str4.length() == 0 || r8 != null)) {
                    drawable = a(context, str4, zVar, 0.0f, 0.0f);
                }
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    Drawable drawable2 = null;
                    if (obj == null) {
                        if (bitmap != null) {
                            depth2 = bitmap.getWidth();
                            i = bitmap.getHeight();
                            if (i5 >= 0 && i4 >= 0 && i5 + i3 <= depth2 && i4 + i2 <= i) {
                                drawable2 = new w(bitmap, new Rect(i5, i4, i5 + i3, i4 + i2));
                                sVar.a(str3, drawable2);
                            }
                        }
                        if (drawable2 == null) {
                            obj = 1;
                        }
                    }
                    if (obj != null || r2 == null) {
                        drawable2 = b(context, str.substring(str.lastIndexOf(File.separator) + 1), zVar, 0.0f, 0.0f);
                        if (drawable2 instanceof s) {
                            Drawable drawable3;
                            s sVar2 = (s) drawable2;
                            if (sVar2.a != null) {
                                w wVar = (w) sVar2.a.get(str3);
                                if (wVar != null) {
                                    drawable3 = (w) wVar.getConstantState().newDrawable().mutate();
                                    if (sVar2.c) {
                                        r.a().a.a(drawable3);
                                    }
                                    if (drawable3 == null) {
                                        Log.e("PatchListDrawable", "the return value of getDrawable is null !!");
                                    }
                                    sVar.a(str3, drawable3);
                                    str2 = str4;
                                }
                            }
                            drawable3 = null;
                            if (drawable3 == null) {
                                Log.e("PatchListDrawable", "the return value of getDrawable is null !!");
                            }
                            sVar.a(str3, drawable3);
                            str2 = str4;
                        }
                    }
                    str2 = str4;
                } else {
                    throw new IOException("Just enable use bitmap!");
                }
            }
        }
        sVar.b = 1024;
        return sVar;
    }

    private Drawable b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, z zVar, String str) throws XmlPullParserException, Exception {
        if (xmlPullParser == null || attributeSet == null) {
            return null;
        }
        Drawable a;
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "insetLeft");
        String str2 = SettingsConst.FALSE;
        if (attributeValue != null) {
            str2 = attributeValue;
        }
        int b = (int) e.b(context, str2);
        attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "insetTop");
        str2 = SettingsConst.FALSE;
        if (attributeValue != null) {
            str2 = attributeValue;
        }
        int b2 = (int) e.b(context, str2);
        attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "insetRight");
        str2 = SettingsConst.FALSE;
        if (attributeValue != null) {
            str2 = attributeValue;
        }
        int b3 = (int) e.b(context, str2);
        attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "insetBottom");
        str2 = SettingsConst.FALSE;
        if (attributeValue != null) {
            str2 = attributeValue;
        }
        int b4 = (int) e.b(context, str2);
        String attributeValue2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawable");
        if (attributeValue2 == null || attributeValue2.length() == 0) {
            int next;
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <inset> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            a = a(context, resources, xmlPullParser, attributeSet, zVar, str);
        } else {
            a = a(context, attributeValue2, zVar, 0.0f, 0.0f);
        }
        if (a == null) {
            return null;
        }
        Drawable kVar = new k(a, b, b2, b3, b4);
        kVar.a = (long) (a.getIntrinsicHeight() * (a.getIntrinsicWidth() * 4));
        return kVar;
    }
}
