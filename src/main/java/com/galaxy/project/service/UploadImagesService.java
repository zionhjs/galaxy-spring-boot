package com.galaxy.project.service;

import com.galaxy.project.core.Result;
import com.galaxy.project.core.Service;
import com.galaxy.project.model.Images;
import com.galaxy.project.param.ZipParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UploadImagesService extends Service<Images> {

    Result uploadImages(MultipartFile multipartFile, String title, String description, String suffix, String level, Integer status, String statusName);

    Result updateImages(Images images);

    Result delete(Long id);

    Result list(Integer page, Integer size, Images images);

    List<Images> imagesList(Images images);

    Result uploadImagesUrl(MultipartFile multipartFile);

    Result uploadImagesDownload(MultipartFile multipartFile);

    Result downloadImage(String imageName, HttpServletRequest request, HttpServletResponse response);

    Result testUploadImages(MultipartFile multipartFile);

    Result saveImg(String url);

    Result uploadImagesNotLogo(MultipartFile multipartFile);

    Result findByModalData(Integer page, Integer size, String title);

    Result batchUploadImages(MultipartFile[] multipartFile, String title, String description, String suffix, String level, Integer status, String statusName);

    Result detail(Long id);

    Result downloadZip(List<ZipParam> param);
}
