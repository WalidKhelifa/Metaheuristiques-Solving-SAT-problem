package sample;

public class Variable {
    private String id = "-1";
    private int value;
    private boolean not;

    public Variable(String id, boolean not) {
        this.id = id;
        this.not = not;
    }

    public Variable(String id, int value, boolean not) {
        this.id = id;
        this.value = value;
        this.not = not;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    public Variable(String id) {
        this.id = id;
    }

    public Variable(String id, int value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public int isValue() {
        if(not&&value==1)
        {
            return 0;
        }
        if (not&&value==0)
        {
            return 1;
        }
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "sample.Variable{" +
                "id='" + id + '\'' +
                ", value=" + value +
                ", not=" + not +
                '}';
    }
}
