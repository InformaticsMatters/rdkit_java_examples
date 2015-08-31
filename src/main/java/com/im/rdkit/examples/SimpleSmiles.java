package com.im.rdkit.examples;

import org.RDKit.RWMol;
import org.RDKit.RDKFuncs;

/**
 *
 * @author Tim Dudgeon <tdudgeon@informaticsmatters.com>
 */
public class SimpleSmiles {

    static {
        System.loadLibrary("GraphMolWrap");
    }

    public static void main(String[] args) {
        Double logp = calcLogp("Cc1ccccc1");
        System.out.println("LogP = " + logp);
    }
    
    public static double calcLogp(String smiles) {
        RWMol mol = RWMol.MolFromSmiles(smiles);
        double logp = RDKFuncs.calcMolLogP(mol);
        return logp;
    }

}
