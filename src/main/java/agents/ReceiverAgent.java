package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiverAgent extends Agent {
    @SuppressWarnings("serial")
    protected void setup() {
        //gui = new AgentView(this);
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = myAgent.receive();
                if(msg!=null){
                    System.out.println("OOOOOOOOOhhh !! un nouveau message ! :"+msg.getSender().getLocalName()+": "+msg.getContent());
                }else{
                    block();
                }
            }
        });
    }
}
