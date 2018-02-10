package okhttp3.internal.platform;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

/* compiled from: ProGuard */
public class Platform {
    public static final int INFO = 4;
    private static final Platform PLATFORM = findPlatform();
    public static final int WARN = 5;
    private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());

    public static Platform get() {
        return PLATFORM;
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        try {
            Object readFieldOrNull = readFieldOrNull(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (readFieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void log(int i, String str, Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public static List<String> alpnProtocolNames(List<Protocol> list) {
        List<String> arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(TrustRootIndex.get(x509TrustManager));
    }

    private static Platform findPlatform() {
        Platform buildIfSupported = AndroidPlatform.buildIfSupported();
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        buildIfSupported = Jdk9Platform.buildIfSupported();
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        buildIfSupported = JdkWithJettyBootPlatform.buildIfSupported();
        return buildIfSupported == null ? new Platform() : buildIfSupported;
    }

    static byte[] concatLengthPrefixed(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    static <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        do {
            Class cls2 = obj.getClass();
            while (cls2 != Object.class) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 == null || !cls.isInstance(obj2)) {
                        return null;
                    }
                    return cls.cast(obj2);
                } catch (NoSuchFieldException e) {
                    cls2 = cls2.getSuperclass();
                } catch (IllegalAccessException e2) {
                    throw new AssertionError();
                }
            }
            if (str.equals("delegate")) {
                break;
            }
            obj = readFieldOrNull(obj, Object.class, "delegate");
        } while (obj != null);
        return null;
    }
}
