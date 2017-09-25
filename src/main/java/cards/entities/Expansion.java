package cards.entities;

/**
 * Created by edgarc on 8/4/17.
 */

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@Entity
@Table(name = "magicexpansion")
public class Expansion {
    @Id
    @Column(name = "ExpansionId")
    private Integer expasionId;
    @Column(name = "Name", columnDefinition = "text")
    private String name;
    @Column(name = "PtBRName", columnDefinition = "text")
    private String portugueseName;
    @Column(name = "LinkName", columnDefinition = "text")
    private String linkName;
    @Column(name = "Code", columnDefinition = "text")
    private String code;
    @Column(name = "LaunchDate", columnDefinition = "date")
    private Date launchDate;
    @Column(name = "ExpansionCategoryId", columnDefinition = "smallint")
    private Integer expasionCategoryId;
    @Column(name = "isPromo", columnDefinition = "smallint")
    private  boolean isPromo;
    @Column(name = "isLegal", columnDefinition = "smallint")
    private  boolean isLegal;

}
