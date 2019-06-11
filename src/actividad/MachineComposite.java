package actividad;

import actividad.MachineComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class MachineComposite extends MachineComponent implements Observer {
    private List<MachineComponent> components = new ArrayList<>();

    public List<MachineComponent> getComponetsBroken() {
        return componetsBroken;
    }

    public  List<MachineComponent> componetsBroken = new ArrayList<>();

    public void addComponent(MachineComponent mc) {
        components.add(mc);
        mc.addObserver(this);
        if(mc.isBroken()) {
            this.componetsBroken.add(mc);
            if (!this.broken && this.componetsBroken.size() == 1) {
                notifyObservers();
            }
        }
     }

    @Override
    public boolean isBroken() {
        if(broken){
            return true;
        }
        for(MachineComponent mc: components) {
            if (mc.isBroken()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        MachineComponent mc = (MachineComponent) o;
        if (mc.isBroken()) {
            addComponentsBroken(mc);
        } else {
            deleteComponentBroken(mc);
        }
    }

    private void addComponentsBroken(MachineComponent mc) {
        if (!this.componetsBroken.contains(mc)){
            this.componetsBroken.add(mc);
        }

        if (!isBroken()){
            notifyObservers();
        }

    }
    private void deleteComponentBroken(MachineComponent mc) {
        if (this.componetsBroken.contains(mc)){
            this.componetsBroken.remove(mc);
        }
        if (!isBroken()) {
            notifyObservers();
        }
    }


}
