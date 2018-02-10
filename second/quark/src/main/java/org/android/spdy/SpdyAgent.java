package org.android.spdy;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: ProGuard */
public final class SpdyAgent {
    public static final int ACCS_ONLINE_SERVER = 1;
    public static final int ACCS_TEST_SERVER = 0;
    private static final boolean HAVE_CLOSE = false;
    private static final int KB32 = 32768;
    private static final int KB8 = 8192;
    private static final int MAX_SPDY_SESSION_COUNT = 50;
    private static final int MB5 = 5242880;
    static final int MODE_QUIC = 256;
    static final int SPDY_CUSTOM_CONTROL_FRAME_RECV = 4106;
    static final int SPDY_DATA_CHUNK_RECV = 4097;
    static final int SPDY_DATA_RECV = 4098;
    static final int SPDY_DATA_SEND = 4099;
    static final int SPDY_PING_RECV = 4101;
    static final int SPDY_REQUEST_RECV = 4102;
    static final int SPDY_SESSION_CLOSE = 4103;
    static final int SPDY_SESSION_CREATE = 4096;
    static final int SPDY_SESSION_FAILED_ERROR = 4105;
    static final int SPDY_STREAM_CLOSE = 4100;
    static final int SPDY_STREAM_RESPONSE_RECV = 4104;
    private static final String TNET_SO_VERSION = "tnet-3.0.14";
    private static Object domainHashLock = new Object();
    private static HashMap<String, Integer> domainHashMap = new HashMap();
    public static volatile boolean enableDebug = false;
    public static volatile boolean enableTimeGaurd = false;
    private static volatile SpdyAgent gSingleInstance = null;
    private static volatile boolean loadSucc = false;
    private static Object lock = new Object();
    private static final Lock r;
    private static final ReentrantReadWriteLock rwLock;
    private static int totalDomain = 0;
    private static final Lock w = rwLock.writeLock();
    private AccsSSLCallback accsSSLCallback;
    private long agentNativePtr;
    private AtomicBoolean closed = new AtomicBoolean();
    private String proxyPassword = null;
    private String proxyUsername = null;
    private HashMap<String, SpdySession> sessionMgr = new HashMap(5);
    private LinkedList<SpdySession> sessionQueue = new LinkedList();

    private native int closeSessionN(long j);

    private native int configLogFileN(String str, int i, int i2);

    private native int configLogFileN(String str, int i, int i2, int i3);

    private native long createSessionN(long j, SpdySession spdySession, int i, byte[] bArr, char c, byte[] bArr2, char c2, byte[] bArr3, byte[] bArr4, Object obj, int i2, int i3, int i4);

    private native int freeAgent(long j);

    private native long getSession(long j, byte[] bArr, char c);

    private native long initAgent(int i, int i2, int i3);

    private static native void inspectN(String str);

    private native void logFileCloseN();

    private native void logFileFlushN();

    private native int setConTimeout(long j, int i);

