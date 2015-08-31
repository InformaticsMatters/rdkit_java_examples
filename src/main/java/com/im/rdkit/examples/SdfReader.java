package com.im.rdkit.examples;

import org.RDKit.ROMol;
import org.RDKit.RDKFuncs;
import org.RDKit.SDMolSupplier;

/**
 *
 * @author Tim Dudgeon <tdudgeon@informaticsmatters.com>
 */
public class SdfReader {

    static {
        System.loadLibrary("GraphMolWrap");
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: SdfReader <filename>");
        }
        String filename = args[0];

        long t0 = System.currentTimeMillis();
        SDMolSupplier sdf = new SDMolSupplier(filename, true, false);

        int count = 0;
        int errors = 0;
        long totRings = 0;
        double sum = 0;
        while (!sdf.atEnd()) {
            count++;
            ROMol mol = sdf.next();
            if (mol == null) {
                errors++;
            } else {
                //double tpsa = RDKFuncs.calcTPSA(mol);
                double mr = RDKFuncs.calcMolMR(mol);
                //double logp = RDKFuncs.calcMolLogP(mol);
                //long rings = RDKFuncs.calcNumRings(mol);
                //totRings += rings;
                //System.out.println("LogP = " + logp);
                sum += mr;
            }
        }

        long t1 = System.currentTimeMillis();
        System.out.println("Processed " + count + " mols in " + (t1 - t0) + "ms. " + errors + " errors");
        System.out.println("Sum: " + sum);
    }

}
