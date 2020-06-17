package org.aptogether.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.aptogether.domain.PollOptionVO;
import org.aptogether.domain.PollSelectVO;
import org.aptogether.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("/tenant/*")
@Log4j
@AllArgsConstructor
public class PollTenantController {

	private PollService service;

	@GetMapping("/pollShow")
	public String tenant_List(Model model) {
		log.info("list");
		model.addAttribute("list", service.PollList());
		return "pollShow";
	}
	
	
	@PostMapping(value = "/pollOptionList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<PollOptionVO>> tenant_pollOptionList(@RequestBody Map<String, Object> seq) {
		log.info("option......");
		int pollSeq = (int) seq.get("pollSeq");
		log.info(pollSeq);
		return new ResponseEntity<>(service.PollOptionList(pollSeq), HttpStatus.OK);

	}

	@GetMapping("/pollSignUpload")
	public void tenant_signUpload() {
		log.info("signUpload..");
	}

	@PostMapping("/pollSignUpload")
	public void tenant_signUpload(PollSelectVO select, @RequestParam(value = "file") MultipartFile[] file,
			@RequestParam("optionSeq") String optionSeq) throws Exception {

		String uploadFolder = "C:\\upload\\sign";

		String s_uploadFolder = "C:\\upload\\s_sign";

		File uploadPath = new File(uploadFolder);

		File s_uploadPath = new File(s_uploadFolder);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : file) {

			String uploadFileName = optionSeq;

			UUID uuid = UUID.randomUUID();

			uploadFileName = uploadFileName + "_" + uuid.toString() + ".png";

			try {

				if (s_uploadPath.exists() == false) {
					s_uploadPath.mkdirs();
				}

				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				FileOutputStream thumbnail = new FileOutputStream(new File(s_uploadPath, "s_" + uploadFileName));
				Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
				thumbnail.close();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				select.setOptionSeq(Integer.parseInt(optionSeq));
				select.setFileName("s_" + uploadFileName);

				service.PollSelectInsert(select);
			}
		}
	}
}
