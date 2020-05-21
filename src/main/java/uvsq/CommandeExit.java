package uvsq;

public class CommandeExit implements Command {

    @Override
    public void execute(){
        System.exit(0);
    }

}
