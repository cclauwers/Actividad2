package test;

import actividad.Machine;
import actividad.MachineComposite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MachineCompositeTest {

    private Machine mc1, mc2, mc5;
    private MachineComposite mComposite1, mComposite2 , grupMComposite;

    public MachineCompositeTest() {   }


    @Before
    public void setUp() throws Exception {
        this.mc1  = new Machine();
        this.mc2  = new Machine();
        this.mComposite1 = new MachineComposite();
        this.mComposite2 = new MachineComposite();
        this.mc5  = new Machine();
    }

    @Test
    public void testIsBroken() throws Exception {
        this.mComposite1.setBroken();
        assertEquals(true, this.mComposite1.isBroken());
    }

    @Test
    public void testRepair() throws Exception {
        this.mComposite1.setBroken();
        this.mComposite1.repair();
        assertEquals(false, this.mComposite1.isBroken());
    }

    @Test
    public void testaddComponentsBroken() throws Exception {
        this.mComposite1.addComponent(this.mc1);
        this.mComposite1.addComponent(this.mc2);
        this.mc2.setBroken();
        this.mc2.repair();
        this.mComposite1.update(mc2, mc2);
    }

}
