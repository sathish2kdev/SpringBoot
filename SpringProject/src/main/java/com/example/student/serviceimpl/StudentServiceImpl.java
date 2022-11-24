package com.example.student.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.student.common.DateUtils;
import com.example.student.dto.StudentDto;
import com.example.student.entity.DepartmentMasterEntity;
import com.example.student.entity.ImageMasterEntity;
import com.example.student.entity.StudentEntity;
import com.example.student.repository.DepartmentMasterRepository;
import com.example.student.repository.ImageMasterMasterRepository;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	DepartmentMasterRepository departmentMasterRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	DateUtils dateUtils;

	@Autowired
	ImageMasterMasterRepository imageMasterMasterRepository;

	private final static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	public List<String> getDetailsForSave() {
		logger.info("---Start of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		List<String> departemntList = null;
		try {
			departemntList = departmentMasterRepository.getDepartmentname();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("---End of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		return departemntList;

	}

	public StudentEntity saveStudentsDetails(StudentDto studentDto) {
		logger.info("---Start of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		StudentEntity studentEntity = new StudentEntity();
		try {
			studentEntity.setStudentName(studentDto.getStudentName());
			studentEntity.setStudentRollNumber(studentDto.getStudentRollNumber());
			Date date = dateUtils.convertyyyymmddToDate(studentDto.getDateOfJoining());
			studentEntity.setDateOfJoining(date);
			DepartmentMasterEntity departmentMasterEntity = departmentMasterRepository
					.getDepartmentDetails(studentDto.getDepartmentName());
			studentEntity.setDepartmentId(departmentMasterEntity);
			studentEntity.setFeesPaidStatus(studentDto.getFeesPaidStatus());
			studentEntity = studentRepository.save(studentEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("---End of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		return studentEntity;
	}

	@Override
	public void saveDetails(HttpServletRequest request, StudentDto studentDto) {
		logger.info("---Start of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		try {
			StudentEntity studentEntity = saveStudentsDetails(studentDto);
			if (studentDto.getImage() != null)
				SaveImageandGenerateImage(request, studentDto.getImage(), studentEntity);
			if (studentDto.getImage1() != null)
				SaveImageandGenerateImage(request, studentDto.getImage1(), studentEntity);
			if (studentDto.getImage2() != null)
				SaveImageandGenerateImage(request, studentDto.getImage2(), studentEntity);
			if (studentDto.getImage3() != null)
				SaveImageandGenerateImage(request, studentDto.getImage3(), studentEntity);
			if (studentDto.getImage4() != null)
				SaveImageandGenerateImage(request, studentDto.getImage4(), studentEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("---End of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
	}

	private void SaveImageandGenerateImage(HttpServletRequest request, MultipartFile file,
			StudentEntity studentEntity) {
		logger.info("---Start of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			ImageMasterEntity imageMasterEntity = new ImageMasterEntity();
			imageMasterEntity.setStudentImage(fileName);
			imageMasterEntity.setStudentId(studentEntity);
			imageMasterMasterRepository.save(imageMasterEntity);
			long id = imageMasterEntity.getStudentImageId();
			String imagename = "Image" + String.valueOf(id);
			saveImage(request, imagename, file);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("---End of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
	}

	@Override
	public List<StudentDto> getStudentList() {
		logger.info("---Start of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		List<StudentDto> studentList = new ArrayList<StudentDto>();
		try {
			List<StudentEntity> studentEntityList = studentRepository.findAll();
			for (StudentEntity studentEntity : studentEntityList) {
				StudentDto studentDto = new StudentDto();
				studentDto.setStudentId(studentEntity.getStudentId());
				studentDto.setStudentName(studentEntity.getStudentName());
				studentDto.setStudentRollNumber(studentEntity.getStudentRollNumber());
				if(studentEntity.getDateOfJoining() != null) {
					String date = dateUtils.convertToSqlToUiDate(studentEntity.getDateOfJoining());
					studentDto.setDateOfJoining(date);
				}
				studentDto.setFeesPaidStatus(studentEntity.getFeesPaidStatus());
				studentDto.setDepartmentName(studentEntity.getDepartmentId().getDepartmentName());
				studentList.add(studentDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("---End of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		return studentList;
	}

	public void saveImage(HttpServletRequest request, String fileName, MultipartFile multipartFile) {
		logger.info("---Start of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		ServletContext sc = request.getServletContext();
		try {
			String path = sc.getRealPath("/");
			File directory = new File(path + "//images");
			if (!directory.exists())
				directory.mkdir();

			Path uploadPath = Paths.get(directory.getAbsolutePath());

			try (InputStream inputStream = multipartFile.getInputStream()) {
				Path filePath = uploadPath.resolve(fileName);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException ioe) {
				throw new IOException("Could not save image file: " + fileName, ioe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("---End of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());

	}

	@Override
	public StudentDto getStudentDetailsbasedonId(long id) {
		logger.info("---Start of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		StudentDto studentDto = new StudentDto();
		try {
			List<StudentEntity> studentEntityList = studentRepository.findByStudentId(id);
			List<String> imageId = new ArrayList<>();

			if (studentEntityList != null && studentEntityList.size() > 0) {
				StudentEntity studentEntity = studentEntityList.get(0);
				studentDto.setStudentId(studentEntity.getStudentId());
				studentDto.setStudentName(studentEntity.getStudentName());
				studentDto.setStudentRollNumber(studentEntity.getStudentRollNumber());
				if(studentEntity.getDateOfJoining() != null) {
					String date = dateUtils.convertToSqlToUiDate(studentEntity.getDateOfJoining());
					studentDto.setDateOfJoining(date);
				}
				studentDto.setFeesPaidStatus(studentEntity.getFeesPaidStatus());
				studentDto.setDepartmentName(studentEntity.getDepartmentId().getDepartmentName());
				List<ImageMasterEntity> imageMasterEntityList = imageMasterMasterRepository
						.findByStudentId(studentEntity);
				for (ImageMasterEntity imageMasterEntity : imageMasterEntityList) {
					File directory = new File("/images/Image" + imageMasterEntity.getStudentImageId());
					imageId.add(directory.getAbsolutePath());
				}
				studentDto.setImagePath(imageId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("---End of " + Thread.currentThread().getStackTrace()[1].getMethodName() + " in "
				+ Thread.currentThread().getStackTrace()[1].getClassName());
		return studentDto;
	}
}
