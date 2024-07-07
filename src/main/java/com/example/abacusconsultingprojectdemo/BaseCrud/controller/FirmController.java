package com.example.abacusconsultingprojectdemo.BaseCrud.controller;

import com.example.abacusconsultingprojectdemo.BaseCrud.dto.request.FirmRequest;
import com.example.abacusconsultingprojectdemo.BaseCrud.service.FirmService;
import com.example.abacusconsultingprojectdemo.common.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/firms")
public class FirmController {

    private final FirmService firmService;

    @PostMapping
    Response<Object> createFirm(@RequestBody FirmRequest createFirmRequest) throws Exception {
        return firmService.createFirm(createFirmRequest);
    }

    @PutMapping("/{id}")
    Response<Object> editFirm(@RequestBody FirmRequest editFirmRequest, @PathVariable int id) throws Exception {
        return firmService.editFirm(editFirmRequest, id);
    }

    @GetMapping("/{id}")
    Response<Object> getFirm(@PathVariable int id) throws Exception  {
        return firmService.getFirm(id);
    }

    @DeleteMapping("/{id}")
    Response<Object> deleteFirm(@PathVariable int id) throws Exception {
        return firmService.deleteFirm(id);
    }

}
