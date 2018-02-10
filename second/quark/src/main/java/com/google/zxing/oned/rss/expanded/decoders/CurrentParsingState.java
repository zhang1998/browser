package com.google.zxing.oned.rss.expanded.decoders;

/* compiled from: ProGuard */
final class CurrentParsingState {
    private State encoding = State.NUMERIC;
    private int position = 0;

    /* compiled from: ProGuard */
    enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    CurrentParsingState() {
    }

    final int getPosition() {
        return this.position;
    }

    final void setPosition(int i) {
        this.position = i;
    }

    final void incrementPosition(int i) {
        this.position += i;
    }

    final boolean isAlpha() {
        return this.encoding == State.ALPHA;
    }

    final boolean isNumeric() {
        return this.encoding == State.NUMERIC;
    }

    final boolean isIsoIec646() {
        return this.encoding == State.ISO_IEC_646;
    }

    final void setNumeric() {
        this.encoding = State.NUMERIC;
    }

    final void setAlpha() {
        this.encoding = State.ALPHA;
    }

    final void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }
}
