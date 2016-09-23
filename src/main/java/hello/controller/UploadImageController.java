package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;

import hello.response.AbsResponse;
import hello.response.ErrorResponse;
import hello.response.ImageUploadedResponse;
import hello.storage.StorageFileNotFoundException;
import hello.storage.StorageService;

import static hello.Constants.TOKEN;
import static hello.Constants.USED_ID;
import static hello.domain.ImageData.createImageDataAvatar;
import static hello.domain.ImageData.createImageDataProfilePhoto;
import static org.springframework.http.HttpStatus.FORBIDDEN;

/**
 * @author Sergey Vorobyev
 */

@Controller
@SuppressWarnings("unused")
class UploadImageController {

    private final StorageService storageService;

    @Autowired
    public UploadImageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/files")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(UploadImageController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(file);
    }

    @PostMapping("/files")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/files";
    }

    @PostMapping("/user/" + USED_ID + "/publicValues/profilePhoto")
    public ResponseEntity<AbsResponse> handleUserPhotoUpload(
            @RequestParam("file") MultipartFile file,
            @RequestHeader(value="X-Access-Token") String token,
            @RequestHeader(value = "Request-User-Id") String userId
    ) {

        if (token.equals(TOKEN)) {
            storageService.store(file);
            return ResponseEntity
                    .ok()
                    .body(new ImageUploadedResponse(createImageDataProfilePhoto()));
        } else {
            return ResponseEntity
                    .status(FORBIDDEN)
                    .body(new ErrorResponse("Bad token"));
        }
    }

    @PostMapping("/user/" + USED_ID + "/publicValues/profileAvatar")
    public ResponseEntity<AbsResponse> handleAvatarUpload(@RequestParam("file") MultipartFile file,
            @RequestHeader(value="X-Access-Token") String token,
            @RequestHeader(value = "Request-User-Id") String userId) {

        if (token.equals(TOKEN)) {
            storageService.store(file);
            return ResponseEntity
                    .ok()
                    .body(new ImageUploadedResponse(createImageDataAvatar()));
        } else {
            return ResponseEntity
                    .status(FORBIDDEN)
                    .body(new ErrorResponse("Bad token"));
        }
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
