package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import static hello.domain.ImageData.createImageDataAvatar;
import static hello.domain.ImageData.createImageDataProfilePhoto;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Sergey Vorobyev
 */

@Controller
@SuppressWarnings("unused")
public class UploadImageController {

    private final StorageService storageService;

    @Autowired
    public UploadImageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping(value = "/files", method = GET)
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

    @RequestMapping(value = "/files/{filename:.+}", method = GET)
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
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

    @RequestMapping(value = "/user/1/publicValues/profilePhoto", method = POST)
    public ResponseEntity<AbsResponse> handleUserPhotoUpload(
            @RequestParam("file") MultipartFile file,
            @RequestHeader(value="X-Access-Token") String token,
            @RequestHeader(value = "Request-User-Id") String userId) {

        if (token != null && token.equals(TOKEN) && userId != null && userId.equals("1")) {
            storageService.store(file);
            return new ResponseEntity<>(
                    new ImageUploadedResponse(true, createImageDataProfilePhoto()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Client Error"), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/user/1/publicValues/profileAvatar", method = POST)
    public ResponseEntity<AbsResponse> handleAvatarUpload(@RequestParam("file") MultipartFile file,
            @RequestHeader(value="X-Access-Token") String token,
            @RequestHeader(value = "Request-User-Id") String userId) {

        if (token != null && token.equals(TOKEN) && userId != null && userId.equals("1")) {
            storageService.store(file);
            return new ResponseEntity<>(
                    new ImageUploadedResponse(true, createImageDataAvatar()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Client Error"), HttpStatus.FORBIDDEN);
        }
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
