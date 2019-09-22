package com.coderby.myapp.upload.model;

import java.sql.Timestamp;
import java.util.Arrays;

public class UploadFileVO {

	private int fileId;
	private String directoryName, fileName, fileContentType;
	private long fileSize;
	private Timestamp fileUploadDate;
	private byte[] fileData;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Timestamp getFileUploadDate() {
		return fileUploadDate;
	}

	public void setFileUploadDate(Timestamp fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
}
