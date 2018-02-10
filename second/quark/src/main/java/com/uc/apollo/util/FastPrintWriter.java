package com.uc.apollo.util;

import android.util.Printer;
import com.uc.apollo.annotation.KeepForSdk;
import com.uc.apollo.impl.SettingsConst;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.android.spdy.SpdyProtocol;

@KeepForSdk
/* compiled from: ProGuard */
public class FastPrintWriter extends PrintWriter {
    private static Writer sDummyWriter = new a();
    private final boolean mAutoFlush;
    private final int mBufferLen;
    private final ByteBuffer mBytes;
    private CharsetEncoder mCharset;
    private boolean mIoError;
    private final OutputStream mOutputStream;
    private int mPos;
    private final Printer mPrinter;
    private final String mSeparator;
    private final char[] mText;
    private final Writer mWriter;

    public FastPrintWriter(OutputStream outputStream) {
        this(outputStream, false, (int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
    }

    public FastPrintWriter(OutputStream outputStream, boolean z) {
        this(outputStream, z, (int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
    }

    public FastPrintWriter(OutputStream outputStream, boolean z, int i) {
        super(sDummyWriter, z);
        if (outputStream == null) {
            throw new NullPointerException("out is null");
        }
        this.mBufferLen = i;
        this.mText = new char[i];
        this.mBytes = ByteBuffer.allocate(this.mBufferLen);
        this.mOutputStream = outputStream;
        this.mWriter = null;
        this.mPrinter = null;
        this.mAutoFlush = z;
        this.mSeparator = "\n";
        initDefaultEncoder();
    }

    public FastPrintWriter(Writer writer) {
        this(writer, false, (int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
    }

    public FastPrintWriter(Writer writer, boolean z) {
        this(writer, z, (int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
    }

    public FastPrintWriter(Writer writer, boolean z, int i) {
        super(sDummyWriter, z);
        if (writer == null) {
            throw new NullPointerException("wr is null");
        }
        this.mBufferLen = i;
        this.mText = new char[i];
        this.mBytes = null;
        this.mOutputStream = null;
        this.mWriter = writer;
        this.mPrinter = null;
        this.mAutoFlush = z;
        this.mSeparator = "\n";
        initDefaultEncoder();
    }

    public FastPrintWriter(Printer printer) {
        this(printer, 512);
    }

    public FastPrintWriter(Printer printer, int i) {
        super(sDummyWriter, true);
        if (printer == null) {
            throw new NullPointerException("pr is null");
        }
        this.mBufferLen = i;
        this.mText = new char[i];
        this.mBytes = null;
        this.mOutputStream = null;
        this.mWriter = null;
        this.mPrinter = printer;
        this.mAutoFlush = true;
        this.mSeparator = "\n";
        initDefaultEncoder();
    }

    private final void initEncoder(String str) throws UnsupportedEncodingException {
        try {
            this.mCharset = Charset.forName(str).newEncoder();
            this.mCharset.onMalformedInput(CodingErrorAction.REPLACE);
            this.mCharset.onUnmappableCharacter(CodingErrorAction.REPLACE);
        } catch (Exception e) {
            throw new UnsupportedEncodingException(str);
        }
    }

    public boolean checkError() {
        boolean z;
        flush();
        synchronized (this.lock) {
            z = this.mIoError;
        }
        return z;
    }

    protected void clearError() {
        synchronized (this.lock) {
            this.mIoError = false;
        }
    }

    protected void setError() {
        synchronized (this.lock) {
            this.mIoError = true;
        }
    }

    private final void initDefaultEncoder() {
        this.mCharset = Charset.defaultCharset().newEncoder();
        this.mCharset.onMalformedInput(CodingErrorAction.REPLACE);
        this.mCharset.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    private void appendLocked(char c) throws IOException {
        int i = this.mPos;
        if (i >= this.mBufferLen - 1) {
            flushLocked();
            i = this.mPos;
        }
        this.mText[i] = c;
        this.mPos = i + 1;
    }

    private void appendLocked(String str, int i, int i2) throws IOException {
        int i3 = this.mBufferLen;
        if (i2 > i3) {
            int i4 = i + i2;
            while (i < i4) {
                int i5 = i + i3;
                appendLocked(str, i, i5 < i4 ? i3 : i4 - i);
                i = i5;
            }
            return;
        }
        int i6 = this.mPos;
        if (i6 + i2 > i3) {
            flushLocked();
            i6 = this.mPos;
        }
        str.getChars(i, i + i2, this.mText, i6);
        this.mPos = i6 + i2;
    }

    private void appendLocked(char[] cArr, int i, int i2) throws IOException {
        int i3 = this.mBufferLen;
        if (i2 > i3) {
            int i4 = i + i2;
            while (i < i4) {
                int i5 = i + i3;
                appendLocked(cArr, i, i5 < i4 ? i3 : i4 - i);
                i = i5;
            }
            return;
        }
        int i6 = this.mPos;
        if (i6 + i2 > i3) {
            flushLocked();
            i6 = this.mPos;
        }
        System.arraycopy(cArr, i, this.mText, i6, i2);
        this.mPos = i6 + i2;
    }

    private void flushBytesLocked() throws IOException {
        int position = this.mBytes.position();
        if (position > 0) {
            this.mBytes.flip();
            this.mOutputStream.write(this.mBytes.array(), 0, position);
            this.mBytes.clear();
        }
    }

    private void flushLocked() throws IOException {
        if (this.mPos > 0) {
            if (this.mOutputStream != null) {
                CharBuffer wrap = CharBuffer.wrap(this.mText, 0, this.mPos);
                CoderResult encode = this.mCharset.encode(wrap, this.mBytes, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        flushBytesLocked();
                        encode = this.mCharset.encode(wrap, this.mBytes, true);
                    } else {
                        flushBytesLocked();
                        this.mOutputStream.flush();
                    }
                }
                throw new IOException(encode.toString());
            } else if (this.mWriter != null) {
                this.mWriter.write(this.mText, 0, this.mPos);
                this.mWriter.flush();
            } else {
                int length = this.mSeparator.length();
                if (length >= this.mPos) {
                    length = this.mPos;
                }
                int i = 0;
                while (i < length && this.mText[(this.mPos - 1) - i] == this.mSeparator.charAt((this.mSeparator.length() - 1) - i)) {
                    i++;
                }
                if (i >= this.mPos) {
                    this.mPrinter.println("");
                } else {
                    this.mPrinter.println(new String(this.mText, 0, this.mPos - i));
                }
            }
            this.mPos = 0;
        }
    }

    public void flush() {
        synchronized (this.lock) {
            try {
                flushLocked();
                if (this.mOutputStream != null) {
                    this.mOutputStream.flush();
                } else if (this.mWriter != null) {
                    this.mWriter.flush();
                }
            } catch (IOException e) {
                setError();
            }
        }
    }

    public void close() {
        synchronized (this.lock) {
            try {
                flushLocked();
                if (this.mOutputStream != null) {
                    this.mOutputStream.close();
                } else if (this.mWriter != null) {
                    this.mWriter.close();
                }
            } catch (IOException e) {
                setError();
            }
        }
    }

    public void print(char[] cArr) {
        synchronized (this.lock) {
            try {
                appendLocked(cArr, 0, cArr.length);
            } catch (IOException e) {
            }
        }
    }

    public void print(char c) {
        synchronized (this.lock) {
            try {
                appendLocked(c);
            } catch (IOException e) {
            }
        }
    }

    public void print(String str) {
        if (str == null) {
            str = String.valueOf(null);
        }
        synchronized (this.lock) {
            try {
                appendLocked(str, 0, str.length());
            } catch (IOException e) {
                setError();
            }
        }
    }

    public void print(int i) {
        if (i == 0) {
            print(SettingsConst.FALSE);
        } else {
            super.print(i);
        }
    }

    public void print(long j) {
        if (j == 0) {
            print(SettingsConst.FALSE);
        } else {
            super.print(j);
        }
    }

    public void println() {
        synchronized (this.lock) {
            try {
                appendLocked(this.mSeparator, 0, this.mSeparator.length());
                if (this.mAutoFlush) {
                    flushLocked();
                }
            } catch (IOException e) {
                setError();
            }
        }
    }

    public void println(int i) {
        if (i == 0) {
            println(SettingsConst.FALSE);
        } else {
            super.println(i);
        }
    }

    public void println(long j) {
        if (j == 0) {
            println(SettingsConst.FALSE);
        } else {
            super.println(j);
        }
    }

    public void println(char[] cArr) {
        print(cArr);
        println();
    }

    public void println(char c) {
        print(c);
        println();
    }

    public void write(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            try {
                appendLocked(cArr, i, i2);
            } catch (IOException e) {
            }
        }
    }

    public void write(int i) {
        synchronized (this.lock) {
            try {
                appendLocked((char) i);
            } catch (IOException e) {
            }
        }
    }

    public void write(String str) {
        synchronized (this.lock) {
            try {
                appendLocked(str, 0, str.length());
            } catch (IOException e) {
            }
        }
    }

    public void write(String str, int i, int i2) {
        synchronized (this.lock) {
            try {
                appendLocked(str, i, i2);
            } catch (IOException e) {
            }
        }
    }

    public PrintWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }
}
