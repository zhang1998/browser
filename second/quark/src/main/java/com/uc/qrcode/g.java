package com.uc.qrcode;

import com.google.zxing.BarcodeFormat;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
final class g {
    static final Set<BarcodeFormat> a = EnumSet.of(BarcodeFormat.UPC_A, new BarcodeFormat[]{BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED});
    static final Set<BarcodeFormat> b = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
    static final Set<BarcodeFormat> c;
    static final Set<BarcodeFormat> d = EnumSet.of(BarcodeFormat.QR_CODE);
    static final Set<BarcodeFormat> e = EnumSet.of(BarcodeFormat.DATA_MATRIX);
    static final Set<BarcodeFormat> f = EnumSet.of(BarcodeFormat.AZTEC);
    static final Set<BarcodeFormat> g = EnumSet.of(BarcodeFormat.PDF_417);
    private static final Pattern h = Pattern.compile(",");
    private static final Map<String, Set<BarcodeFormat>> i;

    static {
        Set copyOf = EnumSet.copyOf(a);
        c = copyOf;
        copyOf.addAll(b);
        Map hashMap = new HashMap();
        i = hashMap;
        hashMap.put("ONE_D_MODE", c);
        i.put("PRODUCT_MODE", a);
        i.put("QR_CODE_MODE", d);
        i.put("DATA_MATRIX_MODE", e);
        i.put("AZTEC_MODE", f);
        i.put("PDF417_MODE", g);
    }
}
