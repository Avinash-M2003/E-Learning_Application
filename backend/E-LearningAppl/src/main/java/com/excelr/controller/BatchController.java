package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excelr.model.Batch;
import com.excelr.service.BatchService;

@RestController
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping("/api/batches")
    public ResponseEntity<?> getAllBatches() {
        return batchService.getAllBatches();
    }

    @GetMapping("/api/batch/{id}")
    public ResponseEntity<?> getBatch(@PathVariable Integer id) {
        return batchService.getBatchById(id);
    }

    @PostMapping("/api/batch")
    public ResponseEntity<?> createBatch(@RequestBody Batch batch) {
        return batchService.createBatch(batch);
    }

    @PutMapping("/api/batch/{id}")
    public ResponseEntity<?> updateBatch(@PathVariable Integer id,
                                         @RequestBody Batch batch) {
        return batchService.updateBatch(id, batch);
    }

    @DeleteMapping("/api/batch/{id}")
    public ResponseEntity<?> deleteBatch(@PathVariable Integer id) {
        return batchService.deleteBatch(id);
    }
}
