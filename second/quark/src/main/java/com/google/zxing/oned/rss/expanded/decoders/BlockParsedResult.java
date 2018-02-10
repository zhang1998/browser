package com.google.zxing.oned.rss.expanded.decoders;

/* compiled from: ProGuard */
final class BlockParsedResult {
    private final DecodedInformation decodedInformation;
    private final boolean finished;

    BlockParsedResult(boolean z) {
        this(null, z);
    }

    BlockParsedResult(DecodedInformation decodedInformation, boolean z) {
        this.finished = z;
        this.decodedInformation = decodedInformation;
    }

    final DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    final boolean isFinished() {
        return this.finished;
    }
}
