/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.heulwen.controllers;

import com.heulwen.dto.request.FullTestRequest;
import com.heulwen.dto.request.TestRequest;
import com.heulwen.dto.response.ApiResponse;
import com.heulwen.dto.response.TestFullResponse;
import com.heulwen.dto.response.TestResponse;
import com.heulwen.services.TestService;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ApiTestController {
    TestService testService;
    
    @GetMapping("/tests")
    ApiResponse<List<TestResponse>> list() {
        return ApiResponse.<List<TestResponse>>builder()
                .code(1000)
                .result(testService.getTests())
                .build();
    }

    @PostMapping("/tests")
    ApiResponse<TestResponse> addOrUpdate(@RequestBody TestRequest request) {
        TestResponse result = testService.addOrUpdateTest(request);
        return ApiResponse.<TestResponse>builder()
                .code(1000)
                .result(result)
                .build();
    }
    
    @GetMapping("/tests/{id}")
    ApiResponse<TestResponse> retrieve(@PathVariable("id") Integer id){
        return ApiResponse.<TestResponse>builder()
                .code(1000)
                .result(testService.getTestById(id))
                .build();
    }
    
    @DeleteMapping("/tests/{id}")
    ResponseEntity<?> delete(@PathVariable("id") int id){
        this.testService.deleteTest(id);
        return ResponseEntity.ok(Map.of("message", "Deleted successfully!"));
    }
    
    @PostMapping("/tests/full")
    ResponseEntity<?> createFullTest(@RequestBody FullTestRequest request){
        testService.createFullTest(request);
        return ResponseEntity.ok(Map.of("message", "Test created successfully!"));
    }
    
    @GetMapping("/tests/full")
    ApiResponse<List<TestFullResponse>> getAllTestsFull(){
        return ApiResponse.<List<TestFullResponse>>builder()
                .code(1000)
                .result(this.testService.getAllTestsFull())
                .build();
    }
    
    @GetMapping("/tests/full/{id}")
    ApiResponse<TestFullResponse> getTestFullById(@PathVariable("id") int id){
        return ApiResponse.<TestFullResponse>builder()
                .code(1000)
                .result(this.testService.getTestFullById(id))
                .build();
    }
}
