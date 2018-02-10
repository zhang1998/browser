package com.uc.webview.export.cyclone;

import android.content.Context;
import android.util.Pair;
import com.taobao.weex.ui.component.ab;
import com.uc.webview.export.cyclone.service.UCDex;
import com.uc.webview.export.cyclone.service.UCServiceInterface;
import com.uc.webview.export.cyclone.service.UCUnSevenZip;
import com.uc.webview.export.cyclone.service.UCVmsize;
import dalvik.system.DexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Constant
/* compiled from: ProGuard */
public class UCService {
    private static final int DEBUG_TOKEN = UCLogger.createToken("d", LOG_TAG);
    private static final String LOG_TAG = "UCService";
    private static final int MAX_CONFIG_CONTENT_LENGTH = 4096;
    private static final int VERBOSE_TOKEN = UCLogger.createToken("v", LOG_TAG);
    private static final int WARNN_TOKEN = UCLogger.createToken(ab.PROP_FS_WRAP_CONTENT, LOG_TAG);
    private static Context s_ctx = null;
    private static final UCSingleton<ConcurrentHashMap<Class<? extends UCServiceInterface>, ConcurrentLinkedQueue<Pair<String, String>>>> s_serviceImplQueues = new UCSingleton(ConcurrentHashMap.class, new Class[0]);
    private static final UCSingleton<ConcurrentHashMap<Class<? extends UCServiceInterface>, UCServiceInterface>> s_serviceImpls = new UCSingleton(ConcurrentHashMap.class, new Class[0]);
    private static final UCSingleton<ConcurrentHashMap<String, Class<? extends UCServiceInterface>>> s_services = new UCSingleton(ConcurrentHashMap.class, new Class[0]);

    static {
        registerDefaultImpl(UCUnSevenZip.class, "com.uc.webview.export.cyclone.service.UCUnSevenZipMultiThreadImpl");
        registerDefaultImpl(UCVmsize.class, "com.uc.webview.export.cyclone.service.UCVmsizeImpl");
    }

    public static void registerService(String str, Class<? extends UCServiceInterface> cls) throws Exception {
        UCLogger.print(DEBUG_TOKEN, "registerService " + str + "," + cls, new Throwable[0]);
        Class<? extends UCServiceInterface> cls2 = (Class) ((ConcurrentHashMap) s_services.initInst(new Object[0])).get(str);
        if (cls2 == null || cls2 == cls) {
            ((ConcurrentHashMap) s_services.initInst(new Object[0])).put(str, cls);
            return;
        }
        throw new UCKnownException(2017, "registerService service name '" + str + "' is registered by '" + cls2 + "' but now '" + cls + "' requested.");
    }

