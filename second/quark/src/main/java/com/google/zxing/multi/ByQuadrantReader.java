package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;

/* compiled from: ProGuard */
public final class ByQuadrantReader implements Reader {
    private final Reader delegate;

    public ByQuadrantReader(Reader reader) {
        this.delegate = reader;
    }

    public final Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        Result decode;
        int width = binaryBitmap.getWidth() / 2;
        int height = binaryBitmap.getHeight() / 2;
        try {
            return this.delegate.decode(binaryBitmap.crop(0, 0, width, height), map);
        } catch (NotFoundException e) {
            try {
                decode = this.delegate.decode(binaryBitmap.crop(width, 0, width, height), map);
                makeAbsolute(decode.getResultPoints(), width, 0);
                return decode;
            } catch (NotFoundException e2) {
                try {
                    decode = this.delegate.decode(binaryBitmap.crop(0, height, width, height), map);
                    makeAbsolute(decode.getResultPoints(), 0, height);
                    return decode;
                } catch (NotFoundException e3) {
                    try {
                        decode = this.delegate.decode(binaryBitmap.crop(width, height, width, height), map);
                        makeAbsolute(decode.getResultPoints(), width, height);
                        return decode;
                    } catch (NotFoundException e4) {
                        int i = width / 2;
                        int i2 = height / 2;
                        decode = this.delegate.decode(binaryBitmap.crop(i, i2, width, height), map);
                        makeAbsolute(decode.getResultPoints(), i, i2);
                        return decode;
                    }
                }
            }
        }
    }

    public final void reset() {
        this.delegate.reset();
    }

    private static void makeAbsolute(ResultPoint[] resultPointArr, int i, int i2) {
        if (resultPointArr != null) {
            for (int i3 = 0; i3 < resultPointArr.length; i3++) {
                ResultPoint resultPoint = resultPointArr[i3];
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
            }
        }
    }
}
