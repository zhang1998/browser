package com.uc.webview.export.internal.setup;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ProGuard */
final class bk implements FilenameFilter {
    bk() {
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(ShareConstants.SO_PATH) && str.endsWith("_kr_uc.so");
    }
}
