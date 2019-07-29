package magiccards.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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
	@Column(name = "launchdate", columnDefinition = "date")
	private String launchDate;
	@Column(name = "expansioncategoryid", columnDefinition = "smallint")
	private Integer expansionCategoryId;
	@Column(name = "ispromo", columnDefinition = "bit")
	private Integer isPromo;
	@Column(name = "islegal", columnDefinition = "bit")
	private Integer isLegal;
	@OneToMany(mappedBy = "expansionId", cascade = {CascadeType.REMOVE})
	private List<Card> cards;
}
