package magiccards.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "magiccard")
public class Card {
	@Id
	@Column(name = "gathererid")
	private String gathererId;
	@Column(name = "variation", columnDefinition = "smallint")
	private Integer variation;
	@Column(name = "searchname", columnDefinition = "text")
	private String searchName;
	@Column(name = "ptbrsearchname", columnDefinition = "text")
	private String ptBrSearchName;
	@Column(name = "englishname", columnDefinition = "text")
	private String englishName;
	@Column(name = "ptbrname", columnDefinition = "text")
	private String ptBrName;
	@Column(name = "linkname", columnDefinition = "text")
	private String linkName;
	@Column(name = "color")
	private Integer color;
	@Column(name = "manacost")
	private String manaCost;
	@Column(name = "collectionnumber", columnDefinition = "smallint")
	private Integer collectionNumber;
	@Column(name = "rarity", columnDefinition = "char")
	private String rarity;
	@Column(name = "rules", columnDefinition = "text")
	private String rules;
	@Column(name = "flavortext", columnDefinition = "text")
	private String flavorText;
	@Column(name = "supertypes")
	private Integer superTypes;
	@Column(name = "cardtypes")
	private Integer cardTypes;
	@Column(name = "unserioussubtypes")
	private String unseriousSubTypes;
	@Column(name = "power")
	private String power;
	@Column(name = "toughness")
	private String toughness;
	@Column(name = "loyalty")
	private String loyalty;
	@Column(name = "expansionid")
	private Integer expansionId;
	@Column(name = "artistid")
	private Integer artistId;
	@Column(name = "flipname", columnDefinition = "text")
	private String flipname;
	@Column(name = "fliprules", columnDefinition = "text")
	private String flipRules;
	@Column(name = "flipsupertypes")
	private Integer flipSuperTypes;
	@Column(name = "fliptypes")
	private Integer flipTypes;
	@Column(name = "flippower")
	private String flipPower;
	@Column(name = "fliptoughness")
	private String flipToughness;
	@Column(name = "flipgathererid")
	private String flipGathererId;
	@Column(name = "splitmanacost")
	private String splitManaCost;

}
