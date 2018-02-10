package com.uc.webview.export.internal.setup;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ProGuard */
final class bj implements FilenameFilter {
    bj() {
    }

    public final boolean accept(File file, String str) {
        return file != null && str != null && file.getPath().startsWith(ShareConstants.SO_PATH) && str.startsWith(ShareConstants.SO_PATH) && str.endsWith(".so") && !str.startsWith("libkernel");
    }
}
