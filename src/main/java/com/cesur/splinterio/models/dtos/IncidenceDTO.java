package com.cesur.splinterio.models.dtos;
import com.cesur.splinterio.models.utils.enums.Priorities;
import com.cesur.splinterio.models.utils.enums.Scopes;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class IncidenceDTO {
    private String description;
    private Priorities priority;
    private Scopes scope;
    private String userCreated;
}
