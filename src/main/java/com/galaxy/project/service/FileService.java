package com.galaxy.project.service;

import com.galaxy.project.core.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {

    Result uploadSingle(HttpServletRequest request,MultipartFile file);

    void export(HttpServletRequest request, HttpServletResponse response);
}
