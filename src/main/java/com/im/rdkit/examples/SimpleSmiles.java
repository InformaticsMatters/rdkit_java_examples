package com.im.rdkit.examples;

import org.RDKit.RWMol;

/**
 *
 * @author Tim Dudgeon <tdudgeon@informaticsmatters.com>
 */
public class SimpleSmiles {

    static {
        System.loadLibrary("GraphMolWrap");
    }

    public static void main(String[] args) {
        RWMol mol = readMol("Cc1ccccc1");
        System.out.println("Mol: " + mol);
    }
    
    public static RWMol readMol(String smiles) {
        RWMol mol = RWMol.MolFromSmiles(smiles);
        return mol;
    }

}
