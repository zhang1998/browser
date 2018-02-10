package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;

/* compiled from: ProGuard */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    static BitArray buildBitArray(List<ExpandedPair> list) {
        int i;
        int size = (list.size() * 2) - 1;
        if (((ExpandedPair) list.get(list.size() - 1)).getRightChar() == null) {
            i = size - 1;
        } else {
            i = size;
        }
        BitArray bitArray = new BitArray(i * 12);
        int value = ((ExpandedPair) list.get(0)).getRightChar().getValue();
        size = 11;
        i = 0;
        while (size >= 0) {
            if (((1 << size) & value) != 0) {
                bitArray.set(i);
            }
            size--;
            i++;
        }
        int i2 = 1;
        size = i;
        while (i2 < list.size()) {
            ExpandedPair expandedPair = (ExpandedPair) list.get(i2);
            int value2 = expandedPair.getLeftChar().getValue();
            value = 11;
            while (value >= 0) {
                if (((1 << value) & value2) != 0) {
                    bitArray.set(size);
                }
                value--;
                size++;
            }
            if (expandedPair.getRightChar() != null) {
                int value3 = expandedPair.getRightChar().getValue();
                i = size;
                size = 11;
                while (size >= 0) {
                    if (((1 << size) & value3) != 0) {
                        bitArray.set(i);
                    }
                    size--;
                    i++;
                }
            } else {
                i = size;
            }
            i2++;
            size = i;
        }
        return bitArray;
    }
}
