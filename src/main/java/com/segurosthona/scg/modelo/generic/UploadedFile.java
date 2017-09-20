package com.segurosthona.scg.modelo.generic;


import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile implements Serializable, IUploadedFile, IGenericModel{

	private static final long serialVersionUID = -7800835692408181004L;
	
	private Integer id;
    private String name;
    private String newFilename;
    private String contentType;
    private Date creation;
    private Long size;
    private String url;
    private String deleteUrl;
    private String deleteType;
    private Integer parentId;
    
    // transient
    MultipartFile multipartFile;
    
    public UploadedFile(){
    	this.creation = new Date();
    }
    public UploadedFile(MultipartFile mpf){
    	this.multipartFile = mpf;  
    	this.creation = new Date();
    }
    public UploadedFile(int parentId, MultipartFile mpf){
    	this.parentId = parentId;
    	this.multipartFile = mpf;
    	this.creation = new Date();
    }    
    public UploadedFile(int parentId, String name){
    	this.parentId = parentId;
    	this.name = name;
    	this.creation = new Date();
    }
    
    public UploadedFile(UploadedFile file){
    	this.deleteType = "DELETE";
    	this.contentType = file.contentType;
    	this.creation = file.creation;
    	this.id = file.id;
    	this.multipartFile = null;
    	this.name = file.name;
    	this.newFilename = file.newFilename;
    	this.size = file.size;
    	this.parentId = file.parentId;
    	this.url = file.url;
    	this.deleteUrl = file.deleteUrl;
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNewFilename() {
		return newFilename;
	}
	public void setNewFilename(String newFilename) {
		this.newFilename = newFilename;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDeleteUrl() {
		return deleteUrl;
	}
	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}
	public String getDeleteType() {
		return deleteType;
	}
	public void setDeleteType(String deleteType) {
		this.deleteType = deleteType;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}  
	
    @Override
    public String toString() {
        return "File{" + "name=" + name + ", newFilename=" + newFilename + ", contentType=" + contentType + ", url=" + url + ", deleteUrl=" + deleteUrl + ", deleteType=" + deleteType + '}';
    }
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
  	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (o == null || !o.getClass().equals(getClass())) {
			return false;
		} else {
			UploadedFile that = ((UploadedFile) o);
			Integer thisId = this.getId();
			Integer thatId = that.getId();
			if (thisId == null || thatId == null) {
				return super.equals(that);
			} else {
				return thatId.equals(thisId);
			}
		}
	}	
    
}
