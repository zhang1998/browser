package com.a.a.a;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: ProGuard */
public final class ea implements ed {
    private static ea i = null;
    boolean a = false;
    int b = -1;
    int c = -1;
    String d = null;
    private int e = -1;
    private float f = 0.0f;
    private float g = 0.0f;
    private Context h = null;

    public static synchronized ea a(Context context) {
        ea eaVar;
        synchronized (ea.class) {
            if (i == null) {
                ar arVar = bb.a(context).c;
                i = new ea(context, arVar.d(), arVar.a(0));
            }
            eaVar = i;
        }
        return eaVar;
    }

    private ea(Context context, String str, int i) {
        this.h = context;
        b(str, i);
    }

    private static float a(String str, int i) {
        int i2 = i * 2;
        if (str == null) {
            return 0.0f;
        }
        return ((float) Integer.valueOf(str.substring(i2, i2 + 5), 16).intValue()) / 1048576.0f;
    }

    private void b(String str, int i) {
        this.e = i;
        String a = bd.a(this.h);
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(str)) {
            this.a = false;
            return;
        }
        try {
            this.f = a(a, 12);
            this.g = a(a, 6);
            float f;
            String[] split;
            int i2;
            int[] iArr;
            if (str.startsWith("SIG7")) {
                if (str != null) {
                    String[] split2 = str.split("\\|");
                    f = 0.0f;
                    if (split2[2].equals("SIG13")) {
                        f = Float.valueOf(split2[3]).floatValue();
                    }
                    if (this.f > f) {
                        this.a = false;
                        return;
                    }
                    float[] fArr;
                    if (split2[0].equals("SIG7")) {
                        split = split2[1].split(",");
                        float[] fArr2 = new float[split.length];
                        for (i2 = 0; i2 < split.length; i2++) {
                            fArr2[i2] = Float.valueOf(split[i2]).floatValue();
                        }
                        fArr = fArr2;
                    } else {
                        fArr = null;
                    }
                    iArr = null;
                    if (split2[4].equals("RPT")) {
                        this.d = "RPT";
                        split2 = split2[5].split(",");
                        iArr = new int[split2.length];
                        for (i2 = 0; i2 < split2.length; i2++) {
                            iArr[i2] = Integer.valueOf(split2[i2]).intValue();
                        }
                    } else if (split2[4].equals("DOM")) {
                        this.a = true;
                        this.d = "DOM";
                        try {
                            split2 = split2[5].split(",");
                            iArr = new int[split2.length];
                            for (i2 = 0; i2 < split2.length; i2++) {
                                iArr[i2] = Integer.valueOf(split2[i2]).intValue();
                            }
                        } catch (Exception e) {
                        }
                    }
                    float f2 = 0.0f;
                    i2 = 0;
                    while (i2 < fArr.length) {
                        f2 += fArr[i2];
                        if (this.g < f2) {
                            break;
                        }
                        i2++;
                    }
                    i2 = -1;
                    if (i2 != -1) {
                        this.a = true;
                        this.c = i2 + 1;
                        if (iArr != null) {
                            this.b = iArr[i2];
                            return;
                        }
                        return;
                    }
                    this.a = false;
                }
            } else if (str.startsWith("FIXED") && str != null) {
                String[] split3 = str.split("\\|");
                f = 0.0f;
                if (split3[2].equals("SIG13")) {
                    f = Float.valueOf(split3[3]).floatValue();
                }
                if (this.f > f) {
                    this.a = false;
                    return;
                }
                int intValue;
                if (split3[0].equals("FIXED")) {
                    intValue = Integer.valueOf(split3[1]).intValue();
                } else {
                    intValue = -1;
                }
                iArr = null;
                if (split3[4].equals("RPT")) {
                    this.d = "RPT";
                    split = split3[5].split(",");
                    iArr = new int[split.length];
                    for (i2 = 0; i2 < split.length; i2++) {
                        iArr[i2] = Integer.valueOf(split[i2]).intValue();
                    }
                } else if (split3[4].equals("DOM")) {
                    this.d = "DOM";
                    this.a = true;
                    try {
                        split = split3[5].split(",");
                        iArr = new int[split.length];
                        for (i2 = 0; i2 < split.length; i2++) {
                            iArr[i2] = Integer.valueOf(split[i2]).intValue();
                        }
                    } catch (Exception e2) {
                    }
                }
                if (intValue != -1) {
                    this.a = true;
                    this.c = intValue;
                    if (iArr != null) {
                        this.b = iArr[intValue - 1];
                        return;
                    }
                    return;
                }
                this.a = false;
            }
        } catch (Throwable e3) {
            this.a = false;
            fw.a("v:" + str, e3);
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\|");
        if (split.length != 6) {
            return false;
        }
        if (split[0].startsWith("SIG7") && split[1].split(",").length == split[5].split(",").length) {
            return true;
        }
        if (!split[0].startsWith("FIXED")) {
            return false;
        }
        int length = split[5].split(",").length;
        int parseInt = Integer.parseInt(split[1]);
        if (length < parseInt || parseInt <= 0) {
            return false;
        }
        return true;
    }

    public final void a(ar arVar) {
        b(arVar.d(), arVar.a(0));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" p13:");
        stringBuilder.append(this.f);
        stringBuilder.append(" p07:");
        stringBuilder.append(this.g);
        stringBuilder.append(" policy:");
        stringBuilder.append(this.b);
        stringBuilder.append(" interval:");
        stringBuilder.append(this.e);
        return stringBuilder.toString();
    }
}
