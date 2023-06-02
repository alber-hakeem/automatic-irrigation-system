package com.digitalfactory.baseservice.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Page {
    private int pageNumber;
    private int pageSize;
}
