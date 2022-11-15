package tw.com.de.librarysystem.model.dto;

import java.util.List;

public class ResponseDto {
	private Integer status;
	
	private String message = "success";

	private Object data;

	public ResponseDto() {
	}

	public ResponseDto(Integer status) {
		this.status = status;
	}

	public static ResponseDto success(Object dto) {
		ResponseDto responseDto = new ResponseDto(200);
		responseDto.setData(dto);
		return responseDto;
	}

	public static ResponseDto success(List<Object> dto) {
		ResponseDto responseDto = new ResponseDto(200);
		responseDto.setData(dto);
		return responseDto;
	}

	public static ResponseDto fail(Integer status) {
		ResponseDto responseDto = new ResponseDto(status);
		responseDto.setMessage("fail");
		return responseDto;
	}

	public static ResponseDto fail() {
		ResponseDto responseDto = new ResponseDto(404);
		responseDto.setMessage("fail");
		return responseDto;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
