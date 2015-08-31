from rdkit import Chem
from rdkit.Chem import Descriptors
from rdkit.Chem import Crippen
import time

start = time.clock()


suppl = Chem.SDMolSupplier('../../../data/Screening_Collection.sdf')
sum = 0
counter = 0
for mol in suppl:
    counter += 1
    mr = Crippen.MolMR(mol)
    #print mr
    sum = sum + mr
  
end = time.clock()

print sum
print "processed " + str(counter) + " mols"
print end - start