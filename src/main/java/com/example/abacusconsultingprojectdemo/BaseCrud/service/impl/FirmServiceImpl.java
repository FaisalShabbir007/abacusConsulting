package com.example.abacusconsultingprojectdemo.BaseCrud.service.impl;

import com.example.abacusconsultingprojectdemo.BaseCrud.dto.request.FirmRequest;
import com.example.abacusconsultingprojectdemo.BaseCrud.entity.FirmModel;
import com.example.abacusconsultingprojectdemo.BaseCrud.repository.FirmRepository;
import com.example.abacusconsultingprojectdemo.BaseCrud.service.FirmService;
import com.example.abacusconsultingprojectdemo.common.enums.ResponseCodes;
import com.example.abacusconsultingprojectdemo.common.response.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class FirmServiceImpl implements FirmService {

    private  final FirmRepository firmRepository;
    @Override
    public Response<Object> createFirm(FirmRequest creationFirmRequest) throws Exception {
        FirmModel firmModel = firmRepository.findByEmailAddress(creationFirmRequest.getEmailAddress());
       // alternate -- we can use validation on request model directly
        if (firmModel == null) {
            if (creationFirmRequest.getEmailAddress() == null) {
                log.info("Firm Email cannot be null");
                return Response.builder().responseCode(ResponseCodes.FAILURE.getValue()).responseMessage(ResponseCodes.FAILURE.toString())
                        .responseBody(ResponseCodes.EMAIL_CAN_NOT_BE_NULL.getValue()).build();
            }

            firmModel = createNewFirmModel(creationFirmRequest);
            firmRepository.save(firmModel);

            return Response.builder().responseCode(ResponseCodes.SUCCESS.getValue()).responseMessage(ResponseCodes.SUCCESS.toString())
                    .responseBody(firmModel).build();
        } else {
            log.info("Firm Already Registered");
            return Response.builder().responseCode(ResponseCodes.FAILURE.getValue())
                    .responseMessage(ResponseCodes.FAILURE.toString())
                    .responseBody(ResponseCodes.FIRM_ALREADY_REGISTER + "'" + creationFirmRequest.getEmailAddress() + "'").build();
        }
    }

    @Override
    public Response<Object> deleteFirm(int id) throws Exception {
        Optional<FirmModel> firm = firmRepository.findByFirmId(id);
        if (firm.isPresent()) {
            firmRepository.deleteById(id);
            return Response.builder().responseCode(ResponseCodes.SUCCESS.getValue())
                    .responseMessage(ResponseCodes.SUCCESS.toString()).responseBody("Firm deleted successfully").build();
        }else {
            log.info("No Firm Found");
            return Response.builder().responseCode(ResponseCodes.FAILURE.getValue())
                    .responseMessage(ResponseCodes.FAILURE.toString()).responseBody(ResponseCodes.NO_FIRMS_FOUND.getValue()).build();
        }
    }

    @Override
    public Response<Object> getFirm(int id) throws Exception {
        List<FirmModel> firms = firmRepository.findAll();
        if (!ObjectUtils.isEmpty(firms)) {
            log.info(" Firms Found");
            ArrayList<Object> list = new ArrayList<>();
            list.add(firms);
            return Response.builder().responseCode(ResponseCodes.SUCCESS.getValue())
                    .responseMessage(ResponseCodes.SUCCESS.toString()).responseBody(list).build();
        } else {
            log.info("No Firm Found");
            return Response.builder().responseCode(ResponseCodes.FAILURE.getValue())
                    .responseMessage(ResponseCodes.FAILURE.toString()).responseBody(ResponseCodes.FIRM_DONT_EXIST.getValue()).build();
        }
    }

    @Override
    public Response<Object> editFirm(FirmRequest editFirmRequest, int id) throws Exception {
        Optional<FirmModel> firm = firmRepository.findByFirmId(id);
        if (firm.isPresent()) {
            FirmModel firmModel = firm.get();
            firmModel = createNewFirmModel(editFirmRequest);
            firmRepository.save(firmModel);
            return Response.builder().responseCode(ResponseCodes.SUCCESS.getValue()).responseMessage(ResponseCodes.FIRM_UPDATED_SUCCESSFULLY.toString())
                    .responseBody(firmModel).build();
        } else {
            log.info("No Firm Found");
            return Response.builder().responseCode(ResponseCodes.FAILURE.getValue())
                    .responseMessage(ResponseCodes.FAILURE.toString()).responseBody(ResponseCodes.NO_FIRMS_FOUND.getValue()).build();
        }
    }

    private FirmModel createNewFirmModel(FirmRequest creationFirmRequest) {
        FirmModel firmModel = new FirmModel();
        ZonedDateTime now = ZonedDateTime.now();
        firmModel.setFirmName(creationFirmRequest.getFirmName());
        firmModel.setFirmAddress(creationFirmRequest.getFirmAddress());
        firmModel.setContactNumber(creationFirmRequest.getContactNumber());
        firmModel.setEmailAddress(creationFirmRequest.getEmailAddress());
        firmModel.setServiceFee(creationFirmRequest.getServiceFee());
        firmModel.setCreatedOn(now.toString());
        firmModel.setIsActive(creationFirmRequest.getIsActive().equalsIgnoreCase("true") ? "true" : "false");
        return firmModel;
    }


}
