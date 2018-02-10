package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: ProGuard */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        this.trustRootIndex = trustRootIndex;
    }

    public final List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        Deque arrayDeque = new ArrayDeque(list);
        List<Certificate> arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        int i = 0;
        Object obj = null;
        while (i < 9) {
            Object obj2;
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate findByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
            if (findByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(findByIssuerAndSignature)) {
                    arrayList.add(findByIssuerAndSignature);
                }
                if (verifySignature(findByIssuerAndSignature, findByIssuerAndSignature)) {
                    return arrayList;
                }
                obj2 = 1;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    findByIssuerAndSignature = (X509Certificate) it.next();
                    if (verifySignature(x509Certificate, findByIssuerAndSignature)) {
                        it.remove();
                        arrayList.add(findByIssuerAndSignature);
                        obj2 = obj;
                    }
                }
                if (obj != null) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            i++;
            obj = obj2;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    private boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }
}
