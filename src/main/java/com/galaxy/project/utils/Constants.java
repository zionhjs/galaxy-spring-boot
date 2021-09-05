package com.galaxy.project.utils;

public final class Constants {

    public static final String REDIS_KEY_LOGIN = "xc_user_login";

    public static final String REDIS_KEY_VERFIY = "xc_user_verfiycode";

    public static final String TOKEN_NAME = "accessToken";

    public static final long verifyCodeForTempValidTime = 5 * 60 * 1000;

    //访问本地图片路径 http://localhost:8066/file/a112d9f0-b3a4-4833-b4b6-d1e1171fc2ea.png
    //public static final String WINDOWS_FILE_USER = "http://352n16b397.wicp.vip:";

    //访问本地图片路径 http://localhost:8066/file/a112d9f0-b3a4-4833-b4b6-d1e1171fc2ea.png
    //public static final String WINDOWS_FILE_URL = "http://localhost:";

    //访问线上图片路径 http://121.4.242.133:8066/file/a112d9f0-b3a4-4833-b4b6-d1e1171fc2ea.png
    public static final String LINUX_FILE_USER = "http://121.4.242.133:";

    public static final String OPTIONS_METHOD = "OPTIONS";

    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_PATTERN_YMD = "yyyy-MM-dd";
}
