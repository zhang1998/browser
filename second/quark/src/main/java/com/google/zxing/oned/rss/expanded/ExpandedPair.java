package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

/* compiled from: ProGuard */
final class ExpandedPair {
    private final FinderPattern finderPattern;
    private final DataCharacter leftChar;
    private final boolean mayBeLast;
    private final DataCharacter rightChar;

    ExpandedPair(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern, boolean z) {
        this.leftChar = dataCharacter;
        this.rightChar = dataCharacter2;
        this.finderPattern = finderPattern;
        this.mayBeLast = z;
    }

    final boolean mayBeLast() {
        return this.mayBeLast;
    }

    final DataCharacter getLeftChar() {
        return this.leftChar;
    }

    final DataCharacter getRightChar() {
        return this.rightChar;
    }

    final FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    public final boolean mustBeLast() {
        return this.rightChar == null;
    }

    public final String toString() {
        Object obj;
        StringBuilder append = new StringBuilder("[ ").append(this.leftChar).append(" , ").append(this.rightChar).append(" : ");
        if (this.finderPattern == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(this.finderPattern.getValue());
        }
        return append.append(obj).append(" ]").toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ExpandedPair)) {
            return false;
        }
        ExpandedPair expandedPair = (ExpandedPair) obj;
        if (equalsOrNull(this.leftChar, expandedPair.leftChar) && equalsOrNull(this.rightChar, expandedPair.rightChar) && equalsOrNull(this.finderPattern, expandedPair.finderPattern)) {
            return true;
        }
        return false;
    }

    private static boolean equalsOrNull(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    public final int hashCode() {
        return (hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar)) ^ hashNotNull(this.finderPattern);
    }

    private static int hashNotNull(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }
}