    public static void registerImpl(Class<? extends UCServiceInterface> cls, String str, String str2) throws Exception {
        UCLogger.print(DEBUG_TOKEN, "registerImpl " + cls + "," + str + "," + str2, new Throwable[0]);
        if (cls == null) {
            throw new UCKnownException(2016, "registerImpl param null.");
        } else if (str == null || str.length() <= 0) {
            throw new UCKnownException(2016, "registerImpl param null.");
        } else {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) ((ConcurrentHashMap) s_serviceImplQueues.initInst(new Object[0])).get(cls);
            if (concurrentLinkedQueue == null) {
                synchronized (cls) {
                    concurrentLinkedQueue = (ConcurrentLinkedQueue) ((ConcurrentHashMap) s_serviceImplQueues.initInst(new Object[0])).get(cls);
                    if (concurrentLinkedQueue == null) {
                        ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
                        ((ConcurrentHashMap) s_serviceImplQueues.initInst(new Object[0])).put(cls, concurrentLinkedQueue2);
                        concurrentLinkedQueue = concurrentLinkedQueue2;
                    }
                }
            }
            if (getImpl(cls) != null) {
                throw new UCKnownException(2018, "registerImpl: the service has instanced. Please registers service impl before use it");
            }
            concurrentLinkedQueue.add(new Pair(str, str2));
        }
    }

    public static boolean registerImpl(Class<? extends UCServiceInterface> cls, UCServiceInterface uCServiceInterface) throws Exception {
        UCLogger.print(DEBUG_TOKEN, "registerImpl " + cls + "=>" + uCServiceInterface, new Throwable[0]);
        if (cls == null) {
            throw new UCKnownException(2013, "registerImpl: serviceInterface is null.");
        } else if (uCServiceInterface == null) {
            ((ConcurrentHashMap) s_serviceImpls.initInst(new Object[0])).remove(cls);
            return true;
        } else {
            UCServiceInterface uCServiceInterface2 = (UCServiceInterface) ((ConcurrentHashMap) s_serviceImpls.initInst(new Object[0])).get(cls);
            if (uCServiceInterface2 != null && uCServiceInterface2.getServiceVersion() >= uCServiceInterface.getServiceVersion()) {
                return false;
            }
            if (cls.isInstance(uCServiceInterface)) {
                ((ConcurrentHashMap) s_serviceImpls.initInst(new Object[0])).put(cls, uCServiceInterface);
                return true;
            }
            throw new UCKnownException(2014, "registerImpl: impl" + uCServiceInterface + " is not compatible with interface " + cls + ".");
        }
    }

    private static Class<? extends UCServiceInterface> getService(String str) {
        return s_services.getInst() == null ? null : (Class) ((ConcurrentHashMap) s_services.getInst()).get(str);
    }

    private static UCServiceInterface getImpl(Class<? extends UCServiceInterface> cls) {
        if (s_serviceImpls.getInst() == null) {
            return null;
        }
        return (UCServiceInterface) ((ConcurrentHashMap) s_serviceImpls.getInst()).get(cls);
    }

    private static ConcurrentLinkedQueue<Pair<String, String>> getImplQueue(Class<? extends UCServiceInterface> cls) {
        if (s_serviceImplQueues.getInst() == null) {
            return null;
        }
        return (ConcurrentLinkedQueue) ((ConcurrentHashMap) s_serviceImplQueues.getInst()).get(cls);
    }

    public static <T extends UCServiceInterface> T initImpl(Class<T> cls) {
        T impl = getImpl(cls);
        if (impl == null) {
            ConcurrentLinkedQueue implQueue = getImplQueue(cls);
            if (implQueue != null) {
                synchronized (cls) {
                    while (!implQueue.isEmpty()) {
                        Pair pair = (Pair) implQueue.poll();
                        try {
                            ClassLoader classLoader;
                            if (pair.second == null) {
                                classLoader = cls.getClassLoader();
                            } else if (s_ctx != null) {
                                String parent = new File((String) pair.second).getParent();
                                UCDex uCDex = (UCDex) initImpl(UCDex.class);
                                if (uCDex == null) {
                                    classLoader = new DexClassLoader((String) pair.second, parent, parent, cls.getClassLoader());
                                } else {
                                    classLoader = uCDex.createDexClassLoader(s_ctx, null, (String) pair.second, parent, parent, cls.getClassLoader());
                                }
                            } else {
                                classLoader = null;
                            }
                            UCLogger.print(DEBUG_TOKEN, "initImpl " + cls + "=>" + Class.forName((String) pair.first, true, classLoader) + " with " + ((String) pair.first) + "," + ((String) pair.second), new Throwable[0]);
                        } catch (Throwable th) {
                            UCLogger.print(WARNN_TOKEN, "initImpl exception", th);
                        }
                    }
                    impl = getImpl(cls);
                }
            }
        }
        return impl;
    }

    public static int search(Context context, File file) {
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        s_ctx = context.getApplicationContext();
        LinkedList linkedList = new LinkedList();
        while (true) {
            UCLogger.print(DEBUG_TOKEN, "searching " + file, new Throwable[0]);
            for (File file2 : file.listFiles()) {
                if (!(file2 == null || !file2.exists() || file2.getName().replace(".", "").replace("/", "").replace(" ", "").length() == 0)) {
                    if (file2.isDirectory()) {
                        linkedList.add(file2);
                    } else if (file2.isFile() && file2.getName().startsWith("cyclone.UCService.") && file2.length() < 4096) {
                        String[] split = file2.getName().split("\\.", 4);
                        if (split.length >= 4) {
                            String str = split[2];
                            String str2 = split[3];
                            UCLogger.print(DEBUG_TOKEN, "search config file:" + str + "=>" + str2, new Throwable[0]);
                            File file3 = new File(file, str2);
                            if (file3.isFile()) {
                                try {
                                    Class service = getService(str);
                                    if (service == null) {
                                        UCLogger.print(WARNN_TOKEN, "search service:" + str + " not registered.", new Throwable[0]);
                                    } else {
                                        String asciiContents = getAsciiContents(file2);
                                        if (asciiContents == null || asciiContents.length() == 0) {
                                            UCLogger.print(WARNN_TOKEN, "search config contents is null.", new Throwable[0]);
                                        } else {
                                            String[] split2 = asciiContents.split(",");
                                            if (split2.length == 0) {
                                                UCLogger.print(WARNN_TOKEN, "search no impl class defined in config.", new Throwable[0]);
                                            } else {
                                                UCLogger.print(DEBUG_TOKEN, "search config contents:" + asciiContents, new Throwable[0]);
                                                for (String asciiContents2 : split2) {
                                                    asciiContents2 = asciiContents2.trim();
                                                    if (asciiContents2.length() != 0) {
                                                        try {
                                                            registerImpl(service, asciiContents2, file3.getAbsolutePath());
                                                        } catch (Exception e) {
                                                            UCLogger.print(WARNN_TOKEN, "search exception", e);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    UCLogger.print(WARNN_TOKEN, "search exception", e2);
                                }
                            }
                        }
                    }
                }
            }
            File file22 = (File) linkedList.poll();
            if (linkedList.isEmpty()) {
                return 0;
            }
            file = file22;
        }
    }

    private static void registerDefaultImpl(Class<? extends UCServiceInterface> cls, String str) {
        UCLogger.print(VERBOSE_TOKEN, "registerDefaultImpl " + cls + "," + str, new Throwable[0]);
        try {
            registerService(cls.getSimpleName(), cls);
            registerImpl(cls, str, null);
        } catch (Throwable th) {
            UCLogger create = UCLogger.create(ab.PROP_FS_WRAP_CONTENT, LOG_TAG);
            if (create != null) {
                create.print("registerDefaultImpl register exception:" + th, new Throwable[0]);
            }
        }
    }

    private static String getAsciiContents(File file) throws Exception {
        Closeable fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                fileInputStream.read(bArr);
                String str = new String(bArr, "US-ASCII");
                UCCyclone.close(fileInputStream);
                return str;
            } catch (Throwable th2) {
                th = th2;
                UCCyclone.close(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            UCCyclone.close(fileInputStream);
            throw th;
        }
    }
}
