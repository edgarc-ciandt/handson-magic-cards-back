package magiccards.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "magicexpansion")
public class Expansion {
	@Id
	@Column(name = "expansionid")
	private Integer expansionId;
	
	@Column(name = "name", columnDefinition = "text")
	private String name;
	
	@Column(name = "ptbrname", columnDefinition = "text", nullable = true)
	private String portugueseName;
	
	@Column(name = "linkname", columnDefinition = "text")
	private String linkName;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "launchdate", columnDefinition = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date launchDate;
	
	@Column(name = "expansioncategoryid", columnDefinition = "smallint")
	private Integer expansionCategoryId;
	
	@Column(name = "ispromo", columnDefinition = "bit(1)")
	private boolean promo;
	
	@Column(name = "islegal", columnDefinition = "bit(1)")
	private boolean legal;

}
