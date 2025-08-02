/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.heulwen.mapper;

import com.heulwen.dto.request.QuestionRequest;
import com.heulwen.dto.response.QuestionResponse;
import com.heulwen.pojo.Question;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 *
 * @author Dell
 */
@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question toQuestion(QuestionRequest request);
    QuestionResponse toQuestionResponse(Question question);
    void updateQuestionFromRequest(QuestionRequest request, @MappingTarget Question question);
}
