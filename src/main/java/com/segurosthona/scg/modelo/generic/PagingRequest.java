package com.segurosthona.scg.modelo.generic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

public class PagingRequest {

	private int pageStartAt;
	private int pageSize;
	
	private int totalRecordsCount;
	private int filteredRecordsCount;
	
	private String orderBy;
	
	private String filterGlobal;
	private List<String> filters;
	
	private List<String> dataProps; // data property used to populate columns (in order)
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecordsCount() {
		return totalRecordsCount;
	}
	public void setTotalRecordsCount(int totalRecordsCount) {
		this.totalRecordsCount = totalRecordsCount;
	}
	public int getFilteredRecordsCount() {
		return filteredRecordsCount;
	}
	public void setFilteredRecordsCount(int filteredRecordsCount) {
		this.filteredRecordsCount = filteredRecordsCount;
	}
	public int getPageStartAt() {
		return pageStartAt;
	}
	public void setPageStartAt(int pageStartAt) {
		this.pageStartAt = pageStartAt;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public List<String> getFilters() {
		return filters;
	}
	public void setFilters(List<String> filters) {
		this.filters = filters;
	}
	
	@Override
	public String toString()		
	{				
		int i = 0;
		StringBuilder str = new StringBuilder(this.getClass().getSimpleName()).append(" [");
		for (Field f : this.getClass().getDeclaredFields()) {
			try {
				if(i>0){
					str.append(", ");
				}
				str.append(f.getName()).append("=").append(PropertyUtils.getProperty(this, f.getName()));				
				i++;
			} catch (Exception e) {
				//e.printStackTrace();
			}
		} 
		str.append("]");
		return str.toString();
	}
	public String getFilterGlobal() {
		return filterGlobal;
	}
	public void setFilterGlobal(String filterGlobal) {
		this.filterGlobal = cleanFilter(filterGlobal);
	}
	
	/**
	 * Clean filters to be used in like expresions
	 * @param filter
	 * @return
	 */
	private String cleanFilter(String filter){
		if(filter!=null && !filter.isEmpty()){ // remove special chars
			filter = filter.replace("'", "");
			filter = filter.replace("%", "");
		}		
		return filter;
	}
	
	/**
	 * Recover nesting expressions in dataproperties (change _ by . ) 
	 */
	private List<String> unplainDataProps(List<String> dataProps){
		if(dataProps!=null && !dataProps.isEmpty()){
			List<String> unplain = new ArrayList<String>();
			for (String dataProp : dataProps) {
				if(dataProp.contains("_")){
					unplain.add(dataProp.replaceAll("\\_", "\\."));
				}
				else{
					unplain.add(dataProp);
				}
			}
			return unplain;
		}
		return dataProps;
	}
	
	public boolean hasFiltersByColumn(){
		
		if(this.filters!=null && !this.filters.isEmpty() ){
			for (String filter : this.filters) {
				if(filter!=null && !filter.isEmpty()){
					return true; 
				}
			}
		}
		
		return false;
	}
	public List<String> getDataProps() {
		return dataProps;
	}
	public void setDataProps(List<String> dataProps) {		
		this.dataProps = unplainDataProps(dataProps);		
	}
	
	/**
	 * Used to hold origina properties where data comes from (properties to be directly linked to Database (hibernate)
	 * @return List of properties that represent the domain object, source of data.
	 */
	public List<String> getDomainDataProps(){
		return this.dataProps;
	}
	
}
