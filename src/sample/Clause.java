package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Clause {
    private LinkedList<Variable>variable=new LinkedList<>();
    private boolean check ;

    public Clause(String line)
    {

        LinkedList<String>s=new LinkedList<String>(Arrays.asList(line.split(" ")));
        int i=0;
        if(s.get(0).equals(""))
        {
            s.removeFirst();
        }
        Variable var;

   do {

        if (s.get(i).substring(0,1).equals("-") )
        {
            var = new Variable(s.get(i).substring(1),true);
            variable.add(var);
        }
        else
        {
            var = new Variable(s.get(i),false);
            variable.add(var);
        }
        i++;
    }while(!s.get(i).equals("0"));
    }

    public LinkedList<Variable> getVariable() {
        return variable;
    }

    public void setVariable(LinkedList<Variable> variable) {
        this.variable = variable;
    }

    public boolean isCheck(ArrayList<Integer>L) {
        Variable var1=variable.get(0);
        Variable var2=variable.get(1);
        Variable var3=variable.get(2);
        variable.get(0).setValue(L.get(Integer.parseInt(var1.getId())));
        variable.get(1).setValue(L.get(Integer.parseInt(var2.getId())));
        variable.get(2).setValue(L.get(Integer.parseInt(var3.getId())));
        if(variable.get(0).isValue()==1||variable.get(1).isValue()==1||variable.get(2).isValue()==1)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "sample.Clause{" +
                "variable=" + variable +
                ", check=" + check +
                '}';
    }
}

