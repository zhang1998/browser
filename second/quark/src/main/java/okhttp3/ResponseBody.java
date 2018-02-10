package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

/* compiled from: ProGuard */
public abstract class ResponseBody implements Closeable {
    private Reader reader;

    /* compiled from: ProGuard */
    final class AnonymousClass1 extends ResponseBody {
        final /* synthetic */ BufferedSource val$content;
        final /* synthetic */ long val$contentLength;
        final /* synthetic */ MediaType val$contentType;

        AnonymousClass1(MediaType mediaType, long j, BufferedSource bufferedSource) {
            this.val$contentType = mediaType;
            this.val$contentLength = j;
            this.val$content = bufferedSource;
        }

        public final MediaType contentType() {
            return this.val$contentType;
        }

        public final long contentLength() {
            return this.val$contentLength;
        }

        public final BufferedSource source() {
            return this.val$content;
        }
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        Closeable source = source();
        try {
            byte[] readByteArray = source.readByteArray();
            if (contentLength == -1 || contentLength == ((long) readByteArray.length)) {
                return readByteArray;
            }
            throw new IOException("Content-Length and stream length disagree");
        } finally {
            Util.closeQuietly(source);
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        reader = new InputStreamReader(byteStream(), charset());
        this.reader = reader;
        return reader;
    }

    public final String string() throws IOException {
        return new String(bytes(), charset().name());
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public void close() {
        Util.closeQuietly(source());
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
        }
        BufferedSource writeString = new Buffer().writeString(str, charset);
        return create(mediaType, writeString.size(), writeString);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new Buffer().write(bArr));
    }

    public static ResponseBody create(MediaType mediaType, long j, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new AnonymousClass1(mediaType, j, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }
}
