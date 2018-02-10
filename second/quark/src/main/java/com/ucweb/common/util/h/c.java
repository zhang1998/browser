package com.ucweb.common.util.h;

import android.os.Debug;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ i a;

    c(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        if (!Debug.isDebuggerConnected()) {
            throw new RuntimeException("这里使用了ThreadManager.post函数运行了一个超过30s的任务，请查看这个任务是否是非常耗时的任务，或者存在死循环，或者存在死锁，或者存在一直卡住线程的情况，如果存在上述情况请解决或者使用ThreadManager.execute函数放入线程池执行该任务。", new Throwable(this.a.a.a.toString()));
        }
    }
}
