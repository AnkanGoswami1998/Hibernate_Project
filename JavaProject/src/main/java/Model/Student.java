//// Entity class of Student table

package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	private int Stu_ID;  ////Columns
	private String Stu_name,Stu_sub,Stu_Contact;

}
