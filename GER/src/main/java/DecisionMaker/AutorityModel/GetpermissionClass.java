package DecisionMaker.AutorityModel;

public class GetpermissionClass extends SecurityManager{

    public String getNameClass(){
        return getClassContext()[1].getSimpleName();
    }


}