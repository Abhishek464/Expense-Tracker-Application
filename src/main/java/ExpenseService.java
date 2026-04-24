import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository repository;

    @Transactional
    public Expense createExpense(ExpenseRequest dto, String idempotencyKey) {
        // 1. Check if we already processed this request
        Optional<Expense> existing = repository.findByIdempotencyKey(idempotencyKey);
        if (existing.isPresent()) {
            return existing.get(); // Return the previously saved entity safely
        }

        // 2. Otherwise, create new
        Expense expense = new Expense();
        expense.setAmount(dto.getAmount());
        // ... set other fields
        expense.setIdempotencyKey(idempotencyKey);

        return repository.save(expense);
    }
}