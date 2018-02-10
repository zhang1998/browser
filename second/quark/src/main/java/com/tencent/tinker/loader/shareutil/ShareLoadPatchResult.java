package com.tencent.tinker.loader.shareutil;

import java.io.Serializable;

/* compiled from: ProGuard */
public class ShareLoadPatchResult implements Serializable {
    public String dexFileDir;
    public int errorCode;
    public long loadDexCost = 0;
    public long loadResCost = 0;
    public long loadSoCost = 0;
    public String oDexFileDir;
    public long patchInternalCost = 0;
    public String resPath;
    public Throwable throwable;
    public String version;

    public ShareLoadPatchResult(String str) {
        this.version = str;
        this.errorCode = ShareConstants.ERROR_LOAD_UNDEFINE;
        this.throwable = null;
    }

    public void set(String str, int i, Throwable th) {
        this.version = str;
        this.errorCode = i;
        this.throwable = th;
    }
}
