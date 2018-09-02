/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

import java.io.Serializable;

/**
 *
 * @author HopefulSplash
 */
class Hall implements Serializable {

Zone z1;
Zone z2;
Zone z3;
Zone z4;

    public Zone getZ1() {
        return z1;
    }

    public Hall(Zone z1, Zone z2, Zone z3, Zone z4) {
        this.z1 = z1;
        this.z2 = z2;
        this.z3 = z3;
        this.z4 = z4;
    }

    public void setZ1(Zone z1) {
        this.z1 = z1;
    }

    public Zone getZ2() {
        return z2;
    }

    public void setZ2(Zone z2) {
        this.z2 = z2;
    }

    public Zone getZ3() {
        return z3;
    }

    public void setZ3(Zone z3) {
        this.z3 = z3;
    }

    public Zone getZ4() {
        return z4;
    }

    public void setZ4(Zone z4) {
        this.z4 = z4;
    }

    


}
