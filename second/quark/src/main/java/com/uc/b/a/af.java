package com.uc.b.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.uc.imagecodec.export.IPictureView;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class af extends Drawable {
    private static float a = IPictureView.DEFAULT_MIN_SCALE;
    private static final Map<String, HashMap<String, SoftReference<af>>> c = new HashMap();
    private static /* synthetic */ int[] j;
    private static /* synthetic */ int[] k;
    private final Paint b;
    private boolean d;
    private int e;
    private int f;
    private final ab g;
    private int h;
    private final n i;

    private static /* synthetic */ int[] b() {
        int[] iArr = j;
        if (iArr == null) {
            iArr = new int[ac.values().length];
            try {
                iArr[ac.A.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ac.CIRCLE.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ac.CLIP_PATH.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ac.DEFS.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ac.DESC.ordinal()] = 6;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ac.ELLIPSE.ordinal()] = 7;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ac.FE_BLEND.ordinal()] = 8;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ac.FE_COLOR_MATRIX.ordinal()] = 9;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ac.FE_GAUSSIAN_BLUR.ordinal()] = 10;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[ac.FE_MERGE.ordinal()] = 11;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[ac.FE_MERGE_NODE.ordinal()] = 12;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[ac.FE_OFFSET.ordinal()] = 13;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[ac.FILTER.ordinal()] = 14;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[ac.G.ordinal()] = 15;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[ac.IMAGE.ordinal()] = 16;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[ac.LINE.ordinal()] = 17;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[ac.LINEAR_GRADIENT.ordinal()] = 18;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[ac.MARKER.ordinal()] = 19;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[ac.MASK.ordinal()] = 20;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[ac.PATH.ordinal()] = 21;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[ac.PATTERN.ordinal()] = 22;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[ac.POLYGON.ordinal()] = 23;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[ac.POLYLINE.ordinal()] = 24;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[ac.RADIAL_GRADIENT.ordinal()] = 25;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[ac.RECT.ordinal()] = 26;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[ac.SET.ordinal()] = 27;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[ac.SOLID_COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[ac.STOP.ordinal()] = 29;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[ac.STYLE.ordinal()] = 30;
            } catch (NoSuchFieldError e29) {
            }
            try {
                iArr[ac.SVG.ordinal()] = 1;
            } catch (NoSuchFieldError e30) {
            }
            try {
                iArr[ac.SWITCH.ordinal()] = 31;
            } catch (NoSuchFieldError e31) {
            }
            try {
                iArr[ac.SYMBOL.ordinal()] = 32;
            } catch (NoSuchFieldError e32) {
            }
            try {
                iArr[ac.TEXT.ordinal()] = 33;
            } catch (NoSuchFieldError e33) {
            }
            try {
                iArr[ac.TEXT_PATH.ordinal()] = 34;
            } catch (NoSuchFieldError e34) {
            }
            try {
                iArr[ac.TITLE.ordinal()] = 35;
            } catch (NoSuchFieldError e35) {
            }
            try {
                iArr[ac.TREF.ordinal()] = 36;
            } catch (NoSuchFieldError e36) {
            }
            try {
                iArr[ac.TSPAN.ordinal()] = 37;
            } catch (NoSuchFieldError e37) {
            }
            try {
                iArr[ac.USE.ordinal()] = 38;
            } catch (NoSuchFieldError e38) {
            }
            try {
                iArr[ac.VIEW.ordinal()] = 39;
            } catch (NoSuchFieldError e39) {
            }
            j = iArr;
        }
        return iArr;
    }

    private static /* synthetic */ int[] c() {
        int[] iArr = k;
        if (iArr == null) {
            iArr = new int[p.values().length];
            try {
                iArr[p.FILL.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[p.FILL_FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[p.FILL_OPACITY.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[p.FILL_RULE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[p.OPACITY.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[p.STROKE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[p.STROKE_DASH_ARRAY.ordinal()] = 12;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[p.STROKE_DASH_OFFSET.ordinal()] = 13;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[p.STROKE_LINE_CAP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[p.STROKE_LINE_JOIN.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[p.STROKE_MITER_LIMIT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[p.STROKE_OPACITY.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[p.STROKE_WIDTH.ordinal()] = 8;
            } catch (NoSuchFieldError e13) {
            }
            k = iArr;
        }
        return iArr;
    }

    public static void a(float f) {
        a = f;
    }

    public static Drawable a(HashMap<String, ?> hashMap, HashMap<String, ?> hashMap2, o oVar, String str, String str2, float f, float f2) {
        if (str == null || str2 == null) {
            return null;
        }
        Drawable drawable;
        Drawable a;
        System.currentTimeMillis();
        if (!(str == null || str2 == null)) {
            HashMap hashMap3 = (HashMap) c.get(str);
            if (hashMap3 != null) {
                SoftReference softReference = (SoftReference) hashMap3.get(str2);
                if (softReference != null) {
                    drawable = (af) softReference.get();
                    if (drawable == null) {
                        return drawable;
                    }
                    a = a(hashMap, hashMap2, oVar, str2, f, f2);
                    if (a != null) {
                        if (str != null || str2 == null || a == null) {
                            return a;
                        }
                        hashMap3 = (HashMap) c.get(str);
                        if (hashMap3 == null) {
                            hashMap3 = new HashMap();
                            hashMap3.put(str2, new SoftReference(a));
                            c.put(str, hashMap3);
                            return a;
                        }
                        SoftReference softReference2 = (SoftReference) hashMap3.get(str2);
                        if (softReference2 == null) {
                            hashMap3.put(str2, new SoftReference(a));
                            return a;
                        } else if (((af) softReference2.get()) == null) {
                            hashMap3.put(str2, new SoftReference(a));
                        }
                    }
                    return a;
                }
            }
        }
        drawable = null;
        if (drawable == null) {
            return drawable;
        }
        a = a(hashMap, hashMap2, oVar, str2, f, f2);
        if (a != null) {
            if (str != null) {
            }
            return a;
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.uc.b.a.af a(java.util.HashMap<java.lang.String, ?> r15, java.util.HashMap<java.lang.String, ?> r16, com.uc.b.a.o r17, java.lang.String r18, float r19, float r20) {
        /*
        if (r15 == 0) goto L_0x000a;
    L_0x0002:
        r0 = r18;
        r2 = r15.get(r0);
        if (r2 != 0) goto L_0x000c;
    L_0x000a:
        r2 = 0;
    L_0x000b:
        return r2;
    L_0x000c:
        r3 = com.uc.b.a.o.STRING;
        r0 = r17;
        if (r0 != r3) goto L_0x007c;
    L_0x0012:
        r3 = new com.uc.b.a.a;
        r2 = (java.lang.String) r2;
        r3.<init>(r2);
        r2 = r3;
    L_0x001a:
        r13 = new java.io.DataInputStream;
        r13.<init>(r2);
        r3 = 0;
        r2 = r13.readUnsignedByte();	 Catch:{ IOException -> 0x00a4 }
        r4 = (char) r2;	 Catch:{ IOException -> 0x00a4 }
        r2 = 64;
        if (r4 != r2) goto L_0x0498;
    L_0x0029:
        r2 = r13.readUTF();	 Catch:{ IOException -> 0x00a4 }
        if (r16 != 0) goto L_0x049c;
    L_0x002f:
        r2 = r15.get(r2);	 Catch:{ IOException -> 0x00a4 }
        if (r2 == 0) goto L_0x0498;
    L_0x0035:
        r4 = com.uc.b.a.o.STRING;	 Catch:{ IOException -> 0x00a4 }
        r0 = r17;
        if (r0 != r4) goto L_0x0085;
    L_0x003b:
        r4 = new com.uc.b.a.a;	 Catch:{ IOException -> 0x00a4 }
        r2 = (java.lang.String) r2;	 Catch:{ IOException -> 0x00a4 }
        r4.<init>(r2);	 Catch:{ IOException -> 0x00a4 }
        r2 = r4;
    L_0x0043:
        r4 = new java.io.DataInputStream;	 Catch:{ IOException -> 0x00a4 }
        r4.<init>(r2);	 Catch:{ IOException -> 0x00a4 }
        r2 = r4.readUnsignedByte();	 Catch:{ IOException -> 0x00a4 }
        r2 = (char) r2;	 Catch:{ IOException -> 0x00a4 }
        r12 = r4;
    L_0x004e:
        r4 = 58;
        if (r2 != r4) goto L_0x0495;
    L_0x0052:
        r14 = new java.util.ArrayList;	 Catch:{ IOException -> 0x00a4 }
        r14.<init>();	 Catch:{ IOException -> 0x00a4 }
        r5 = b(r12);	 Catch:{ IOException -> 0x00a4 }
        r4 = r5.length;	 Catch:{ IOException -> 0x00a4 }
        r6 = 2;
        if (r4 != r6) goto L_0x008e;
    L_0x005f:
        r4 = new com.uc.b.a.ab;	 Catch:{ IOException -> 0x00a4 }
        r6 = 0;
        r6 = r5[r6];	 Catch:{ IOException -> 0x00a4 }
        r7 = 1;
        r5 = r5[r7];	 Catch:{ IOException -> 0x00a4 }
        r4.<init>(r6, r5);	 Catch:{ IOException -> 0x00a4 }
    L_0x006a:
        r10 = new com.uc.b.a.af;	 Catch:{ IOException -> 0x00a4 }
        r0 = r19;
        r1 = r20;
        r10.<init>(r4, r0, r1);	 Catch:{ IOException -> 0x00a4 }
        r14.add(r4);	 Catch:{ IOException -> 0x00ed }
    L_0x0076:
        r3 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        if (r2 != r3) goto L_0x00aa;
    L_0x007a:
        r2 = r10;
        goto L_0x000b;
    L_0x007c:
        r3 = new java.io.ByteArrayInputStream;
        r2 = (byte[]) r2;
        r3.<init>(r2);
        r2 = r3;
        goto L_0x001a;
    L_0x0085:
        r4 = new java.io.ByteArrayInputStream;	 Catch:{ IOException -> 0x00a4 }
        r2 = (byte[]) r2;	 Catch:{ IOException -> 0x00a4 }
        r4.<init>(r2);	 Catch:{ IOException -> 0x00a4 }
        r2 = r4;
        goto L_0x0043;
    L_0x008e:
        r4 = r5.length;	 Catch:{ IOException -> 0x00a4 }
        r6 = 4;
        if (r4 != r6) goto L_0x00a8;
    L_0x0092:
        r4 = new com.uc.b.a.ab;	 Catch:{ IOException -> 0x00a4 }
        r6 = 0;
        r6 = r5[r6];	 Catch:{ IOException -> 0x00a4 }
        r7 = 1;
        r7 = r5[r7];	 Catch:{ IOException -> 0x00a4 }
        r8 = 2;
        r8 = r5[r8];	 Catch:{ IOException -> 0x00a4 }
        r9 = 3;
        r5 = r5[r9];	 Catch:{ IOException -> 0x00a4 }
        r4.<init>(r6, r7, r8, r5);	 Catch:{ IOException -> 0x00a4 }
        goto L_0x006a;
    L_0x00a4:
        r2 = move-exception;
        r2 = r3;
        goto L_0x000b;
    L_0x00a8:
        r4 = 0;
        goto L_0x006a;
    L_0x00aa:
        r2 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r11 = (char) r2;	 Catch:{ IOException -> 0x00ed }
        switch(r11) {
            case 97: goto L_0x039a;
            case 100: goto L_0x03bc;
            case 110: goto L_0x00b4;
            case 112: goto L_0x03d5;
            case 115: goto L_0x017c;
            case 116: goto L_0x02b2;
            case 118: goto L_0x03d8;
            case 122: goto L_0x042c;
            default: goto L_0x00b2;
        };	 Catch:{ IOException -> 0x00ed }
    L_0x00b2:
        r2 = r11;
        goto L_0x0076;
    L_0x00b4:
        r2 = 0;
        r3 = com.uc.b.a.ac.values();	 Catch:{ IOException -> 0x00ed }
        r4 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r3 = r3[r4];	 Catch:{ IOException -> 0x00ed }
        r4 = b();	 Catch:{ IOException -> 0x00ed }
        r3 = r3.ordinal();	 Catch:{ IOException -> 0x00ed }
        r3 = r4[r3];	 Catch:{ IOException -> 0x00ed }
        switch(r3) {
            case 3: goto L_0x012b;
            case 7: goto L_0x0144;
            case 15: goto L_0x0175;
            case 17: goto L_0x00d3;
            case 21: goto L_0x0162;
            case 23: goto L_0x0169;
            case 24: goto L_0x016f;
            case 26: goto L_0x00f3;
            default: goto L_0x00cc;
        };	 Catch:{ IOException -> 0x00ed }
    L_0x00cc:
        if (r2 == 0) goto L_0x00d1;
    L_0x00ce:
        r14.add(r2);	 Catch:{ IOException -> 0x00ed }
    L_0x00d1:
        r2 = r11;
        goto L_0x0076;
    L_0x00d3:
        r3 = b(r12);	 Catch:{ IOException -> 0x00ed }
        r2 = r3.length;	 Catch:{ IOException -> 0x00ed }
        r4 = 4;
        if (r2 != r4) goto L_0x00f1;
    L_0x00db:
        r2 = new com.uc.b.a.w;	 Catch:{ IOException -> 0x00ed }
        r4 = 0;
        r4 = r3[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 1;
        r5 = r3[r5];	 Catch:{ IOException -> 0x00ed }
        r6 = 2;
        r6 = r3[r6];	 Catch:{ IOException -> 0x00ed }
        r7 = 3;
        r3 = r3[r7];	 Catch:{ IOException -> 0x00ed }
        r2.<init>(r4, r5, r6, r3);	 Catch:{ IOException -> 0x00ed }
        goto L_0x00cc;
    L_0x00ed:
        r2 = move-exception;
        r2 = r10;
        goto L_0x000b;
    L_0x00f1:
        r2 = 0;
        goto L_0x00cc;
    L_0x00f3:
        r8 = b(r12);	 Catch:{ IOException -> 0x00ed }
        r2 = r8.length;	 Catch:{ IOException -> 0x00ed }
        r3 = 4;
        if (r2 != r3) goto L_0x010d;
    L_0x00fb:
        r2 = new com.uc.b.a.aa;	 Catch:{ IOException -> 0x00ed }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = r8[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 2;
        r5 = r8[r5];	 Catch:{ IOException -> 0x00ed }
        r6 = 3;
        r6 = r8[r6];	 Catch:{ IOException -> 0x00ed }
        r2.<init>(r3, r4, r5, r6);	 Catch:{ IOException -> 0x00ed }
        goto L_0x00cc;
    L_0x010d:
        r2 = r8.length;	 Catch:{ IOException -> 0x00ed }
        r3 = 6;
        if (r2 != r3) goto L_0x0129;
    L_0x0111:
        r2 = new com.uc.b.a.aa;	 Catch:{ IOException -> 0x00ed }
        r3 = 0;
        r3 = r8[r3];	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = r8[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 2;
        r5 = r8[r5];	 Catch:{ IOException -> 0x00ed }
        r6 = 3;
        r6 = r8[r6];	 Catch:{ IOException -> 0x00ed }
        r7 = 4;
        r7 = r8[r7];	 Catch:{ IOException -> 0x00ed }
        r9 = 5;
        r8 = r8[r9];	 Catch:{ IOException -> 0x00ed }
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ IOException -> 0x00ed }
        goto L_0x00cc;
    L_0x0129:
        r2 = 0;
        goto L_0x00cc;
    L_0x012b:
        r3 = b(r12);	 Catch:{ IOException -> 0x00ed }
        r2 = r3.length;	 Catch:{ IOException -> 0x00ed }
        r4 = 3;
        if (r2 != r4) goto L_0x0142;
    L_0x0133:
        r2 = new com.uc.b.a.t;	 Catch:{ IOException -> 0x00ed }
        r4 = 0;
        r4 = r3[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 1;
        r5 = r3[r5];	 Catch:{ IOException -> 0x00ed }
        r6 = 2;
        r3 = r3[r6];	 Catch:{ IOException -> 0x00ed }
        r2.<init>(r4, r5, r3);	 Catch:{ IOException -> 0x00ed }
        goto L_0x00cc;
    L_0x0142:
        r2 = 0;
        goto L_0x00cc;
    L_0x0144:
        r3 = b(r12);	 Catch:{ IOException -> 0x00ed }
        r2 = r3.length;	 Catch:{ IOException -> 0x00ed }
        r4 = 4;
        if (r2 != r4) goto L_0x015f;
    L_0x014c:
        r2 = new com.uc.b.a.u;	 Catch:{ IOException -> 0x00ed }
        r4 = 0;
        r4 = r3[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 1;
        r5 = r3[r5];	 Catch:{ IOException -> 0x00ed }
        r6 = 2;
        r6 = r3[r6];	 Catch:{ IOException -> 0x00ed }
        r7 = 3;
        r3 = r3[r7];	 Catch:{ IOException -> 0x00ed }
        r2.<init>(r4, r5, r6, r3);	 Catch:{ IOException -> 0x00ed }
        goto L_0x00cc;
    L_0x015f:
        r2 = 0;
        goto L_0x00cc;
    L_0x0162:
        r2 = new com.uc.b.a.x;	 Catch:{ IOException -> 0x00ed }
        r2.<init>();	 Catch:{ IOException -> 0x00ed }
        goto L_0x00cc;
    L_0x0169:
        r2 = com.uc.b.a.y.a(r12);	 Catch:{ IOException -> 0x00ed }
        goto L_0x00cc;
    L_0x016f:
        r2 = com.uc.b.a.z.a(r12);	 Catch:{ IOException -> 0x00ed }
        goto L_0x00cc;
    L_0x0175:
        r2 = new com.uc.b.a.v;	 Catch:{ IOException -> 0x00ed }
        r2.<init>();	 Catch:{ IOException -> 0x00ed }
        goto L_0x00cc;
    L_0x017c:
        r2 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r3 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r2 = r14.get(r2);	 Catch:{ IOException -> 0x00ed }
        r2 = (com.uc.b.a.c) r2;	 Catch:{ IOException -> 0x00ed }
        r4 = c();	 Catch:{ IOException -> 0x00ed }
        r5 = com.uc.b.a.p.values();	 Catch:{ IOException -> 0x00ed }
        r3 = r5[r3];	 Catch:{ IOException -> 0x00ed }
        r3 = r3.ordinal();	 Catch:{ IOException -> 0x00ed }
        r3 = r4[r3];	 Catch:{ IOException -> 0x00ed }
        switch(r3) {
            case 1: goto L_0x01a0;
            case 2: goto L_0x01b6;
            case 3: goto L_0x01d2;
            case 4: goto L_0x01ea;
            case 5: goto L_0x0200;
            case 6: goto L_0x0203;
            case 7: goto L_0x0219;
            case 8: goto L_0x022f;
            case 9: goto L_0x0245;
            case 10: goto L_0x025d;
            case 11: goto L_0x0275;
            case 12: goto L_0x028b;
            case 13: goto L_0x029d;
            default: goto L_0x019d;
        };	 Catch:{ IOException -> 0x00ed }
    L_0x019d:
        r2 = r11;
        goto L_0x0076;
    L_0x01a0:
        r3 = com.uc.b.a.p.OPACITY;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = r13.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x01b6:
        r3 = r13.readBoolean();	 Catch:{ IOException -> 0x00ed }
        if (r3 != 0) goto L_0x019d;
    L_0x01bc:
        r3 = com.uc.b.a.p.FILL;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = r13.readInt();	 Catch:{ IOException -> 0x00ed }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x01d2:
        r3 = com.uc.b.a.p.FILL_RULE;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = com.uc.b.a.h.values();	 Catch:{ IOException -> 0x00ed }
        r7 = r12.readByte();	 Catch:{ IOException -> 0x00ed }
        r6 = r6[r7];	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x01ea:
        r3 = com.uc.b.a.p.FILL_OPACITY;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = r13.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x0200:
        r2 = r11;
        goto L_0x0076;
    L_0x0203:
        r3 = com.uc.b.a.p.STROKE;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = r13.readInt();	 Catch:{ IOException -> 0x00ed }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x0219:
        r3 = com.uc.b.a.p.STROKE_OPACITY;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = r13.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x022f:
        r3 = com.uc.b.a.p.STROKE_WIDTH;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = r12.readFloat();	 Catch:{ IOException -> 0x00ed }
        r6 = java.lang.Float.valueOf(r6);	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x0245:
        r3 = com.uc.b.a.p.STROKE_LINE_CAP;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = com.uc.b.a.i.values();	 Catch:{ IOException -> 0x00ed }
        r7 = r12.readByte();	 Catch:{ IOException -> 0x00ed }
        r6 = r6[r7];	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x025d:
        r3 = com.uc.b.a.p.STROKE_LINE_JOIN;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = com.uc.b.a.j.values();	 Catch:{ IOException -> 0x00ed }
        r7 = r12.readByte();	 Catch:{ IOException -> 0x00ed }
        r6 = r6[r7];	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x0275:
        r3 = com.uc.b.a.p.STROKE_MITER_LIMIT;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = r12.readFloat();	 Catch:{ IOException -> 0x00ed }
        r6 = java.lang.Float.valueOf(r6);	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x028b:
        r3 = com.uc.b.a.p.STROKE_DASH_ARRAY;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = b(r12);	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x029d:
        r3 = com.uc.b.a.p.STROKE_DASH_OFFSET;	 Catch:{ IOException -> 0x00ed }
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed }
        r5 = 0;
        r6 = r12.readFloat();	 Catch:{ IOException -> 0x00ed }
        r6 = java.lang.Float.valueOf(r6);	 Catch:{ IOException -> 0x00ed }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        goto L_0x019d;
    L_0x02b2:
        r2 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r3 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r4 = b(r12);	 Catch:{ IOException -> 0x00ed }
        r2 = r14.get(r2);	 Catch:{ IOException -> 0x00ed }
        r2 = (com.uc.b.a.c) r2;	 Catch:{ IOException -> 0x00ed }
        r5 = com.uc.b.a.ad.values();	 Catch:{ IOException -> 0x00ed }
        r3 = r5[r3];	 Catch:{ IOException -> 0x00ed }
        r5 = r2.d;	 Catch:{ IOException -> 0x00ed }
        if (r5 != 0) goto L_0x02d5;
    L_0x02ce:
        r5 = new android.graphics.Matrix;	 Catch:{ IOException -> 0x00ed }
        r5.<init>();	 Catch:{ IOException -> 0x00ed }
        r2.d = r5;	 Catch:{ IOException -> 0x00ed }
    L_0x02d5:
        r5 = com.uc.b.a.g.e();	 Catch:{ IOException -> 0x00ed }
        r3 = r3.ordinal();	 Catch:{ IOException -> 0x00ed }
        r3 = r5[r3];	 Catch:{ IOException -> 0x00ed }
        switch(r3) {
            case 1: goto L_0x02e5;
            case 2: goto L_0x0387;
            case 3: goto L_0x034b;
            case 4: goto L_0x0363;
            case 5: goto L_0x0375;
            case 6: goto L_0x032b;
            default: goto L_0x02e2;
        };	 Catch:{ IOException -> 0x00ed }
    L_0x02e2:
        r2 = r11;
        goto L_0x0076;
    L_0x02e5:
        r3 = new android.graphics.Matrix;	 Catch:{ IOException -> 0x00ed }
        r3.<init>();	 Catch:{ IOException -> 0x00ed }
        r5 = 9;
        r5 = new float[r5];	 Catch:{ IOException -> 0x00ed }
        r6 = 0;
        r7 = 0;
        r7 = r4[r7];	 Catch:{ IOException -> 0x00ed }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00ed }
        r6 = 1;
        r7 = 2;
        r7 = r4[r7];	 Catch:{ IOException -> 0x00ed }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00ed }
        r6 = 2;
        r7 = 4;
        r7 = r4[r7];	 Catch:{ IOException -> 0x00ed }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00ed }
        r6 = 3;
        r7 = 1;
        r7 = r4[r7];	 Catch:{ IOException -> 0x00ed }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00ed }
        r6 = 4;
        r7 = 3;
        r7 = r4[r7];	 Catch:{ IOException -> 0x00ed }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00ed }
        r6 = 5;
        r7 = 5;
        r4 = r4[r7];	 Catch:{ IOException -> 0x00ed }
        r5[r6] = r4;	 Catch:{ IOException -> 0x00ed }
        r4 = 6;
        r6 = 0;
        r5[r4] = r6;	 Catch:{ IOException -> 0x00ed }
        r4 = 7;
        r6 = 0;
        r5[r4] = r6;	 Catch:{ IOException -> 0x00ed }
        r4 = 8;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r5[r4] = r6;	 Catch:{ IOException -> 0x00ed }
        r3.setValues(r5);	 Catch:{ IOException -> 0x00ed }
        r2 = r2.d;	 Catch:{ IOException -> 0x00ed }
        r2.preConcat(r3);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x032b:
        r3 = r4.length;	 Catch:{ IOException -> 0x00ed }
        r5 = 1;
        if (r3 != r5) goto L_0x033a;
    L_0x032f:
        r2 = r2.d;	 Catch:{ IOException -> 0x00ed }
        r3 = 0;
        r3 = r4[r3];	 Catch:{ IOException -> 0x00ed }
        r2.preRotate(r3);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x033a:
        r2 = r2.d;	 Catch:{ IOException -> 0x00ed }
        r3 = 0;
        r3 = r4[r3];	 Catch:{ IOException -> 0x00ed }
        r5 = 1;
        r5 = r4[r5];	 Catch:{ IOException -> 0x00ed }
        r6 = 2;
        r4 = r4[r6];	 Catch:{ IOException -> 0x00ed }
        r2.preRotate(r3, r5, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x034b:
        r3 = r2.d;	 Catch:{ IOException -> 0x00ed }
        r2 = 0;
        r5 = r4[r2];	 Catch:{ IOException -> 0x00ed }
        r2 = r4.length;	 Catch:{ IOException -> 0x00ed }
        r6 = 2;
        if (r2 != r6) goto L_0x035f;
    L_0x0354:
        r2 = 1;
        r2 = r4[r2];	 Catch:{ IOException -> 0x00ed }
    L_0x0357:
        r4 = 0;
        r6 = 0;
        r3.preScale(r5, r2, r4, r6);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x035f:
        r2 = 0;
        r2 = r4[r2];	 Catch:{ IOException -> 0x00ed }
        goto L_0x0357;
    L_0x0363:
        r2 = r2.d;	 Catch:{ IOException -> 0x00ed }
        r3 = 0;
        r3 = r4[r3];	 Catch:{ IOException -> 0x00ed }
        r4 = (double) r3;	 Catch:{ IOException -> 0x00ed }
        r4 = java.lang.Math.tan(r4);	 Catch:{ IOException -> 0x00ed }
        r3 = (float) r4;	 Catch:{ IOException -> 0x00ed }
        r4 = 0;
        r2.preSkew(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x0375:
        r2 = r2.d;	 Catch:{ IOException -> 0x00ed }
        r3 = 0;
        r5 = 0;
        r4 = r4[r5];	 Catch:{ IOException -> 0x00ed }
        r4 = (double) r4;	 Catch:{ IOException -> 0x00ed }
        r4 = java.lang.Math.tan(r4);	 Catch:{ IOException -> 0x00ed }
        r4 = (float) r4;	 Catch:{ IOException -> 0x00ed }
        r2.preSkew(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x0387:
        r3 = r2.d;	 Catch:{ IOException -> 0x00ed }
        r2 = 0;
        r5 = r4[r2];	 Catch:{ IOException -> 0x00ed }
        r2 = r4.length;	 Catch:{ IOException -> 0x00ed }
        r6 = 2;
        if (r2 != r6) goto L_0x0398;
    L_0x0390:
        r2 = 1;
        r2 = r4[r2];	 Catch:{ IOException -> 0x00ed }
    L_0x0393:
        r3.preTranslate(r5, r2);	 Catch:{ IOException -> 0x00ed }
        goto L_0x02e2;
    L_0x0398:
        r2 = 0;
        goto L_0x0393;
    L_0x039a:
        r3 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r2 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r2 = r14.get(r2);	 Catch:{ IOException -> 0x00ed }
        r2 = (com.uc.b.a.v) r2;	 Catch:{ IOException -> 0x00ed }
        r3 = r14.get(r3);	 Catch:{ IOException -> 0x00ed }
        r3 = (com.uc.b.a.c) r3;	 Catch:{ IOException -> 0x00ed }
        r4 = r2.c;	 Catch:{ IOException -> 0x00ed }
        r4.add(r3);	 Catch:{ IOException -> 0x00ed }
        r3 = r3.a;	 Catch:{ IOException -> 0x00ed }
        r2 = r2.a;	 Catch:{ IOException -> 0x00ed }
        r3.e = r2;	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x03bc:
        r2 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r3 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r3 = (char) r3;	 Catch:{ IOException -> 0x00ed }
        r4 = b(r12);	 Catch:{ IOException -> 0x00ed }
        r2 = r14.get(r2);	 Catch:{ IOException -> 0x00ed }
        r2 = (com.uc.b.a.x) r2;	 Catch:{ IOException -> 0x00ed }
        r2.a(r3, r4);	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x03d5:
        r2 = r11;
        goto L_0x0076;
    L_0x03d8:
        r2 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r7 = r12.readUnsignedShort();	 Catch:{ IOException -> 0x00ed }
        if (r2 != 0) goto L_0x03f5;
    L_0x03e2:
        r3 = r12.readFloat();	 Catch:{ IOException -> 0x00ed }
        r4 = r12.readFloat();	 Catch:{ IOException -> 0x00ed }
        r5 = r12.readFloat();	 Catch:{ IOException -> 0x00ed }
        r6 = r12.readFloat();	 Catch:{ IOException -> 0x00ed }
        switch(r7) {
            case 4: goto L_0x03f8;
            case 5: goto L_0x03f5;
            case 6: goto L_0x0408;
            default: goto L_0x03f5;
        };	 Catch:{ IOException -> 0x00ed }
    L_0x03f5:
        r2 = r11;
        goto L_0x0076;
    L_0x03f8:
        r2 = r14.get(r2);	 Catch:{ IOException -> 0x00ed }
        r2 = (com.uc.b.a.ab) r2;	 Catch:{ IOException -> 0x00ed }
        r7 = new com.uc.b.a.ae;	 Catch:{ IOException -> 0x00ed }
        r7.<init>(r3, r4, r5, r6);	 Catch:{ IOException -> 0x00ed }
        r2.e = r7;	 Catch:{ IOException -> 0x00ed }
        r2 = r11;
        goto L_0x0076;
    L_0x0408:
        r7 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r8 = r12.readUnsignedByte();	 Catch:{ IOException -> 0x00ed }
        r2 = r14.get(r2);	 Catch:{ IOException -> 0x00ed }
        r0 = r2;
        r0 = (com.uc.b.a.ab) r0;	 Catch:{ IOException -> 0x00ed }
        r9 = r0;
        r2 = com.uc.b.a.k.values();	 Catch:{ IOException -> 0x00ed }
        r7 = r2[r7];	 Catch:{ IOException -> 0x00ed }
        r2 = com.uc.b.a.l.values();	 Catch:{ IOException -> 0x00ed }
        r8 = r2[r8];	 Catch:{ IOException -> 0x00ed }
        r2 = new com.uc.b.a.ae;	 Catch:{ IOException -> 0x00ed }
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ IOException -> 0x00ed }
        r9.e = r2;	 Catch:{ IOException -> 0x00ed }
        goto L_0x03f5;
    L_0x042c:
        r2 = r10.g;	 Catch:{ IOException -> 0x00ed }
        r2 = r2.b;	 Catch:{ IOException -> 0x00ed }
        r2 = r2.width();	 Catch:{ IOException -> 0x00ed }
        r3 = r10.g;	 Catch:{ IOException -> 0x00ed }
        r3 = r3.b;	 Catch:{ IOException -> 0x00ed }
        r3 = r3.height();	 Catch:{ IOException -> 0x00ed }
        r4 = new com.uc.b.a.b;	 Catch:{ IOException -> 0x00ed }
        r4.<init>();	 Catch:{ IOException -> 0x00ed }
        r5 = r10.e;	 Catch:{ IOException -> 0x00ed }
        if (r5 <= 0) goto L_0x0479;
    L_0x0445:
        r5 = r10.f;	 Catch:{ IOException -> 0x00ed }
        if (r5 <= 0) goto L_0x0479;
    L_0x0449:
        r5 = r10.e;	 Catch:{ IOException -> 0x00ed }
        r5 = (float) r5;	 Catch:{ IOException -> 0x00ed }
        r2 = r5 / r2;
        r5 = r10.f;	 Catch:{ IOException -> 0x00ed }
        r5 = (float) r5;	 Catch:{ IOException -> 0x00ed }
        r3 = r5 / r3;
        r4.a(r2, r3);	 Catch:{ IOException -> 0x00ed }
        r2 = r2 + r3;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 / r3;
    L_0x045a:
        r3 = r10.g;	 Catch:{ IOException -> 0x00ed }
        r5 = 1;
        r3.b(r2, r4, r5);	 Catch:{ IOException -> 0x00ed }
        r2 = 0;
        r3 = 0;
        r4 = r10.e;	 Catch:{ IOException -> 0x00ed }
        r5 = r10.f;	 Catch:{ IOException -> 0x00ed }
        super.setBounds(r2, r3, r4, r5);	 Catch:{ IOException -> 0x00ed }
        r2 = r10.g;	 Catch:{ IOException -> 0x00ed }
        r3 = 0;
        r2.a(r3);	 Catch:{ IOException -> 0x00ed }
        r13.close();	 Catch:{ IOException -> 0x00ed }
        if (r12 == r13) goto L_0x00b2;
    L_0x0474:
        r12.close();	 Catch:{ IOException -> 0x00ed }
        goto L_0x00b2;
    L_0x0479:
        r5 = a;	 Catch:{ IOException -> 0x00ed }
        r2 = r2 * r5;
        r2 = java.lang.Math.round(r2);	 Catch:{ IOException -> 0x00ed }
        r10.e = r2;	 Catch:{ IOException -> 0x00ed }
        r2 = a;	 Catch:{ IOException -> 0x00ed }
        r2 = r2 * r3;
        r2 = java.lang.Math.round(r2);	 Catch:{ IOException -> 0x00ed }
        r10.f = r2;	 Catch:{ IOException -> 0x00ed }
        r2 = a;	 Catch:{ IOException -> 0x00ed }
        r3 = a;	 Catch:{ IOException -> 0x00ed }
        r4.a(r2, r3);	 Catch:{ IOException -> 0x00ed }
        r2 = a;	 Catch:{ IOException -> 0x00ed }
        goto L_0x045a;
    L_0x0495:
        r2 = r3;
        goto L_0x000b;
    L_0x0498:
        r2 = r4;
        r12 = r13;
        goto L_0x004e;
    L_0x049c:
        r15 = r16;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.b.a.af.a(java.util.HashMap, java.util.HashMap, com.uc.b.a.o, java.lang.String, float, float):com.uc.b.a.af");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float[] b(java.io.DataInputStream r7) throws java.io.IOException {
        /*
        r6 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r5 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r1 = r7.readUnsignedByte();
        r2 = r7.readUnsignedShort();
        r3 = new float[r2];
        r0 = 0;
        switch(r1) {
            case 0: goto L_0x001f;
            case 1: goto L_0x002d;
            case 2: goto L_0x003b;
            case 3: goto L_0x0048;
            case 4: goto L_0x0056;
            case 5: goto L_0x0064;
            default: goto L_0x0012;
        };
    L_0x0012:
        if (r0 < r2) goto L_0x0067;
    L_0x0014:
        return r3;
    L_0x0015:
        r1 = r0 + 1;
        r4 = r7.readByte();
        r4 = (float) r4;
        r3[r0] = r4;
        r0 = r1;
    L_0x001f:
        if (r0 < r2) goto L_0x0015;
    L_0x0021:
        goto L_0x0014;
    L_0x0022:
        r1 = r0 + 1;
        r4 = r7.readByte();
        r4 = (float) r4;
        r4 = r4 / r5;
        r3[r0] = r4;
        r0 = r1;
    L_0x002d:
        if (r0 < r2) goto L_0x0022;
    L_0x002f:
        goto L_0x0014;
    L_0x0030:
        r1 = r0 + 1;
        r4 = r7.readByte();
        r4 = (float) r4;
        r4 = r4 / r6;
        r3[r0] = r4;
        r0 = r1;
    L_0x003b:
        if (r0 < r2) goto L_0x0030;
    L_0x003d:
        goto L_0x0014;
    L_0x003e:
        r1 = r0 + 1;
        r4 = r7.readShort();
        r4 = (float) r4;
        r3[r0] = r4;
        r0 = r1;
    L_0x0048:
        if (r0 < r2) goto L_0x003e;
    L_0x004a:
        goto L_0x0014;
    L_0x004b:
        r1 = r0 + 1;
        r4 = r7.readShort();
        r4 = (float) r4;
        r4 = r4 / r5;
        r3[r0] = r4;
        r0 = r1;
    L_0x0056:
        if (r0 < r2) goto L_0x004b;
    L_0x0058:
        goto L_0x0014;
    L_0x0059:
        r1 = r0 + 1;
        r4 = r7.readShort();
        r4 = (float) r4;
        r4 = r4 / r6;
        r3[r0] = r4;
        r0 = r1;
    L_0x0064:
        if (r0 < r2) goto L_0x0059;
    L_0x0066:
        goto L_0x0014;
    L_0x0067:
        r1 = r0 + 1;
        r4 = r7.readFloat();
        r3[r0] = r4;
        r0 = r1;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.b.a.af.b(java.io.DataInputStream):float[]");
    }

    private af(ab abVar, float f, float f2) {
        this.b = new Paint(3);
        this.d = false;
        this.h = 255;
        this.i = new n(this);
        this.g = abVar;
        if (f > 0.0f && f2 > 0.0f) {
            this.e = Math.round(f);
            this.f = Math.round(f2);
        }
    }

    private af(af afVar) {
        this.b = new Paint(3);
        this.d = false;
        this.h = 255;
        this.i = new n(this);
        this.g = afVar.g.c();
        this.f = afVar.f;
        this.e = afVar.e;
        super.setBounds(0, 0, this.e, this.f);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        float f = (float) (i3 - i);
        float f2 = (float) (i4 - i2);
        if (f <= 0.0f || f2 <= 0.0f) {
            this.d = true;
            return;
        }
        Rect bounds = getBounds();
        if (!(bounds.left == i && bounds.top == i2 && bounds.right == i3 && bounds.bottom == i4)) {
            if (!(((float) bounds.width()) == f && ((float) bounds.height()) == f2)) {
                float width = f / ((float) bounds.width());
                float height = f2 / ((float) bounds.height());
                b bVar = new b();
                bVar.a(width, height);
                this.g.b((height + width) / 2.0f, bVar, false);
            }
            super.setBounds(i, i2, i3, i4);
        }
        this.e = Math.round(f);
        this.f = Math.round(f2);
        this.d = false;
    }

    public final void setBounds(Rect rect) {
        if (rect != null) {
            setBounds(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public final int getIntrinsicWidth() {
        return this.e;
    }

    public final int getIntrinsicHeight() {
        return this.f;
    }

    public final ConstantState getConstantState() {
        return this.i;
    }

    public final void setAlpha(int i) {
        if (i >= 0 && i <= 255) {
            this.h = i;
            invalidateSelf();
        }
    }

    public final ColorFilter getColorFilter() {
        return this.b.getColorFilter();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        if (!this.d) {
            canvas.save();
            Object obj = null;
            Rect bounds = getBounds();
            canvas.clipRect(bounds);
            canvas.translate((float) bounds.left, (float) bounds.top);
            if (this.h != 255) {
                canvas.saveLayerAlpha(0.0f, 0.0f, (float) bounds.width(), (float) bounds.height(), this.h, 4);
                obj = 1;
            }
            this.g.a(canvas, this.b);
            if (obj != null) {
                canvas.restore();
            }
            canvas.restore();
        }
    }
}
