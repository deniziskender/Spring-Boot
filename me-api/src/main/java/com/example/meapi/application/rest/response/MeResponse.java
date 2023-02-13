package com.example.meapi.application.rest.response;

import com.example.meapi.domain.data.MeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeResponse {
    private List<MeDto> mes;
}
