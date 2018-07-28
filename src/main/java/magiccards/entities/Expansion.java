package magiccards.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "expansionId")
@Entity
@Table(name = "magicexpansion")
public class Expansion implements Serializable {

    @Id
    @Column(name="expansionid")
    private Integer expansionId;
    @Column(name = "name" , columnDefinition = "text")
    private String name;
    @Column(name = "ptbrname" , columnDefinition = "text")
    private String portugueseName;
    @Column(name="linkname", columnDefinition = "text")
    private String linkName;
    private String code;
    @Column(name="launchdate")
    private Date launchDate;
    @Column(name="expansioncategoryid" , columnDefinition = "smallint")
    private Integer expansionCategoryId;
    @Column(name="ispromo")
    private boolean promo;
    @Column(name="islegal")
    private boolean legal;

}
