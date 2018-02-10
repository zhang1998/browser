package com.uc.sync.c.b;

import android.os.Handler;
import com.uc.base.b.c.b.c;
import com.uc.sync.f.l;
import java.util.ArrayList;

/* compiled from: ProGuard */
public interface a<CloudSyncItem extends l, SyncItemPb extends c, SyncMetaDataPb extends c> {
    Handler a();

    SyncMetaDataPb a(SyncMetaDataPb syncMetaDataPb);

    SyncMetaDataPb a(SyncMetaDataPb syncMetaDataPb, l lVar);

    SyncItemPb a(CloudSyncItem cloudSyncItem);

    CloudSyncItem a(long j);

    CloudSyncItem a(CloudSyncItem cloudSyncItem, SyncItemPb syncItemPb);

    CloudSyncItem a(String str);

    ArrayList<CloudSyncItem> a(int i, int i2);

    ArrayList<l> a(ArrayList<l> arrayList);

    void a(int i);

    void a(CloudSyncItem cloudSyncItem, CloudSyncItem cloudSyncItem2);

    SyncMetaDataPb b(SyncMetaDataPb syncMetaDataPb);

    CloudSyncItem b(String str);

    void b();

    void b(CloudSyncItem cloudSyncItem);

    void b(CloudSyncItem cloudSyncItem, CloudSyncItem cloudSyncItem2);

    void b(ArrayList<Long> arrayList);

    long c(CloudSyncItem cloudSyncItem);

    void c();

    void c(CloudSyncItem cloudSyncItem, CloudSyncItem cloudSyncItem2);

    byte[] c(SyncItemPb syncItemPb);

    SyncItemPb d();

    void d(CloudSyncItem cloudSyncItem);

    boolean d(CloudSyncItem cloudSyncItem, CloudSyncItem cloudSyncItem2);

    CloudSyncItem e();

    SyncMetaDataPb f();

    int g();
}
