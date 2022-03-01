package task1;

import java.util.ArrayList;

public class Mobile {
    String firm;
    ArrayList<Model> models;

    public Mobile() {
        models = new ArrayList<>();
    }

    public Mobile(String firm) {
        this.firm = firm;
        models = new ArrayList<>();
    }

    public void addModel(String name){
        models.add(new Model(name));
    }

    @Override
    public String toString() {
        return "Mobile \n{" +
                "firm: '" + firm + '\'' +
                "\nmodels: \n" + models +
                '}';
    }

    class Model{
        String name;
        ArrayList<Attribute> attributes;

        public Model() {
            attributes = new ArrayList<>();
        }

        public Model(String name) {
            this.name = name;
            attributes = new ArrayList<>();
        }

        public void addAttribute(String name, int amount){
            Attribute attribute = new Attribute(name, amount);
            attributes.add(attribute);
        }

        public void addAttribute(String name){
            Attribute attribute = new Attribute(name);
            attributes.add(attribute);
        }

        @Override
        public String toString() {
            return "\n   Model{" +
                    "name='" + name + '\'' +
                    "\n       attributes=" + attributes + '\n' +
                    "   }";
        }

        class Attribute{
            String name;
            int amount;

            public Attribute() {
            }

            public Attribute(String name) {
                this.name = name;
                this.amount = -1;
            }

            public Attribute(String name, int amount) {
                this.name = name;
                this.amount = amount;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            @Override
            public String toString() {
                if(amount != -1) {
                    return "Attribute{" +
                            "name='" + name + '\'' +
                            ", amount=" + amount +
                            '}';
                } else {
                    return "Attribute{" +
                            "name='" + name +
                            '}';
                }
            }
        }
    }
}
