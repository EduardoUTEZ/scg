package com.segurosthona.scg.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Exception utils contains a variety of functionalities related with 
 * the exceptions treatment and inspection 
 * @author OWL - Oscar Lithgow
 *
 */
public class ExceptionUtils extends org.apache.commons.lang.exception.ExceptionUtils{


	
	public ExceptionUtils(){
		super();
	}
	
	/**
	 * Inspects through the exception chain looking for the specified pattern until it reaches the maximum deepness 
	 * @param e exception to be inspected
	 * @param patternStr String pattern
	 * @param maxDeep maximum deepnes allowed (0 = no restriction)
	 * @return List of arrays, each array contain in its former element the whole found string and in the next ones 
	 * the groups in case that the regexp epecified them
	 */
	public static List<String[]> LookforPattern(Exception e, String patternStr, int maxDeep){
		
		int deepness = 0;
		List<String[]> findings = new ArrayList<String[]>();
		
		Pattern pattern = Pattern.compile(patternStr);
		
		findings.addAll(LookforPattern(e.getMessage(), pattern)); // inspect ultimate cause
				
		Throwable tr = ExceptionUtils.getRootCause(e.getCause());
		while(tr != null){			
			findings.addAll(LookforPattern(tr.toString(), pattern)); // inspect root cause
			
			deepness++;
			if(maxDeep > 0 && deepness >= maxDeep){
				break;
			}
			tr = ExceptionUtils.getRootCause(tr);
		}
		
		return findings;		
	}
	
	/**
	 * Look for a pattern inside of the target string
	 * @param targetStr string where the search is going to be done
	 * @param pattern compiled pattern to be looked for
	 * @return array contain in its former element the whole found string and in the next ones 
	 * the groups in case that the regexp epecified them
	 */
	public static List<String[]> LookforPattern(String targetStr, Pattern pattern){		
		List<String[]> findings = new ArrayList<String[]>();
		Matcher m = pattern.matcher(targetStr);
		while (m.find()) {
			String[] groups = new String[m.groupCount()+1];
			for (int i = 0; i < groups.length; i++) {
				groups[i] = m.group(i);
			}
			findings.add(groups);			
		}			
		return findings;
	}
	
	public static String getDataIntegrityViolationMessage(DataIntegrityViolationException e, MessageSource messageSource){
	
		final String DEFAULT_MSG = "It was not possible to delete the record beacuse it is referenced by others.";
		String refs = "";
		
		if(e.getMessage().startsWith("referenced_entities:")){
			String[] parts = e.getMessage().split(":");
			StringBuilder references = new StringBuilder();
			for (String entity : parts[1].split(",")) {
				if(references.length()>0) references.append(", ");
				references.append(messageSource.getMessage(entity.trim().toLowerCase() + ".entity", null, entity.trim(), null));
			}
			refs = references.toString();
		}
		else{
			try{
				List<String[]> findings = ExceptionUtils.LookforPattern(e, "`FK_(.*?)_(.*?)`", 3);
				StringBuilder references = new StringBuilder();
				int count=0;
				for (String[] groups : findings) {				
					if(count>0) references.append(", ");
					references.append(groups.length >= 3 ? messageSource.getMessage(groups[1] + ".entity", null, groups[1], null) : groups[0]);
					count++;
				}
				refs = references.toString();
			} catch(Exception ex){
				ex.printStackTrace();
				return DEFAULT_MSG;
			}
		}
				
		return messageSource.getMessage("DataIntegrityViolationException", new String[]{refs}, DEFAULT_MSG, null);
	}
	
}
