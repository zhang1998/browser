package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

/* compiled from: ProGuard */
final class DecodedNumeric extends DecodedObject {
    static final int FNC1 = 10;
    private final int firstDigit;
    private final int secondDigit;

    DecodedNumeric(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.firstDigit = i2;
        this.secondDigit = i3;
    }

    final int getFirstDigit() {
        return this.firstDigit;
    }

    final int getSecondDigit() {
        return this.secondDigit;
    }

    final int getValue() {
        return (this.firstDigit * 10) + this.secondDigit;
    }

    final boolean isFirstDigitFNC1() {
        return this.firstDigit == 10;
    }

    final boolean isSecondDigitFNC1() {
        return this.secondDigit == 10;
    }

    final boolean isAnyFNC1() {
        return this.firstDigit == 10 || this.secondDigit == 10;
    }
}
