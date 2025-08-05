/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.heulwen.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.heulwen.pojo.Test;
import com.heulwen.pojo.User;
import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 *
 * @author Dell
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestResultsResponse {
    Integer id;
    Integer score;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date dateTaken;
    Test testId;
    User userId;
}
