package com.google.zxing.common.reedsolomon;

/* compiled from: ProGuard */
final class GenericGFPoly {
    private final int[] coefficients;
    private final GenericGF field;

    GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.field = genericGF;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.coefficients = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.coefficients = new int[]{0};
            return;
        }
        this.coefficients = new int[(length - i)];
        System.arraycopy(iArr, i, this.coefficients, 0, this.coefficients.length);
    }

    final int[] getCoefficients() {
        return this.coefficients;
    }

    final int getDegree() {
        return this.coefficients.length - 1;
    }

    final boolean isZero() {
        return this.coefficients[0] == 0;
    }

    final int getCoefficient(int i) {
        return this.coefficients[(this.coefficients.length - 1) - i];
    }

    final int evaluateAt(int i) {
        int i2 = 0;
        if (i == 0) {
            return getCoefficient(0);
        }
        int length;
        int i3;
        if (i == 1) {
            int[] iArr = this.coefficients;
            length = iArr.length;
            i3 = 0;
            while (i2 < length) {
                i3 = GenericGF.addOrSubtract(i3, iArr[i2]);
                i2++;
            }
            return i3;
        }
        i2 = this.coefficients[0];
        length = this.coefficients.length;
        i3 = i2;
        i2 = 1;
        while (i2 < length) {
            int addOrSubtract = GenericGF.addOrSubtract(this.field.multiply(i, i3), this.coefficients[i2]);
            i2++;
            i3 = addOrSubtract;
        }
        return i3;
    }

    final GenericGFPoly addOrSubtract(GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (isZero()) {
            return genericGFPoly;
        } else {
            if (genericGFPoly.isZero()) {
                return this;
            }
            Object obj = this.coefficients;
            Object obj2 = genericGFPoly.coefficients;
            if (obj.length <= obj2.length) {
                Object obj3 = obj;
                obj = obj2;
                obj2 = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r0.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = GenericGF.addOrSubtract(r0[i - length], obj[i]);
            }
            return new GenericGFPoly(this.field, obj4);
        }
    }

    final GenericGFPoly multiply(GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (isZero() || genericGFPoly.isZero()) {
            return this.field.getZero();
        } else {
            int[] iArr = this.coefficients;
            int length = iArr.length;
            int[] iArr2 = genericGFPoly.coefficients;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = GenericGF.addOrSubtract(iArr3[i + i3], this.field.multiply(i2, iArr2[i3]));
                }
            }
            return new GenericGFPoly(this.field, iArr3);
        }
    }

    final GenericGFPoly multiply(int i) {
        if (i == 0) {
            return this.field.getZero();
        }
        if (i == 1) {
            return this;
        }
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.field.multiply(this.coefficients[i2], i);
        }
        return new GenericGFPoly(this.field, iArr);
    }

    final GenericGFPoly multiplyByMonomial(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.field.getZero();
        } else {
            int length = this.coefficients.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.field.multiply(this.coefficients[i3], i2);
            }
            return new GenericGFPoly(this.field, iArr);
        }
    }

    final GenericGFPoly[] divide(GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (genericGFPoly.isZero()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            GenericGFPoly zero = this.field.getZero();
            int inverse = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
            GenericGFPoly genericGFPoly2 = zero;
            zero = this;
            while (zero.getDegree() >= genericGFPoly.getDegree() && !zero.isZero()) {
                int degree = zero.getDegree() - genericGFPoly.getDegree();
                int multiply = this.field.multiply(zero.getCoefficient(zero.getDegree()), inverse);
                GenericGFPoly multiplyByMonomial = genericGFPoly.multiplyByMonomial(degree, multiply);
                genericGFPoly2 = genericGFPoly2.addOrSubtract(this.field.buildMonomial(degree, multiply));
                zero = zero.addOrSubtract(multiplyByMonomial);
            }
            return new GenericGFPoly[]{genericGFPoly2, zero};
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    stringBuilder.append(" - ");
                    coefficient = -coefficient;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    coefficient = this.field.log(coefficient);
                    if (coefficient == 0) {
                        stringBuilder.append('1');
                    } else if (coefficient == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(coefficient);
                    }
                }
                if (degree != 0) {
                    if (degree == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(degree);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
