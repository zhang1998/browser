package com.bumptech.glide.c;

import android.content.Context;
import android.os.Process;
import android.support.annotation.NonNull;

/* compiled from: ProGuard */
public final class h implements e {
    @NonNull
    public final d a(@NonNull Context context, @NonNull c cVar) {
        return (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0 ? 1 : null) != null ? new g(context, cVar) : new l();
    }
}
