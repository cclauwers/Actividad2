public class Machine extends MachineComponent {

    private boolean broken = false;
    @Override
    public boolean isBroken() {
        return broken;
    }

    public void setBroken() {
        broken = true;
        if (broken) {
            setChanged();
            notifyObservers();
        }
    }

    public void repair() {
        broken = false;
        if (!broken) {
            setChanged();
            notifyObservers();
        }
    }
}
