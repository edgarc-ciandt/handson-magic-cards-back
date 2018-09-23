package magiccards.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "ptbrname", columnDefinition = "text")
	private String ptBrName;

	@Column(name = "linkname", columnDefinition = "text")
	private String linkName;

	@Column(name = "code")
	private String code;

	@Column(name = "launchdate")
	private Date launchDate;

	@Column(name = "expansioncategoryid")
	private Short expansionCategoryId;

	@Column(name = "ispromo")
	private boolean promo;

	@Column(name = "islegal")
	private boolean legal;

}
