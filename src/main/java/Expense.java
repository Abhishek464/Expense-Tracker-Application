
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Expense {

    @Id
    @GeneratedValue
    private UUID id;

    private BigDecimal amount;
    private String category;
    private String description;
    private LocalDate date;

    private Instant createdAt;

    @Column(unique = true)
    private String idempotencyKey;

    // getters & setters
}