package com.eden.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
	
	private Integer id;
	private Integer operateUser;
	private LocalDateTime operateTime;
	private String className;
	private String methodName;
	private String methodParams;
	private String returnValue;
	private Long costTime;
	
}
