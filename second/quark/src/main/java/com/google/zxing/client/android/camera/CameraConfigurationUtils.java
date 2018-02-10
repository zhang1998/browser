package com.google.zxing.client.android.camera;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@TargetApi(15)
/* compiled from: ProGuard */
public final class CameraConfigurationUtils {
    private static final int AREA_PER_1000 = 400;
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    private static final double MAX_ASPECT_DISTORTION = 0.1d;
    private static final float MAX_EXPOSURE_COMPENSATION = 1.5f;
    private static final int MAX_FPS = 20;
    private static final float MIN_EXPOSURE_COMPENSATION = 0.0f;
    private static final int MIN_FPS = 10;
    private static final int MIN_PREVIEW_PIXELS = 153600;
    private static final Pattern SEMICOLON = Pattern.compile(";");
    private static final String TAG = "CameraConfiguration";
    private static final int TEN_DESIRED_ZOOM = 27;

    private CameraConfigurationUtils() {
    }

    public static void setFocus(Parameters parameters, boolean z, boolean z2, boolean z3) {
        Collection supportedFocusModes = parameters.getSupportedFocusModes();
        String str = null;
        if (z) {
            if (z3 || z2) {
                str = findSettableValue("focus mode", supportedFocusModes, "auto");
            } else {
                str = findSettableValue("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
            }
        }
        if (!z3 && r0 == null) {
            str = findSettableValue("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (str != null && !str.equals(parameters.getFocusMode())) {
            parameters.setFocusMode(str);
        }
    }

    public static void setTorch(Parameters parameters, boolean z) {
        String findSettableValue;
        Collection supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            findSettableValue = findSettableValue("flash mode", supportedFlashModes, "torch", "on");
        } else {
            findSettableValue = findSettableValue("flash mode", supportedFlashModes, "off");
        }
        if (findSettableValue != null && !findSettableValue.equals(parameters.getFlashMode())) {
            parameters.setFlashMode(findSettableValue);
        }
    }

    public static void setBestExposure(Parameters parameters, boolean z) {
        float f = MIN_EXPOSURE_COMPENSATION;
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (!(minExposureCompensation == 0 && maxExposureCompensation == 0) && exposureCompensationStep > MIN_EXPOSURE_COMPENSATION) {
            if (!z) {
                f = MAX_EXPOSURE_COMPENSATION;
            }
            int round = Math.round(f / exposureCompensationStep);
            exposureCompensationStep *= (float) round;
            round = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
            if (parameters.getExposureCompensation() == round) {
                new StringBuilder("Exposure compensation already set to ").append(round).append(" / ").append(exposureCompensationStep);
                return;
            }
            new StringBuilder("Setting exposure compensation to ").append(round).append(" / ").append(exposureCompensationStep);
            parameters.setExposureCompensation(round);
        }
    }

    public static void setBestPreviewFPS(Parameters parameters) {
        setBestPreviewFPS(parameters, 10, 20);
    }

    public static void setBestPreviewFPS(Parameters parameters, int i, int i2) {
        Collection<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        new StringBuilder("Supported FPS ranges: ").append(toString((Collection) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            for (int[] iArr : supportedPreviewFpsRange) {
                int i3 = iArr[0];
                int i4 = iArr[1];
                if (i3 >= i * 1000 && i4 <= i2 * 1000) {
                    break;
                }
            }
            int[] iArr2 = null;
            if (iArr2 != null) {
                int[] iArr3 = new int[2];
                parameters.getPreviewFpsRange(iArr3);
                if (Arrays.equals(iArr3, iArr2)) {
                    new StringBuilder("FPS range already set to ").append(Arrays.toString(iArr2));
                    return;
                }
                new StringBuilder("Setting FPS range to ").append(Arrays.toString(iArr2));
                parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
            }
        }
    }

    public static void setFocusArea(Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            new StringBuilder("Old focus areas: ").append(toString(parameters.getFocusAreas()));
            Iterable buildMiddleArea = buildMiddleArea(400);
            new StringBuilder("Setting focus area to : ").append(toString(buildMiddleArea));
            parameters.setFocusAreas(buildMiddleArea);
        }
    }

    public static void setMetering(Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            new StringBuilder("Old metering areas: ").append(parameters.getMeteringAreas());
            Iterable buildMiddleArea = buildMiddleArea(400);
            new StringBuilder("Setting metering area to : ").append(toString(buildMiddleArea));
            parameters.setMeteringAreas(buildMiddleArea);
        }
    }

