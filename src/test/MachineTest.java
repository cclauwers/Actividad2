package test;

import actividad.Machine;
import actividad.MachineComponent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MachineTest {

    private MachineComponent mc;

    public MachineTest() {    }

    @Before
    public void setUp() throws Exception {
        this.mc = new Machine();
    }

    @Test
    public void testIsBroken() throws Exception {
        this.mc.setBroken();
        assertEquals(true, this.mc.isBroken());
    }

    @Test
    public void testRepair() throws Exception {
        this.mc.setBroken();
        this.mc.repair();
        assertEquals(false, this.mc.isBroken());
    }

    @Test
    public void testIsBrokenException() throws Exception {
        this.mc.setBroken();
        this.mc.setBroken();
        assertEquals(true, this.mc.isBroken());
    }

    @Test
    public void testRepairException() throws Exception {
        this.mc.repair();
        assertEquals(false, this.mc.isBroken());
    }
}
