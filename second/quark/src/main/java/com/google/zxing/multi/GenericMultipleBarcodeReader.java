package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    public final Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    public final Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        List arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        int i4 = i2;
        int i5 = i;
        List<Result> list2 = list;
        Map<DecodeHintType, ?> map2 = map;
        GenericMultipleBarcodeReader genericMultipleBarcodeReader = this;
        while (i3 <= 4) {
            try {
                Object obj;
                Result decode = genericMultipleBarcodeReader.delegate.decode(binaryBitmap, map2);
                for (Result text : list2) {
                    if (text.getText().equals(decode.getText())) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    list2.add(translateResultPoints(decode, i5, i4));
                }
                ResultPoint[] resultPoints = decode.getResultPoints();
                if (resultPoints != null && resultPoints.length != 0) {
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    float f = (float) width;
                    float f2 = (float) height;
                    float f3 = 0.0f;
                    float f4 = 0.0f;
                    int length = resultPoints.length;
                    int i6 = 0;
                    while (i6 < length) {
                        float y;
                        float f5;
                        ResultPoint resultPoint = resultPoints[i6];
                        if (resultPoint != null) {
                            float f6;
                            float x = resultPoint.getX();
                            y = resultPoint.getY();
                            if (x < f) {
                                f6 = x;
                            } else {
                                f6 = f;
                            }
                            if (y < f2) {
                                f2 = y;
                            }
                            if (x > f3) {
                                f = x;
                            } else {
                                f = f3;
                            }
                            if (y > f4) {
                                f3 = f6;
                            } else {
                                y = f4;
                                f3 = f6;
                            }
                        } else {
                            y = f4;
                            f5 = f3;
                            f3 = f;
                            f = f5;
                        }
                        i6++;
                        f4 = y;
                        f5 = f;
                        f = f3;
                        f3 = f5;
                    }
                    if (f > 100.0f) {
                        doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f, height), map2, list2, i5, i4, i3 + 1);
                    }
                    if (f2 > 100.0f) {
                        doDecodeMultiple(binaryBitmap.crop(0, 0, width, (int) f2), map2, list2, i5, i4, i3 + 1);
                    }
                    if (f3 < ((float) (width - 100))) {
                        Map<DecodeHintType, ?> map3 = map2;
                        List<Result> list3 = list2;
                        i6 = i4;
                        doDecodeMultiple(binaryBitmap.crop((int) f3, 0, width - ((int) f3), height), map3, list3, i5 + ((int) f3), i6, i3 + 1);
                    }
                    if (f4 < ((float) (height - 100))) {
                        binaryBitmap = binaryBitmap.crop(0, (int) f4, width, height - ((int) f4));
                        i4 += (int) f4;
                        i3++;
                    } else {
                        return;
                    }
                }
                return;
            } catch (ReaderException e) {
                return;
            }
        }
    }

    private static Result translateResultPoints(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            ResultPoint resultPoint = resultPoints[i3];
            if (resultPoint != null) {
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }
}
