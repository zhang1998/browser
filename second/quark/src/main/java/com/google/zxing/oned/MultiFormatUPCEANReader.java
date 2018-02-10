package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: ProGuard */
public final class MultiFormatUPCEANReader extends OneDReader {
    private final UPCEANReader[] readers;

    public MultiFormatUPCEANReader(Map<DecodeHintType, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new EAN13Reader());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new UPCAReader());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new EAN8Reader());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new UPCEReader());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new EAN13Reader());
            arrayList.add(new EAN8Reader());
            arrayList.add(new UPCEReader());
        }
        this.readers = (UPCEANReader[]) arrayList.toArray(new UPCEANReader[arrayList.size()]);
    }

    public final Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        int[] findStartGuardPattern = UPCEANReader.findStartGuardPattern(bitArray);
        UPCEANReader[] uPCEANReaderArr = this.readers;
        int length = uPCEANReaderArr.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                Collection collection;
                Result decodeRow = uPCEANReaderArr[i2].decodeRow(i, bitArray, findStartGuardPattern, map);
                int i3 = (decodeRow.getBarcodeFormat() == BarcodeFormat.EAN_13 && decodeRow.getText().charAt(0) == '0') ? 1 : 0;
                if (map == null) {
                    collection = null;
                } else {
                    collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                }
                if (collection == null || collection.contains(BarcodeFormat.UPC_A)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i3 == 0 || r0 == 0) {
                    return decodeRow;
                }
                Result result = new Result(decodeRow.getText().substring(1), decodeRow.getRawBytes(), decodeRow.getResultPoints(), BarcodeFormat.UPC_A);
                result.putAllMetadata(decodeRow.getResultMetadata());
                return result;
            } catch (ReaderException e) {
                i2++;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void reset() {
        for (Reader reset : this.readers) {
            reset.reset();
        }
    }
}
