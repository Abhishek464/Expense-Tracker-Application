

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseTrackerController {

    private final ExpenseService service;

    public ExpenseTrackerController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public Expense createExpense(
            @RequestHeader(value = "Idempotency-Key", required = false) String key,
            @Valid @RequestBody ExpenseCreateRequest request
    ) {
        return service.createExpense(request, key);
    }

    @GetMapping
    public List<Expense> getExpenses(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String sort
    ) {
        return service.getExpenses(category, sort);
    }
}