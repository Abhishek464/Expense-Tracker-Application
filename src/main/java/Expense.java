import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Use BigDecimal for exact financial calculations
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private String category;

    private String description;

    @Column(nullable = false)
    private LocalDate expenseDate;

    @CreationTimestamp
    private Instant createdAt;

    // The secret sauce for the "network retry" requirement
    @Column(unique = true, nullable = false)
    private String idempotencyKey;

    // Getters, Setters, Constructors
}