package com.example.tmf629.pagination;

import java.util.List;

public record LiveSearchResult<T>(long total, List<T> items) {
}
