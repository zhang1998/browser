package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* compiled from: ProGuard */
final class GeneralAppIdDecoder {
    private final StringBuilder buffer = new StringBuilder();
    private final CurrentParsingState current = new CurrentParsingState();
    private final BitArray information;

    GeneralAppIdDecoder(BitArray bitArray) {
        this.information = bitArray;
    }

    final String decodeAllCodes(StringBuilder stringBuilder, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            DecodedInformation decodeGeneralPurposeField = decodeGeneralPurposeField(i, str);
            str = FieldParser.parseFieldsInGeneralPurpose(decodeGeneralPurposeField.getNewString());
            if (str != null) {
                stringBuilder.append(str);
            }
            if (decodeGeneralPurposeField.isRemaining()) {
                str = String.valueOf(decodeGeneralPurposeField.getRemainingValue());
            } else {
                str = null;
            }
            if (i == decodeGeneralPurposeField.getNewPosition()) {
                return stringBuilder.toString();
            }
            i = decodeGeneralPurposeField.getNewPosition();
        }
    }

    private boolean isStillNumeric(int i) {
        if (i + 7 <= this.information.getSize()) {
            for (int i2 = i; i2 < i + 3; i2++) {
                if (this.information.get(i2)) {
                    return true;
                }
            }
            return this.information.get(i + 3);
        } else if (i + 4 <= this.information.getSize()) {
            return true;
        } else {
            return false;
        }
    }

    private DecodedNumeric decodeNumeric(int i) throws FormatException {
        if (i + 7 > this.information.getSize()) {
            int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 4);
            if (extractNumericValueFromBitArray == 0) {
                return new DecodedNumeric(this.information.getSize(), 10, 10);
            }
            return new DecodedNumeric(this.information.getSize(), extractNumericValueFromBitArray - 1, 10);
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
        return new DecodedNumeric(i + 7, (extractNumericValueFromBitArray2 - 8) / 11, (extractNumericValueFromBitArray2 - 8) % 11);
    }

    final int extractNumericValueFromBitArray(int i, int i2) {
        return extractNumericValueFromBitArray(this.information, i, i2);
    }

    static int extractNumericValueFromBitArray(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    final DecodedInformation decodeGeneralPurposeField(int i, String str) throws FormatException {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.setPosition(i);
        DecodedInformation parseBlocks = parseBlocks();
        if (parseBlocks == null || !parseBlocks.isRemaining()) {
            return new DecodedInformation(this.current.getPosition(), this.buffer.toString());
        }
        return new DecodedInformation(this.current.getPosition(), this.buffer.toString(), parseBlocks.getRemainingValue());
    }

    private DecodedInformation parseBlocks() throws FormatException {
        BlockParsedResult parseAlphaBlock;
        boolean isFinished;
        do {
            int position = this.current.getPosition();
            if (this.current.isAlpha()) {
                parseAlphaBlock = parseAlphaBlock();
                isFinished = parseAlphaBlock.isFinished();
            } else if (this.current.isIsoIec646()) {
                parseAlphaBlock = parseIsoIec646Block();
                isFinished = parseAlphaBlock.isFinished();
            } else {
                parseAlphaBlock = parseNumericBlock();
                isFinished = parseAlphaBlock.isFinished();
            }
            if ((position != this.current.getPosition() ? 1 : null) == null && !isFinished) {
                break;
            }
        } while (!isFinished);
        return parseAlphaBlock.getDecodedInformation();
    }

    private BlockParsedResult parseNumericBlock() throws FormatException {
        while (isStillNumeric(this.current.getPosition())) {
            DecodedNumeric decodeNumeric = decodeNumeric(this.current.getPosition());
            this.current.setPosition(decodeNumeric.getNewPosition());
            if (decodeNumeric.isFirstDigitFNC1()) {
                DecodedInformation decodedInformation;
                if (decodeNumeric.isSecondDigitFNC1()) {
                    decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString());
                } else {
                    decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodeNumeric.getSecondDigit());
                }
                return new BlockParsedResult(decodedInformation, true);
            }
            this.buffer.append(decodeNumeric.getFirstDigit());
            if (decodeNumeric.isSecondDigitFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeNumeric.getSecondDigit());
        }
        if (isNumericToAlphaNumericLatch(this.current.getPosition())) {
            this.current.setAlpha();
            this.current.incrementPosition(4);
        }
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseIsoIec646Block() throws FormatException {
        while (isStillIsoIec646(this.current.getPosition())) {
            DecodedChar decodeIsoIec646 = decodeIsoIec646(this.current.getPosition());
            this.current.setPosition(decodeIsoIec646.getNewPosition());
            if (decodeIsoIec646.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeIsoIec646.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setAlpha();
        }
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseAlphaBlock() {
        while (isStillAlpha(this.current.getPosition())) {
            DecodedChar decodeAlphanumeric = decodeAlphanumeric(this.current.getPosition());
            this.current.setPosition(decodeAlphanumeric.getNewPosition());
            if (decodeAlphanumeric.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeAlphanumeric.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setIsoIec646();
        }
        return new BlockParsedResult(false);
    }

    private boolean isStillIsoIec646(int i) {
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 16) {
            return true;
        }
        if (i + 7 > this.information.getSize()) {
            return false;
        }
        extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 7);
        if (extractNumericValueFromBitArray >= 64 && extractNumericValueFromBitArray < 116) {
            return true;
        }
        if (i + 8 > this.information.getSize()) {
            return false;
        }
        extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 8);
        if (extractNumericValueFromBitArray < 232 || extractNumericValueFromBitArray >= 253) {
            return false;
        }
        return true;
    }

    private DecodedChar decodeIsoIec646(int i) throws FormatException {
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 7);
        if (extractNumericValueFromBitArray >= 64 && extractNumericValueFromBitArray < 90) {
            return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray + 1));
        }
        if (extractNumericValueFromBitArray >= 90 && extractNumericValueFromBitArray < 116) {
            return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray + 7));
        }
        char c;
        switch (extractNumericValueFromBitArray(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new DecodedChar(i + 8, c);
    }

    private boolean isStillAlpha(int i) {
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 16) {
            return true;
        }
        if (i + 6 > this.information.getSize()) {
            return false;
        }
        extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 6);
        if (extractNumericValueFromBitArray < 16 || extractNumericValueFromBitArray >= 63) {
            return false;
        }
        return true;
    }

    private DecodedChar decodeAlphanumeric(int i) {
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 6);
        if (extractNumericValueFromBitArray >= 32 && extractNumericValueFromBitArray < 58) {
            return new DecodedChar(i + 6, (char) (extractNumericValueFromBitArray + 33));
        }
        char c;
        switch (extractNumericValueFromBitArray) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + extractNumericValueFromBitArray);
        }
        return new DecodedChar(i + 6, c);
    }

    private boolean isAlphaTo646ToAlphaLatch(int i) {
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 5 && i2 + i < this.information.getSize()) {
            if (i2 == 2) {
                if (!this.information.get(i + 2)) {
                    return false;
                }
            } else if (this.information.get(i + i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean isAlphaOr646ToNumericLatch(int i) {
        if (i + 3 > this.information.getSize()) {
            return false;
        }
        for (int i2 = i; i2 < i + 3; i2++) {
            if (this.information.get(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int i) {
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 4 && i2 + i < this.information.getSize()) {
            if (this.information.get(i + i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }
}
