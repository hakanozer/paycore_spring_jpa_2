package com.works.services;

import com.works.documents.ProductDocument;
import com.works.repositories.ProductDocumentRepository;
import com.works.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductDocumentService {

    final ProductDocumentRepository pRepo;

    public ResponseEntity add(ProductDocument document) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        pRepo.save(document);
        hm.put(REnum.status, true);
        hm.put(REnum.result, document);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search(String data) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true);
        Pageable pageable = PageRequest.of(0, 100);
        hm.put(REnum.result,  pRepo.findTitle(data, pageable) );
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
