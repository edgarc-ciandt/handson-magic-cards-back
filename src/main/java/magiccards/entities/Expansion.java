package magiccards.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "magicexpansion")
public class Expansion {
    @Id
    @Column(name = "expansionid")
    @Getter
    @Setter
    private String expansionId;

    @Column(name = "name", columnDefinition = "text")
    @Getter
    @Setter
    private String name;

    @Column(name = "ptbrname", columnDefinition = "text")
    @Getter
    @Setter
    private String portugueseName;

    @Column(name = "linkname", columnDefinition = "text")
    @Getter
    @Setter
    private String linkName;

    @Column(name = "code", columnDefinition = "text")
    @Getter
    @Setter
    private String code;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "launchdate", columnDefinition = "date")
    @Getter
    @Setter
    private Date launchDate;

    @Column(name = "expansioncategoryid", columnDefinition = "int")
    @Getter
    @Setter
    private String expansionCategoryId;

    @Column(name = "ispromo", columnDefinition = "tinyint(1) default 0")
    @Getter
    @Setter
    private Boolean promo;

    @Column(name = "islegal", columnDefinition = "tinyint(1) default 0")
    @Getter
    @Setter
    private Boolean legal;
}
