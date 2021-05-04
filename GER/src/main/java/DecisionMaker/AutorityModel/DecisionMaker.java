package DecisionMaker.AutorityModel;

import java.io.IOException;

public class DecisionMaker {

    public static void main(String[] args) throws IOException {

        PoliticPermission pp = new PoliticPermission();
        String properties = pp.getpermissionClass( new GetpermissionClass().getNameClass() );
        if (properties.contains( "YES" )){
          System.out.print( "politica ativa" );

        }

    }


}
