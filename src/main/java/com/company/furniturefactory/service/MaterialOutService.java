package com.company.furniturefactory.service;

import com.company.furniturefactory.dao.MaterialOutDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialOutService {
    private final MaterialOutDAO materialOutDAO;
}
