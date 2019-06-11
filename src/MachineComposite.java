import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class MachineComposite extends MachineComponent implements Observer {
    private List<MachineComponent> components = new ArrayList<>();
    public  List<MachineComponent> componetsBroken = new ArrayList<>();

    public void addComponent(MachineComponent mc) {
        components.add(mc);
        mc.addObserver(this);
        if(mc.isBroken()) {
            this.componetsBroken.add(mc);
            if (!this.broken && this.componetsBroken.size() == 1) {
                this.notifyObservers();
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

    }
}
