package uvsq;

import java.util.Scanner;

public class DrawingTUI {

    private Scanner scan;

    public Command nextCommand(){

        String token;
        //this.command.init();
        token= this.scan.nextLine();


        token=token.replaceAll(" ","");

        String tmp = token.substring(0, token.indexOf("("));



        if (token.equals("exit")){
            CommandeExit c = new CommandeExit();
            return c;
        }

        else if(tmp.equals("addDessin")){
            CommandeAddDessin c = new CommandeAddDessin(token.substring(token.indexOf("(") + 1,token.indexOf(",")),
                    token.substring(token.lastIndexOf(",") + 1,token.indexOf(")")));
            return c;
        }

        else if(tmp.equals("affiche")){
            CommandeAffiche c = new CommandeAffiche(token.substring(token.indexOf("(") + 1,token.indexOf(")")));
            return c;
        }

        else if(tmp.equals("afficheDessin")){
            CommandeAfficheDessin c = new CommandeAfficheDessin(token.substring(token.indexOf("(") + 1,token.indexOf(")")));
            return c;
        }

        else if(tmp.equals("move")){
            String tmpcoord = token.substring(token.lastIndexOf("(") + 1,token.indexOf(")"));
            CommandeMove c = new CommandeMove(token.substring(token.indexOf("(") + 1,token.indexOf(",")),
                    tmpcoord);
            return c;
        }

        else if(tmp.equals("moveDessin")){
            String tmpcoord = token.substring(token.lastIndexOf("(") + 1,token.indexOf(")"));
            CommandeMoveDessin c = new CommandeMoveDessin(token.substring(token.indexOf("(") + 1,token.indexOf(",")),
                    tmpcoord);
            return c;
        }

        else if(tmp.equals("removeDessin")){
            CommandeRemoveDessin c = new CommandeRemoveDessin(token.substring(token.indexOf("(") + 1,token.indexOf(",")),
                    token.substring(token.indexOf(",") + 1,token.lastIndexOf(")")));
            return c;
        }

        else {
            tmp = token.substring(0, token.indexOf("="));

            String type = token.substring(token.indexOf("=") + 1,token.indexOf("("));
            token = token.substring(token.indexOf("(") + 1);

            if (type.equals("Carre")){
                CommandeCreateCarre c = new CommandeCreateCarre(tmp,
                        token.substring(token.indexOf("(") + 1,token.indexOf(")")),
                        Integer.parseInt(token.substring(token.lastIndexOf(",") + 1,token.lastIndexOf(")"))));
                return c;
            }

            else if (type.equals("Cercle")){
                CommandeCreateCercle c = new CommandeCreateCercle(tmp,
                        token.substring(token.indexOf("(") + 1,token.indexOf(")")),
                        Integer.parseInt(token.substring(token.lastIndexOf(",") + 1,token.lastIndexOf(")"))));
                return c;
            }

            else if (type.equals("Dessin")){
                CommandeCreateDessin c = new CommandeCreateDessin(tmp);
                return c;
            }

            else if (type.equals("Triangle")){
                CommandeCreateTriangle c = new CommandeCreateTriangle(tmp,
                        token.substring(token.indexOf("(") + 1,token.indexOf(")")),
                        Integer.parseInt(token.substring(token.lastIndexOf(",") + 1,token.lastIndexOf(")"))));
                return c;
            }

            else if (type.equals("Rectangle")){
                String sub = token.substring(token.indexOf(")") + 1);
                CommandeCreateRectangle c = new CommandeCreateRectangle(tmp,
                        token.substring(token.indexOf("(") + 1,token.indexOf(")")),
                        Integer.parseInt(sub.substring(0 , sub.indexOf(","))),
                        Integer.parseInt(token.substring(token.lastIndexOf(",") + 1,token.lastIndexOf(")"))));
                return c;
            }

            else{
                System.out.println("Commande non reconnue");
                return null;
            }


        }

    }

    public void showDessin(Dessin d){

        System.out.println(d.show());

    }

}
