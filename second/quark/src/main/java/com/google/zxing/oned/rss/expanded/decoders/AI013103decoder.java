package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* compiled from: ProGuard */
final class AI013103decoder extends AI013x0xDecoder {
    AI013103decoder(BitArray bitArray) {
        super(bitArray);
    }

    protected final void addWeightCode(StringBuilder stringBuilder, int i) {
        stringBuilder.append("(3103)");
    }

    protected final int checkWeight(int i) {
        return i;
    }
}
