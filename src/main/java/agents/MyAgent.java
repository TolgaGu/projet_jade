package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

public class MyAgent extends Agent {

    protected void setup(){
        Object[] args = getArguments();
        if(args.length > 0){
            if(args[0] instanceof String){
                System.out.println("Je rends le service "+args[0]+ " et je suis "+getAID());
                registerService((String)args[0]);
            }
        }
    }
    private void registerService(String service){
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType(service);
        sd.setName(service);
        dfd.addServices(sd);
        try{
            DFService.register(this,dfd);
        }catch (FIPAException e){
            e.printStackTrace();
            doDelete();
        }
    }


}
