package de.greenrobot.dao.async;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.DaoLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ProGuard */
class AsyncOperationExecutor implements Callback, Runnable {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private int countOperationsCompleted;
    private int countOperationsEnqueued;
    private volatile boolean executorRunning;
    private Handler handlerMainThread;
    private int lastSequenceNumber;
    private volatile AsyncOperationListener listener;
    private volatile AsyncOperationListener listenerMainThread;
    private volatile int maxOperationCountToMerge = 50;
    private final BlockingQueue<AsyncOperation> queue = new LinkedBlockingQueue();
    private volatile int waitForMergeMillis = 50;

    AsyncOperationExecutor() {
    }

    public void enqueue(AsyncOperation asyncOperation) {
        synchronized (this) {
            int i = this.lastSequenceNumber + 1;
            this.lastSequenceNumber = i;
            asyncOperation.sequenceNumber = i;
            this.queue.add(asyncOperation);
            this.countOperationsEnqueued++;
            if (!this.executorRunning) {
                this.executorRunning = true;
                executorService.execute(this);
            }
        }
    }

    public int getMaxOperationCountToMerge() {
        return this.maxOperationCountToMerge;
    }

    public void setMaxOperationCountToMerge(int i) {
        this.maxOperationCountToMerge = i;
    }

    public int getWaitForMergeMillis() {
        return this.waitForMergeMillis;
    }

    public void setWaitForMergeMillis(int i) {
        this.waitForMergeMillis = i;
    }

    public AsyncOperationListener getListener() {
        return this.listener;
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.listener = asyncOperationListener;
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.listenerMainThread;
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.listenerMainThread = asyncOperationListener;
    }

    public synchronized boolean isCompleted() {
        return this.countOperationsEnqueued == this.countOperationsCompleted;
    }

