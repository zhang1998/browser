package okhttp3.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

/* compiled from: ProGuard */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException e) {
            return false;
        }
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        if (Util.verifyAsIpAddress(str)) {
            return verifyIpAddress(str, x509Certificate);
        }
        return verifyHostname(str, x509Certificate);
    }

    private boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        List subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        int size = subjectAltNames.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase((String) subjectAltNames.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String toLowerCase = str.toLowerCase(Locale.US);
        List subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        int size = subjectAltNames.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            if (verifyHostname(toLowerCase, (String) subjectAltNames.get(i))) {
                return true;
            }
            i++;
            int i2 = 1;
        }
        if (obj == null) {
            String findMostSpecific = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).findMostSpecific("cn");
            if (findMostSpecific != null) {
                return verifyHostname(toLowerCase, findMostSpecific);
            }
        }
        return false;
    }

    public static List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        Collection subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        Collection subjectAltNames2 = getSubjectAltNames(x509Certificate, 2);
        List<String> arrayList = new ArrayList(subjectAltNames.size() + subjectAltNames2.size());
        arrayList.addAll(subjectAltNames);
        arrayList.addAll(subjectAltNames2);
        return arrayList;
    }

    private static List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
        List<String> arrayList = new ArrayList();
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2) {
                    Integer num = (Integer) list.get(0);
                    if (num != null && num.intValue() == i) {
                        String str = (String) list.get(1);
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    private boolean verifyHostname(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + '.';
        }
        String toLowerCase = str2.toLowerCase(Locale.US);
        if (!toLowerCase.contains("*")) {
            return str.equals(toLowerCase);
        }
        if (!toLowerCase.startsWith("*.") || toLowerCase.indexOf(42, 1) != -1 || str.length() < toLowerCase.length() || "*.".equals(toLowerCase)) {
            return false;
        }
        toLowerCase = toLowerCase.substring(1);
        if (!str.endsWith(toLowerCase)) {
            return false;
        }
        int length = str.length() - toLowerCase.length();
        if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
            return true;
        }
        return false;
    }
}
