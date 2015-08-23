package com.im.rdkit.examples;

import org.RDKit.RWMol;
import org.RDKit.RDKFuncs;

/**
 *
 * @author Tim Dudgeon <tdudgeon@informaticsmatters.com>
 */
public class Example1 {

    static {
        System.loadLibrary("GraphMolWrap");
    }

    public static void main(String[] args) {

        RWMol mol = RWMol.MolFromSmiles("Cc1ccccc1");
        Double logp = RDKFuncs.calcMolLogP(mol);
        System.out.println("LogP = " + logp);
    }

}
