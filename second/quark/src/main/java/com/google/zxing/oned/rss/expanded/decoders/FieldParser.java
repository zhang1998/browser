package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

/* compiled from: ProGuard */
final class FieldParser {
    private static final Object[][] FOUR_DIGIT_DATA_LENGTH;
    private static final Object[][] THREE_DIGIT_DATA_LENGTH;
    private static final Object[][] THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH;
    private static final Object[][] TWO_DIGIT_DATA_LENGTH;
    private static final Object VARIABLE_LENGTH = new Object();

    static {
        r0 = new Object[24][];
        r0[0] = new Object[]{"00", Integer.valueOf(18)};
        r0[1] = new Object[]{"01", Integer.valueOf(14)};
        r0[2] = new Object[]{"02", Integer.valueOf(14)};
        r0[3] = new Object[]{"10", VARIABLE_LENGTH, Integer.valueOf(20)};
        r0[4] = new Object[]{"11", Integer.valueOf(6)};
        r0[5] = new Object[]{"12", Integer.valueOf(6)};
        r0[6] = new Object[]{"13", Integer.valueOf(6)};
        r0[7] = new Object[]{"15", Integer.valueOf(6)};
        r0[8] = new Object[]{"17", Integer.valueOf(6)};
        r0[9] = new Object[]{"20", Integer.valueOf(2)};
        r0[10] = new Object[]{"21", VARIABLE_LENGTH, Integer.valueOf(20)};
        r0[11] = new Object[]{"22", VARIABLE_LENGTH, Integer.valueOf(29)};
        r0[12] = new Object[]{"30", VARIABLE_LENGTH, Integer.valueOf(8)};
        r0[13] = new Object[]{"37", VARIABLE_LENGTH, Integer.valueOf(8)};
        r0[14] = new Object[]{"90", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[15] = new Object[]{"91", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[16] = new Object[]{"92", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[17] = new Object[]{"93", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[18] = new Object[]{"94", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[19] = new Object[]{"95", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[20] = new Object[]{"96", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[21] = new Object[]{"97", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[22] = new Object[]{"98", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[23] = new Object[]{"99", VARIABLE_LENGTH, Integer.valueOf(30)};
        TWO_DIGIT_DATA_LENGTH = r0;
        r0 = new Object[23][];
        r0[0] = new Object[]{"240", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[1] = new Object[]{"241", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[2] = new Object[]{"242", VARIABLE_LENGTH, Integer.valueOf(6)};
        r0[3] = new Object[]{"250", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[4] = new Object[]{"251", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[5] = new Object[]{"253", VARIABLE_LENGTH, Integer.valueOf(17)};
        r0[6] = new Object[]{"254", VARIABLE_LENGTH, Integer.valueOf(20)};
        r0[7] = new Object[]{"400", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[8] = new Object[]{"401", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[9] = new Object[]{"402", Integer.valueOf(17)};
        r0[10] = new Object[]{"403", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[11] = new Object[]{"410", Integer.valueOf(13)};
        r0[12] = new Object[]{"411", Integer.valueOf(13)};
        r0[13] = new Object[]{"412", Integer.valueOf(13)};
        r0[14] = new Object[]{"413", Integer.valueOf(13)};
        r0[15] = new Object[]{"414", Integer.valueOf(13)};
        r0[16] = new Object[]{"420", VARIABLE_LENGTH, Integer.valueOf(20)};
        r0[17] = new Object[]{"421", VARIABLE_LENGTH, Integer.valueOf(15)};
        r0[18] = new Object[]{"422", Integer.valueOf(3)};
        r0[19] = new Object[]{"423", VARIABLE_LENGTH, Integer.valueOf(15)};
        r0[20] = new Object[]{"424", Integer.valueOf(3)};
        r0[21] = new Object[]{"425", Integer.valueOf(3)};
        r0[22] = new Object[]{"426", Integer.valueOf(3)};
        THREE_DIGIT_DATA_LENGTH = r0;
        r0 = new Object[57][];
        r0[0] = new Object[]{"310", Integer.valueOf(6)};
        r0[1] = new Object[]{"311", Integer.valueOf(6)};
        r0[2] = new Object[]{"312", Integer.valueOf(6)};
        r0[3] = new Object[]{"313", Integer.valueOf(6)};
        r0[4] = new Object[]{"314", Integer.valueOf(6)};
        r0[5] = new Object[]{"315", Integer.valueOf(6)};
        r0[6] = new Object[]{"316", Integer.valueOf(6)};
        r0[7] = new Object[]{"320", Integer.valueOf(6)};
        r0[8] = new Object[]{"321", Integer.valueOf(6)};
        r0[9] = new Object[]{"322", Integer.valueOf(6)};
        r0[10] = new Object[]{"323", Integer.valueOf(6)};
        r0[11] = new Object[]{"324", Integer.valueOf(6)};
        r0[12] = new Object[]{"325", Integer.valueOf(6)};
        r0[13] = new Object[]{"326", Integer.valueOf(6)};
        r0[14] = new Object[]{"327", Integer.valueOf(6)};
        r0[15] = new Object[]{"328", Integer.valueOf(6)};
        r0[16] = new Object[]{"329", Integer.valueOf(6)};
        r0[17] = new Object[]{"330", Integer.valueOf(6)};
        r0[18] = new Object[]{"331", Integer.valueOf(6)};
        r0[19] = new Object[]{"332", Integer.valueOf(6)};
        r0[20] = new Object[]{"333", Integer.valueOf(6)};
        r0[21] = new Object[]{"334", Integer.valueOf(6)};
        r0[22] = new Object[]{"335", Integer.valueOf(6)};
        r0[23] = new Object[]{"336", Integer.valueOf(6)};
        r0[24] = new Object[]{"340", Integer.valueOf(6)};
        r0[25] = new Object[]{"341", Integer.valueOf(6)};
        r0[26] = new Object[]{"342", Integer.valueOf(6)};
        r0[27] = new Object[]{"343", Integer.valueOf(6)};
        r0[28] = new Object[]{"344", Integer.valueOf(6)};
        r0[29] = new Object[]{"345", Integer.valueOf(6)};
        r0[30] = new Object[]{"346", Integer.valueOf(6)};
        r0[31] = new Object[]{"347", Integer.valueOf(6)};
        r0[32] = new Object[]{"348", Integer.valueOf(6)};
        r0[33] = new Object[]{"349", Integer.valueOf(6)};
        r0[34] = new Object[]{"350", Integer.valueOf(6)};
        r0[35] = new Object[]{"351", Integer.valueOf(6)};
        r0[36] = new Object[]{"352", Integer.valueOf(6)};
        r0[37] = new Object[]{"353", Integer.valueOf(6)};
        r0[38] = new Object[]{"354", Integer.valueOf(6)};
        r0[39] = new Object[]{"355", Integer.valueOf(6)};
        r0[40] = new Object[]{"356", Integer.valueOf(6)};
        r0[41] = new Object[]{"357", Integer.valueOf(6)};
        r0[42] = new Object[]{"360", Integer.valueOf(6)};
        r0[43] = new Object[]{"361", Integer.valueOf(6)};
        r0[44] = new Object[]{"362", Integer.valueOf(6)};
        r0[45] = new Object[]{"363", Integer.valueOf(6)};
        r0[46] = new Object[]{"364", Integer.valueOf(6)};
        r0[47] = new Object[]{"365", Integer.valueOf(6)};
        r0[48] = new Object[]{"366", Integer.valueOf(6)};
        r0[49] = new Object[]{"367", Integer.valueOf(6)};
        r0[50] = new Object[]{"368", Integer.valueOf(6)};
        r0[51] = new Object[]{"369", Integer.valueOf(6)};
        r0[52] = new Object[]{"390", VARIABLE_LENGTH, Integer.valueOf(15)};
        r0[53] = new Object[]{"391", VARIABLE_LENGTH, Integer.valueOf(18)};
        r0[54] = new Object[]{"392", VARIABLE_LENGTH, Integer.valueOf(15)};
        r0[55] = new Object[]{"393", VARIABLE_LENGTH, Integer.valueOf(18)};
        r0[56] = new Object[]{"703", VARIABLE_LENGTH, Integer.valueOf(30)};
        THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = r0;
        r0 = new Object[18][];
        r0[0] = new Object[]{"7001", Integer.valueOf(13)};
        r0[1] = new Object[]{"7002", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[2] = new Object[]{"7003", Integer.valueOf(10)};
        r0[3] = new Object[]{"8001", Integer.valueOf(14)};
        r0[4] = new Object[]{"8002", VARIABLE_LENGTH, Integer.valueOf(20)};
        r0[5] = new Object[]{"8003", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[6] = new Object[]{"8004", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[7] = new Object[]{"8005", Integer.valueOf(6)};
        r0[8] = new Object[]{"8006", Integer.valueOf(18)};
        r0[9] = new Object[]{"8007", VARIABLE_LENGTH, Integer.valueOf(30)};
        r0[10] = new Object[]{"8008", VARIABLE_LENGTH, Integer.valueOf(12)};
        r0[11] = new Object[]{"8018", Integer.valueOf(18)};
        r0[12] = new Object[]{"8020", VARIABLE_LENGTH, Integer.valueOf(25)};
        r0[13] = new Object[]{"8100", Integer.valueOf(6)};
        r0[14] = new Object[]{"8101", Integer.valueOf(10)};
        r0[15] = new Object[]{"8102", Integer.valueOf(2)};
        r0[16] = new Object[]{"8110", VARIABLE_LENGTH, Integer.valueOf(70)};
        r0[17] = new Object[]{"8200", VARIABLE_LENGTH, Integer.valueOf(70)};
        FOUR_DIGIT_DATA_LENGTH = r0;
    }

    private FieldParser() {
    }

    static String parseFieldsInGeneralPurpose(String str) throws NotFoundException {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, 2);
        Object[][] objArr = TWO_DIGIT_DATA_LENGTH;
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object[] objArr2 = objArr[i];
            if (!objArr2[0].equals(substring)) {
                i++;
            } else if (objArr2[1] == VARIABLE_LENGTH) {
                return processVariableAI(2, ((Integer) objArr2[2]).intValue(), str);
            } else {
                return processFixedAI(2, ((Integer) objArr2[1]).intValue(), str);
            }
        }
        if (str.length() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        substring = str.substring(0, 3);
        objArr = THREE_DIGIT_DATA_LENGTH;
        length = objArr.length;
        i = 0;
        while (i < length) {
            objArr2 = objArr[i];
            if (!objArr2[0].equals(substring)) {
                i++;
            } else if (objArr2[1] == VARIABLE_LENGTH) {
                return processVariableAI(3, ((Integer) objArr2[2]).intValue(), str);
            } else {
                return processFixedAI(3, ((Integer) objArr2[1]).intValue(), str);
            }
        }
        objArr = THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH;
        length = objArr.length;
        i = 0;
        while (i < length) {
            objArr2 = objArr[i];
            if (!objArr2[0].equals(substring)) {
                i++;
            } else if (objArr2[1] == VARIABLE_LENGTH) {
                return processVariableAI(4, ((Integer) objArr2[2]).intValue(), str);
            } else {
                return processFixedAI(4, ((Integer) objArr2[1]).intValue(), str);
            }
        }
        if (str.length() < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        substring = str.substring(0, 4);
        objArr = FOUR_DIGIT_DATA_LENGTH;
        length = objArr.length;
        i = 0;
        while (i < length) {
            objArr2 = objArr[i];
            if (!objArr2[0].equals(substring)) {
                i++;
            } else if (objArr2[1] == VARIABLE_LENGTH) {
                return processVariableAI(4, ((Integer) objArr2[2]).intValue(), str);
            } else {
                return processFixedAI(4, ((Integer) objArr2[1]).intValue(), str);
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static String processFixedAI(int i, int i2, String str) throws NotFoundException {
        if (str.length() < i) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, i);
        if (str.length() < i + i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring2 = str.substring(i, i + i2);
        String substring3 = str.substring(i + i2);
        substring = "(" + substring + ')' + substring2;
        substring2 = parseFieldsInGeneralPurpose(substring3);
        return substring2 == null ? substring : substring + substring2;
    }

    private static String processVariableAI(int i, int i2, String str) throws NotFoundException {
        int length;
        String substring = str.substring(0, i);
        if (str.length() < i + i2) {
            length = str.length();
        } else {
            length = i + i2;
        }
        String substring2 = str.substring(i, length);
        String substring3 = str.substring(length);
        String str2 = "(" + substring + ')' + substring2;
        substring = parseFieldsInGeneralPurpose(substring3);
        if (substring == null) {
            return str2;
        }
        return str2 + substring;
    }
}
