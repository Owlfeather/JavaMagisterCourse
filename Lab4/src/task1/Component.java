package task1;

import java.util.Objects;

public class Component {
    int id;
    String name;
    boolean playable;
    int size;
    int duration;

    public Component() {
    }

    public Component(int id, String name, boolean playable, int size, int duration) {
        this.id = id;
        this.name = name;
        this.playable = playable;
        this.size = size;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return id == component.id && playable == component.playable && size == component.size && duration == component.duration && Objects.equals(name, component.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, playable, size, duration);
    }

    public boolean isFolder(){
        return !playable;
    }

    public void updateSize(int size){
        this.size += size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        if(playable){
            return "Component{" +
                    "id=" + id +
                    ", name=" + name +
                    ", size=" + size +
                    ", duration=" + duration +
                    "} \n";
        } else {
            return "Component{" +
                    "id=" + id +
                    ", name=" + name +
                    ", size=" + size +
                    "} \n";
        }
    }
}
