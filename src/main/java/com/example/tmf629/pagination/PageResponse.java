package com.example.tmf629.pagination;

import java.util.List;

public record PageResponse<T>(PaginationMeta paginationMeta, List<T> items) {}