package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* compiled from: ProGuard */
final class AI01393xDecoder extends AI01decoder {
    private static final int FIRST_THREE_DIGITS_SIZE = 10;
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;

    AI01393xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public final String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder stringBuilder = new StringBuilder();
        encodeCompressedGtin(stringBuilder, 8);
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
        stringBuilder.append("(393");
        stringBuilder.append(extractNumericValueFromBitArray);
        stringBuilder.append(')');
        extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(50, 10);
        if (extractNumericValueFromBitArray / 100 == 0) {
            stringBuilder.append('0');
        }
        if (extractNumericValueFromBitArray / 10 == 0) {
            stringBuilder.append('0');
        }
        stringBuilder.append(extractNumericValueFromBitArray);
        stringBuilder.append(getGeneralDecoder().decodeGeneralPurposeField(60, null).getNewString());
        return stringBuilder.toString();
    }
}
