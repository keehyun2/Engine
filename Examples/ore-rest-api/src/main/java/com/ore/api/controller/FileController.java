package com.ore.api.controller;

import com.ore.api.service.JobService;
import com.ore.api.service.StorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Path;

/**
 * REST controller for file downloads.
 */
@Tag(name = "files", description = "File download APIs")
@RestController
@RequestMapping("/api/jobs/{jobId}/files")
@RequiredArgsConstructor
public class FileController {

    private final JobService jobService;
    private final StorageService storageService;

    @Operation(summary = "Download an output file")
    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable String jobId,
            @PathVariable String filename
    ) {
        // Verify job exists
        jobService.getJob(jobId);

        Path filePath = storageService.getFilePath(jobId, filename);
        File file = filePath.toFile();
        Resource resource = new FileSystemResource(file);

        // Determine media type
        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
        if (filename.endsWith(".csv")) {
            mediaType = MediaType.parseMediaType("text/csv");
        } else if (filename.endsWith(".txt") || filename.endsWith(".log")) {
            mediaType = MediaType.TEXT_PLAIN;
        } else if (filename.endsWith(".json")) {
            mediaType = MediaType.APPLICATION_JSON;
        } else if (filename.endsWith(".xml")) {
            mediaType = MediaType.parseMediaType("text/xml");
        }

        return ResponseEntity.ok()
            .contentType(mediaType)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
            .body(resource);
    }
}
