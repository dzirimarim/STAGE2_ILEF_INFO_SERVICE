package stage.etude.ilefinfo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import stage.etude.ilefinfo.FileStorageService;
import stage.etude.ilefinfo.LogoStorageService;
import stage.etude.ilefinfo.ResponseFile;
import stage.etude.ilefinfo.ResponseMessage;
import stage.etude.ilefinfo.model.LogoDB;

@Controller
@CrossOrigin("*")
public class LogoController {
	
	@Autowired
	  private LogoStorageService lstorageService;
	
	
	 @PostMapping("/uploadLogo/{id}")
	  public ResponseEntity<ResponseMessage> uploadLogo(@RequestParam("file") MultipartFile file , @PathVariable String id ) {
	    String message = "";
	    try {
	      lstorageService.store(file ,id );

	      message = "Uploaded the logo successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }

	  @GetMapping("/logos")
	  public ResponseEntity<List<ResponseFile>> getListlogos() {
	    List<ResponseFile> files = lstorageService.getAllLogos().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/logos/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/logos/{id}")
	  public ResponseEntity<byte[]> getLogo(@PathVariable String id) {
	    LogoDB logoDB = lstorageService.getLogo(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + logoDB.getName() + "\"")
	        .body(logoDB.getData());
	  }

}
