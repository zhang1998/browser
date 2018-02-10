package com.google.zxing.qrcode.encoder;

/* compiled from: ProGuard */
final class MaskUtil {
    private static final int N1 = 3;
    private static final int N2 = 3;
    private static final int N3 = 40;
    private static final int N4 = 10;

    private MaskUtil() {
    }

    static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height - 1) {
            int i3 = 0;
            while (i3 < width - 1) {
                byte b = array[i][i3];
                if (b == array[i][i3 + 1] && b == array[i + 1][i3] && b == array[i + 1][i3 + 1]) {
                    i2++;
                }
                i3++;
            }
            i++;
        }
        return i2 * 3;
    }

    static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height) {
            int i3 = 0;
            while (i3 < width) {
                byte[] bArr = array[i];
                if (i3 + 6 < width && bArr[i3] == (byte) 1 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 1 && bArr[i3 + 3] == (byte) 1 && bArr[i3 + 4] == (byte) 1 && bArr[i3 + 5] == (byte) 0 && bArr[i3 + 6] == (byte) 1 && (isWhiteHorizontal(bArr, i3 - 4, i3) || isWhiteHorizontal(bArr, i3 + 7, i3 + 11))) {
                    i2++;
                }
                if (i + 6 < height && array[i][i3] == (byte) 1 && array[i + 1][i3] == (byte) 0 && array[i + 2][i3] == (byte) 1 && array[i + 3][i3] == (byte) 1 && array[i + 4][i3] == (byte) 1 && array[i + 5][i3] == (byte) 0 && array[i + 6][i3] == (byte) 1 && (isWhiteVertical(array, i3, i - 4, i) || isWhiteVertical(array, i3, i + 7, i + 11))) {
                    i2++;
                }
                i3++;
            }
            i++;
        }
        return i2 * 40;
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        int i;
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i2 = 0;
        for (int i3 = 0; i3 < height; i3++) {
            byte[] bArr = array[i3];
            for (i = 0; i < width; i++) {
                if (bArr[i] == (byte) 1) {
                    i2++;
                }
            }
        }
        i = byteMatrix.getHeight() * byteMatrix.getWidth();
        return ((Math.abs((i2 * 2) - i) * 10) / i) * 10;
    }

    static boolean getDataMaskBit(int i, int i2, int i3) {
        int i4;
        switch (i) {
            case 0:
                i4 = (i3 + i2) & 1;
                break;
            case 1:
                i4 = i3 & 1;
                break;
            case 2:
                i4 = i2 % 3;
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                break;
            case 4:
                i4 = ((i3 / 2) + (i2 / 3)) & 1;
                break;
            case 5:
                i4 = i3 * i2;
                i4 = (i4 % 3) + (i4 & 1);
                break;
            case 6:
                i4 = i3 * i2;
                i4 = ((i4 % 3) + (i4 & 1)) & 1;
                break;
            case 7:
                i4 = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i);
        }
        if (i4 == 0) {
            return true;
        }
        return false;
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i = 0;
        int i2 = 0;
        while (i < height) {
            byte b = (byte) -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < width) {
                int i5;
                int i6;
                byte b2;
                byte b3 = z ? array[i][i3] : array[i3][i];
                byte b4;
                if (b3 == b) {
                    b4 = b;
                    i5 = i4 + 1;
                    i6 = i2;
                    b2 = b4;
                } else {
                    if (i4 >= 5) {
                        i2 += (i4 - 5) + 3;
                    }
                    i5 = 1;
                    b4 = b3;
                    i6 = i2;
                    b2 = b4;
                }
                i3++;
                i4 = i5;
                b = b2;
                i2 = i6;
            }
            if (i4 >= 5) {
                i2 += (i4 - 5) + 3;
            }
            i++;
        }
        return i2;
    }
}
