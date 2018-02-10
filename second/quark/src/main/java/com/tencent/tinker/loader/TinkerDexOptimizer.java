package com.tencent.tinker.loader;

import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ProGuard */
public final class TinkerDexOptimizer {
    private static final String TAG = "Tinker.ParallelDex";

    /* compiled from: ProGuard */
    public interface ResultCallback {
        void onFailed(File file, File file2, Throwable th);

        void onStart(File file, File file2);

        void onSuccess(File file, File file2, File file3);
    }

    /* compiled from: ProGuard */
    class OptimizeWorker {
        private static String targetISA = null;
        private final ResultCallback callback;
        private final File dexFile;
        private final File optimizedDir;
        private final boolean useInterpretMode;

        OptimizeWorker(File file, File file2, boolean z, String str, ResultCallback resultCallback) {
            this.dexFile = file;
            this.optimizedDir = file2;
            this.useInterpretMode = z;
            this.callback = resultCallback;
            targetISA = str;
        }

        public boolean run() {
            try {
                if (SharePatchFileUtil.isLegalFile(this.dexFile) || this.callback == null) {
                    if (this.callback != null) {
                        this.callback.onStart(this.dexFile, this.optimizedDir);
                    }
                    String optimizedPathFor = SharePatchFileUtil.optimizedPathFor(this.dexFile, this.optimizedDir);
                    if (this.useInterpretMode) {
                        interpretDex2Oat(this.dexFile.getAbsolutePath(), optimizedPathFor);
                    } else {
                        DexFile.loadDex(this.dexFile.getAbsolutePath(), optimizedPathFor, 0);
                    }
                    if (this.callback != null) {
                        this.callback.onSuccess(this.dexFile, this.optimizedDir, new File(optimizedPathFor));
                    }
                    return true;
                }
                this.callback.onFailed(this.dexFile, this.optimizedDir, new IOException("dex file " + this.dexFile.getAbsolutePath() + " is not exist!"));
                return false;
            } catch (Throwable th) {
                Log.e(TinkerDexOptimizer.TAG, "Failed to optimize dex: " + this.dexFile.getAbsolutePath(), th);
                if (this.callback != null) {
                    this.callback.onFailed(this.dexFile, this.optimizedDir, th);
                    return false;
                }
            }
        }

        private void interpretDex2Oat(String str, String str2) throws IOException {
            File file = new File(str2);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            List arrayList = new ArrayList();
            arrayList.add("dex2oat");
            if (VERSION.SDK_INT >= 24) {
                arrayList.add("--runtime-arg");
                arrayList.add("-classpath");
                arrayList.add("--runtime-arg");
                arrayList.add("&");
            }
            arrayList.add("--dex-file=" + str);
            arrayList.add("--oat-file=" + str2);
            arrayList.add("--instruction-set=" + targetISA);
            if (VERSION.SDK_INT > 25) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
            ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
            processBuilder.redirectErrorStream(true);
            Process start = processBuilder.start();
            StreamConsumer.consumeInputStream(start.getInputStream());
            StreamConsumer.consumeInputStream(start.getErrorStream());
            try {
                int waitFor = start.waitFor();
                if (waitFor != 0) {
                    throw new IOException("dex2oat works unsuccessfully, exit code: " + waitFor);
                }
            } catch (Throwable e) {
                throw new IOException("dex2oat is interrupted, msg: " + e.getMessage(), e);
            }
        }
    }

    /* compiled from: ProGuard */
    class StreamConsumer {
        static final Executor STREAM_CONSUMER = Executors.newSingleThreadExecutor();

        /* compiled from: ProGuard */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ InputStream val$is;

            AnonymousClass1(InputStream inputStream) {
                this.val$is = inputStream;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r2 = this;
                r0 = r2.val$is;
                if (r0 != 0) goto L_0x0005;
            L_0x0004:
                return;
            L_0x0005:
                r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                r0 = new byte[r0];
            L_0x0009:
                r1 = r2.val$is;	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                r1 = r1.read(r0);	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                if (r1 > 0) goto L_0x0009;
            L_0x0011:
                r0 = r2.val$is;	 Catch:{ Exception -> 0x0017 }
                r0.close();	 Catch:{ Exception -> 0x0017 }
                goto L_0x0004;
            L_0x0017:
                r0 = move-exception;
                goto L_0x0004;
            L_0x0019:
                r0 = move-exception;
                r0 = r2.val$is;	 Catch:{ Exception -> 0x0020 }
                r0.close();	 Catch:{ Exception -> 0x0020 }
                goto L_0x0004;
            L_0x0020:
                r0 = move-exception;
                goto L_0x0004;
            L_0x0022:
                r0 = move-exception;
                r1 = r2.val$is;	 Catch:{ Exception -> 0x0029 }
                r1.close();	 Catch:{ Exception -> 0x0029 }
            L_0x0028:
                throw r0;
            L_0x0029:
                r1 = move-exception;
                goto L_0x0028;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerDexOptimizer.StreamConsumer.1.run():void");
            }
        }

        private StreamConsumer() {
        }

        static void consumeInputStream(InputStream inputStream) {
            STREAM_CONSUMER.execute(new AnonymousClass1(inputStream));
        }
    }

    public static boolean optimizeAll(Collection<File> collection, File file, ResultCallback resultCallback) {
        return optimizeAll(collection, file, false, null, resultCallback);
    }

    public static boolean optimizeAll(Collection<File> collection, File file, boolean z, String str, ResultCallback resultCallback) {
        Object arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new Comparator<File>() {
            public final int compare(File file, File file2) {
                long length = file.length() - file2.length();
                if (length > 0) {
                    return 1;
                }
                if (length == 0) {
                    return 0;
                }
                return -1;
            }
        });
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!new OptimizeWorker((File) it.next(), file, z, str, resultCallback).run()) {
                return false;
            }
        }
        return true;
    }
}
