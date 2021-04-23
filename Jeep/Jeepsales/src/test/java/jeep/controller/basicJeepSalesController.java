package jeep.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import entity.Jeep;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class basicJeepSalesController implements JeepSalesController {

	@Override
	public List<Jeep> fetchJeeps(String model, String trim) {
		log.debug("model={}, trim={}", model, trim);
		return null;
	}

}
