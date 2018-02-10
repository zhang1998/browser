package com.uc.webview.export.utility.download;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.UCMobile.Apollo.ApolloMetaData;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.utility.d;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

@Api
/* compiled from: ProGuard */
public class UpdateTask {
    public static final String START_FLG_FILE_NAME = "299772b0fd1634653ae3c31f366de3f8";
    public static final String STOP_FLG_FILE_NAME = "2e67cdbeb4ec133dcc8204d930aa7145";
    private static final ConcurrentHashMap<Long, Long> a = new ConcurrentHashMap();
    private final String[] b = new String[3];
    private final long[] c = new long[6];
    private final ValueCallback<UpdateTask>[] d = new ValueCallback[11];
    private final Object[] e = new Object[3];
    private int f = 0;
    private int g = 0;
    private String h = "core.jar";
    private ValueCallback<Object[]> i;

    static /* synthetic */ void a(File file, boolean z) throws Exception {
        if (z) {
            new File(file, STOP_FLG_FILE_NAME).createNewFile();
        } else {
            new File(file, START_FLG_FILE_NAME).createNewFile();
        }
    }

    public UpdateTask(Context context, String str, String str2, String str3, ValueCallback<Object[]> valueCallback, Long l, Long l2) {
        if (l == null) {
            l = Long.valueOf(60000);
        }
        if (l2 == null) {
            l2 = Long.valueOf(604800000);
        }
        int hashCode = str.hashCode();
        synchronized (a) {
            if (a.containsKey(Long.valueOf((long) hashCode))) {
                throw new RuntimeException("Duplicate task.");
            }
            a.put(Long.valueOf((long) hashCode), Long.valueOf((long) hashCode));
        }
        String valueOf = hashCode >= 0 ? String.valueOf(hashCode) : String.valueOf(hashCode).replace('-', '_');
        WaStat.stat(IWaStat.UCM);
        this.i = valueCallback;
        this.c[0] = (long) hashCode;
        this.c[4] = l.longValue();
        this.c[5] = l2.longValue();
        this.b[0] = str;
        this.b[1] = str2;
        this.b[2] = valueOf;
        this.e[0] = context;
        this.e[2] = new DownloadTask(context, str, valueCallback);
        this.h = str3;
    }

    public static final File getUCPlayerRoot(Context context) throws UCSetupException {
        if (SDKFactory.t != null) {
            return new File(SDKFactory.t);
        }
        return (File) UCMPackageInfo.invoke(10001, context, "ucplayer");
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (a) {
                a.remove(Long.valueOf(this.c[0]));
            }
        } catch (Throwable th) {
        }
    }

    public UpdateTask onEvent(String str, ValueCallback<UpdateTask> valueCallback) {
        if (str.equals("success")) {
            this.d[0] = valueCallback;
        } else if (str.equals("failed")) {
            this.d[1] = valueCallback;
        } else if (str.equals("recovered")) {
            this.d[2] = valueCallback;
        } else if (str.equals("progress")) {
            this.d[3] = valueCallback;
        } else if (str.equals("exception")) {
            this.d[4] = valueCallback;
        } else if (str.equals("check")) {
            this.d[5] = valueCallback;
        } else if (str.equals("exists")) {
            this.d[6] = valueCallback;
        } else if (str.equals("beginDownload")) {
            this.d[7] = valueCallback;
        } else if (str.equals("beginUnZip")) {
            this.d[8] = valueCallback;
        } else if (str.equals("unzipSuccess")) {
            this.d[9] = valueCallback;
        } else if (str.equals("downloadException")) {
            this.d[10] = valueCallback;
        } else {
            throw new RuntimeException("The given event:" + str + " is unknown.");
        }
        return this;
    }

    public final File getUpdateDir() throws UCSetupException {
        if (this.c[1] <= 0) {
            Pair a = d.a(this.b[0], null);
            this.c[1] = ((Long) a.first).longValue();
            this.c[2] = ((Long) a.second).longValue();
        }
        return new File(this.b[1] + "/" + this.b[2] + "/" + (String.valueOf(this.c[1]) + "_" + this.c[2]));
    }

    public Throwable getException() {
        return (Throwable) this.e[1];
    }

    public UpdateTask start() {
        ValueCallback valueCallback = this.d[0];
        ValueCallback valueCallback2 = this.d[1];
        ValueCallback valueCallback3 = this.d[2];
        ValueCallback valueCallback4 = this.d[3];
        ValueCallback valueCallback5 = this.d[4];
        ValueCallback valueCallback6 = this.d[5];
        ValueCallback valueCallback7 = this.d[6];
        ValueCallback valueCallback8 = this.d[7];
        ValueCallback valueCallback9 = this.d[8];
        ValueCallback valueCallback10 = this.d[9];
        ValueCallback valueCallback11 = this.d[10];
        String str = this.b[0];
        DownloadTask downloadTask = (DownloadTask) this.e[2];
        this.f = 0;
        Runnable dVar = new d(this, valueCallback4, str, downloadTask, valueCallback2, valueCallback9, valueCallback10, valueCallback, valueCallback5);
        downloadTask.onEvent("check", new n(this, valueCallback6)).onEvent("success", new m(this, dVar)).onEvent("exists", new l(this, dVar)).onEvent("failed", new k(this, valueCallback2)).onEvent("progress", new j(this, valueCallback4)).onEvent("exception", new h(this, valueCallback11, valueCallback5)).onEvent(ApolloMetaData.KEY_HEADER, new g(this, valueCallback7, valueCallback3, valueCallback4, valueCallback5)).onEvent("beginDownload", new f(this, valueCallback8)).start();
        return this;
    }

    public UpdateTask stop() {
        ((DownloadTask) this.e[2]).stop();
        return this;
    }

    public UpdateTask startDownload() {
        ((DownloadTask) this.e[2]).start();
        return this;
    }

    public UpdateTask delete() {
        ((DownloadTask) this.e[2]).stopWith(new e(this));
        return this;
    }

    public static boolean isFinished(File file, String str) {
        return file.exists() && new File(file, str).exists() && (!(new File(file, START_FLG_FILE_NAME).exists() || new File(file, "c34d62af061f389f7e4c9f0e835f7a54").exists()) || new File(file, STOP_FLG_FILE_NAME).exists() || new File(file, "95b70b3ec9f6407a92becf890996088d").exists());
    }

    public static File getUpdateRoot(Context context) throws Exception {
        return (File) UCMPackageInfo.invoke(10002, context);
    }

    public int getPercent() {
        return this.g;
    }
}
