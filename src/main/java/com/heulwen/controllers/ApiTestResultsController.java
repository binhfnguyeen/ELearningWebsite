/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.heulwen.controllers;

import com.heulwen.dto.request.TestResultsRequest;
import com.heulwen.dto.response.ApiResponse;
import com.heulwen.dto.response.TestResultsResponse;
import com.heulwen.services.TestResultsService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dell
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApiTestResultsController {
    TestResultsService testResultsService;
    
    @GetMapping("/test-results")
    ApiResponse<List<TestResultsResponse>> list(){
        return ApiResponse.<List<TestResultsResponse>>builder()
                .code(1000)
                .result(this.testResultsService.getTestResults())
                .build();
    }
    
    @PostMapping("/test-results")
    ApiResponse <TestResultsResponse> post(@RequestBody TestResultsRequest request){
        return ApiResponse.<TestResultsResponse>builder()
                .code(1000)
                .result(this.testResultsService.createTestResults(request))
                .build();
    }
    
    @GetMapping("/test-results/{id}")
    ApiResponse<TestResultsResponse> retrieve(@PathVariable("id") int  id){
        return ApiResponse.<TestResultsResponse>builder()
                .code(1000)
                .result(this.testResultsService.getTestResultsById(id))
                .build();
    }
    
}
