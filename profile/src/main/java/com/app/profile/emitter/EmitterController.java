package com.app.profile.emitter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@RestController
public class EmitterController {

	@GetMapping("/responseEmitter")
	public ResponseBodyEmitter responseEmitter() {
		ResponseBodyEmitter emittor = new ResponseBodyEmitter();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			List<String> data = Arrays.asList("a", "e", "i", "o", "u");
			data.stream().forEach(p -> {
				randomDelay();
				try {
					emittor.send(p);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			emittor.complete();
		});
		executor.shutdown();
		return emittor;
	}

	public void randomDelay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
