package uvsq;

public class CommandeAfficheDessin implements Command{

    private Dessin d;
    private DessinDAO dao;

    public CommandeAfficheDessin(String name){

        this.d = this.dao.find(name);
    }

    @Override
    public void execute(){
        if (this.d != null){
            this.d.show();
        }
        else{
            System.out.println("Dessin not found");
        }
    }
}
