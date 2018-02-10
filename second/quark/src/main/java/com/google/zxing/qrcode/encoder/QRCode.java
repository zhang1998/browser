package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

/* compiled from: ProGuard */
public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;
    private ErrorCorrectionLevel ecLevel;
    private int maskPattern = -1;
    private ByteMatrix matrix;
    private Mode mode;
    private Version version;

    public final Mode getMode() {
        return this.mode;
    }

    public final ErrorCorrectionLevel getECLevel() {
        return this.ecLevel;
    }

    public final Version getVersion() {
        return this.version;
    }

    public final int getMaskPattern() {
        return this.maskPattern;
    }

    public final ByteMatrix getMatrix() {
        return this.matrix;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.mode);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.ecLevel);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.version);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.maskPattern);
        if (this.matrix == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.matrix);
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }

    public final void setMode(Mode mode) {
        this.mode = mode;
    }

    public final void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.ecLevel = errorCorrectionLevel;
    }

    public final void setVersion(Version version) {
        this.version = version;
    }

    public final void setMaskPattern(int i) {
        this.maskPattern = i;
    }

    public final void setMatrix(ByteMatrix byteMatrix) {
        this.matrix = byteMatrix;
    }

    public static boolean isValidMaskPattern(int i) {
        return i >= 0 && i < 8;
    }
}
