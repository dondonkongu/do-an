package com.thanhdon.product_service.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResponse<T> {
    int currentPage;
    int totalPages;
    int pageSizes;
    long totalElements;

    @Builder.Default
    private List<T> data = Collections.emptyList();


}
