package com.works.restcontrollers;

import com.works.documents.ProductDocument;
import com.works.services.ProductDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elastic")
@RequiredArgsConstructor
public class ProductDocumentRestcontroller {

    final ProductDocumentService pService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ProductDocument document) {
        return pService.add(document);
    }

    @PostMapping("/search")
    public ResponseEntity search(@RequestParam String data) {
        return pService.search(data);
    }

}
