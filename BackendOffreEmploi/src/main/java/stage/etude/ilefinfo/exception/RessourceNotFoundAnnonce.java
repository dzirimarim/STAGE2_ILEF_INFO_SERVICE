package stage.etude.ilefinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundAnnonce extends RuntimeException {
	
	private static final long serialVersionUID = 1L ;


	public RessourceNotFoundAnnonce(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	
	
}
