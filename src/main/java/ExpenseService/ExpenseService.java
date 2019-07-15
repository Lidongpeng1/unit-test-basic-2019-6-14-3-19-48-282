package ExpenseService;

import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.*;
import ExpenseService.Exception.*;

import static ExpenseService.Expense.ExpenseType.*;
import static ExpenseService.Project.ProjectType.*;

class ExpenseService {
    static ExpenseType getExpenseCodeByProjectTypeAndName(Project project) throws UnexpectedProjectTypeException {  //传入一个Project返回一个枚举类型ExpenseType
        if(project.getProjectType() == INTERNAL){
            return INTERNAL_PROJECT_EXPENSE;  //如果ProjectType()的枚举类型是INTERNAL，则返回ExpenseType的枚举INTERNAL_PROJECT_EXPENSE
        }else{
            if(project.getProjectType() == EXTERNAL){
                if(project.getProjectName().equals("Project A")){
                    return EXPENSE_TYPE_A;
                }

                if(project.getProjectName().equals("Project B")){
                    return EXPENSE_TYPE_B;
                }

                return OTHER_EXPENSE;
            }

            throw new UnexpectedProjectTypeException("You enter invalid project type");
        }
    }
}
