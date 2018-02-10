package com.tencent.wxop.stat.a;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class j implements FileFilter {
    j() {
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
