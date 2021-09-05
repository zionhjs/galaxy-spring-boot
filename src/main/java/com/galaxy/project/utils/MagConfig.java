package com.galaxy.project.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author chenjinming
 * @Description 自定义注解信息，包含放行得url
 * @Date 17:54 2019/9/18
 **/
@Component
@ConfigurationProperties(prefix = "taskmagprops")
public class MagConfig {

    //300分钟
    @Value("${expireTime:300}")
    private Long expireTime;

    @Value("${checkLoginUrl:123}")
    private String checkLoginUrl;

    @Value("${filedir:123}")
    private String filedir;

    @Value("${fileBasePath:123}")
    private String fileBasePath;

    @Value("${galaxy.notCheckLoginUrl}")
    private String notCheckLoginUrl;

    public String getNotCheckLoginUrl() {
        return notCheckLoginUrl;
    }

    public void setNotCheckLoginUrl(String notCheckLoginUrl) {
        this.notCheckLoginUrl = notCheckLoginUrl;
    }

    public String getFileBasePath() {
        return fileBasePath;
    }

    public void setFileBasePath(String fileBasePath) {
        this.fileBasePath = fileBasePath;
    }

    public String getFiledir() {
        return filedir;
    }

    public void setFiledir(String filedir) {
        this.filedir = filedir;
    }

    public String getCheckLoginUrl() {
        return checkLoginUrl;
    }

    public void setCheckLoginUrl(String checkLoginUrl) {
        this.checkLoginUrl = checkLoginUrl;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

}
