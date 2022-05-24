/**
 * 
 */
package com.raken.takehome.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jagmohan swain
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

	private String To; //- Required
	private String CC; //- Optional
	private String BCC; //- Optional
	private String Body; //Text/HTML
	private String Subject;  //- Optional

}


