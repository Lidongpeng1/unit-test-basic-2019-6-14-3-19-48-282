package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ExpenseService.Expense.ExpenseType.*;
import static ExpenseService.Project.ProjectType.INTERNAL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
//        Project project = new Project(INTERNAL,"ProjectA");
        ProjectType internal = ProjectType.INTERNAL;
        Project project = new Project(internal,"ProjectA");
        ExpenseService expenseService = new ExpenseService();
        // when
//        ProjectType result = project.getProjectType();
        ExpenseType result = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
//        Assertions.assertEquals(INTERNAL_PROJECT_EXPENSE,result);
        Assertions.assertEquals(INTERNAL_PROJECT_EXPENSE,result);

    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        ProjectType internal = ProjectType.EXTERNAL;
        Project project = new Project(internal,"Project A");
        ExpenseService expenseService = new ExpenseService();
        // when
        ExpenseType result = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        Assertions.assertEquals(EXPENSE_TYPE_A,result);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        ProjectType internal = ProjectType.EXTERNAL;
        Project project = new Project(internal,"Project B");
        ExpenseService expenseService = new ExpenseService();
        // when
        ExpenseType result = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        Assertions.assertEquals(EXPENSE_TYPE_B,result);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        ProjectType internal = ProjectType.EXTERNAL;
        Project project = new Project(internal,"Project c");
        ExpenseService expenseService = new ExpenseService();
        // when
        ExpenseType result = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        Assertions.assertEquals(OTHER_EXPENSE,result);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() throws UnexpectedProjectTypeException {
        // given
//        ProjectType internal = ProjectType.UNEXPECTED_PROJECT_TYPE;
//        Project project = new Project(internal,"Project c");
//        ExpenseService expenseService = new ExpenseService();
        String projectName = "ProjectName";
        // when
        Project project = new Project(ProjectType.UNEXPECTED_PROJECT_TYPE,projectName);
        // then
        Assertions.assertThrows(new UnexpectedProjectTypeException("you enter invalid project type").getClass(),
                ()->ExpenseService.getExpenseCodeByProjectTypeAndName(project));
    }
}