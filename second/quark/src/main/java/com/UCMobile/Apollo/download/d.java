package com.UCMobile.Apollo.download;

import java.util.HashMap;

/* compiled from: ProGuard */
public interface d {
    void onDownloadInfo(int i, long j);

    void onFileAttribute(int i, String str);

    void onPlayableRanges(int[] iArr, int[] iArr2);

    void onStateToggle(int i, int i2);

    void onStatistics(HashMap<String, String> hashMap);

    void onSwitchDownloadMode(int i);
}
