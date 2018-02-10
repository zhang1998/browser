package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        int i4 = i / 2;
        this.leftInit = i2 - i4;
        this.rightInit = i2 + i4;
        this.upInit = i3 - i4;
        this.downInit = i4 + i3;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public final ResultPoint[] detect() throws NotFoundException {
        int i;
        int i2;
        int i3;
        boolean z = false;
        int i4 = 1;
        int i5 = this.leftInit;
        int i6 = this.rightInit;
        int i7 = this.upInit;
        int i8 = this.downInit;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i9 = 1;
        while (i9 != 0) {
            boolean z7 = true;
            boolean z8 = z5;
            z5 = false;
            while (true) {
                if ((z7 || !z8) && i6 < this.width) {
                    z7 = containsBlackPoint(i7, i8, i6, false);
                    if (z7) {
                        i6++;
                        z8 = true;
                        z5 = true;
                    } else if (!z8) {
                        i6++;
                    }
                }
            }
            if (i6 >= this.width) {
                z = true;
                i = i7;
                i2 = i6;
                i3 = i8;
                i8 = i5;
                i5 = i3;
                break;
            }
            z7 = z4;
            z4 = z5;
            z5 = true;
            while (true) {
                if ((z5 || !z7) && i8 < this.height) {
                    z5 = containsBlackPoint(i5, i6, i8, true);
                    if (z5) {
                        i8++;
                        z7 = true;
                        z4 = true;
                    } else if (!z7) {
                        i8++;
                    }
                }
            }
            if (i8 >= this.height) {
                z = true;
                i = i7;
                i2 = i6;
                i3 = i8;
                i8 = i5;
                i5 = i3;
                break;
            }
            z5 = z3;
            z3 = z4;
            z4 = true;
            while (true) {
                if ((z4 || !z5) && i5 >= 0) {
                    z4 = containsBlackPoint(i7, i8, i5, false);
                    if (z4) {
                        i5--;
                        z5 = true;
                        z3 = true;
                    } else if (!z5) {
                        i5--;
                    }
                }
            }
            if (i5 < 0) {
                z = true;
                i = i7;
                i2 = i6;
                i3 = i8;
                i8 = i5;
                i5 = i3;
                break;
            }
            z4 = z3;
            z3 = z2;
            z2 = true;
            while (true) {
                if ((z2 || !z3) && i7 >= 0) {
                    z2 = containsBlackPoint(i5, i6, i7, true);
                    if (z2) {
                        i7--;
                        z3 = true;
                        z4 = true;
                    } else if (!z3) {
                        i7--;
                    }
                }
            }
            if (i7 < 0) {
                z = true;
                i = i7;
                i2 = i6;
                i3 = i8;
                i8 = i5;
                i5 = i3;
                break;
            }
            if (z4) {
                z6 = true;
            }
            z2 = z3;
            z3 = z5;
            z5 = z8;
            boolean z9 = z7;
            z7 = z4;
            z4 = z9;
        }
        i = i7;
        i2 = i6;
        i3 = i8;
        i8 = i5;
        i5 = i3;
        if (z || !r0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i10 = i2 - i8;
        int i11 = 1;
        ResultPoint resultPoint = null;
        while (resultPoint == null && i11 < i10) {
            i11++;
            resultPoint = getBlackPointOnSegment((float) i8, (float) (i5 - i11), (float) (i8 + i11), (float) i5);
        }
        if (resultPoint == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        i11 = 1;
        ResultPoint resultPoint2 = null;
        while (resultPoint2 == null && i11 < i10) {
            i11++;
            resultPoint2 = getBlackPointOnSegment((float) i8, (float) (i + i11), (float) (i8 + i11), (float) i);
        }
        if (resultPoint2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint3 = null;
        i8 = 1;
        while (resultPoint3 == null && i8 < i10) {
            ResultPoint blackPointOnSegment = getBlackPointOnSegment((float) i2, (float) (i + i8), (float) (i2 - i8), (float) i);
            i8++;
            resultPoint3 = blackPointOnSegment;
        }
        if (resultPoint3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        blackPointOnSegment = null;
        while (blackPointOnSegment == null && i4 < i10) {
            blackPointOnSegment = getBlackPointOnSegment((float) i2, (float) (i5 - i4), (float) (i2 - i4), (float) i5);
            i4++;
        }
        if (blackPointOnSegment != null) {
            return centerEdges(blackPointOnSegment, resultPoint, resultPoint3, resultPoint2);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = (f3 - f) / ((float) round);
        float f6 = (f4 - f2) / ((float) round);
        for (int i = 0; i < round; i++) {
            int round2 = MathUtils.round((((float) i) * f5) + f);
            int round3 = MathUtils.round((((float) i) * f6) + f2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x4 - IPictureView.DEFAULT_MIN_SCALE, y4 + IPictureView.DEFAULT_MIN_SCALE), new ResultPoint(x2 + IPictureView.DEFAULT_MIN_SCALE, y2 + IPictureView.DEFAULT_MIN_SCALE), new ResultPoint(x3 - IPictureView.DEFAULT_MIN_SCALE, y3 - IPictureView.DEFAULT_MIN_SCALE), new ResultPoint(x + IPictureView.DEFAULT_MIN_SCALE, y - IPictureView.DEFAULT_MIN_SCALE)};
        }
        return new ResultPoint[]{new ResultPoint(x4 + IPictureView.DEFAULT_MIN_SCALE, y4 + IPictureView.DEFAULT_MIN_SCALE), new ResultPoint(x2 + IPictureView.DEFAULT_MIN_SCALE, y2 - IPictureView.DEFAULT_MIN_SCALE), new ResultPoint(x3 - IPictureView.DEFAULT_MIN_SCALE, y3 + IPictureView.DEFAULT_MIN_SCALE), new ResultPoint(x - IPictureView.DEFAULT_MIN_SCALE, y - IPictureView.DEFAULT_MIN_SCALE)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.image.get(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
