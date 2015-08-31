package com.im.rdkit.examples;

import org.RDKit.RDKFuncs;
import org.RDKit.RWMol;

/**
 *
 * @author Tim Dudgeon <tdudgeon@informaticsmatters.com>
 */
public class MoleculeFunctions {

    static {
        System.loadLibrary("GraphMolWrap");
    }

    public static void main(String[] args) {
        RWMol mol = RWMol.MolFromSmiles(args.length == 0 ? "Cc1ccccc1" : args[0]);
        System.out.println("Input: " + mol.MolToSmiles());
        RDKFuncs.Kekulize(mol);
        System.out.println("Keule: " + mol.MolToSmiles());
        RDKFuncs.setAromaticity(mol);
        System.out.println("Aromatic: " + mol.MolToSmiles());
        RDKFuncs.addHs(mol);
        System.out.println("Hydrogens: " + mol.MolToSmiles());
    }
}
