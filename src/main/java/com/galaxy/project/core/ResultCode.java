package com.galaxy.project.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误

    NOT_EXIST_USER_EXCEPTION(800039),//用户名或密码错误
    USER_ALREADY_EXIST(800038),//用户名已存在，请登录
    FILEUPLOAD_ERROR(800037),//上传文件不可为空
    TEAM_NOT_EXIST(800036),//team不存在或者已删除
    SHORT_CONN_ERROR(800035),//短链接生成失败，请重新发送
    COMMENT_SAVE_ERROR(800034),//新增评论失败，请重新添加
    BLOG_UPDATE_ERROR(800033),//更新博客失败，请重新更新
    BLOG_NOT_EXIST(800032),//博客不存在或者已删除
    BLOG_DETAIL_ERROR(800031),//博客不存在或者已删除
    CANCEL_BLOG_LIKE_ERROR(800030),//为博客取消点赞失败，请重新点赞!
    CANCEL_COMMENT_LIKE_ERROR(800029),//为评论取消点赞失败，请重新取消点赞!
    CANCEL_LIKE_ERROR(800028),//取消点赞失败!
    LIKE_ERROR_ERROR(800027),//点赞记录不存在，或者已删除!
    LIKE_ERROR(800026),//点赞失败!
    LIKE_DETAILS_ERROR(800025),//增加点赞详情失败!
    COMMENT_MOMENT_LIKE_ERROR(800024),//为评论点赞失败，请重新点赞!
    BLOG_LIKE_ERROR(800023),//为博客点赞失败，请重新点赞!
    MOMENT_LIKE_ERROR(800022),//不可重复点赞!
    VIDEO_FRAME_IMAGEAS_ERROR(800021),//截取帧数图片失败
    USER_PERMISSION_ERROR(800020),//暂无权限使用此功能
    PHONE_ERROR(800019),//手机号已存在
    VIDEO_LOGO_ERROR(800018),//请重新上传视频
    VIDEO_ERROR(800017),//上传视频失败
    IMAGEAS_NULL_ERROR(800016),//图片不存在或者已删除
    IMAGEAS_LOGO_ERROR(800015),//增加Logo错误，请重新上传图片
    IMAGEAS_ERROR(800014),//上传图片失败
    IMAGEAS_NOT_EXIST(800013),//文件不存在
    OUT_TIME_TOKEN(800012),//token 失效
    NOT_EXIST_TOKEN_EXCEPTION(800011),//token不存在(请重新登录再访问)
    PARAM_ERROR(800010),//手机号或者邮箱必须输入一个
    FILE_DOWNLOAD_ERROR(800009),//文件下载失败
    FILE_BULL_ERROR(800008),//文件不能为空
    USER_LOGIN_CHANNEL_ERROR(800006),//登录渠道不存在，请重新登录
    NOT_LOGIN_EXCEPTION(800005),//用户未登录,请重新登录
    VERFIY_CODE_TIME_ERROR(800004),//验证码已经过期
    VERFIY_CODE_ERROR(800003),//验证码输入错误
    VERFIY_TOKEN_ERROR(800002),//图形验证码token不存在
    PASSWORD_ERROR(800001),//用户名或密码错误
    USER_NOT_EXIST(800000)//用户信息不存在[账号可能被停用或删除]
    ;

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
