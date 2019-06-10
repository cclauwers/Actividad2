public abstract class MachineComponent {

    protected boolean broken = false;

    public void setBroken(){
        this.broken = true;
    }

    public void repair() throws Exception {
        this.broken = false;
    }

    public abstract boolean isBroken();
}
