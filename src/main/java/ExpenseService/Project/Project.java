package ExpenseService.Project;

public class Project {
    
    private ProjectType projectType;

    private String projectName;

    public Project(ProjectType projectType, String projectName) {  //传入一个枚举类型
        this.projectType = projectType;
        this.projectName = projectName;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public String getProjectName() {
        return projectName;
    }
}
