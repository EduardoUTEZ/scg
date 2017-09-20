package com.segurosthona.scg.modelo.generic;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadedFile {

	    
		public Integer getId();
		public void setId(Integer id);
		public String getName();
		public void setName(String name);
		public String getNewFilename();
		public void setNewFilename(String newFilename);
		public String getContentType();
		public void setContentType(String contentType);
		public Long getSize();
		public void setSize(Long size);
		public String getUrl();
		public void setUrl(String url);
		public String getDeleteUrl();
		public void setDeleteUrl(String deleteUrl);
		public String getDeleteType();
		public void setDeleteType(String deleteType);
		public Date getCreation();
		public void setCreation(Date creation);
		public MultipartFile getMultipartFile();
		public void setMultipartFile(MultipartFile multipartFile);
	    public String toString();	  
	    
}
