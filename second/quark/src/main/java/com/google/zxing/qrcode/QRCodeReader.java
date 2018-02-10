package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class QRCodeReader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    public final Decoder getDecoder() {
        return this.decoder;
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        DecoderResult decode;
        ResultPoint[] points;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
            decode = this.decoder.decode(detect.getBits(), (Map) map);
            points = detect.getPoints();
        } else {
            decode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), (Map) map);
            points = NO_POINTS;
        }
        if (decode.getOther() instanceof QRCodeDecoderMetaData) {
            ((QRCodeDecoderMetaData) decode.getOther()).applyMirroredCorrection(points);
        }
        Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.QR_CODE);
        List byteSegments = decode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        if (decode.hasStructuredAppend()) {
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decode.getStructuredAppendSequenceNumber()));
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decode.getStructuredAppendParity()));
        }
        return result;
    }

    public void reset() {
    }

    private static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float moduleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = bottomRightOnBit[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (i2 - i != i4 - i3) {
            i4 = (i2 - i) + i3;
            if (i4 >= bitMatrix.getWidth()) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        int round = Math.round(((float) ((i4 - i3) + 1)) / moduleSize);
        int round2 = Math.round(((float) ((i2 - i) + 1)) / moduleSize);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        } else if (round2 != round) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            int i5 = (int) (moduleSize / 2.0f);
            int i6 = i + i5;
            i = i3 + i5;
            i4 = (((int) (((float) (round - 1)) * moduleSize)) + i) - i4;
            if (i4 <= 0) {
                i3 = i;
            } else if (i4 > i5) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                i3 = i - i4;
            }
            i4 = (((int) (((float) (round2 - 1)) * moduleSize)) + i6) - i2;
            if (i4 <= 0) {
                i4 = i6;
            } else if (i4 > i5) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                i4 = i6 - i4;
            }
            BitMatrix bitMatrix2 = new BitMatrix(round, round2);
            for (i = 0; i < round2; i++) {
                i5 = i4 + ((int) (((float) i) * moduleSize));
                for (i6 = 0; i6 < round; i6++) {
                    if (bitMatrix.get(((int) (((float) i6) * moduleSize)) + i3, i5)) {
                        bitMatrix2.set(i6, i);
                    }
                }
            }
            return bitMatrix2;
        }
    }

    private static float moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = i;
        int i4 = 0;
        while (i3 < width && i2 < height) {
            boolean z2;
            if (z != bitMatrix.get(i3, i2)) {
                i = i4 + 1;
                if (i == 5) {
                    break;
                }
                boolean z3;
                if (z) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                int i5 = i;
                z2 = z3;
                i4 = i5;
            } else {
                z2 = z;
            }
            i3++;
            i2++;
            z = z2;
        }
        if (i3 != width && i2 != height) {
            return ((float) (i3 - iArr[0])) / 7.0f;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
