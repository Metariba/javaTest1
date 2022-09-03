package Details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/details")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DetailsController {
    @Autowired
    DetailsService detailsService;

    @PostMapping
    public Details newDetails(@RequestBody Details detail) throws IllegalAccessException {
        return detailsService.newDetail(detail);
    }

}
