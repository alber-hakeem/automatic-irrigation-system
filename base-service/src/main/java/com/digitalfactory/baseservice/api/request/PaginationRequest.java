package com.digitalfactory.baseservice.api.request;

import com.digitalfactory.baseservice.api.common.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class PaginationRequest extends Page {
    private List<SortingBy> sortingByList;
}
