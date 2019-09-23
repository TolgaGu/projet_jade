package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class SenderAgent extends Agent {

    protected void setup(){
        Object[] args = getArguments();
        if(args.length > 0){
            if(args[0] instanceof String){
                System.out.println("Je rends le service "+args[0]);
                sendMessage((String)args[0]);
            }
        }
    }
    private void sendMessage(String message){
        try{
            ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
            aclMessage.addReceiver(new AID("jack",false));
            aclMessage.setContent(message);
            this.send(aclMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