    public synchronized void waitForCompletion() {
        while (!isCompleted()) {
            try {
                wait();
            } catch (Throwable e) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e);
            }
        }
    }

    public synchronized boolean waitForCompletion(int i) {
        if (!isCompleted()) {
            try {
                wait((long) i);
            } catch (Throwable e) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e);
            }
        }
        return isCompleted();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r6 = this;
        r5 = 0;
    L_0x0001:
        r0 = r6.queue;	 Catch:{ InterruptedException -> 0x0042 }
        r2 = 1;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0042 }
        r0 = r0.poll(r2, r1);	 Catch:{ InterruptedException -> 0x0042 }
        r0 = (de.greenrobot.dao.async.AsyncOperation) r0;	 Catch:{ InterruptedException -> 0x0042 }
        if (r0 != 0) goto L_0x0076;
    L_0x000f:
        monitor-enter(r6);	 Catch:{ InterruptedException -> 0x0042 }
        r0 = r6.queue;	 Catch:{ all -> 0x0064 }
        r0 = r0.poll();	 Catch:{ all -> 0x0064 }
        r0 = (de.greenrobot.dao.async.AsyncOperation) r0;	 Catch:{ all -> 0x0064 }
        if (r0 != 0) goto L_0x0021;
    L_0x001a:
        r0 = 0;
        r6.executorRunning = r0;	 Catch:{ all -> 0x0064 }
        monitor-exit(r6);	 Catch:{ all -> 0x0064 }
        r6.executorRunning = r5;
    L_0x0020:
        return;
    L_0x0021:
        monitor-exit(r6);	 Catch:{ all -> 0x0064 }
        r1 = r0;
    L_0x0023:
        r0 = r1.isMergeTx();	 Catch:{ InterruptedException -> 0x0042 }
        if (r0 == 0) goto L_0x0072;
    L_0x0029:
        r0 = r6.queue;	 Catch:{ InterruptedException -> 0x0042 }
        r2 = r6.waitForMergeMillis;	 Catch:{ InterruptedException -> 0x0042 }
        r2 = (long) r2;	 Catch:{ InterruptedException -> 0x0042 }
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0042 }
        r0 = r0.poll(r2, r4);	 Catch:{ InterruptedException -> 0x0042 }
        r0 = (de.greenrobot.dao.async.AsyncOperation) r0;	 Catch:{ InterruptedException -> 0x0042 }
        if (r0 == 0) goto L_0x0072;
    L_0x0038:
        r2 = r1.isMergeableWith(r0);	 Catch:{ InterruptedException -> 0x0042 }
        if (r2 == 0) goto L_0x006b;
    L_0x003e:
        r6.mergeTxAndExecute(r1, r0);	 Catch:{ InterruptedException -> 0x0042 }
        goto L_0x0001;
    L_0x0042:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0067 }
        r1.<init>();	 Catch:{ all -> 0x0067 }
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0067 }
        r2 = r2.getName();	 Catch:{ all -> 0x0067 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0067 }
        r2 = " was interruppted";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0067 }
        r1 = r1.toString();	 Catch:{ all -> 0x0067 }
        de.greenrobot.dao.DaoLog.w(r1, r0);	 Catch:{ all -> 0x0067 }
        r6.executorRunning = r5;
        goto L_0x0020;
    L_0x0064:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0064 }
        throw r0;	 Catch:{ InterruptedException -> 0x0042 }
    L_0x0067:
        r0 = move-exception;
        r6.executorRunning = r5;
        throw r0;
    L_0x006b:
        r6.executeOperationAndPostCompleted(r1);	 Catch:{ InterruptedException -> 0x0042 }
        r6.executeOperationAndPostCompleted(r0);	 Catch:{ InterruptedException -> 0x0042 }
        goto L_0x0001;
    L_0x0072:
        r6.executeOperationAndPostCompleted(r1);	 Catch:{ InterruptedException -> 0x0042 }
        goto L_0x0001;
    L_0x0076:
        r1 = r0;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.dao.async.AsyncOperationExecutor.run():void");
    }

    private void mergeTxAndExecute(AsyncOperation asyncOperation, AsyncOperation asyncOperation2) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        arrayList.add(asyncOperation);
        arrayList.add(asyncOperation2);
        SQLiteDatabase database = asyncOperation.getDatabase();
        database.beginTransaction();
        int i = 0;
        while (i < arrayList.size()) {
            AsyncOperation asyncOperation3;
            try {
                asyncOperation3 = (AsyncOperation) arrayList.get(i);
                executeOperation(asyncOperation3);
                if (asyncOperation3.isFailed()) {
                    obj = 1;
                    break;
                }
                if (i == arrayList.size() - 1) {
                    AsyncOperation asyncOperation4 = (AsyncOperation) this.queue.peek();
                    if (i >= this.maxOperationCountToMerge || !asyncOperation3.isMergeableWith(asyncOperation4)) {
                        database.setTransactionSuccessful();
                    } else {
                        asyncOperation3 = (AsyncOperation) this.queue.remove();
                        if (asyncOperation3 != asyncOperation4) {
                            throw new DaoException("Internal error: peeked op did not match removed op");
                        }
                        arrayList.add(asyncOperation3);
                    }
                }
                i++;
            } catch (Throwable th) {
                database.endTransaction();
            }
        }
        obj = null;
        database.endTransaction();
        if (obj != null) {
            DaoLog.i("Revered merged transaction because one of the operations failed. Executing operations one by one instead...");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                asyncOperation3 = (AsyncOperation) it.next();
                asyncOperation3.reset();
                executeOperationAndPostCompleted(asyncOperation3);
            }
            return;
        }
        int size = arrayList.size();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            asyncOperation3 = (AsyncOperation) it2.next();
            asyncOperation3.mergedOperationsCount = size;
            handleOperationCompleted(asyncOperation3);
        }
    }

    private void handleOperationCompleted(AsyncOperation asyncOperation) {
        asyncOperation.setCompleted();
        AsyncOperationListener asyncOperationListener = this.listener;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted(asyncOperation);
        }
        if (this.listenerMainThread != null) {
            if (this.handlerMainThread == null) {
                this.handlerMainThread = new Handler(Looper.getMainLooper(), this);
            }
            this.handlerMainThread.sendMessage(this.handlerMainThread.obtainMessage(1, asyncOperation));
        }
        synchronized (this) {
            this.countOperationsCompleted++;
            if (this.countOperationsCompleted == this.countOperationsEnqueued) {
                notifyAll();
            }
        }
    }

    private void executeOperationAndPostCompleted(AsyncOperation asyncOperation) {
        executeOperation(asyncOperation);
        handleOperationCompleted(asyncOperation);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void executeOperation(de.greenrobot.dao.async.AsyncOperation r4) {
        /*
        r3 = this;
        r0 = java.lang.System.currentTimeMillis();
        r4.timeStarted = r0;
        r0 = de.greenrobot.dao.async.AsyncOperationExecutor.AnonymousClass1.$SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType;	 Catch:{ Throwable -> 0x002a }
        r1 = r4.type;	 Catch:{ Throwable -> 0x002a }
        r1 = r1.ordinal();	 Catch:{ Throwable -> 0x002a }
        r0 = r0[r1];	 Catch:{ Throwable -> 0x002a }
        switch(r0) {
            case 1: goto L_0x0034;
            case 2: goto L_0x003c;
            case 3: goto L_0x0046;
            case 4: goto L_0x0050;
            case 5: goto L_0x0058;
            case 6: goto L_0x0062;
            case 7: goto L_0x006c;
            case 8: goto L_0x0074;
            case 9: goto L_0x007e;
            case 10: goto L_0x0088;
            case 11: goto L_0x0090;
            case 12: goto L_0x009a;
            case 13: goto L_0x00a4;
            case 14: goto L_0x00a8;
            case 15: goto L_0x00ac;
            case 16: goto L_0x00b8;
            case 17: goto L_0x00c4;
            case 18: goto L_0x00cd;
            case 19: goto L_0x00d4;
            case 20: goto L_0x00e0;
            case 21: goto L_0x00ea;
            case 22: goto L_0x00f8;
            default: goto L_0x0013;
        };	 Catch:{ Throwable -> 0x002a }
    L_0x0013:
        r0 = new de.greenrobot.dao.DaoException;	 Catch:{ Throwable -> 0x002a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002a }
        r2 = "Unsupported operation: ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x002a }
        r2 = r4.type;	 Catch:{ Throwable -> 0x002a }
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x002a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x002a }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x002a }
        throw r0;	 Catch:{ Throwable -> 0x002a }
    L_0x002a:
        r0 = move-exception;
        r4.throwable = r0;
    L_0x002d:
        r0 = java.lang.System.currentTimeMillis();
        r4.timeCompleted = r0;
        return;
    L_0x0034:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r1 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0.delete(r1);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x003c:
        r1 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (java.lang.Iterable) r0;	 Catch:{ Throwable -> 0x002a }
        r1.deleteInTx(r0);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x0046:
        r1 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (java.lang.Object[]) r0;	 Catch:{ Throwable -> 0x002a }
        r1.deleteInTx(r0);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x0050:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r1 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0.insert(r1);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x0058:
        r1 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (java.lang.Iterable) r0;	 Catch:{ Throwable -> 0x002a }
        r1.insertInTx(r0);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x0062:
        r1 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (java.lang.Object[]) r0;	 Catch:{ Throwable -> 0x002a }
        r1.insertInTx(r0);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x006c:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r1 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0.insertOrReplace(r1);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x0074:
        r1 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (java.lang.Iterable) r0;	 Catch:{ Throwable -> 0x002a }
        r1.insertOrReplaceInTx(r0);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x007e:
        r1 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (java.lang.Object[]) r0;	 Catch:{ Throwable -> 0x002a }
        r1.insertOrReplaceInTx(r0);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x0088:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r1 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0.update(r1);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x0090:
        r1 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (java.lang.Iterable) r0;	 Catch:{ Throwable -> 0x002a }
        r1.updateInTx(r0);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x009a:
        r1 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (java.lang.Object[]) r0;	 Catch:{ Throwable -> 0x002a }
        r1.updateInTx(r0);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00a4:
        r3.executeTransactionRunnable(r4);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00a8:
        r3.executeTransactionCallable(r4);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00ac:
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (de.greenrobot.dao.query.Query) r0;	 Catch:{ Throwable -> 0x002a }
        r0 = r0.list();	 Catch:{ Throwable -> 0x002a }
        r4.result = r0;	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00b8:
        r0 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = (de.greenrobot.dao.query.Query) r0;	 Catch:{ Throwable -> 0x002a }
        r0 = r0.unique();	 Catch:{ Throwable -> 0x002a }
        r4.result = r0;	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00c4:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r1 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0.deleteByKey(r1);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00cd:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0.deleteAll();	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00d4:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r1 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0 = r0.load(r1);	 Catch:{ Throwable -> 0x002a }
        r4.result = r0;	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00e0:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r0.loadAll();	 Catch:{ Throwable -> 0x002a }
        r4.result = r0;	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00ea:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r0 = r0.count();	 Catch:{ Throwable -> 0x002a }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ Throwable -> 0x002a }
        r4.result = r0;	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
    L_0x00f8:
        r0 = r4.dao;	 Catch:{ Throwable -> 0x002a }
        r1 = r4.parameter;	 Catch:{ Throwable -> 0x002a }
        r0.refresh(r1);	 Catch:{ Throwable -> 0x002a }
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.dao.async.AsyncOperationExecutor.executeOperation(de.greenrobot.dao.async.AsyncOperation):void");
    }

    private void executeTransactionRunnable(AsyncOperation asyncOperation) {
        SQLiteDatabase database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            ((Runnable) asyncOperation.parameter).run();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    private void executeTransactionCallable(AsyncOperation asyncOperation) throws Exception {
        SQLiteDatabase database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            asyncOperation.result = ((Callable) asyncOperation.parameter).call();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public boolean handleMessage(Message message) {
        AsyncOperationListener asyncOperationListener = this.listenerMainThread;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted((AsyncOperation) message.obj);
        }
        return false;
    }
}
