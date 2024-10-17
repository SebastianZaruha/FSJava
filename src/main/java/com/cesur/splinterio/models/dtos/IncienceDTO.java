package com.cesur.splinterio.models.dtos;
import com.cesur.splinterio.models.utils.Priorities;
import com.cesur.splinterio.models.utils.Scopes;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class IncienceDTO {
    private Long id;
    private String description;
    private Priorities priority;
    private Scopes scope;
    private String userCreated;
}
