package stage.etude.ilefinfo;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import stage.etude.ilefinfo.model.LogoDB;
import stage.etude.ilefinfo.repository.LogoDBRepository;

@Service
public class LogoStorageService {
	
	@Autowired
	  private LogoDBRepository logoDBRepository;

	  public LogoDB store(MultipartFile file , String id ) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    LogoDB logoDB = new LogoDB(fileName, file.getContentType(), file.getBytes() ,id );
	    
	    return logoDBRepository.save(logoDB);
	  }

	  public LogoDB getLogo(String id) {
	    return logoDBRepository.findById(id).get();
	  }
	  
	  public Stream<LogoDB> getAllLogos() {
	    return logoDBRepository.findAll().stream();
	  }

}
