package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* compiled from: ProGuard */
final class AI01392xDecoder extends AI01decoder {
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;

    AI01392xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public final String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder stringBuilder = new StringBuilder();
        encodeCompressedGtin(stringBuilder, 8);
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
        stringBuilder.append("(392");
        stringBuilder.append(extractNumericValueFromBitArray);
        stringBuilder.append(')');
        stringBuilder.append(getGeneralDecoder().decodeGeneralPurposeField(50, null).getNewString());
        return stringBuilder.toString();
    }
}
