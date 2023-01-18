package au.com.frankdev.spring.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use auto-incrementing ID
    private Integer id;

    @Column
    private String name;

    @Column
    private BigDecimal balance;

    @Column
    private Boolean enabled;

    @Column
    private LocalDateTime createAt;

    @Column
    private LocalDateTime updateAt;
}
