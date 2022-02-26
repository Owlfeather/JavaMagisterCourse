package task1;

import java.util.HashMap;

public class CD {

    String name;

    public CD(String name) {
        this.name = name;
    }

    class Directory {
        HashMap<Component, Component> child_parent;
        Component root;

        public Directory() {
            child_parent = new HashMap<>();
            root = new Component(0, "Folder 0", false, 3, 0);
        }

        public void addComponent(Component child, Component parent){
            if(parent.isFolder()) {
                child_parent.put(child, parent);
                parent.updateSize(child.getSize());
                while (child_parent.get(parent) != null){
                    parent = child_parent.get(parent);
                    parent.updateSize(child.getSize());
                }
                if(!parent.equals(root)) {
                    root.updateSize(child.getSize());
                }
            } else {
                System.out.println("Invalid operation!");
            }
        }
        public void addComponent(Component child){
            this.addComponent(child, this.root);
        }

        @Override
        public String toString() {
            return "directory{" +
                    "child_parent=" + child_parent +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CD{" + '\n' +
                "name='" + name + '\n' +
                '}';
    }
}
