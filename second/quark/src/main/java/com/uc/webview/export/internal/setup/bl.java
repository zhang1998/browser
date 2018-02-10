package com.uc.webview.export.internal.setup;

import java.io.File;
import java.util.Comparator;

/* compiled from: ProGuard */
final class bl implements Comparator<UCMPackageInfo> {
    bl() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return Long.valueOf(new File((String) ((UCMPackageInfo) obj2).coreImplModule.first).lastModified() - new File((String) ((UCMPackageInfo) obj).coreImplModule.first).lastModified()).intValue();
    }
}