    private native int setSessionKind(long j, int i);

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        rwLock = reentrantReadWriteLock;
        r = reentrantReadWriteLock.readLock();
    }

    final void clearSpdySession(String str, String str2, int i) {
        if (str != null) {
            w.lock();
            if (str != null) {
                try {
                    this.sessionMgr.remove(str + str2 + i);
                } catch (Throwable th) {
                    w.unlock();
                }
            }
            w.unlock();
        }
    }

    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind) throws UnsatisfiedLinkError, SpdyErrorException {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, null);
                }
            }
        }
        return gSingleInstance;
    }

    public static boolean checkLoadSucc() {
        return loadSucc;
    }

    @Deprecated
    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) throws UnsatisfiedLinkError, SpdyErrorException {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, accsSSLCallback);
                }
            }
        }
        return gSingleInstance;
    }

    private int getDomainHashIndex(String str) {
        Integer num;
        synchronized (domainHashLock) {
            num = (Integer) domainHashMap.get(str);
            if (num == null) {
                HashMap hashMap = domainHashMap;
                int i = totalDomain + 1;
                totalDomain = i;
                hashMap.put(str, Integer.valueOf(i));
                num = Integer.valueOf(totalDomain);
            }
        }
        return num.intValue();
    }

    private SpdyAgent(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) throws UnsatisfiedLinkError {
        try {
            SoInstallMgrSdk.init(context);
            loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
        } catch (Throwable th) {
        }
        try {
            this.agentNativePtr = initAgent(spdyVersion.getInt(), spdySessionKind.getint(), SslVersion.SLIGHT_VERSION_V1.getint());
            this.accsSSLCallback = accsSSLCallback;
        } catch (UnsatisfiedLinkError e) {
        }
        this.closed.set(false);
    }

    private void checkLoadSo() throws SpdyErrorException {
        if (!loadSucc) {
            try {
                synchronized (lock) {
                    if (loadSucc) {
                        return;
                    } else {
                        loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
                        this.agentNativePtr = initAgent(0, 0, 0);
                    }
                }
            } catch (Throwable th) {
            }
        } else {
            return;
        }
        if (!loadSucc) {
            throw new SpdyErrorException("TNET_JNI_ERR_LOAD_SO_FAIL", TnetStatusCode.TNET_JNI_ERR_LOAD_SO_FAIL);
        }
    }

    public final void setProxyUsernamePassword(String str, String str2) {
        this.proxyUsername = str;
        this.proxyPassword = str2;
    }

    static void securityCheck(int i, int i2) {
        if (i >= 32768) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        } else if (i2 >= 8192) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:value=" + i2, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    static void tableListJudge(int i) {
        if (i >= MB5) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    static void InvlidCharJudge(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            if ((bArr[i2] & 255) < 32 || (bArr[i2] & 255) > 126) {
                bArr[i2] = (byte) 63;
            }
            i2++;
        }
        while (i < bArr2.length) {
            if ((bArr2[i] & 255) < 32 || (bArr2[i] & 255) > 126) {
                bArr2[i] = (byte) 63;
            }
            i++;
        }
    }

    static void headJudge(Map<String, String> map) {
        if (map != null) {
            int i = 0;
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                InvlidCharJudge(str.getBytes(), str2.getBytes());
                int length = ((str.length() + 1) + str2.length()) + i;
                securityCheck(length, str2.length());
                i = length;
            }
        }
    }

    static String mapBodyToString(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map == null) {
            return null;
        }
        int i = 0;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            stringBuilder.append(str).append('=').append(str2).append('&');
            int length = (str2.length() + (str.length() + 1)) + i;
            tableListJudge(length);
            i = length;
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    static byte[] dataproviderToByteArray(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider) {
        headJudge(spdyRequest.getHeaders());
        if (spdyDataProvider == null) {
            return null;
        }
        byte[] bytes;
        String mapBodyToString = mapBodyToString(spdyDataProvider.postBody);
        if (mapBodyToString != null) {
            bytes = mapBodyToString.getBytes();
        } else {
            bytes = spdyDataProvider.data;
        }
        if (bytes == null || bytes.length < MB5) {
            return bytes;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + bytes.length, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    @Deprecated
    public final SpdySession createSession(String str, Object obj, SessionCb sessionCb, int i) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, null, i, 0);
    }

    @Deprecated
    public final SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, int i) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, null, i, 0);
    }

    @Deprecated
    public final SpdySession createSession(String str, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, sslCertcb, i, 0);
    }

    public final SpdySession createSession(SessionInfo sessionInfo) throws SpdyErrorException {
        return createSession(sessionInfo.getAuthority(), sessionInfo.getDomain(), sessionInfo.getSessonUserData(), sessionInfo.getSessionCb(), null, sessionInfo.getMode(), sessionInfo.getPubKeySeqNum(), sessionInfo.getConnectionTimeoutMs());
    }

    @Deprecated
    public final SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i, i2, -1);
    }

    public final SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2, int i3) throws SpdyErrorException {
        if (str == null) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM", TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        String str3;
        String[] split = str.split("/");
        String[] split2 = split[0].split(":");
        byte[] bytes = "0.0.0.0".getBytes();
        char c = '\u0000';
        if (split.length != 1) {
            split = split[1].split(":");
            bytes = split[0].getBytes();
            c = (char) Integer.parseInt(split[1]);
            str3 = str;
        } else {
            str3 = str + "/0.0.0.0:0";
        }
        agentIsOpen();
        Object obj2 = null;
        r.lock();
        try {
            SpdySession spdySession = (SpdySession) this.sessionMgr.get(str3 + str2 + i);
            if (this.sessionMgr.size() >= 50) {
                obj2 = 1;
            }
            r.unlock();
            if (obj2 != null) {
                throw new SpdyErrorException("SPDY_SESSION_EXCEED_MAXED: session count exceed max", TnetStatusCode.TNET_SESSION_EXCEED_MAXED);
            } else if (spdySession != null) {
                spdySession.increRefCount();
                return spdySession;
            } else {
                w.lock();
                try {
                    spdySession = (SpdySession) this.sessionMgr.get(str3 + str2 + i);
                } catch (Throwable th) {
                    spdySession = null;
                }
                if (spdySession != null) {
                    w.unlock();
                    spdySession.increRefCount();
                    return spdySession;
                }
                try {
                    long createSessionN;
                    long j;
                    int i4;
                    SpdySession spdySession2 = new SpdySession(0, this, str3, str2, sessionCb, i, i2, obj);
                    int domainHashIndex = getDomainHashIndex(str2 + i);
                    if (this.proxyUsername == null || this.proxyPassword == null) {
                        createSessionN = createSessionN(this.agentNativePtr, spdySession2, domainHashIndex, split2[0].getBytes(), (char) Integer.parseInt(split2[1]), bytes, c, null, null, obj, i, i2, i3);
                    } else {
                        createSessionN = createSessionN(this.agentNativePtr, spdySession2, domainHashIndex, split2[0].getBytes(), (char) Integer.parseInt(split2[1]), bytes, c, this.proxyUsername.getBytes(), this.proxyPassword.getBytes(), obj, i, i2, i3);
                    }
                    spduLog.Logi("tnet-jni", " create new session: " + str);
                    if ((1 & createSessionN) == 1) {
                        j = 0;
                        i4 = (int) (createSessionN >> 1);
                    } else {
                        i4 = 0;
                        j = createSessionN;
                    }
                    if (j != 0) {
                        spdySession2.setSessionNativePtr(j);
                        this.sessionMgr.put(str3 + str2 + i, spdySession2);
                        this.sessionQueue.add(spdySession2);
                    } else if (i4 != 0) {
                        throw new SpdyErrorException("create session error: " + i4, i4);
                    } else {
                        spdySession2 = null;
                    }
                    w.unlock();
                    return spdySession2;
                } catch (Throwable th2) {
                    w.unlock();
                }
            }
        } catch (Throwable th3) {
            r.unlock();
        }
    }

    @Deprecated
    public final SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i) throws SpdyErrorException {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i, 0, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    @Deprecated
    public final SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i, int i2) throws SpdyErrorException {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i, i2, spdyRequest.getConnectionTimeoutMs());
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    public final SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i, int i2) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, null, i, i2);
    }

    @Deprecated
    public final SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, null, i);
    }

    private void agentIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("SPDY_JNI_ERR_ASYNC_CLOSE", TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
        checkLoadSo();
    }

    public final void close() {
    }

    final void removeSession(SpdySession spdySession) {
        w.lock();
        try {
            this.sessionQueue.remove(spdySession);
        } finally {
            w.unlock();
        }
    }

    final int closeSession(long j) {
        return closeSessionN(j);
    }

    static String[] mapToByteArray(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        String[] strArr = new String[(map.size() * 2)];
        int i = 0;
        for (Entry entry : map.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr[i + 1] = (String) entry.getValue();
            i += 2;
        }
        return strArr;
    }

    static Map<String, List<String>> stringArrayToMap(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap(5);
        int i = 0;
        while (i + 2 <= strArr.length) {
            if (strArr[i] == null || strArr[i + 1] == null) {
                return null;
            }
            List list = (List) hashMap.get(strArr[i]);
            if (list == null) {
                list = new ArrayList(1);
                hashMap.put(strArr[i], list);
            }
            list.add(strArr[i + 1]);
            i += 2;
        }
        return hashMap;
    }

    @Deprecated
    public final int setSessionKind(SpdySessionKind spdySessionKind) {
        int i = -1;
        agentIsOpen();
        try {
            i = setSessionKind(this.agentNativePtr, spdySessionKind.getint());
        } catch (UnsatisfiedLinkError e) {
        }
        return i;
    }

    @Deprecated
    public final int setConnectTimeOut(int i) {
        int i2 = 0;
        agentIsOpen();
        try {
            i2 = setConTimeout(this.agentNativePtr, i);
        } catch (UnsatisfiedLinkError e) {
        }
        return i2;
    }

    public final void setAccsSslCallback(AccsSSLCallback accsSSLCallback) {
        spduLog.Logi("tnet-jni", "[setAccsSslCallback] - " + accsSSLCallback.getClass());
        this.accsSSLCallback = accsSSLCallback;
    }

    private void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdySessionConnectCB(spdySession, superviseConnectInfo);
        }
    }

    private void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, int i, SpdyByteArray spdyByteArray, int i2) {
        spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataChunkRecvCB(spdySession, z, j, spdyByteArray, i2);
        }
    }

    private void spdyDataRecvCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataRecvCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyDataSendCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataSendCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyStreamCloseCallback(SpdySession spdySession, int i, int i2, int i3, SuperviseData superviseData) {
        spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - ");
        long j = 4294967295L & ((long) i);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyStreamCloseCallback(spdySession, j, i2, i3, superviseData);
        }
    }

    private void spdyPingRecvCallback(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyPingRecvCallback(spdySession, (long) i, obj);
        }
    }

    private void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyCustomControlFrameRecvCallback(spdySession, obj, i, i2, i3, i4, bArr);
        }
    }

    private void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyCustomControlFrameFailCallback(spdySession, obj, i, i2);
        }
    }

    private void bioPingRecvCallback(SpdySession spdySession, int i) {
        spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.bioPingRecvCallback(spdySession, i);
        }
    }

    private void spdyRequestRecvCallback(SpdySession spdySession, int i, int i2) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyRequestRecvCallback(spdySession, j, i2);
        }
    }

    private void spdyStreamResponseRecv(SpdySession spdySession, int i, String[] strArr, int i2) {
        spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - ");
        Map stringArrayToMap = stringArrayToMap(strArr);
        long j = 4294967295L & ((long) i);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyOnStreamResponse(spdySession, j, stringArrayToMap, i2);
        }
    }

    private void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - errorCode = " + i);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i);
            }
            spdySession.cleanUp();
        } catch (Throwable th) {
            spdySession.cleanUp();
        }
    }

    private void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdySessionFailedError] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionFailedError(spdySession, i, obj);
            }
            spdySession.cleanUp();
        } catch (Throwable th) {
            spdySession.cleanUp();
        }
    }

    private void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
        spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionOnWritable(spdySession, obj, i);
            }
        } catch (Throwable th) {
            spduLog.Loge("tnet-jni", "[spdySessionOnWritable] - exception:" + th);
        }
    }

    private byte[] getSSLPublicKey(int i, byte[] bArr) {
        if (this.accsSSLCallback != null) {
            return this.accsSSLCallback.getSSLPublicKey(i, bArr);
        }
        spduLog.Logd("tnet-jni", "[getSSLPublicKey] - accsSSLCallback is null.");
        return null;
    }

    private int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session is null");
            return -1;
        } else if (spdySession.intenalcb != null) {
            return spdySession.intenalcb.putSSLMeta(spdySession, bArr);
        } else {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session.intenalcb is null");
            return -1;
        }
    }

    private byte[] getSSLMeta(SpdySession spdySession) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session is null");
            return null;
        } else if (spdySession.intenalcb != null) {
            return spdySession.intenalcb.getSSLMeta(spdySession);
        } else {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session.intenalcb is null");
            return null;
        }
    }

    private void getPerformance(SpdySession spdySession, SslPermData sslPermData) {
    }

    public final HashMap<String, SpdySession> getAllSession() {
        return this.sessionMgr;
    }

    private static void crashReporter(int i) {
    }

    public final int configLogFile(String str, int i, int i2) {
        return loadSucc ? configLogFileN(str, i, i2) : -1;
    }

    public final int configLogFile(String str, int i, int i2, int i3) {
        return loadSucc ? configLogFileN(str, i, i2, i3) : -1;
    }

    public final void logFileFlush() {
        if (loadSucc) {
            logFileFlushN();
        }
    }

    public final void logFileClose() {
        if (loadSucc) {
            logFileFlushN();
            logFileCloseN();
        }
    }

    @Deprecated
    public final void switchAccsServer(int i) {
    }

    public static void inspect(String str) {
    }
}
