package za.co.teama.data.pulse.Service;

import org.springframework.stereotype.Service;
import za.co.teama.data.pulse.Models.Response;
import za.co.teama.data.pulse.Models.Survey;
import za.co.teama.data.pulse.Repository.ResponseRepository;

import java.util.List;

@Service
public class ResponseService {

    private final ResponseRepository responseRepo;

    public ResponseService(ResponseRepository responseRepo) { this.responseRepo = responseRepo; }

    //Get responses
    public List<Response> getResponses() {
        return responseRepo.findAll();
    }

    //Create Responses
    public Response addResponse(Response response) {
        return responseRepo.save(response);
    }

}
