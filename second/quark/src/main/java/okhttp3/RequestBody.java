package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

/* compiled from: ProGuard */
public abstract class RequestBody {

    /* compiled from: ProGuard */
    final class AnonymousClass1 extends RequestBody {
        final /* synthetic */ ByteString val$content;
        final /* synthetic */ MediaType val$contentType;

        AnonymousClass1(MediaType mediaType, ByteString byteString) {
            this.val$contentType = mediaType;
            this.val$content = byteString;
        }

        public final MediaType contentType() {
            return this.val$contentType;
        }

        public final long contentLength() throws IOException {
            return (long) this.val$content.size();
        }

        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.val$content);
        }
    }

    /* compiled from: ProGuard */
    final class AnonymousClass2 extends RequestBody {
        final /* synthetic */ int val$byteCount;
        final /* synthetic */ byte[] val$content;
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ int val$offset;

        AnonymousClass2(MediaType mediaType, int i, byte[] bArr, int i2) {
            this.val$contentType = mediaType;
            this.val$byteCount = i;
            this.val$content = bArr;
            this.val$offset = i2;
        }

        public final MediaType contentType() {
            return this.val$contentType;
        }

        public final long contentLength() {
            return (long) this.val$byteCount;
        }

        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.val$content, this.val$offset, this.val$byteCount);
        }
    }

    /* compiled from: ProGuard */
    final class AnonymousClass3 extends RequestBody {
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ File val$file;

        AnonymousClass3(MediaType mediaType, File file) {
            this.val$contentType = mediaType;
            this.val$file = file;
        }

        public final MediaType contentType() {
            return this.val$contentType;
        }

        public final long contentLength() {
            return this.val$file.length();
        }

        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            Closeable closeable = null;
            try {
                closeable = Okio.source(this.val$file);
                bufferedSink.writeAll(closeable);
            } finally {
                Util.closeQuietly(closeable);
            }
        }
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public long contentLength() throws IOException {
        return -1;
    }

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(MediaType mediaType, ByteString byteString) {
        return new AnonymousClass1(mediaType, byteString);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        return new AnonymousClass2(mediaType, i2, bArr, i);
    }

    public static RequestBody create(MediaType mediaType, File file) {
        if (file != null) {
            return new AnonymousClass3(mediaType, file);
        }
        throw new NullPointerException("content == null");
    }
}
