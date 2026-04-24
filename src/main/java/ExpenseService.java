

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }

    public Expense createExpense(ExpenseCreateRequest req, String idempotencyKey) {

        if (idempotencyKey != null) {
            var existing = repo.findByIdempotencyKey(idempotencyKey);
            if (existing.isPresent()) {
                return existing.get();
            }
        }

        Expense e = new Expense();
        e.setAmount(req.getAmount());
        e.setCategory(req.getCategory());
        e.setDescription(req.getDescription());
        e.setDate(req.getDate());
        e.setCreatedAt(Instant.now());
        e.setIdempotencyKey(idempotencyKey);

        return repo.save(e);
    }

    public List<Expense> getExpenses(String category, String sort) {

        if (category != null) {
            return repo.findByCategoryOrderByDateDesc(category);
        }

        if ("date_desc".equals(sort)) {
            return repo.findAllByOrderByDateDesc();
        }

        return repo.findAll();
    }
}