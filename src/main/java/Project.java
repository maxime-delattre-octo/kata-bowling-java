public class Project {

    private Dependency dependency;

    public Project(Dependency dependency){
        this.dependency = dependency;
    }

    public int testFunction(){
        dependency.mockFunction();
        return dependency.stubFunction();
    }
}
