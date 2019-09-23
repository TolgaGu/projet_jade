package agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

import java.util.Iterator;

public class AgentSearch extends Agent {

    protected void setup(){

        Object[] args = getArguments();
        if(args.length > 0){
            if(args[0] instanceof String){
                System.out.println("Je rends le service "+args[0]);
                searchService();
            }
        }
    }

    private void searchService(){
        DFAgentDescription dfd= new DFAgentDescription();
        DFAgentDescription[] result = null;
        String s ="";
        try {
            result = DFService.search(this, dfd);
        }catch (FIPAException e){
            e.printStackTrace();
            doDelete();
        }

        for (int i=0; i<result.length; i++) {
            Iterator iter= result[i].getAllServices();
            while (iter.hasNext()) {
                ServiceDescription sd=(ServiceDescription)iter.next();
                s+=sd.getName();
            }
            System.out.println(s);
        }

    }
}
