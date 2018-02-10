package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.ReaderException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* compiled from: ProGuard */
public final class Decoder {
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);

    public final DecoderResult decode(boolean[][] zArr) throws ChecksumException, FormatException {
        return decode(zArr, null);
    }

    public final DecoderResult decode(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        int length = zArr.length;
        BitMatrix bitMatrix = new BitMatrix(length);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length; i2++) {
                if (zArr[i][i2]) {
                    bitMatrix.set(i2, i);
                }
            }
        }
        return decode(bitMatrix, (Map) map);
    }

    public final DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, null);
    }

    public final DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        DecoderResult decode;
        ChecksumException checksumException;
        FormatException e;
        ReaderException readerException = null;
        BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
        try {
            decode = decode(bitMatrixParser, (Map) map);
        } catch (FormatException e2) {
            FormatException formatException = e2;
            checksumException = readerException;
            try {
                bitMatrixParser.remask();
                bitMatrixParser.setMirror(true);
                bitMatrixParser.readVersion();
                bitMatrixParser.readFormatInformation();
                bitMatrixParser.mirror();
                decode = decode(bitMatrixParser, (Map) map);
                decode.setOther(new QRCodeDecoderMetaData(true));
                return decode;
            } catch (FormatException e3) {
                e = e3;
                if (formatException != null) {
                    throw formatException;
                } else if (checksumException == null) {
                    throw checksumException;
                } else {
                    throw e;
                }
            } catch (ChecksumException e4) {
                e = e4;
                if (formatException != null) {
                    throw formatException;
                } else if (checksumException == null) {
                    throw e;
                } else {
                    throw checksumException;
                }
            }
        } catch (ChecksumException e5) {
            checksumException = e5;
            ReaderException readerException2 = readerException;
            bitMatrixParser.remask();
            bitMatrixParser.setMirror(true);
            bitMatrixParser.readVersion();
            bitMatrixParser.readFormatInformation();
            bitMatrixParser.mirror();
            decode = decode(bitMatrixParser, (Map) map);
            decode.setOther(new QRCodeDecoderMetaData(true));
            return decode;
        }
        return decode;
    }

    private DecoderResult decode(BitMatrixParser bitMatrixParser, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        Version readVersion = bitMatrixParser.readVersion();
        ErrorCorrectionLevel errorCorrectionLevel = bitMatrixParser.readFormatInformation().getErrorCorrectionLevel();
        DataBlock[] dataBlocks = DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), readVersion, errorCorrectionLevel);
        int i = 0;
        for (DataBlock numDataCodewords : dataBlocks) {
            i += numDataCodewords.getNumDataCodewords();
        }
        byte[] bArr = new byte[i];
        int length = dataBlocks.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            DataBlock dataBlock = dataBlocks[i3];
            byte[] codewords = dataBlock.getCodewords();
            int numDataCodewords2 = dataBlock.getNumDataCodewords();
            correctErrors(codewords, numDataCodewords2);
            i = i2;
            i2 = 0;
            while (i2 < numDataCodewords2) {
                int i4 = i + 1;
                bArr[i] = codewords[i2];
                i2++;
                i = i4;
            }
            i3++;
            i2 = i;
        }
        return DecodedBitStreamParser.decode(bArr, readVersion, errorCorrectionLevel, map);
    }

    private void correctErrors(byte[] bArr, int i) throws ChecksumException {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.rsDecoder.decode(iArr, bArr.length - i);
            while (i2 < i) {
                bArr[i2] = (byte) iArr[i2];
                i2++;
            }
        } catch (ReedSolomonException e) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
