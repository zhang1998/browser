package com.tencent.wxop.stat.a;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class r implements Comparator<ScanResult> {
    r() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ScanResult scanResult = (ScanResult) obj2;
        int abs = Math.abs(((ScanResult) obj).level);
        int abs2 = Math.abs(scanResult.level);
        return abs > abs2 ? 1 : abs == abs2 ? 0 : -1;
    }
}
