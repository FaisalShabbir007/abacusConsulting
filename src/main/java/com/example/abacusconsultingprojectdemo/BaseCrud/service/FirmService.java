package com.example.abacusconsultingprojectdemo.BaseCrud.service;

import com.example.abacusconsultingprojectdemo.BaseCrud.dto.request.FirmRequest;
import com.example.abacusconsultingprojectdemo.common.response.Response;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FirmService {

    Response<Object> createFirm(FirmRequest createFirmRequest) throws Exception;
    Response<Object> deleteFirm(int id) throws Exception;
    Response<Object> getFirm(int id) throws Exception;
    Response<Object> editFirm(FirmRequest editFirmRequest, int id) throws Exception;
}
