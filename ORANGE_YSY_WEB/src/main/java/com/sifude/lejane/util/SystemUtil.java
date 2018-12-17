package com.sifude.lejane.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author jinghao.liang
 * 
 */
@Configuration("systemUtil")
public class SystemUtil {

	@Value("${archive.upload.file.path}")
	private String archiveUploadPath;
	
	@Value("${archive.download.file.path}")
	private String archiveDownloadPath;
	
	@Value("${archive.error.file.path}")
	private String archiveErrorPath;

	public String getArchiveUploadPath() {
		return archiveUploadPath;
	}

	public void setArchiveUploadPath(String archiveUploadPath) {
		this.archiveUploadPath = archiveUploadPath;
	}

	public String getArchiveDownloadPath() {
		return archiveDownloadPath;
	}

	public void setArchiveDownloadPath(String archiveDownloadPath) {
		this.archiveDownloadPath = archiveDownloadPath;
	}

	public String getArchiveErrorPath() {
		return archiveErrorPath;
	}

	public void setArchiveErrorPath(String archiveErrorPath) {
		this.archiveErrorPath = archiveErrorPath;
	}
}
