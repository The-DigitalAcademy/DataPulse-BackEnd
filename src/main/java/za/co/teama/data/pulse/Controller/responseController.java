package za.co.teama.data.pulse.Controller;

import Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.teama.data.pulse.Models.Response;
import za.co.teama.data.pulse.Models.Survey;
import za.co.teama.data.pulse.Service.ResponseService;


@RestController
@RequestMapping("/api/response")
public class responseController {

    @Autowired
    private final ResponseService responseService;

    public responseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping
    public Object getAllResponses() { return responseService.getResponses(); }

    @PostMapping
    public Object addResponse(@RequestBody ResponseDto responseDto) {
//        System.out.println("get post rsponse request");
//        System.out.println("g "+ responseDto);
        return responseService.addResponse(responseDto);
    }
}
