from rdkit import Chem
from rdkit.Chem import Descriptors
from rdkit.Chem import Crippen
import time
import sys

if len(sys.argv) != 2:
    print 'Usage: SdfReader.py <sdf file>'
    quit()

print 'Processing file:', sys.argv[1]

start = time.clock()


suppl = Chem.SDMolSupplier(sys.argv[1])
sum = 0
counter = 0
for mol in suppl:
    counter += 1
    mur = Chem.MurckoDecompose(mol)
    val = len(mur.GetAtoms())
    #mr = Crippen.MolMR(mol)
    #rings = Descriptors.NumAromaticRings(mol)
    #val = Descriptors.LabuteASA(mol)
    #val = Descriptors.HallKierAlpha(mol)
    #print mr
    sum = sum + val
  
end = time.clock()

print 'Sum:', sum
print "processed", counter, "strctures in", end - start, 's'
