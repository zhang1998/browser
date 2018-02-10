package com.uc.webview.export.internal.setup;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ProGuard */
final class ac implements FilenameFilter {
    final /* synthetic */ ab a;

    ac(ab abVar) {
        this.a = abVar;
    }

    public final boolean accept(File file, String str) {
        return file != null && str != null && file.getPath().startsWith(ShareConstants.SO_PATH) && str.equals("libkernelu4_uc_7z.so");
    }
}
