package com.example.tmf629.pagination;

import java.util.List;

public record PageResponse<T>(long total, List<T> items) {}