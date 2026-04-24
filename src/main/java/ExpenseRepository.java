import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

    Optional<Expense> findByIdempotencyKey(String key);

    List<Expense> findByCategoryOrderByDateDesc(String category);

    List<Expense> findAllByOrderByDateDesc();
}