    private static List<Area> buildMiddleArea(int i) {
        return Collections.singletonList(new Area(new Rect(-i, -i, i, i), 1));
    }

    public static void setVideoStabilization(Parameters parameters) {
        if (parameters.isVideoStabilizationSupported() && !parameters.getVideoStabilization()) {
            parameters.setVideoStabilization(true);
        }
    }

    public static void setBarcodeSceneMode(Parameters parameters) {
        if (!"barcode".equals(parameters.getSceneMode())) {
            String findSettableValue = findSettableValue("scene mode", parameters.getSupportedSceneModes(), "barcode");
            if (findSettableValue != null) {
                parameters.setSceneMode(findSettableValue);
            }
        }
    }

    private static int findBestMotZoomValue(CharSequence charSequence, int i) {
        String[] split = COMMA_PATTERN.split(charSequence);
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            try {
                double parseDouble = Double.parseDouble(split[i2].trim());
                int i4 = (int) (10.0d * parseDouble);
                if (Math.abs(((double) i) - parseDouble) >= ((double) Math.abs(i - i3))) {
                    i4 = i3;
                }
                i2++;
                i3 = i4;
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i3;
    }

    public static void setZoom(Parameters parameters) {
        int i = 27;
        if (parameters.isZoomSupported()) {
            String str = parameters.get("zoom-supported");
            if (str == null || Boolean.parseBoolean(str)) {
                int parseDouble;
                String str2 = parameters.get("max-zoom");
                if (str2 != null) {
                    try {
                        parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                        if (27 <= parseDouble) {
                            parseDouble = 27;
                        }
                        i = parseDouble;
                    } catch (NumberFormatException e) {
                        Log.w(TAG, "Bad max-zoom: " + str2);
                    }
                }
                String str3 = parameters.get("taking-picture-zoom-max");
                if (str3 != null) {
                    try {
                        parseDouble = Integer.parseInt(str3);
                        if (i > parseDouble) {
                            i = parseDouble;
                        }
                    } catch (NumberFormatException e2) {
                        Log.w(TAG, "Bad taking-picture-zoom-max: " + str3);
                    }
                }
                CharSequence charSequence = parameters.get("mot-zoom-values");
                if (charSequence != null) {
                    i = findBestMotZoomValue(charSequence, i);
                }
                String str4 = parameters.get("mot-zoom-step");
                if (str4 != null) {
                    try {
                        int parseDouble2 = (int) (Double.parseDouble(str4.trim()) * 10.0d);
                        if (parseDouble2 > 1) {
                            i -= i % parseDouble2;
                        }
                    } catch (NumberFormatException e3) {
                    }
                }
                if (!(str2 == null && charSequence == null)) {
                    parameters.set("zoom", String.valueOf(((double) i) / 10.0d));
                }
                if (str3 != null) {
                    parameters.set("taking-picture-zoom", i);
                }
            }
        }
    }

    private static Integer indexOfClosestZoom(Parameters parameters, double d) {
        List zoomRatios = parameters.getZoomRatios();
        new StringBuilder("Zoom ratios: ").append(zoomRatios);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            Log.w(TAG, "Invalid zoom ratios!");
            return null;
        }
        double d2 = 100.0d * d;
        int i = 0;
        int i2 = 0;
        double d3 = Double.POSITIVE_INFINITY;
        while (i < zoomRatios.size()) {
            double d4;
            int i3;
            double abs = Math.abs(((double) ((Integer) zoomRatios.get(i)).intValue()) - d2);
            if (abs < d3) {
                d4 = abs;
                i3 = i;
            } else {
                i3 = i2;
                d4 = d3;
            }
            i++;
            i2 = i3;
            d3 = d4;
        }
        new StringBuilder("Chose zoom ratio of ").append(((double) ((Integer) zoomRatios.get(i2)).intValue()) / 100.0d);
        return Integer.valueOf(i2);
    }

    public static void setInvertColor(Parameters parameters) {
        if (!"negative".equals(parameters.getColorEffect())) {
            String findSettableValue = findSettableValue("color effect", parameters.getSupportedColorEffects(), "negative");
            if (findSettableValue != null) {
                parameters.setColorEffect(findSettableValue);
            }
        }
    }

