package com.uc.webview.export.cd;

/* compiled from: ProGuard */
public class CDParserFactory {
    private static CDParserFactory sInstance;

    private CDParserFactory() {
    }

    public static CDParserFactory getInstance() {
        if (sInstance == null) {
            sInstance = new CDParserFactory();
        }
        return sInstance;
    }

    public CDParser createCDParserForAndroid(String str, String str2) {
        if (str == null) {
            if (CDUtil.startsWithPrefexIgnoreCase(CDController.PREFIX_JSON_CD, str2)) {
                return new CDJsonParser(CDUtil.getCDDataFromOrignData(str2));
            }
            return new CDJsonParser(str2);
        } else if (CDController.PREFIX_JSON_CD.equalsIgnoreCase(str)) {
            return new CDJsonParser(str2);
        } else {
            throw new IllegalStateException("prefix: " + str + " illegal.");
        }
    }

    public CDJsonConsumer createCDConsumerForAndroid(CDParser cDParser) {
        if (cDParser == null || cDParser.getResult() == null) {
            return null;
        }
        if (cDParser instanceof CDJsonParser) {
            return new CDJsonConsumer(cDParser);
        }
        throw new IllegalStateException("Create cd consumer fuilure!");
    }

    public CDParser createCDParserForPCClient(String str, String str2) {
        return null;
    }
}
