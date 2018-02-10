package okhttp3.internal.cache;

import com.alibaba.wireless.security.SecExceptionCode;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;

/* compiled from: ProGuard */
public final class CacheStrategy {
    public final Response cacheResponse;
    public final Request networkRequest;

    /* compiled from: ProGuard */
    public class Factory {
        private int ageSeconds = -1;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j, Request request, Response response) {
            this.nowMillis = j;
            this.request = request;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String name = headers.name(i);
                    String value = headers.value(i);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.servedDate = HttpDate.parse(value);
                        this.servedDateString = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.expires = HttpDate.parse(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.lastModified = HttpDate.parse(value);
                        this.lastModifiedString = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.etag = value;
                    } else if ("Age".equalsIgnoreCase(name)) {
                        this.ageSeconds = HttpHeaders.parseSeconds(value, -1);
                    }
                }
            }
        }

        public CacheStrategy get() {
            CacheStrategy candidate = getCandidate();
            if (candidate.networkRequest == null || !this.request.cacheControl().onlyIfCached()) {
                return candidate;
            }
            return new CacheStrategy(null, null);
        }

        private CacheStrategy getCandidate() {
            long j = 0;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            long toMillis;
            long cacheResponseAge = cacheResponseAge();
            long computeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds()));
            }
            if (cacheControl.minFreshSeconds() != -1) {
                toMillis = TimeUnit.SECONDS.toMillis((long) cacheControl.minFreshSeconds());
            } else {
                toMillis = 0;
            }
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            if (!(cacheControl2.mustRevalidate() || cacheControl.maxStaleSeconds() == -1)) {
                j = TimeUnit.SECONDS.toMillis((long) cacheControl.maxStaleSeconds());
            }
            if (cacheControl2.noCache() || cacheResponseAge + toMillis >= r4 + computeFreshnessLifetime) {
                String str;
                String str2;
                if (this.etag != null) {
                    str = "If-None-Match";
                    str2 = this.etag;
                } else if (this.lastModified != null) {
                    str = "If-Modified-Since";
                    str2 = this.lastModifiedString;
                } else if (this.servedDate == null) {
                    return new CacheStrategy(this.request, null);
                } else {
                    str = "If-Modified-Since";
                    str2 = this.servedDateString;
                }
                Builder newBuilder = this.request.headers().newBuilder();
                Internal.instance.addLenient(newBuilder, str, str2);
                return new CacheStrategy(this.request.newBuilder().headers(newBuilder.build()).build(), this.cacheResponse);
            }
            Response.Builder newBuilder2 = this.cacheResponse.newBuilder();
            if (toMillis + cacheResponseAge >= computeFreshnessLifetime) {
                newBuilder2.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if (cacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                newBuilder2.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new CacheStrategy(null, newBuilder2.build());
        }

        private long computeFreshnessLifetime() {
            CacheControl cacheControl = this.cacheResponse.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds());
            }
            long time;
            if (this.expires != null) {
                time = this.expires.getTime() - (this.servedDate != null ? this.servedDate.getTime() : this.receivedResponseMillis);
                if (time <= 0) {
                    return 0;
                }
                return time;
            } else if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0;
            } else {
                time = (this.servedDate != null ? this.servedDate.getTime() : this.sentRequestMillis) - this.lastModified.getTime();
                if (time > 0) {
                    return time / 10;
                }
                return 0;
            }
        }

        private long cacheResponseAge() {
            long j = 0;
            if (this.servedDate != null) {
                j = Math.max(0, this.receivedResponseMillis - this.servedDate.getTime());
            }
            if (this.ageSeconds != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.ageSeconds));
            }
            return (j + (this.receivedResponseMillis - this.sentRequestMillis)) + (this.nowMillis - this.receivedResponseMillis);
        }

        private boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        private static boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }
    }

    private CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    public static boolean isCacheable(Response response, Request request) {
        switch (response.code()) {
            case 200:
            case SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE /*203*/:
            case SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE /*204*/:
            case SecExceptionCode.SEC_ERROR_STA_ENC /*300*/:
            case SecExceptionCode.SEC_ERROR_STA_INVALID_PARAM /*301*/:
            case 308:
            case SecExceptionCode.SEC_ERROR_DYN_ENC_GET_DATA_FILE_KEY_FAILED /*404*/:
            case SecExceptionCode.SEC_ERROR_DYN_ENC_GET_ENCRYPT_KEY_FAILED /*405*/:
            case 410:
            case 414:
            case SecExceptionCode.SEC_ERROR_DYN_STORE_INVALID_PARAM /*501*/:
                break;
            case SecExceptionCode.SEC_ERROR_STA_DATA_FILE_MISMATCH /*302*/:
            case 307:
                if (response.header("Expires") == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                    return false;
                }
            default:
                return false;
        }
        return (response.cacheControl().noStore() || request.cacheControl().noStore()) ? false : true;
    }
}
