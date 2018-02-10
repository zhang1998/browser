package com.uc.aerie.loader;

import com.tencent.tinker.loader.shareutil.ShareLoadPatchResult;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class LoadMasterResult {
    public long cost;
    public int errorCode;
    public int expactVersionRollbackType;
    public String expectVersion;
    public List<ShareLoadPatchResult> failLoadRecords = new ArrayList();
    public long loadDexCost;
    public long loadResCost;
    public long loadSoCost;
    public String loadVersion;
    public long patchInternalCost;
    public Throwable throwable;

    public LoadMasterResult(String str, int i, long j, long j2, long j3, long j4, long j5, String str2, int i2, Throwable th, List<ShareLoadPatchResult> list) {
        this.loadVersion = str;
        this.errorCode = i;
        this.cost = j;
        this.patchInternalCost = j2;
        this.loadDexCost = j3;
        this.loadResCost = j4;
        this.loadSoCost = j5;
        this.expectVersion = str2;
        this.expactVersionRollbackType = i2;
        this.throwable = th;
        this.failLoadRecords = list;
    }
}
