package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: ProGuard */
final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Source source;

    RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.source = source;
    }

    public final Buffer buffer() {
        return this.buffer;
    }

    public final long read(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (this.buffer.size == 0 && this.source.read(this.buffer, 8192) == -1) {
            return -1;
        } else {
            return this.buffer.read(buffer, Math.min(j, this.buffer.size));
        }
    }

    public final boolean exhausted() throws IOException {
        if (!this.closed) {
            return this.buffer.exhausted() && this.source.read(this.buffer, 8192) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final void require(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    public final boolean request(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else {
            while (this.buffer.size < j) {
                if (this.source.read(this.buffer, 8192) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public final byte readByte() throws IOException {
        require(1);
        return this.buffer.readByte();
    }

    public final ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    public final ByteString readByteString(long j) throws IOException {
        require(j);
        return this.buffer.readByteString(j);
    }

    public final int select(Options options) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int selectPrefix = this.buffer.selectPrefix(options);
            if (selectPrefix == -1) {
                return -1;
            }
            int size = options.byteStrings[selectPrefix].size();
            if (((long) size) <= this.buffer.size) {
                this.buffer.skip((long) size);
                return selectPrefix;
            }
        } while (this.source.read(this.buffer, 8192) != -1);
        return -1;
    }

    public final byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    public final byte[] readByteArray(long j) throws IOException {
        require(j);
        return this.buffer.readByteArray(j);
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final void readFully(byte[] bArr) throws IOException {
        try {
            require((long) bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e) {
            EOFException eOFException = e;
            int i = 0;
            while (this.buffer.size > 0) {
                int read = this.buffer.read(bArr, i, (int) this.buffer.size);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
            throw eOFException;
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        if (this.buffer.size == 0 && this.source.read(this.buffer, 8192) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i, (int) Math.min((long) i2, this.buffer.size));
    }

    public final void readFully(Buffer buffer, long j) throws IOException {
        try {
            require(j);
            this.buffer.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(this.buffer);
            throw e;
        }
    }

    public final long readAll(Sink sink) throws IOException {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.source.read(this.buffer, 8192) != -1) {
            long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(this.buffer, completeSegmentByteCount);
            }
        }
        if (this.buffer.size() <= 0) {
            return j;
        }
        j += this.buffer.size();
        sink.write(this.buffer, this.buffer.size());
        return j;
    }

    public final String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    public final String readUtf8(long j) throws IOException {
        require(j);
        return this.buffer.readUtf8(j);
    }

    public final String readString(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    public final String readString(long j, Charset charset) throws IOException {
        require(j);
        if (charset != null) {
            return this.buffer.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public final String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            return this.buffer.size != 0 ? readUtf8(this.buffer.size) : null;
        } else {
            return this.buffer.readUtf8Line(indexOf);
        }
    }

    public final String readUtf8LineStrict() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.buffer.readUtf8Line(indexOf);
        }
        Buffer buffer = new Buffer();
        this.buffer.copyTo(buffer, 0, Math.min(32, this.buffer.size()));
        throw new EOFException("\\n not found: size=" + this.buffer.size() + " content=" + buffer.readByteString().hex() + "…");
    }

    public final int readUtf8CodePoint() throws IOException {
        require(1);
        byte b = this.buffer.getByte(0);
        if ((b & 224) == 192) {
            require(2);
        } else if ((b & 240) == 224) {
            require(3);
        } else if ((b & 248) == 240) {
            require(4);
        }
        return this.buffer.readUtf8CodePoint();
    }

    public final short readShort() throws IOException {
        require(2);
        return this.buffer.readShort();
    }

    public final short readShortLe() throws IOException {
        require(2);
        return this.buffer.readShortLe();
    }

    public final int readInt() throws IOException {
        require(4);
        return this.buffer.readInt();
    }

    public final int readIntLe() throws IOException {
        require(4);
        return this.buffer.readIntLe();
    }

    public final long readLong() throws IOException {
        require(8);
        return this.buffer.readLong();
    }

    public final long readLongLe() throws IOException {
        require(8);
        return this.buffer.readLongLe();
    }

    public final long readDecimalLong() throws IOException {
        require(1);
        int i = 0;
        while (request((long) (i + 1))) {
            byte b = this.buffer.getByte((long) i);
            if ((b < (byte) 48 || b > (byte) 57) && !(i == 0 && b == (byte) 45)) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(b)}));
                }
                return this.buffer.readDecimalLong();
            }
            i++;
        }
        return this.buffer.readDecimalLong();
    }

    public final long readHexadecimalUnsignedLong() throws IOException {
        require(1);
        for (int i = 0; request((long) (i + 1)); i++) {
            byte b = this.buffer.getByte((long) i);
            if ((b < (byte) 48 || b > (byte) 57) && ((b < (byte) 97 || b > (byte) 102) && (b < (byte) 65 || b > (byte) 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
                }
                return this.buffer.readHexadecimalUnsignedLong();
            }
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }

    public final void skip(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.buffer.size == 0 && this.source.read(this.buffer, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.buffer.size());
            this.buffer.skip(min);
            j -= min;
        }
    }

    public final long indexOf(byte b) throws IOException {
        return indexOf(b, 0);
    }

    public final long indexOf(byte b, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(b, j);
            if (indexOf != -1) {
                return indexOf;
            }
            indexOf = this.buffer.size;
            if (this.source.read(this.buffer, 8192) == -1) {
                return -1;
            }
            j = Math.max(j, indexOf);
        }
    }

    public final long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public final long indexOf(ByteString byteString, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(byteString, j);
            if (indexOf != -1) {
                return indexOf;
            }
            indexOf = this.buffer.size;
            if (this.source.read(this.buffer, 8192) == -1) {
                return -1;
            }
            j = Math.max(j, (indexOf - ((long) byteString.size())) + 1);
        }
    }

    public final long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0);
    }

    public final long indexOfElement(ByteString byteString, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.buffer.indexOfElement(byteString, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            indexOfElement = this.buffer.size;
            if (this.source.read(this.buffer, 8192) == -1) {
                return -1;
            }
            j = Math.max(j, indexOfElement);
        }
    }

    public final boolean rangeEquals(long j, ByteString byteString) throws IOException {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public final boolean rangeEquals(long j, ByteString byteString, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        } else {
            int i3 = 0;
            while (i3 < i2) {
                long j2 = ((long) i3) + j;
                if (!request(1 + j2) || this.buffer.getByte(j2) != byteString.getByte(i + i3)) {
                    return false;
                }
                i3++;
            }
            return true;
        }
    }

    public final InputStream inputStream() {
        return new InputStream() {
            public int read() throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                } else if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 8192) == -1) {
                    return -1;
                } else {
                    return RealBufferedSource.this.buffer.readByte() & 255;
                }
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
                if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 8192) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.read(bArr, i, i2);
            }

            public int available() throws IOException {
                if (!RealBufferedSource.this.closed) {
                    return (int) Math.min(RealBufferedSource.this.buffer.size, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }
        };
    }

    public final void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.buffer.clear();
        }
    }

    public final Timeout timeout() {
        return this.source.timeout();
    }

    public final String toString() {
        return "buffer(" + this.source + ")";
    }
}
