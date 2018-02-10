package android.support.a.a;

import java.util.ArrayList;

/* compiled from: ProGuard */
final class a {
    static float[] a(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = i + 0;
        length = Math.min(i2, length + 0);
        Object obj = new float[i2];
        System.arraycopy(fArr, 0, obj, 0, length);
        return obj;
    }

    public static h[] a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a = a(str, i);
            String trim = str.substring(i2, a).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), b(trim));
            }
            i = a + 1;
            i2 = a;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    public static h[] a(h[] hVarArr) {
        if (hVarArr == null) {
            return null;
        }
        h[] hVarArr2 = new h[hVarArr.length];
        for (int i = 0; i < hVarArr.length; i++) {
            hVarArr2[i] = new h();
        }
        return hVarArr2;
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 65) * (charAt - 90) <= 0 || (charAt - 97) * (charAt - 122) <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    private static void a(ArrayList<h> arrayList, char c, float[] fArr) {
        arrayList.add(new h(c, fArr));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float[] b(java.lang.String r13) {
        /*
        r1 = 1;
        r2 = 0;
        r0 = r13.charAt(r2);
        r3 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        if (r0 != r3) goto L_0x001a;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = r13.charAt(r2);
        r4 = 90;
        if (r3 != r4) goto L_0x001c;
    L_0x0013:
        r3 = r1;
    L_0x0014:
        r0 = r0 | r3;
        if (r0 == 0) goto L_0x001e;
    L_0x0017:
        r0 = new float[r2];
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = r2;
        goto L_0x000b;
    L_0x001c:
        r3 = r2;
        goto L_0x0014;
    L_0x001e:
        r0 = r13.length();	 Catch:{ NumberFormatException -> 0x0094 }
        r8 = new float[r0];	 Catch:{ NumberFormatException -> 0x0094 }
        r9 = new android.support.a.a.b;	 Catch:{ NumberFormatException -> 0x0094 }
        r0 = 0;
        r9.<init>();	 Catch:{ NumberFormatException -> 0x0094 }
        r10 = r13.length();	 Catch:{ NumberFormatException -> 0x0094 }
        r7 = r1;
        r3 = r2;
    L_0x0030:
        if (r7 >= r10) goto L_0x008f;
    L_0x0032:
        r0 = 0;
        r9.b = r0;	 Catch:{ NumberFormatException -> 0x0094 }
        r5 = r2;
        r0 = r2;
        r4 = r2;
        r6 = r7;
    L_0x0039:
        r11 = r13.length();	 Catch:{ NumberFormatException -> 0x0094 }
        if (r6 >= r11) goto L_0x0072;
    L_0x003f:
        r11 = r13.charAt(r6);	 Catch:{ NumberFormatException -> 0x0094 }
        switch(r11) {
            case 32: goto L_0x0052;
            case 44: goto L_0x0052;
            case 45: goto L_0x0056;
            case 46: goto L_0x0061;
            case 69: goto L_0x006e;
            case 101: goto L_0x006e;
            default: goto L_0x0046;
        };	 Catch:{ NumberFormatException -> 0x0094 }
    L_0x0046:
        r5 = r4;
        r4 = r0;
        r0 = r2;
    L_0x0049:
        if (r5 != 0) goto L_0x0072;
    L_0x004b:
        r6 = r6 + 1;
        r12 = r0;
        r0 = r4;
        r4 = r5;
        r5 = r12;
        goto L_0x0039;
    L_0x0052:
        r4 = r0;
        r5 = r1;
        r0 = r2;
        goto L_0x0049;
    L_0x0056:
        if (r6 == r7) goto L_0x0046;
    L_0x0058:
        if (r5 != 0) goto L_0x0046;
    L_0x005a:
        r4 = 1;
        r9.b = r4;	 Catch:{ NumberFormatException -> 0x0094 }
        r4 = r0;
        r5 = r1;
        r0 = r2;
        goto L_0x0049;
    L_0x0061:
        if (r0 != 0) goto L_0x0067;
    L_0x0063:
        r0 = r2;
        r5 = r4;
        r4 = r1;
        goto L_0x0049;
    L_0x0067:
        r4 = 1;
        r9.b = r4;	 Catch:{ NumberFormatException -> 0x0094 }
        r4 = r0;
        r5 = r1;
        r0 = r2;
        goto L_0x0049;
    L_0x006e:
        r5 = r4;
        r4 = r0;
        r0 = r1;
        goto L_0x0049;
    L_0x0072:
        r9.a = r6;	 Catch:{ NumberFormatException -> 0x0094 }
        r4 = r9.a;	 Catch:{ NumberFormatException -> 0x0094 }
        if (r7 >= r4) goto L_0x00b0;
    L_0x0078:
        r0 = r3 + 1;
        r5 = r13.substring(r7, r4);	 Catch:{ NumberFormatException -> 0x0094 }
        r5 = java.lang.Float.parseFloat(r5);	 Catch:{ NumberFormatException -> 0x0094 }
        r8[r3] = r5;	 Catch:{ NumberFormatException -> 0x0094 }
    L_0x0084:
        r3 = r9.b;	 Catch:{ NumberFormatException -> 0x0094 }
        if (r3 == 0) goto L_0x008b;
    L_0x0088:
        r7 = r4;
        r3 = r0;
        goto L_0x0030;
    L_0x008b:
        r7 = r4 + 1;
        r3 = r0;
        goto L_0x0030;
    L_0x008f:
        r0 = a(r8, r3);	 Catch:{ NumberFormatException -> 0x0094 }
        goto L_0x0019;
    L_0x0094:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "error in parsing \"";
        r2.<init>(r3);
        r2 = r2.append(r13);
        r3 = "\"";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x00b0:
        r0 = r3;
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.a.a.a.b(java.lang.String):float[]");
    }
}