    public static Point findBestPreviewSizeValue(Parameters parameters, Point point) {
        Collection supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        Size previewSize;
        if (supportedPreviewSizes == null) {
            Log.w(TAG, "Device returned no supported preview sizes; using default");
            previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        Size size;
        List<Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Size>() {
            public final int compare(Size size, Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                if (i2 > i) {
                    return 1;
                }
                return 0;
            }
        });
        if (Log.isLoggable(TAG, 4)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Size size2 : arrayList) {
                stringBuilder.append(size2.width).append('x').append(size2.height).append(' ');
            }
            new StringBuilder("Supported preview sizes: ").append(stringBuilder);
        }
        double d = ((double) point.y) / ((double) point.x);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            size2 = (Size) it.next();
            int i = size2.width;
            int i2 = size2.height;
            if (i * i2 < MIN_PREVIEW_PIXELS) {
                it.remove();
            } else {
                int i3;
                int i4 = i < i2 ? 1 : 0;
                if (i4 != 0) {
                    i3 = i2;
                } else {
                    i3 = i;
                }
                if (i4 != 0) {
                    i4 = i;
                } else {
                    i4 = i2;
                }
                if (Math.abs((((double) i3) / ((double) i4)) - d) > MAX_ASPECT_DISTORTION) {
                    it.remove();
                } else if (i3 == point.x && i4 == point.y) {
                    Point point2 = new Point(i, i2);
                    new StringBuilder("Found preview size exactly matching screen size: ").append(point2);
                    return point2;
                }
            }
        }
        if (arrayList.isEmpty()) {
            previewSize = parameters.getPreviewSize();
            if (previewSize == null) {
                throw new IllegalStateException("Parameters contained no preview size!");
            }
            point2 = new Point(previewSize.width, previewSize.height);
            new StringBuilder("No suitable preview sizes, using default: ").append(point2);
            return point2;
        }
        size2 = (Size) arrayList.get(0);
        Point point3 = new Point(size2.width, size2.height);
        new StringBuilder("Using largest suitable preview size: ").append(point3);
        return point3;
    }

    private static String findSettableValue(String str, Collection<String> collection, String... strArr) {
        new StringBuilder("Requesting ").append(str).append(" value from among: ").append(Arrays.toString(strArr));
        new StringBuilder("Supported ").append(str).append(" values: ").append(collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    new StringBuilder("Can set ").append(str).append(" to: ").append(str2);
                    return str2;
                }
            }
        }
        return null;
    }

    private static String toString(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            stringBuilder.append(Arrays.toString((int[]) it.next()));
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private static String toString(Iterable<Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Area area : iterable) {
            stringBuilder.append(area.rect).append(':').append(area.weight).append(' ');
        }
        return stringBuilder.toString();
    }

    public static String collectStats(Parameters parameters) {
        return collectStats(parameters.flatten());
    }

    public static String collectStats(CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder(1000);
        stringBuilder.append("BOARD=").append(Build.BOARD).append('\n');
        stringBuilder.append("BRAND=").append(Build.BRAND).append('\n');
        stringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append('\n');
        stringBuilder.append("DEVICE=").append(Build.DEVICE).append('\n');
        stringBuilder.append("DISPLAY=").append(Build.DISPLAY).append('\n');
        stringBuilder.append("FINGERPRINT=").append(Build.FINGERPRINT).append('\n');
        stringBuilder.append("HOST=").append(Build.HOST).append('\n');
        stringBuilder.append("ID=").append(Build.ID).append('\n');
        stringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append('\n');
        stringBuilder.append("MODEL=").append(Build.MODEL).append('\n');
        stringBuilder.append("PRODUCT=").append(Build.PRODUCT).append('\n');
        stringBuilder.append("TAGS=").append(Build.TAGS).append('\n');
        stringBuilder.append("TIME=").append(Build.TIME).append('\n');
        stringBuilder.append("TYPE=").append(Build.TYPE).append('\n');
        stringBuilder.append("USER=").append(Build.USER).append('\n');
        stringBuilder.append("VERSION.CODENAME=").append(VERSION.CODENAME).append('\n');
        stringBuilder.append("VERSION.INCREMENTAL=").append(VERSION.INCREMENTAL).append('\n');
        stringBuilder.append("VERSION.RELEASE=").append(VERSION.RELEASE).append('\n');
        stringBuilder.append("VERSION.SDK_INT=").append(VERSION.SDK_INT).append('\n');
        if (charSequence != null) {
            String[] split = SEMICOLON.split(charSequence);
            Arrays.sort(split);
            for (String append : split) {
                stringBuilder.append(append).append('\n');
            }
        }
        return stringBuilder.toString();
    }
}
