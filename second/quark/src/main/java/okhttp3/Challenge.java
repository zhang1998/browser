package okhttp3;

import com.alibaba.wireless.security.SecExceptionCode;
import okhttp3.internal.Util;

/* compiled from: ProGuard */
public final class Challenge {
    private final String realm;
    private final String scheme;

    public Challenge(String str, String str2) {
        this.scheme = str;
        this.realm = str2;
    }

    public final String scheme() {
        return this.scheme;
    }

    public final String realm() {
        return this.realm;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Challenge) && Util.equal(this.scheme, ((Challenge) obj).scheme) && Util.equal(this.realm, ((Challenge) obj).realm);
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        if (this.realm != null) {
            hashCode = this.realm.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR) * 31;
        if (this.scheme != null) {
            i = this.scheme.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return this.scheme + " realm=\"" + this.realm + "\"";
    }
}
